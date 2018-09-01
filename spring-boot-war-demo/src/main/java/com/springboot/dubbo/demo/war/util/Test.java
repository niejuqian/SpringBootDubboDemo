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

        Test test = new Test();
        Test test2 = new Test();
        Class cls1 = test.getClass();
        Class cls2 = Test.class;
        System.out.println(cls1 == cls2);
        Class cls3 = test2.getClass();
        System.out.println(cls1 == cls3);
        System.out.println(cls3.isPrimitive());
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
