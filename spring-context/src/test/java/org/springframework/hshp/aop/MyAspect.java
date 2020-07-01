package org.springframework.hshp.aop;

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
	public void myPointcut() {}

	@Before("myPointcut()")
	public void doAccessCheck() {
		System.out.println("before");
	}

	@After("myPointcut()")
	public void doAccessCheck2() {
		System.out.println("After");
	}

	@AfterThrowing("myPointcut()")
	public void doAccessCheck3() {
		System.out.println("AfterThrowing");
	}

	@AfterReturning("myPointcut()")
	public void doAccessCheck4() {
		System.out.println("AfterReturning");
	}

	@Around("myPointcut()")
	public void doAccessCheck5(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around start");
		pjp.proceed();
		System.out.println("Around end");
	}
}
