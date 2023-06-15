package com.java.servlet.scheduler;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorRepeat {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

        Runnable task1 = new Runnable() {
			
			@Override
			public void run() {
				count++;
	            System.out.println("Running...task1 - count : " + count);
			}
		}; 

        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 5, 24, TimeUnit.HOURS);//5시간 후 24시간 간격으로 실행시킨다.
        ScheduledFuture<?> scheduledFuture2 = ses.scheduleAtFixedRate(task1, 5, 2, TimeUnit.SECONDS);//5초 후 2초 간격으로 실행시킨다.

    }
}