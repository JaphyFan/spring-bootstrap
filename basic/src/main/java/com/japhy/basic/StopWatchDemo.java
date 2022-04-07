package com.japhy.basic;

import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.time.StopWatch;

/**
 * @author Japhy
 * @since 2022/2/15 13:43
 */
public class StopWatchDemo {

    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        TimeUnit.SECONDS.sleep(3L);
        System.out.println(stopWatch.formatTime());
        stopWatch.stop();

    }

}
