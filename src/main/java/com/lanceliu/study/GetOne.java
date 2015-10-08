package com.lanceliu.study;

/**
 * @author liufei
 * @date 15/5/10
 */
public class GetOne {
    public static int count(int n){
        int count=0;
        while(n>0) {
            count+=(n%10==1)?1:0;
            n=n/10;
        }
        return count;
    }

    public static void main(String[] arg ){
        System.out.println(Count(111));
    }

    static int Count(int m){
        //1的个数  
        int count = 0;
        //当前位  
        int Factor = 1;
        //低位数字  
        int LowerNum = 0;
        //当前位数字  
        int CurrNum = 0;
        //高位数字  
        int HigherNum = 0;
        if(m <= 0){
            return 0;
        }
        while(m / Factor != 0){
            //低位数字  
            LowerNum = m - (m / Factor) * Factor;
            //当前位数字  
            CurrNum = (m / Factor) % 10;
            //高位数字  
            HigherNum = m / (Factor * 10);
            //如果为0,出现1的次数由高位决定  
            if(CurrNum == 0){
                //等于高位数字 * 当前位数  
                count += HigherNum * Factor;
            }
            //如果为1,出现1的次数由高位和低位决定  
            else if(CurrNum == 1){
                //高位数字 * 当前位数 + 低位数字 + 1  
                count += HigherNum * Factor + LowerNum + 1;
            }
            //如果大于1,出现1的次数由高位决定  
            else{
                //（高位数字+1）* 当前位数  
                count += (HigherNum + 1) * Factor;
            }
            //前移一位  
            Factor *= 10;
        }
        return count;
    }
}
