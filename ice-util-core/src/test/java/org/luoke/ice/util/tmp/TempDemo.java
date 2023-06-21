package org.luoke.ice.util.tmp;

import java.util.Arrays;

/**
 * @author luoke
 * @date 2022/7/28 8:41
 */
public class TempDemo {
    public static void main(String[] args) {
        A[] a = new B[2];
        a[0] = new A();
        a[1] = new B();

        System.out.println(Arrays.toString(a));

    }
}

class A {}

class B extends A{}
