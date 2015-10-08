package com.lanceliu.study.sort;

/**
 * @author liufei
 * @date 15/5/14
 */
public class BubbleSort {
    public static void bubbleSort1(int[] source) {
        for ( int i=source.length-1;i>0;i--) {
            for (int j=0; j< i;j++) {
                if (source[j] < source[j+1]) {
                    swap(source, j, j+1);
                }
            }
            outputArray(source);
        }
    }

    public static void bubbleSort2(int[] source) {
        for ( int i=0;i< source.length -1 ;i++) {
            for (int j=0; j< source.length - 1 -i;j++) {
                if (source[j+1] < source[j]) {
                    swap(source, j, j+1);
                }
            }
            outputArray(source);

        }
    }

    private static void swap(int[] source, int i, int j) {
        int temp = source[i];
        source[i] = source[j];
        source[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 1, 6, 3, 6, 0, -5, 1, 1};
        int i;
        bubbleSort2(a);

        for( i= 0; i<10;i++)
            System.out.printf("%d", a[i]);
    }
    public static void outputArray(int[] a) {
        for(int i=0;i < a.length;i++)
            System.out.printf("%3s ", a[i]);
        System.out.println();
    }
}
