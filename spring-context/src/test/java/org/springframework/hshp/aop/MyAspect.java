package org.springframework.hshp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @ClassName MyAspect
 * @Description TODO
 * @Author HX0011049
 * @Date 2019/11/27 14:37
 */

@Aspect
public class MyAspect {

	@Pointcut("execution(* org.springframework.hshp.aop.*.*(..))")
	public void myPointcut() {
	}

	@Before("myPointcut()")
	public void before(JoinPoint joinPoint) {
		System.out.println("before:" + joinPoint.getSignature().getName());
		System.out.println("before");
	}

	@After("myPointcut()")
	public void after() {
		System.out.println("after");
	}

	@AfterThrowing("myPointcut()")
	public void afterThrowing() {
		System.out.println("AfterThrowing");
	}

	@AfterReturning("myPointcut()")
	public void afterReturning() {
		System.out.println("AfterReturning");
	}

	@Around("myPointcut()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around start");
		pjp.proceed();
		System.out.println("Around end");
	}
}
