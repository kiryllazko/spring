package web;

import com.lirik.service.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import web.connection.DBConnServletTest;
import web.connection.ProductDAOImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class MainController {
    Store store = Store.getInstance();

    ProductDAOImpl productDAO = ProductDAOImpl.getInstance();

//    private final DBConnServletTest dbc;
//
//    @Autowired
//    public MainController(DBConnServletTest dbc) {
//        this.dbc = dbc;
//    }

    @GetMapping("store/products")
    public String products(Model model) {
        model.addAttribute("products", store.getProducts());
        return "products";
    }

    @GetMapping("store/food")
    public String food(Model model) {
        model.addAttribute("food", store.getFood());
        return "food";
    }

    @GetMapping("store/parts")
    public String parts(Model model) {
        model.addAttribute("parts", store.getVehicleParts());
        return "parts";
    }

    @GetMapping("store/sql")
    public String listProduct(Model model) {
        model.addAttribute("products", productDAO.getALL());
        return "sql";
    }

//    @PostMapping("store/add")
//    public String addProducts (Model model) {
//        model.addAttribute("products",productDAO.saveSql());
//        return "products";
//    }


//    @PostMapping("/add")
//    public void add(HttpServletRequest req, HttpServletResponse res)
//            throws IOException {
//        res.setContentType("text/html");
//
//        int Id = Integer.parseInt(req.getParameter("Id"));
//        String Title = req.getParameter("Title");
//        try {
//            store.add(new Product(Id, Title));
//        } catch (StoreException e) {
//            throw new RuntimeException(e);
//        }
//        res.sendRedirect("store/sql");
//    }

}






