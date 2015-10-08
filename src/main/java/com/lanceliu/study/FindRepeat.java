package com.lanceliu.study;

import java.util.*;

public class FindRepeat {
    public static void doString(String str){
        char[] array=str.toCharArray();
        ArrayList list=new ArrayList();
        TreeSet set=new TreeSet();
        for(int i=0;i<array.length;i++){
            list.add(String.valueOf(array[i]));
            set.add(String.valueOf(array[i]));
        }
        Collections.sort(list);
        System.out.println("list获得的值为："+list);
        System.out.println("set获得的值为："+set);
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<list.size();i++){
            sb=sb.append(list.get(i));
        }
        str=sb.toString();
        int max=0;
        HashMap hm=new HashMap();
        for(Iterator itss=set.iterator();itss.hasNext();){
            String os=(String)itss.next();
            int begin=str.indexOf(os);
            int end=str.lastIndexOf(os);
            int value=end-begin+1;
            hm.put(os,value);
            if((value>max)&&(value>1)){
                max=value;
            }
        }
        Set set2=hm.entrySet();
        Iterator iterator=set2.iterator();
        while(iterator.hasNext()){
            Map.Entry mapentry=(Map.Entry)iterator.next();
            if(mapentry.getValue().equals(max)){
                System.out.println("最多的字符串为："+mapentry.getKey());
                System.out.println("最多的次数为："+max);
            }

        }
    }
    public static void main(String[] args){
        String strInput = new String("aavzcadfdsfsdhshgWasdfasdfffff");
        doString(strInput);
    }
}