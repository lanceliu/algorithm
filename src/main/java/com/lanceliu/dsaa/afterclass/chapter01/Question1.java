package com.lanceliu.dsaa.afterclass.chapter01;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择问题答案
 *
 * 选择问题是指从N个数当中，按升序（降序也可以）排列，找出第k个数。
 * LZ的写法是采用书中给出的算法自己实现的，分别采用冒泡排序和分批处理的方式。以下为LZ写出的算法代码。
 *
 * @author lanceliu <liuyunfei@yuntujinfu.com>
 * @date 15/9/18
 */
public class Question1 {
    public static final Random RANDOM = new Random(47);

    //假设N = 10
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printResult(createArray(RANDOM.nextInt(100000)));
        }
    }

    //冒泡排序
    public static void sort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            for (int j = 0; j < values.length - i; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }

    //分批处理
    public static int select(int[] values) {
        if (values == null || values.length == 0) {
            throw new NullPointerException("values can't be null.");
        }
        int k = values.length / 2;
        int[] temp = Arrays.copyOf(values, k);
        sort(temp);
        for (int i = k; i < values.length; i++) {
            if (values[i] < temp[k - 1]) {
                temp[k - 1] = temp[k - 2];
                for (int j = k - 2; j > 0; j--) {
                    if (values[i] > temp[j]) {
                        temp[j + 1] = values[i];
                        break;
                    } else {
                        temp[j] = temp[j - 1];
                    }
                }
            }
        }
        return temp[k - 1];
    }

    //创建随即数组
    public static int[] createArray(int length) {
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            values[i] = RANDOM.nextInt(length * 2);
        }
        return values;
    }

    //打印结果
    public static void printResult(int[] values) {

        System.out.println("length:" + values.length);
        long start = System.currentTimeMillis();
        System.out.println("result:" + select(values));
        System.out.println("cost:" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("--------------------------------");
    }
}
