package br.com.projeto.produtos.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.projeto.produtos.model.Produto;

public class ProdutoDto {

	private String id;
	private String nome;
	private BigDecimal valor;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public static Page<ProdutoDto> converterList(Page<Produto> produto) {
		return produto.map(ProdutoDto::new);
	}
	
	public static List<ProdutoDto> converterOpt(Optional<Produto> produto) {
		return produto.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}
	
	
}
