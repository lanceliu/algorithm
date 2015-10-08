package com.lanceliu.study.sort;

/**
 * @author liufei
 * @date 15/5/14
 */
public class InsertSort {
    public static void insertSort(int[] source) {
        for ( int i=1; i< source.length;i++) {
            for (int j=i; j>0;j--) {
                if (source[j] < source[j-1]) {
                    swap(source, j-1, j);
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
        insertSort(a);

        for( i= 0; i<10;i++)
            System.out.printf("%d", a[i]);
    }
    public static void outputArray(int[] a) {
        for(int i=0;i < a.length;i++)
            System.out.printf("%3s ", a[i]);
        System.out.println();
    }
}