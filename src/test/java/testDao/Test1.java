package testDao;

import com.github.pagehelper.PageHelper;
import org.dfzr.dao.IProductDao;
import org.dfzr.pojo.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test1 {

    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application_dao.xml");
        IProductDao iProductDao = context.getBean("IProductDao", IProductDao.class);
        PageHelper.startPage(1,5);
        List<Product> allProduct = iProductDao.findPage("苹");
        for (Product product : allProduct) {
            System.out.println(product);
        }
    }
}
