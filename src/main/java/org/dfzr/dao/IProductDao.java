package org.dfzr.dao;

import org.dfzr.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

    //查询所有
    List<Product> findAllProduct();

    //模糊查询
    List<Product> findPage(String name);

    //查询总条数
    Integer findProductSum();

    Product findOne(Integer proId);

    void addProduct(Product product);

    void deleteProduct(Integer proId);

    void deleteProductList(Integer[] check_val);
}
