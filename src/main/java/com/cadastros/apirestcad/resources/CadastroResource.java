package com.cadastros.apirestcad.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastros.apirestcad.models.Cadastro;
import com.cadastros.apirestcad.repository.CadastroRepository;

/**
 * Crud dos cadastros.
 * 
 * @param add		  adicionar cadastro	
 * @param remover     remover cadastro
 * @param buscar      buscar cadastro
 * @param listar	  listar cadastros
 * @param adicioanar  adicionar cadastro
 * @return            lista json contendo os cadastros
 * @author            Harlan Valmer
 * @author            hvalmer@hotmail.com
 * @since    24/11/2019
 * @version  1.0
 */

@RestController
@RequestMapping(value="/api")
public class CadastroResource {

	@Autowired
	CadastroRepository cadastroRepository;
	
	//Método GET para listar todos os cadastros
	@GetMapping("/cadastros")
	public List<Cadastro> listaCadastros(){
		return cadastroRepository.findAll();
	}
	
	//Método GET para listar único cadastro
	@GetMapping("/cadastro/{id}")
	public Cadastro listaCadastroUnico(@PathVariable(value="id") long id){
		return cadastroRepository.findById(id);
	}
	
	//Método POST salva determinado cadastro
	@PostMapping("/cadastro")
	public Cadastro salvaCadastro(@RequestBody Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}
	
}
