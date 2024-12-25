package com.sportshop.sportshop.controller.admin;

import com.sportshop.sportshop.service.OrderService;
import com.sportshop.sportshop.service.ProductService;
import com.sportshop.sportshop.service.UserService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ModelAndView homeAdmin() {

        return  new ModelAndView("/admin/admin")
                .addObject("userQuantity", userService.countUsers())
                .addObject("productQuantity", productService.countProduct())
                .addObject("orderQuantity", orderService.getCount())
                .addObject("increase", orderService.getIncrease())
                .addObject("revenueByDay", orderService.getRevenueByDay(LocalDate.now().minusMonths(1), LocalDate.now()))
                .addObject("revenueByMonth", orderService.getRevenueByMonth(LocalDate.now().minusYears(1), LocalDate.now()))
                .addObject("productMostSold", productService.getProductMostSold());
    }
}
