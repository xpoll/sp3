package cn.blmdz.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.blmdz.spring.Bike;

public class BeansTest {

    public static void main(String[] args) {


        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean-servlet.xml");
        System.out.println(ac);
        Bike bike = (Bike) ac.getBean("bike");
        
        System.out.println(bike.getName());
    }
}
