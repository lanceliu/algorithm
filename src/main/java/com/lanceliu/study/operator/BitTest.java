package com.lanceliu.study.operator;

/**
 *
 * @author lanceliu <liuyunfei@yuntujinfu.com>
 * @date 16/2/15
 */
public class BitTest {
    public static void main(String[] args) {
        int n = 4;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        System.out.println(n);
    }
}
