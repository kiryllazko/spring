package web;

import com.lirik.exception.StoreException;
import com.lirik.model.Product;
import com.lirik.model.VehiclePart;
import com.lirik.service.Store;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AddController {

    Store store = Store.getInstance();


//
//    @GetMapping("/add")
//    public String add() {
//               return "add";
//    }

    @PostMapping("/add")
    public void add(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        res.setContentType("text/html");

        int Id = Integer.parseInt(req.getParameter("Id"));
        String Title = req.getParameter("Title");
        String Make = req.getParameter("Make");
        String Model = req.getParameter("Model");
        int Year = Integer.parseInt(req.getParameter("Year"));

        try {
            store.add(new VehiclePart(Id, Title, Make, Model, Year));
        } catch (StoreException e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("/store/parts");
    }
}
