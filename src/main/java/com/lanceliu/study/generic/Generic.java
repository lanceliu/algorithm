package com.lanceliu.study.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liufei
 * @date 15/7/19
 */
public class Generic {
    public static void main(String[] args) {
        List<Object> lst = new ArrayList<Object>();
        lst.add(new Integer(1));
        lst.add(1);

        List<?> lst1 = new ArrayList();
        lst.add("sdf");

    }
}
