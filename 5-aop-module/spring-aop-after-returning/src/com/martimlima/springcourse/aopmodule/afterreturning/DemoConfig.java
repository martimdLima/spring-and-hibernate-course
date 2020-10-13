package com.martimlima.springcourse.aopmodule.afterreturning;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.martimlima.springcourse.aopmodule.afterreturning.dao")
public class DemoConfig {

}
