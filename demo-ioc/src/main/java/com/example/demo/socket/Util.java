package com.example.demo.socket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Util {

    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 5, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-hh-dd#HH-mm-ss");

    public static String getFileName() {
        return simpleDateFormat.format(new Date());
    }
}
