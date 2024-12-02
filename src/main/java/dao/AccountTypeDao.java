package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountType;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountTypeDao {

    // Method to retrieve all account types from the database
    public List<AccountType> getAllAccountTypes() {
        String sql = "SELECT * FROM accountTypes";
        List<AccountType> accountTypes = new ArrayList<>();

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AccountType accountType = new AccountType();
                accountType.setTypeId(rs.getInt("type_id"));
                accountType.setSubTypeId(rs.getInt("sub_type_id"));
                accountType.setTypeName(rs.getString("type_name"));
                accountType.setSubTypeName(rs.getString("sub_type_name"));
                accountTypes.add(accountType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountTypes;
    }
}
