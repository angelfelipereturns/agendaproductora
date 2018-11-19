package com.afaf.agendaproductora;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.afaf.agendaproductora.rest.ContactoRestController;
import com.afaf.agendaproductora.service.ContactoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendaProductoraApplicationTests {
	
	@Autowired
	private ContactoRestController contactoRestController;
	
	@Autowired
	private ContactoService contactoService;

	
	@Test
	public void contextLoads() {
		assertThat(contactoRestController).isNotNull();
		assertThat(contactoService).isNotNull();
	}

}
