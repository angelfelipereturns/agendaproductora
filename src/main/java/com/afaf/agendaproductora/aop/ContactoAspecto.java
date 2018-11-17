package com.afaf.agendaproductora.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ContactoAspecto {
	
	@Before("com.afaf.agendaproductora.aop.ComunJoinPointConfig.pointContactoTodos()")
	public void beforeContactoTodos(JoinPoint joinPoint) {
		System.out.println("------>>>>>>>>>>> SE HA LLAMADO AL SERVICIO REST "+joinPoint.getSignature()+
				" cortado por "+this.getClass()+".beforeContactoTodos(JoinPoint joinPoint)");
	}
	
	@AfterReturning("com.afaf.agendaproductora.aop.ComunJoinPointConfig.pointContactoTodos()")
	public void afterContactoTodos(JoinPoint joinPoint) {
		System.out.println("------>>>>>>>>>>> SE HA EJECUTADO EL SERVICIO REST "+joinPoint.getSignature()+
				" cortado por "+this.getClass()+".afterContactoTodos(JoinPoint joinPoint)");
	}
	
	@AfterThrowing("com.afaf.agendaproductora.aop.ComunJoinPointConfig.pointContactoTodos()")
	public void throwingContactoTodos(JoinPoint joinPoint) {
		System.out.println("------>>>>>>>>>>> SE HA PRODUCIDO ERROR EN EL SERVICIO REST "+joinPoint.getSignature()+
				" cortado por "+this.getClass()+".vigilanteContactoTodos(JoinPoint joinPoint)");
	}
	
	/*@Around("com.afaf.agendaproductora.aop.ComunJoinPointConfig.pointContactoTodos()")
	public void vigilanteContactoTodos(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			System.out.println("------>>>>>>>>>>> SE HA LLAMADO AL SERVICIO REST "+proceedingJoinPoint.getSignature()+
					" cortado por "+this.getClass()+".vigilanteContactoTodos(ProceedingJoinPoint proceedingJoinPoint)");
			proceedingJoinPoint.proceed();
			System.out.println("------>>>>>>>>>>> SE HA EJECUTADO EL SERVICIO REST "+proceedingJoinPoint.getSignature()+
					" cortado por "+this.getClass()+".vigilanteContactoTodos(ProceedingJoinPoint proceedingJoinPoint)");
		} catch (Throwable e) {
			System.out.println("------>>>>>>>>>>> SE HA PRODUCIDO ERROR EN EL SERVICIO REST "+proceedingJoinPoint.getSignature()+
					" cortado por "+this.getClass()+".vigilanteContactoTodos(ProceedingJoinPoint proceedingJoinPoint)");
		}
	}*/
	
	@Before("com.afaf.agendaproductora.aop.ComunJoinPointConfig.pointContactoPorId(id)")
	public void beforeContactoPorId(JoinPoint joinPoint, Long id) {
		System.out.println("------>>>>>>>>>>> SE HA LLAMADO AL SERVICIO REST "+joinPoint.getSignature()+" con id="+id+
				" cortado por "+this.getClass()+".beforeContactoPorId(JoinPoint joinPoint, Long id)");
	}
	
	@AfterReturning("com.afaf.agendaproductora.aop.ComunJoinPointConfig.pointContactoPorId(id)")
	public void afterContactoPorId(JoinPoint joinPoint, Long id) {
		System.out.println("------>>>>>>>>>>> SE HA EJECUTADO EL SERVICIO REST "+joinPoint.getSignature()+" con id="+id+
				" cortado por "+this.getClass()+".afterContactoPorId(JoinPoint joinPoint, Long id)");
	}
	
	@AfterThrowing("com.afaf.agendaproductora.aop.ComunJoinPointConfig.pointContactoPorId(id)")
	public void throwingContactoPorId(JoinPoint joinPoint, Long id) {
		System.out.println("------>>>>>>>>>>> SE PRODUCIDO ERROR EN EL SERVICIO REST "+joinPoint.getSignature()+" con id="+id+
				" cortado por "+this.getClass()+".afterContactoPorId(JoinPoint joinPoint, Long id)");
	}
	
	/*@Around("com.afaf.agendaproductora.aop.ComunJoinPointConfig.pointContactoPorId(id)")
	public void vigilanteContactoPorId(ProceedingJoinPoint proceedingJoinPoint, Long id) {
		try {
			System.out.println("------>>>>>>>>>>> SE HA LLAMADO AL SERVICIO REST "+proceedingJoinPoint.getSignature()+" con id="+id+
					" cortado por "+this.getClass()+".vigilanteContactoPorId(ProceedingJoinPoint proceedingJoinPoint, Long id)");
			proceedingJoinPoint.proceed();
			System.out.println("------>>>>>>>>>>> SE HA EJECUTADO EL SERVICIO REST "+proceedingJoinPoint.getSignature()+" con id="+id+
					" cortado por "+this.getClass()+".vigilanteContactoPorId(ProceedingJoinPoint proceedingJoinPoint, Long id)");
		} catch (Throwable e) {
			System.out.println("------>>>>>>>>>>> SE HA PRODUCIDO ERROR EN EL SERVICIO REST "+proceedingJoinPoint.getSignature()+" con id="+id+
					" cortado por "+this.getClass()+".vigilanteContactoPorId(ProceedingJoinPoint proceedingJoinPoint, Long id)");
		}
	}*/
	
}
