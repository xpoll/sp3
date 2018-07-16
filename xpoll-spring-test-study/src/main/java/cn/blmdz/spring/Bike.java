package cn.blmdz.spring;

import lombok.Data;

@Data
public class Bike implements Abc {
    private String name;
    
    public Bike() {
        System.out.println("Bike bean");
    }

    @Override
    public void abc() {
        System.out.println("Bike bean abc");
        
    }
}
