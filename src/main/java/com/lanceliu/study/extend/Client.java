package com.lanceliu.study.extend;

/**
 * @author liufei
 * @date 15/7/24
 */
public class Client {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.printStr();

        parent = new Child2();

        parent.printStr();
    }
}
