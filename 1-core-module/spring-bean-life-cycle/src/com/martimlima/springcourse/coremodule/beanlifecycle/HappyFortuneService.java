package com.martimlima.springcourse.coremodule.beanlifecycle;

public class HappyFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    return "Today is your lucky day!";
  }
}
