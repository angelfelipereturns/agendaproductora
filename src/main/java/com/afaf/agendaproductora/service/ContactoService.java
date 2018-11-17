package com.afaf.agendaproductora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.afaf.agendaproductora.data.ContactoRepository;
import com.afaf.agendaproductora.data.model.Contacto;

@Service
public class ContactoService {
	
	@Autowired
	private ContactoRepository contactoRepository;
	
	
	public List<Contacto> contactoTodos() {
		return contactoRepository.findAll(Sort.by(Order.by("nombre")));
	}
	
	public Optional<Contacto> contactoPorId(Long id) {
		return contactoRepository.findById(id);
	}
	
	public Contacto contactoSave(Contacto contacto) {
		return contactoRepository.save(contacto);
	}
	
	public void contactoBorrar(Long id) {
		contactoRepository.deleteById(id);
	}
	
}
