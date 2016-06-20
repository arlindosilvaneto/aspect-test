package test.aspect.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class GeneralAspect {
	final Logger logger = Logger.getAnonymousLogger();
	
	/**
	 * Advice para métodos que sejam validáveis e que contenham dois parâmetros.
	 * 
	 * @param joinPoint
	 * @param last
	 * @throws Throwable
	 */
	@Around("SystemArchitecture.isValidProne() && SystemArchitecture.hasLast(last)")
	public void validateLast(ProceedingJoinPoint joinPoint, String last) throws Throwable {
		if(last.trim().equals("")) {
			logger.severe("AROUND ADVICE: Invalid Last Parameter.");
			return;
		}
		
		joinPoint.proceed();
	}
	 
	/**
	 * Advice para execucao de métodos que contenham somente um parâmetro.
	 * 
	 * @param joinPoint
	 * @param first
	 */
	@Before("SystemArchitecture.onTools() && args(first)")
	public void appRunning(JoinPoint joinPoint, String first) {
		logger.info("BEFORE ADVICE: Running One Arg Tool: " + joinPoint.getKind() + " with " + first);
	}
	
	/**
	 * Advice para métods que executem algum utilitário e que retornem valores.
	 * 
	 * @param result
	 */
	@AfterReturning(pointcut="call(* test.aspect.lib.Tools.*(..))", returning="result")
	public void onCallTools(String result) {
		logger.info("AFTER RETURNING ADVICE: Tools chamado: " + result);
	}
	
	/**
	 * Advice for wildcard method on tools library.
	 */
	@After("execution(* test.aspect.lib.Tools.call*(..))")
	public void callToolCalled() {
		logger.info("AFTER ADVICE: Tools callable called");
	}
}
