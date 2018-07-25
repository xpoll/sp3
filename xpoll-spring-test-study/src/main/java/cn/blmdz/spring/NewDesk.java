package cn.blmdz.spring;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

import lombok.Data;

@Data
public class NewDesk implements MethodReplacer {
    private String name;
    
    public NewDesk() {
        System.out.println("NewDesk bean");
    }

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("NewDesk bean reimplement");
        return null;
    }
}
