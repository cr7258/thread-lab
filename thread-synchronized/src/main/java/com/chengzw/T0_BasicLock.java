package com.chengzw;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author chengzw
 * @description
 * @since 2021/5/29
 */
@Slf4j
public class T0_BasicLock {
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object o = new Object();
        //log.info(ClassLayout.parseInstance(o).toPrintable()); //匿名偏向

        new Thread(()->{
            synchronized (o){
                log.info(ClassLayout.parseInstance(o).toPrintable());  //偏向锁
            }
        }).start();

        //注释变成重量级锁
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //log.info(ClassLayout.parseInstance(o).toPrintable());  //偏向锁
        new Thread(()->{
            synchronized (o){
                log.info(ClassLayout.parseInstance(o).toPrintable());  //存在两个线程进入同步块，偏向锁升级成轻量级锁
            }
        }).start();
    }
}
