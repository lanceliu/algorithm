package com.lanceliu.study.recursion;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args)  {
        String[] array = new String[]{"1","2","3","4"};
        listAll(Arrays.asList(array), "");
    }
    public static void listAll(List candidate, String prefix) {
        //if(candidate.isEmpty()){
        System.out.println(prefix);
        //}
        for(int i=0;i<candidate.size();i++) {
            List tmp = new LinkedList(candidate);
            listAll(tmp, prefix + tmp.remove(i));//函数中的参数从右边开始解析
        }
    }

}
