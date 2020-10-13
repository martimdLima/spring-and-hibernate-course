package com.martimlima.springcourse.aopmodule.around;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.martimlima.springcourse.aopmodule.around.dao")
public class DemoConfig {

}
