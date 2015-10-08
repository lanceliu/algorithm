package com.lanceliu.study;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：用1、2、2、3、4、5这六个数字，
 * 用java写一个main函数，打印出所有不同的排列，
 * 如：512234、412345等，要求：”4″不能在第三位，”3″与”5″不能相连.
 * @author hbj
 *
 */
public class Arithmetic2 {
    static Set<String> intSet = new HashSet<String>();
    public static void doSomething(Integer[] array,int count,String result){
        if(count==6){
            if(result.indexOf('4')!=2&&!result.contains("35")&&!result.contains("53")){
                intSet.add(result);
            }
        }else{
            for(int i=0;i<array.length;i++){
                if(array[i]!=0){
                    int temCount = count;
                    String _tem = result;
                    _tem += array[i]+"";
                    Integer[] _array = array.clone();
                    _array[i]=0;
                    doSomething(_array,++temCount,_tem);
                }
            }
        }
    }



    public static void main(String[] args){
        Integer[] array = new Integer[]{1,2,2,3,4,5};
        Arithmetic2.doSomething(array, 0, "");
        Integer  c=1;
        for(String s :intSet){
            System.out.println((c++)+": "+s);
        }
    }

}