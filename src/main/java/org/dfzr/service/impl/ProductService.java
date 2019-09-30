package org.dfzr.service.impl;

import com.github.pagehelper.PageHelper;
import org.dfzr.dao.IProductDao;
import org.dfzr.pojo.Product;
import org.dfzr.service.IProductService;
import org.dfzr.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductService implements IProductService {

    @Autowired
    IProductDao dao;


    public PageVo findPage(String name, Integer currentPage) {
        PageVo pageVo = new PageVo();
        if (currentPage == null) {
            currentPage = 1;
        }
        PageHelper.startPage(currentPage, 5);
        List<Product> productList = dao.findPage(name);
        //设置当前页数
        pageVo.setCurrentPage(currentPage);
        //设置总条数
        Integer totalCount = dao.findProductSum();
        pageVo.setTotalCount(totalCount);
        //设置总页数
        int totalPage = (int) Math.ceil(1.0 * totalCount / 5);
        pageVo.setTotalPage(totalPage);
        //设置查询结果
        pageVo.setObjects(productList);
        return pageVo;
    }

    @Override
    public Product findOne(Integer proId) {
        Product product = dao.findOne(proId);
        return product;
    }

    @Override
    public void addProduct(MultipartFile newFile, Product product, String path) throws IOException {
        File fileUp = new File(path);
        //判断但钱文件夹是否存在
        if (!fileUp.exists()) {
            fileUp.mkdirs();
        }
        //获取文件的上传名称
        String imgName = newFile.getOriginalFilename();
        //为防止文件重名，使用UUId
        String uuid = UUID.randomUUID().toString().replace("-", "");
        newFile.transferTo(new File(fileUp,uuid+"_"+imgName));

        //手动封装前端未封装的对象
        product.setIdDelete(0);
        //文件路径
        product.setProImage("/upload/"+uuid+"_"+imgName);
        //将上传的文件的信息进行持久化
        dao.addProduct(product);
    }

    /*单个删除*/
    @Override
    public void deleteProduct(Integer proId) {
        dao.deleteProduct(proId);
    }

    /*批量删除*/
    @Override
    public void deleteProductList(Integer[] check_val) {
        if(check_val.length==0||check_val==null){
            dao.deleteProductList(new Integer[]{0});
        }else {
            dao.deleteProductList(check_val);
        }
    }
}
