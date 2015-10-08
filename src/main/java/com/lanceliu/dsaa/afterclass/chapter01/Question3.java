package com.lanceliu.dsaa.afterclass.chapter01;

import java.util.Scanner;

/**
 * TODO: describe.
 *
 * @author lanceliu <liuyunfei@yuntujinfu.com>
 * @date 15/9/22
 */
public class Question3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        printDigit(sc.nextDouble(), sc.nextInt());
    }

    private static void printDigit(double v, int reserveBit) {
        // 打印整数部分(包含符号)
        int intpart = (int) v;
        double decimal = v - intpart;

        if (intpart < 0) {
            System.out.print("-");
            intpart = -intpart;
            decimal = -decimal;
        }
        printOutput(intpart);

        // 打印.
        System.out.print(".");

        // 打印decimal部分, 实际时注意四舍五入
        int bit = 1;
        while (decimal != 0 && bit <= reserveBit) {
            decimal = decimal*10;
            intpart = (int) decimal;
            decimal = decimal - intpart;
            printOutput(intpart);
            bit ++;
        }
    }

    private static void printOutput(int intpart) {
        if (intpart / 10 > 0)
            printOutput(intpart/10);
        System.out.print(intpart%10);
    }
}
