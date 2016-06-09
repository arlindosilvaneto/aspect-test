package test.aspect.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class GeneralAspect {
	final Logger logger = Logger.getAnonymousLogger();
	
	@Around("SystemArchitecture.isValidProne() && SystemArchitecture.hasLast(last)")
	public void validateLast(ProceedingJoinPoint joinPoint, String last) throws Throwable {
		if(last.trim().equals("")) {
			logger.severe("ADVICE: Invalid Last Parameter.");
			return;
		}
		
		joinPoint.proceed();
	}
}
