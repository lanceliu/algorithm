package com.lanceliu.study.sort;

/**
 * @author liufei
 * @date 15/5/15
 */
public class ShellSort {
    public static int[] a = {4, 2, 1, 6, 3, 6, 0, -5, 1, 1};

    public static void main(String[] args ) {
        int i;
        int index = a.length;

        System.out.println("排序前");
        for(i=0;i < index;i++)
            System.out.printf("%3s ", a[i]);
        System.out.println();

        shellSort(a);

    }

    public static void outputArray(int[] a) {
        for(int i=0;i < a.length;i++)
            System.out.printf("%3s ", a[i]);
        System.out.println();
    }

    public static void shellSort(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                System.out.println("2:  " + increment + "  " + i);
                for (j = i; j >= increment; j -= increment) {
                    System.out.println("3:  " + data[j] + "  " +j);

                    if(temp > data[j - increment]){
                        data[j] = data[j - increment];
                    }else{
                        break;
                    }
                }
                data[j] = temp;
                outputArray(data);
System.out.println();
            }
            outputArray(data);
        }
    }
}
