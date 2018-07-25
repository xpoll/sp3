package cn.blmdz.spring;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }
    
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("userName");
        String email = element.getAttribute("email");
        if (StringUtils.hasText(name)) {
            builder.addPropertyValue("userName", name);
        }
        if (StringUtils.hasText(email)) {
            builder.addPropertyValue("email", email);
        }
    }
}
