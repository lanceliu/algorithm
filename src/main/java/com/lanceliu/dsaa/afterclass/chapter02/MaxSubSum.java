package com.lanceliu.dsaa.afterclass.chapter02;

/**
 * TODO: describe.
 *
 * @author lanceliu <liuyunfei@yuntujinfu.com>
 * @date 15/10/26
 */
public class MaxSubSum {
    public  static void main(String[] args) {
        int[] a = { 4, -3, 5, -2, -1, 2, 6, -2};
        int max1 = maxSubSum1( a );
        System.out.println( max1 );
        int max2 = maxSubSum2(a);
        System.out.println( max2 );
        int max3 = maxSubSum3(a, 0, a.length - 1 );
        System.out.println( max3 );
        int max4 = maxSubSum4(a );
        System.out.println( max4 );
    }

    /**
     * ∑ ∑ ∑ ＝ n^3
     * most inner: i~j = j-i+1
     * second: i~a.length = (N-1 - i)(N-i)/2
     *
     * @param a
     * @return
     */
    public static int maxSubSum1( int[] a ) {
        int maxSum = 0;

        for ( int i = 0; i < a.length; i++ ) {
            for ( int j = i; j < a.length; j++) {

                int thisSum = 0;
                for ( int k = i; k <= j ; k++ ) {
                    thisSum += a[k];
                    if ( maxSum < thisSum )
                        maxSum = thisSum;
                }

            }
        }

        return maxSum;
    }

    /**
     * n ^ 2
     * @param a
     * @return
     */
    public static int maxSubSum2 ( int[] a ){
        int maxSum =0;

        for ( int i = 0; i < a.length; i++ ) {

            int thisSum = 0;
            for ( int j = i; j < a.length; j++ ) {
                thisSum += a[j];
                if ( maxSum < thisSum )
                    maxSum = thisSum;
            }
        }
        return maxSum;
    }

    /**
     * divide and conquer
     * @param a
     * @param left
     * @param right
     * @return
     */
    public static int maxSubSum3( int[] a, int left, int right ) {
        if ( left == right )
            if ( a[left] > 0 )
                return a[left];
            else
                return 0;

        int center = ( left + right )/2;
        int maxLeft = maxSubSum3( a, left, center );
        int maxRight = maxSubSum3( a, center+1, right );

        int leftPartMax = 0, leftPartSum =0;
        for ( int i = center; i >= left; i-- ) {
            leftPartSum += a[i];
            if ( leftPartMax < leftPartSum )
                leftPartMax = leftPartSum;
        }

        int rightPartMax = 0, rightPartSum =0;
        for ( int i = center + 1; i <= right; i++ ) {
            rightPartSum += a[i];
            if ( rightPartMax < rightPartSum )
                rightPartMax = rightPartSum;
        }

        return max( maxLeft, maxRight, leftPartMax + rightPartMax );
    }

    private static int max(int maxLeft, int maxRight, int i) {
        int max = maxLeft >= maxRight ? maxLeft : maxRight;
        max = max >= i ? max : i;
        return max;
    }

    /**
     * 最大子序列肯定是 正数开头和结尾的；
     * 加和<0时， 最大子序列开始位置肯定需要重新开始；
     * 加和小于前一项加和时，截至位置下表在前一项；
     *
     * <p>联机算法</p>
     * @param a
     * @return
     */
    private static int maxSubSum4( int[] a) {
        int max = 0, thisSum = 0;

        for ( int i = 0; i< a.length; i++ ) {
            thisSum += a[i];

            if ( thisSum > max)
                max = thisSum;

            if ( thisSum < 0)
                thisSum = 0;
        }

        return max;
    }

}
