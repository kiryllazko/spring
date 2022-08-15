package web.connection;

import com.lirik.model.Product;
import sql.ConnectionFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void saveSql (HttpServletRequest req, HttpServletResponse res) throws SQLException {
        res.setContentType("text/html");

        String query = "INSERT INTO brand (id, name) values (?, ?)";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);

        int Id = Integer.parseInt(req.getParameter("Id"));
        String Title = req.getParameter("Title");

        ps.setInt(1,Id);
        ps.setString(2,Title);

        connection.close();
    }
}
