package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;
import util.DatabaseUtil;
public class AccountSubTypeDao {

	public List<AccountSubType> getSubTypesByAccountTypeId(int accountTypeId) {
	    String sql = "SELECT * FROM accountSubType WHERE type_id = ?";
	    List<AccountSubType> accountSubTypes = new ArrayList<>();

	    try (Connection conn = DatabaseUtil.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, accountTypeId);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                AccountSubType accountSubType = new AccountSubType();
	                accountSubType.setSubTypeId(rs.getInt("sub_type_id"));
	                accountSubType.setSubTypeName(rs.getString("sub_type_name"));
	                accountSubType.setTypeId(rs.getInt("type_id"));
	                accountSubTypes.add(accountSubType);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return accountSubTypes;
	}

}
