package cn.blmdz.spring.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import cn.blmdz.spring.Bike;
import cn.blmdz.spring.LookUpMethod;
import cn.blmdz.spring.User;

@SuppressWarnings("deprecation")
public class BeansTest {

    public static void main(String[] args) throws Exception {

        // ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:bean-servlet.xml");
        // System.out.println(ac);

        Resource resource = new ClassPathResource("bean-servlet2.xml");
//        InputStream in = resource.getInputStream();
//      1.  
//        Reader reader = new InputStreamReader(in, "UTF-8");
//        StringBuilder out = new StringBuilder();
//        
//        char[] chars = new char[1024];
//        
//        while (true) {
//
//            int rsz = reader.read(chars, 0, chars.length);
//            if (rsz < 0)
//                break;
//            out.append(chars, 0, rsz);
//        }
//        System.out.println(out.toString());
//        2.
//        for (String str : IOUtils.readLines(in)) {
//            System.out.print(str);
//        }
//        3.
//      System.out.println(new BufferedReader(new InputStreamReader(in, "UTF-8")).lines().collect(Collectors.joining("\n")));
//      System.out.println(new BufferedReader(new InputStreamReader(in, "UTF-8")).lines().parallel().collect(Collectors.joining("\n")));
      
        
        
        BeanFactory bf = new XmlBeanFactory(resource);
        Bike bike = (Bike) bf.getBean("bike");

        System.out.println(bike.getName());

        LookUpMethod lookupMethod = (LookUpMethod) bf.getBean("lookupMethod");
        lookupMethod.show();

        User abc = (User) bf.getBean("abc");
        System.out.println(abc.getUserName());
        System.out.println(abc.getEmail());

    }
}
