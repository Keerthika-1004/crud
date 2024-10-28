package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {
	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

//	@Pointcut(value="execution(* com.example.demo.*.*.*(..) )")
//	@Pointcut("within(com.crud.controller..*)")
	
	//public void myPointcut() {

	//}

	@Before(value="execution(* com.example.demo.*.*.*(..) )")
	public void before(JoinPoint jPoint) {
		log.error("Before method invoked: " + jPoint.getArgs());
	}
	
	@After(value="execution(* com.example.demo.*.*.*(..) )")
	public void after(JoinPoint jPoint) {
		log.info("After method invoked: " + jPoint.getArgs());
	}
	
	@AfterReturning(value="execution(* com.example.demo.*.*.*(..) )")
	public void afterReturning(JoinPoint jPoint) {
		log.info("After returning method invoked: " + jPoint.getArgs());
	}
//	
//	@AfterThrowing(value="execution(* com.example.demo.*.*.*(..) )")
//	public void afterThrowing(JoinPoint jPoint) {
//		log.info("After throwing method invoked: " + jPoint.getArgs());
//	}
//	
//	@AfterThrowing(value="execution(* com.example.demo.*.*.*(..) )")
//	public void applicationLogger(JoinPoint jp, Exception e) {
//		log.error(e.getMessage(),e);      
//	}

	@Around(value="execution(* com.example.demo.*.*.*(..) )")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
				+ mapper.writeValueAsString(array));
		Object object = pjp.proceed();
		log.info(className + " : " + methodName + "()" + "Response : " + mapper.writeValueAsString(object));
		return object;
	}



}
