package com.chengzw;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author chengzw
 * @description
 * @since 2021/5/29
 */
public class T0_ObjectSize {

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5); //JVM为了减少偏向锁升级的开销，推迟了偏向锁的启动，时间大概是4s，
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}