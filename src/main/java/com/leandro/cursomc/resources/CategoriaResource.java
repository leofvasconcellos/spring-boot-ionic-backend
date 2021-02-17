package com.leandro.cursomc.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.leandro.cursomc.domain.Categoria;
import com.leandro.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Optional<Categoria> obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public List<Categoria> Listar() {						
		List<Categoria> lista = new ArrayList<>();
		  
		lista = service.listar();		
		
		return lista;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		
		UriComponents uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId());
		
		return ResponseEntity.created(uri.toUri()).build();
	}
}
