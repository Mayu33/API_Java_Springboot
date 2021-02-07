package br.com.projeto.produtos.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.projeto.produtos.controller.ProdutoController;
import br.com.projeto.produtos.controller.dto.ProdutoDto;
import br.com.projeto.produtos.model.Produto;
import br.com.projeto.produtos.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService{

	private final static Logger LOGGER = LoggerFactory.getLogger(ProdutoServiceImpl.class);
	
	@Autowired
	ProdutoRepository repository;

	@Override
	public Produto save(Produto produto) throws SQLException {
		return repository.save(produto);
	}

	@Override
	public void deleteById(String id) throws SQLException {
		
		repository.deleteById(id);
		
	}

	@Override
	public List<ProdutoDto> findById(String id) throws SQLException {
		List<ProdutoDto> produto = ProdutoDto.converterOpt(repository.findById(id));
		return produto;
	}

	@Override
	public Page<ProdutoDto> list(Pageable paginacao) throws SQLException {
		
		Page<Produto> paginado = repository.findAll(paginacao);
		Page<ProdutoDto> produtos = ProdutoDto.converterList(paginado);
		return produtos;
	}
	
	public ProdutoDto update(String id, Produto p) throws SQLException {
		
		Optional<Produto> produtoEdit = repository.findById(id);
		if(produtoEdit.isPresent()) {
			Produto produto = produtoEdit.get();
			produto.setNome(p.getNome());
			produto.setValor(p.getValor());
			repository.save(produto);
			return new ProdutoDto(produto);
		}else{
		 throw new SQLException();
		}
	}
}
