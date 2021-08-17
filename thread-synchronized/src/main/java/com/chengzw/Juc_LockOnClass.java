package com.chengzw;

/**
 * @author chengzw
 * @description
 * @since 2021/5/29
 */
public class Juc_LockOnClass {
    static int stock;

    public static synchronized void decrStock(){
        System.out.println(--stock);
    }

    public static synchronized void cgg(){
        System.out.println();
    }

    public static void main(String[] args) {
        //com.chengzw.Juc_LockOnClass.class对象
        Juc_LockOnClass.decrStock();
    }

}
