package com.example.effective.chapter4.clauses16;

/**
 * 确保每个实例都有一个有效时间
 *
 * @Author: zhenglongze
 * @Date 2020/1/17 11:51
 */
public class Time {

    private static final int HOURS_TIME = 24;
    private static final int MINUTES_PER_HOURS = 60;

    private final int hour;

    private final int minute;

    public Time(int hour, int minute) {
        if(hour<0||hour>=HOURS_TIME){
            throw new IllegalArgumentException("hour:"+hour);
        }
        if(minute<0||minute>=MINUTES_PER_HOURS){
            throw new IllegalArgumentException("minute:"+minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
}
