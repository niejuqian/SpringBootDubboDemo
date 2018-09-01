package com.springboot.dubbo.demo.war.util;

/**
 * Created by laonie on 2018/9/1.
 */
public class Test {

    public static void main(String[] args) {
        WeekDay weekDay = WeekDay.MON;
        System.out.println(weekDay);
        System.out.println(weekDay.nextDay());

        System.out.println(TrafficLamp.GREEN.nextLamp());
    }

    public enum TrafficLamp{
        READ(){
            @Override
            public TrafficLamp nextLamp() {
                return YELLOW;
            }
        },
        GREEN {
            @Override
            public TrafficLamp nextLamp() {
                return READ;
            }
        },
        YELLOW {
            @Override
            public TrafficLamp nextLamp() {
                return READ;
            }
        };

        public abstract TrafficLamp nextLamp();
    }
}
