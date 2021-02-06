package br.com.projeto.produtos.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projeto.produtos.model.Produto;

@Service
public interface ProdutoService {

	
	public Produto save(Produto produto) throws SQLException;
	
	public void deleteById(Long id) throws SQLException;
	
	public Optional<Produto> findById(Long idProduto) throws SQLException;
		
	public List<Produto> list() throws SQLException;
	
	
}
