package com.martimlima.springcourse.coremodule.setterinjection;

public class Main {

    public static void main(String[] args) {
        // create the object
        Coach theCoach = new TrackCoach();

        // use the object
        System.out.println(theCoach.getDailyWorkout());
    }
}

