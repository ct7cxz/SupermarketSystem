package org.dfzr.controller;

import org.dfzr.pojo.Product;
import org.dfzr.service.IProductService;
import org.dfzr.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /*查找当前页面的所有信息*/
    @RequestMapping(path = "/findPage")
    public String findPage(Model model, String name, HttpServletResponse response, Integer currentPage) {
        response.setContentType("text/html;charset=utf-8");
        PageVo page = productService.findPage(name, currentPage);
        //查询到的当前页的信息
        model.addAttribute("page", page);
        //模糊查询结果回显
        model.addAttribute("name", name);
        return "list";
    }

    /*查找商品的详细信息*/
    @RequestMapping(path = "/details")
    public String details(Integer proId, Model model) {
        Product product = productService.findOne(proId);
        model.addAttribute("product", product);
        return "details";
    }

    /*删除商品信息*/
    @RequestMapping(path = "/deleteProduct")
    public String deleteProduct(Integer proId, Integer currentPage, String name, Model model) {
        productService.deleteProduct(proId);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("name", name);
        return "forward:/product/findPage";
    }

    /*批量删除*/
    @RequestMapping(path = "/deleteProductList")
    public String deleteProductList(Integer currentPage, String name, Model model,Integer[] check_val){
        productService.deleteProductList(check_val);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("name", name);
        return "forward:/product/findPage";
    }

    /*转发到新增商品页面*/
    @RequestMapping(path = "/add")
    public String add() {
        return "add";
    }

    /*新增商品信息*/
    @RequestMapping(path = "/addProduct")
    public String addProduct(MultipartFile file, Product product, HttpServletRequest request) throws IOException {
        String path = request.getServletContext().getRealPath("/upload/");
        productService.addProduct(file, product, path);
        return "redirect:/product/findPage";
    }
}
