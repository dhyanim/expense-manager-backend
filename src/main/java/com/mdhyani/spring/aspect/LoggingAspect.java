package com.mdhyani.spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	
	 @Around("execution(* com.mdhyani.spring.controller.UserController.getUsers())")
	   public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("logAround() is running!");
		System.out.println("hijacked method : " + joinPoint.getSignature().getName());
		System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

		System.out.println("Around before is running!");
		System.out.println("Around after is running!");
		System.out.println("******");
		return joinPoint.proceed();
	   }

}
