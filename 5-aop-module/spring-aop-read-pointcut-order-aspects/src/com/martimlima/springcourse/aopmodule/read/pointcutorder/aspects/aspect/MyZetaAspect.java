package com.martimlima.springcourse.aopmodule.read.pointcutorder.aspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(6)
public class MyZetaAspect {

	@Before("com.martimlima.springcourse.aopmodule.read.pointcutorder.aspects.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> FUNNY");		
	}

}
