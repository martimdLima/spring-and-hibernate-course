package com.martimlima.springcourse.aopmodule.afterfinally.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.martimlima.springcourse.aopmodule.afterfinally.aopdemo.dao")
public class DemoConfig {

}
