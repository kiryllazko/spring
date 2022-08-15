package com.lirik.connection;

import com.lirik.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductDAOImpl implements ProductDAO {

    private static ProductDAOImpl INSTANCE;

    public static synchronized ProductDAOImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductDAOImpl();
        }
        return INSTANCE;
    }

    @Override
    public List<Product> getALL() {
        List<Product> products = new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM brand");

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                products.add(new Product(id, name));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void saveSql(Product product) {

        String query = "INSERT INTO brand (id, name) values (?, ?)";
        try {
            Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getTitle());
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
