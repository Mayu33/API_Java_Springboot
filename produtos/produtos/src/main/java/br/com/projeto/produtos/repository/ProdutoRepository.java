package br.com.projeto.produtos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projeto.produtos.model.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{

}
