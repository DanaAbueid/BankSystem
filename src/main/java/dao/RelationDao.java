package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Relation;
import util.DatabaseUtil;

public class RelationDao {

    public List<Relation> getAllRelation() {
        List<Relation> relations = new ArrayList<>();
        String sql = "SELECT * FROM relation";
        
        try (Connection con = DatabaseUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
            	Relation relation = new Relation();
            	relation.setRelationId(rs.getInt("realation_id"));
            	relation.setRelationName(rs.getString("relation_name"));
            	relations.add(relation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return relations;
    }
    
}