package com.lanceliu.study;

import java.util.Collections;

/**
 * @author liufei
 * @date 15/5/10
 */
public class Recursion {
    public static void main(String[] args){
        String s= "122";
        Pailie(s, "");
    }
    static int i=0;
    public static void  Pailie(String s, String p){

        if(s.length()<1){
            i++;
            System.out.println(p+"\n\n");
        } else {
            int index[]= new int[s.length()];
            for (int i=0;i<s.length();i++){
                index[i]=s.indexOf(s.charAt(i));

            }

            for (int i = 0; i< s.length();i++){
                if (i==index[i]){
                    System.out.println(p+s.substring(0,1)+"进入递归");

                    Pailie(s.substring(1), p+s.substring(0,1));
                }

                s=s.substring(1)+s.substring(0,1);
            }
        }
    }
}
