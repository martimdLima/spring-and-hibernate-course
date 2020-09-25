package com.martimlima.springcourse.coremodule.annotationbeanlifecyclemethods;

public class SadFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    return "Today is a sad day";
  }
}
