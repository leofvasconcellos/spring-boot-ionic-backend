package com.leandro.cursomc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.cursomc.domain.Cliente;
import com.leandro.cursomc.repositories.ClienteRepository;
import com.leandro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Optional<Cliente> find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())));
	}
	
	public List<Cliente> listar() {
		List<Cliente> lista = new ArrayList<>();
		lista = repo.findAll();		
		
		return lista;
	}
}
