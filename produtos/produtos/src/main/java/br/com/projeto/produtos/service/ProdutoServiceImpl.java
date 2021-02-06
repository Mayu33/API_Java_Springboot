package br.com.projeto.produtos.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.projeto.produtos.controller.ProdutoController;
import br.com.projeto.produtos.model.Produto;

public class ProdutoServiceImpl implements ProdutoService{

	private final static Logger LOGGER = LoggerFactory.getLogger(ProdutoServiceImpl.class);

	@Override
	public Produto save(Produto produto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Produto> findById(Long idProduto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> list() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
