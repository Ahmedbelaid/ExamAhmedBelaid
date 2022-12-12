package com.example.ahmed_belaid.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {


	
	@After("execution(void com.example.ahmed_belaid.Controllers.*.*(..))")
	public void apres(JoinPoint thisJoinPoint) {
		log.info("Out of the method (After)" + thisJoinPoint.getSignature().getName());
	}
	
	


}	