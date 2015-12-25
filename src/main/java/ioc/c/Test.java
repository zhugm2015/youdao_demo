package ioc.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2015/12/19.
 */
public class Test {
    public static void main(String[] args) {
       /*
       //方式一：构造器
       Business business=new Business(new USBWriter());
        business.write();*/

        //方式二：getter方法
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
        Business business= (Business) applicationContext.getBean("business");
        business.write();
    }
}
