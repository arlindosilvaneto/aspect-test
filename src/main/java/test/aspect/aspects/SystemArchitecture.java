package test.aspect.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {
	
	@Pointcut("execution(@test.aspect.annotations.Validate * *(..))")
	public void isValidProne() {}
	
	@Pointcut("args(..,last)")
	public void hasLast(String last) {}
}
