/*
 * Copyright (C), 2016-2017, 上海苏宁信息技术有限公司
 * Author:   17032117
 * Date:     2017/7/30
 * History:  
 * <author>               <time>              <version>               <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.lanceliu.study.recursion;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
class Lift{
    public static void main(String[] args) {
        foo(5);
    }
    private static void foo(int count) {
        foo("1", count - 1);
        foo("2", count - 2);
    }
    private static void foo(String prifix, int count) {
        if (count < 0) {
            return;
        }
        if (count == 0) {
            System.out.println(prifix);
        } else {
            foo(prifix + ", 1", count - 1);
            foo(prifix + ", 2", count - 2);
        }
    }
}