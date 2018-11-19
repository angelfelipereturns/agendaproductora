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
	
	
	public List<Contacto> contactoTodos() throws Exception {
		try {
			return contactoRepository.findAll(Sort.by(Order.by("nombre")));
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public Optional<Contacto> contactoPorId(final Long id) throws Exception {
		try {
			return contactoRepository.findById(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public Contacto contactoSave(final Contacto contacto) throws Exception {
		try {
			return contactoRepository.save(contacto);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public boolean contactoBorrar(final Long id) throws Exception {
		try {
			contactoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
}
