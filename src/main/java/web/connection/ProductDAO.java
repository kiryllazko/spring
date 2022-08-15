package web.connection;

import com.lirik.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {


    public List<Product> getALL();

    public void saveSql(HttpServletRequest req, HttpServletResponse res) throws SQLException;
}
