package test.aspect.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {
	
	/**
	 * Join points anotados com @Validate.
	 */
	@Pointcut("execution(@test.aspect.annotations.Validate * *(..))")
	public void isValidProne() {}
	
	/**
	 * Join points executados em Tools.
	 */
	@Pointcut("execution(* test.aspect.lib.Tools.*(..))")
	public void onTools() {}
	
	/**
	 * Join points com dois parâmetros, sendo o segundo utilizado no advice.
	 * 
	 * @param last
	 */
	@Pointcut("args(*,last)")
	public void hasLast(String last) {}
}
