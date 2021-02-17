package com.leandro.cursomc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.cursomc.domain.Pedido;
import com.leandro.cursomc.repositories.PedidoRepository;
import com.leandro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Optional<Pedido> buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return Optional.ofNullable(obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())));
	}
	
	public List<Pedido> listar() {
		List<Pedido> lista = new ArrayList<>();
		lista = repo.findAll();		
		
		return lista;
	}
}
