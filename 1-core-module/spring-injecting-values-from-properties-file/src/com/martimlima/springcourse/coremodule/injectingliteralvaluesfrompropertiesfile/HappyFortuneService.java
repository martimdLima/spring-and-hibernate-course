package com.martimlima.springcourse.coremodule.injectingliteralvaluesfrompropertiesfile;

public class HappyFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    return "Today is your lucky day!";
  }
}
