package cn.blmdz.spring;

public abstract class LookUpMethod {

    public void show() {
        this.getBean().abc();
    }
    
    public abstract Abc getBean();
}
