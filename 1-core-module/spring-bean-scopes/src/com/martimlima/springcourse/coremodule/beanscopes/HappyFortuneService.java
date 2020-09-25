package com.martimlima.springcourse.coremodule.beanscopes;

public class HappyFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    return "Today is your lucky day!";
  }
}
