package com.lanceliu.study.load;

/**
 * @author liufei
 * @date 15/7/21
 */
public class Client {
    public static void main(String args[]) {
        Parent a = new Child();
        Parent b = new Child("hello");
    }

}
