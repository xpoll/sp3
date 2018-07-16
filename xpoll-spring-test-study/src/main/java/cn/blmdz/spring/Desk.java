package cn.blmdz.spring;

import lombok.Data;

@Data
public class Desk implements Abc {
    private String name;
    
    public Desk() {
        System.out.println("Desk bean");
    }

    @Override
    public void abc() {
        System.out.println("Desk bean abc");
    }
}
