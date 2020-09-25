package com.martimlima.springcourse.coremodule.setterinjection;

public class HappyFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    return "Today is your lucky day!";
  }
}
