package com.martimlima.springcourse.aopmodule.afterthrowing;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.martimlima.springcourse.aopmodule.afterthrowing.dao")
public class DemoConfig {

}
