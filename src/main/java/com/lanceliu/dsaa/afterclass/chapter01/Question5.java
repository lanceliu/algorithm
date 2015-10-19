package com.lanceliu.dsaa.afterclass.chapter01;

import java.util.Scanner;

/**
 * TODO: describe.
 *
 * @author lanceliu <liuyunfei@yuntujinfu.com>
 * @date 15/10/14
 */
public class Question5 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int l = 0;
        do {
            System.out.println("请输入一个数字");
            try {
                l = scan.nextInt();
            } catch (Exception e) {

            }
        } while (l <= 0);

        int a = outputBinaryOne(l);
        System.out.println("数字二进制中1的个数是：" + a);

    }

    private static int outputBinaryOne(int l) {
        if (l == 1)
            return 1;
        else {
            if (l % 2== 0)
                return outputBinaryOne(l/2);
            else
                return 1 + outputBinaryOne(l/2);
        }
    }
}
