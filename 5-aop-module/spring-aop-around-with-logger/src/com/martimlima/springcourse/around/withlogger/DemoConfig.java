package com.martimlima.springcourse.around.withlogger;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.martimlima.springcourse.around.withlogger")
public class DemoConfig {

}
