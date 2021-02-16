package com.leandro.cursomc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.cursomc.domain.Categoria;
import com.leandro.cursomc.repositories.CategoriaRepository;
import com.leandro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())));
	}
	
	public List<Categoria> listar() {
		List<Categoria> lista = new ArrayList<>();
		lista = repo.findAll();		
		
		return lista;
	}
}
