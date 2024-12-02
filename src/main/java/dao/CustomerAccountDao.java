package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.CustomerAccount;
import util.DatabaseUtil;

public class CustomerAccountDao {

    public void addCustomerAccount(CustomerAccount customerAccount) {
        String sql = "INSERT INTO CustomerAccount (cif_id, account_number, customer_name, account_type_id, minimum_balance, nominee, relationship, is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customerAccount.getCifId());
            ps.setString(2, customerAccount.getAccountNumber());
            ps.setString(3, customerAccount.getCustomerName());
            ps.setInt(4, customerAccount.getAccountTypeId());
            ps.setDouble(5, customerAccount.getMinimumBalance());
            ps.setString(6, customerAccount.getNominee());
            ps.setString(7, customerAccount.getRelationship());
            ps.setBoolean(8, customerAccount.isDeleted());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    public CustomerAccount getCustomerAccount(String id) {
        String sql = "SELECT * FROM CustomerAccount WHERE account_number = ?";
        CustomerAccount customerAccount = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    customerAccount = new CustomerAccount();
                    customerAccount.setId(rs.getInt("id"));
                    customerAccount.setCifId(rs.getString("cif_id"));
                    customerAccount.setAccountNumber(rs.getString("account_number"));
                    customerAccount.setCustomerName(rs.getString("customer_name"));
                    customerAccount.setAccountTypeId(rs.getInt("account_type_id"));
                    customerAccount.setMinimumBalance(rs.getDouble("minimum_balance"));
                    customerAccount.setNominee(rs.getString("nominee"));
                    customerAccount.setRelationship(rs.getString("relationship"));
                    customerAccount.setDeleted(rs.getBoolean("is_deleted"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerAccount;
    }
    
    
    
    
    public String getCustomerName(String id) {
        String sql = "SELECT customer_name FROM CustomerAccount WHERE cif_id = ?";
        String customerAccount = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    customerAccount = rs.getString("customer_name");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerAccount;
    }
    
    public List<CustomerAccount> getAllCustomerAccounts() {
        String sql = "SELECT * FROM CustomerAccount WHERE is_deleted = false";
        List<CustomerAccount> customerAccounts = new ArrayList<>();

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CustomerAccount customerAccount = new CustomerAccount();
                customerAccount.setId(rs.getInt("id"));
                customerAccount.setCifId(rs.getString("cif_id"));
                customerAccount.setAccountNumber(rs.getString("account_number"));
                customerAccount.setCustomerName(rs.getString("customer_name"));
                customerAccount.setAccountTypeId(rs.getInt("account_type_id"));
                customerAccount.setMinimumBalance(rs.getDouble("minimum_balance"));
                customerAccount.setNominee(rs.getString("nominee"));
                customerAccount.setRelationship(rs.getString("relationship"));
                customerAccount.setDeleted(rs.getBoolean("is_deleted"));
                customerAccounts.add(customerAccount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerAccounts;
    }

    public void updateCustomerAccount(CustomerAccount customerAccount) {
        String sql = "UPDATE CustomerAccount SET customer_name = ?, account_type_id = ?,  minimum_balance = ?, nominee = ?, relationship = ?, is_deleted = ? WHERE account_number = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customerAccount.getCustomerName());
            ps.setInt(2, customerAccount.getAccountTypeId());
            ps.setDouble(3, customerAccount.getMinimumBalance());
            ps.setString(4, customerAccount.getNominee());
            ps.setString(5, customerAccount.getRelationship());
            ps.setBoolean(6, customerAccount.isDeleted());
            ps.setString(7, customerAccount.getAccountNumber());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CustomerAccount> getAccountsByCifId(String cifId) {
        String sql = "SELECT * FROM CustomerAccount WHERE cif_id = ? AND is_deleted = false";
        List<CustomerAccount> customerAccounts = new ArrayList<>();

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cifId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    CustomerAccount customerAccount = new CustomerAccount();
                    customerAccount.setId(rs.getInt("id"));
                    customerAccount.setCifId(rs.getString("cif_id"));
                    customerAccount.setAccountNumber(rs.getString("account_number"));
                    customerAccount.setCustomerName(rs.getString("customer_name"));
                    customerAccount.setAccountTypeId(rs.getInt("account_type_id"));
                    customerAccount.setMinimumBalance(rs.getDouble("minimum_balance"));
                    customerAccount.setNominee(rs.getString("nominee"));
                    customerAccount.setRelationship(rs.getString("relationship"));
                    customerAccount.setDeleted(rs.getBoolean("is_deleted"));
                    customerAccounts.add(customerAccount);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerAccounts;
    }

    public List<CustomerAccount> getAllCustomers() {
        String sql = "SELECT DISTINCT cif_id, customer_name FROM CustomerAccount WHERE is_deleted = false";
        List<CustomerAccount> customerInfo = new ArrayList<>();

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CustomerAccount customerAccount = new CustomerAccount();
                customerAccount.setCifId(rs.getString("cif_id"));
                customerAccount.setCustomerName(rs.getString("customer_name"));
                customerInfo.add(customerAccount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerInfo;
    }

    public void deleteCustomerAccount(String id) {
        String sql = "UPDATE CustomerAccount SET is_deleted = true WHERE account_number = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

