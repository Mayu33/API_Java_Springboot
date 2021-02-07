package br.com.projeto.produtos.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto.produtos.controller.dto.ProdutoDto;
import br.com.projeto.produtos.model.Produto;

@Service
public interface ProdutoService {

	
	public Produto save(Produto produto) throws SQLException;
	
	public void deleteById(String id) throws SQLException;
	
	public List<ProdutoDto> findById(String idProduto) throws SQLException;
		
	public List<ProdutoDto> list() throws SQLException;

	public ProdutoDto update(String id, Produto p) throws SQLException;
	
	
}
