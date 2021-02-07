package br.com.projeto.produtos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.produtos.controller.dto.ProdutoDto;
import br.com.projeto.produtos.model.Produto;
import br.com.projeto.produtos.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired
	ProdutoService service;
	
	@GetMapping
	public ResponseEntity<Page<ProdutoDto>> listAll(Pageable paginacao) {
		
		try {
			LOGGER.debug("Função listar produtos");
			Page<ProdutoDto> list = service.list(paginacao);
			LOGGER.debug("Listando produtos");
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.debug("Erro ao carregar lista");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<ProdutoDto>> listById(@PathVariable String id, Model model) {
		try {
			List<ProdutoDto> produto = service.findById(id);
			LOGGER.debug("Listando pelo ID: " + id + ".");
			return new ResponseEntity<>(produto, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.debug("Erro ao carregar pelo ID: " + id + ".");
			LOGGER.debug("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		

	}
	
	@PostMapping("/")
	public ResponseEntity<ProdutoDto> save(@RequestBody @Validated Produto produto) {
		
		try {
			service.save(produto);
			LOGGER.debug("Salvando novo produto");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.debug("Erro ao salvar novo produto. Exception: " + e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProdutoDto> delete(@PathVariable String id) {
		
		try {
			service.deleteById(id);
			LOGGER.debug("ID: " + id + " deletado com sucesso.");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.debug("Erro ao deletar ID: " + id);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDto> update(@PathVariable String id, @RequestBody Produto p) {
		
		try {
			ProdutoDto produto = service.update(id, p);
			LOGGER.debug("Atualizando produto ID: " + id);
			return new ResponseEntity<ProdutoDto>(produto, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.debug("Erro ao atualizar produto ID: " + id);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
