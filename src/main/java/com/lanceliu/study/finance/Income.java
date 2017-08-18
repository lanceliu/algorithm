package com.lanceliu.study.finance;

/**
 *
 * @author lanceliu <liuyunfei@yuntujinfu.com>
 * @date 16/6/22
 */
public class Income {

    /* 初始投资本金 */
    double principal = 1000000;
    /* 每笔投资期限 */
    int term = 12;
    /* 年化收益率 */
    double ratio = 0.1;


    /* 每期还款比率 */
    double X=(ratio+1)/12;
    /* 每期每月可获取的收益 */
    double Y=ratio/12;

    /* 当前月份可用投资额度 */
    public double calculateUsageAmount( int month ) {
        if( month == 1)
            return principal;
        else
        {
            double a = 0;
            for ( int i=month;i >1;i--) {
                a +=calculateUsageAmount(i -1)*X;
            }
            return a;
        }
    }

    /* 当前月份获取的累计收益 */
    public double calculateInterestAmount( int month ) {
        double a= 0;
        for(int i=month;i>0;i--) {
            a += calculateUsageAmount(i)*Y*12;
        }
        return a;
    }

    /* 当前月份额度 */
    public void printAmount( int month ) {
        for(int i=month;i>0;i--) {
            System.out.println( String.format("第%s个月可放款额度%s", i,  calculateUsageAmount(i)) );
        }
    }

    public static void main(String[] args) {
        Income a = new Income();
        a.printAmount(2);
        for ( int i =1;i<=12;i++)
            System.out.println(String.format("第%s个月累计收益%s", i,  a.calculateInterestAmount(i)));
    }

}
