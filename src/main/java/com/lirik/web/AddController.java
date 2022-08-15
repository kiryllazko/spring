package com.lirik.web;


import org.springframework.stereotype.Controller;

@Controller
public class AddController {



//
//    @GetMapping("/add")
//    public String add() {
//               return "add";
//    }

//    @PostMapping("/add")
//    public void add(HttpServletRequest req, HttpServletResponse res)
//            throws IOException {
//        res.setContentType("text/html");
//
//        int Id = Integer.parseInt(req.getParameter("Id"));
//        String Title = req.getParameter("Title");
//        String Make = req.getParameter("Make");
//        String Model = req.getParameter("Model");
//        int Year = Integer.parseInt(req.getParameter("Year"));
//
//        try {
//            store.add(new VehiclePart(Id, Title, Make, Model, Year));
//        } catch (StoreException e) {
//            throw new RuntimeException(e);
//        }
//        res.sendRedirect("/store/parts");
//    }
}
