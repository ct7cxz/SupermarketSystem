package org.dfzr.service;

import org.dfzr.pojo.Product;
import org.dfzr.vo.PageVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface IProductService {

    PageVo findPage(String name, Integer currentPage);

    Product findOne(Integer proId);

    void addProduct(MultipartFile file, Product product,String path) throws IOException;

    void deleteProduct(Integer proId);

    void deleteProductList(Integer[] check_val);
}
