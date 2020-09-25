package com.martimlima.springcourse.coremodule.javaconfiginjectvaluesfrompropsfile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
// @ComponentScan("com.mdlima.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  // define bean for our sad fortune service
  @Bean
  public FortuneService sadFortuneService() {
    return new SadFortuneService();
  }

  // define bean for our swim coach AND inject dependency
  @Bean
  public Coach swimCoach() {
    SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());

    return mySwimCoach;
  }
}
