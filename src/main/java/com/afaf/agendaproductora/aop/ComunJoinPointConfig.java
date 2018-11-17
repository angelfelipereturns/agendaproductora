package com.afaf.agendaproductora.aop;

import org.aspectj.lang.annotation.Pointcut;

public class ComunJoinPointConfig {
	
	@Pointcut("execution(* com.afaf.agendaproductora.rest.ContactoRestController.contactoTodos(..))")
	public void pointContactoTodos() {}
	
	@Pointcut("execution(* com.afaf.agendaproductora.rest.ContactoRestController.contactoPorId(Long)) && args(id)")
	public void pointContactoPorId(Long id) {}

	
}
