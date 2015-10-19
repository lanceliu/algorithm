package com.lanceliu.dsaa.afterclass.chapter01;

import java.util.Scanner;

/**
 * TODO: describe.
 *
 * @author lanceliu <liuyunfei@yuntujinfu.com>
 * @date 15/10/15
 */
public class Question6 {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        new Question6().permute(scan.nextLine());
    }

    public void permute( String str ) {
        if (str == null && "".equals(str))
            return;
        char buf[] = str.toCharArray();
        perm(buf,0,buf.length-1);
    }

    public static void perm(char[] buf,int start,int end){

//这个判断很关键，每次递归到最后的时候，就是START每次都等于END的时候，就是要打印出相
// 应的全排列字符串的时候，

        if(start==end){//这个判断用于递归到最后的时候输出相应的字符串
            for(int i=0;i<=end;i++){
                System.out.print(buf[i]);
            }

            System.out.println();

        } else {
//这个else块的作用有
//            1：交换第一个位置的字符，比如第一个位置的全排列字符串全部打印后 就把第一个字符和第二个交换；
//            2：递归打印每次第一个字符串的全排列字符串；
//            3：每次递归的时候都会传递一个字符串数组，最后三行代码就是控制这个字符串数组不变，意思就是
//什么样子传递出去，就什么样子传递回来，一点不能变化，因为最后三行代码不是用于改变字符串数组的

            int[] indexArray = new int[buf.length];
            for (int i=0; i< buf.length; i++) {
                for (int j=0; j<buf.length; j++) {
                    if (buf[i] == buf[j])
                        indexArray[j] = i;
                }
            }



            for(int i=start;i<=end;i++){

                char temp=buf[start];//这三行代码用于控制第一个位置的字符，就是作用1
                buf[start]=buf[i]; //比如,第一次时的第一个字符的全排列输出完后,
                buf[i]=temp;


                // 如果有重复元素时，跳过
                if ( indexArray[i] != i )
                    continue;

                // 全排列输出
                for (int j=0;j<=start;j++)
                    System.out.print(buf[j]);
                System.out.println();

                perm(buf,start+1,end);//通过start控制要被输出的字符串，对应作用2

                temp=buf[start];
                buf[start]=buf[i];
                buf[i]=temp;
            }
        }

    }
}
