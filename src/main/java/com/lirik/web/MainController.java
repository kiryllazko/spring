package com.lirik.web;

import com.lirik.connection.ProductDAOImpl;
import com.lirik.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class MainController {

    @GetMapping("store/sql")
    public String listProduct(HttpServletRequest req, Model model) {
        ServletContext sc = req.getServletContext();
        ProductDAOImpl productDAO = (ProductDAOImpl) sc.getAttribute("productDAO");
        model.addAttribute("products", productDAO.getALL());
        return "sql";
    }

    @GetMapping("store/add")
    public String product() {
        return "add";
    }

    @PostMapping("store/add")
    public String saveSql(HttpServletRequest req) {
        ServletContext sc = req.getServletContext();
        ProductDAOImpl productDAO = (ProductDAOImpl) sc.getAttribute("productDAO");
        int id = Integer.parseInt(req.getParameter("Id"));
        String title = req.getParameter("Title");

        Product product = new Product(id, title);
        productDAO.saveSql(product);
        req.setAttribute("products", productDAO.getALL());
        return "sql";
    }
}






