package com.lanceliu.dsaa.afterclass.chapter02;

/**
 *
 * @author lanceliu <liuyunfei@yuntujinfu.com>
 * @date 15/10/29
 */
public class Gcd {

    public static void main(String[] a) {
        System.out.println( gcd(49,21) );
        System.out.println( primeProbability(10) );
    }

    private static int gcd(int i, int i1) {
        while ( i1 > 0) {
            int temp = i%i1;
            i = i1;
            i1 = temp;
        }

        return i;
    }

    private static double primeProbability( int n) {
        int rel = 0, tot = 0;
        for ( int i = 0; i < n; i++ ) {
            for ( int j = i + 1; j < n ;j++ ) {
                tot ++;
                if ( gcd ( j, i ) == 1 )
                    rel ++;
            }
        }

        return rel*1d/tot;
    }
}
