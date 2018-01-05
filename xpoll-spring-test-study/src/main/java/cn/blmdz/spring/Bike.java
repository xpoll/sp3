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
        // TODO Auto-generated method stub
        
    }
}
