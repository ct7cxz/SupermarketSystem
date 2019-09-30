package testService;

import org.dfzr.pojo.Product;
import org.dfzr.service.IProductService;
import org.dfzr.vo.PageVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class Test2 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application_service.xml");
        IProductService service = context.getBean("iProductService", IProductService.class);
        List<PageVo> page = (List<PageVo>) service.findPage("苹",1);
        System.out.println(page);
    }
}
