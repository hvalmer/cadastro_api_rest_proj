package com.cadastros.apirestcad.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastros.apirestcad.models.Cadastro;
import com.cadastros.apirestcad.repository.CadastroRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
@Api(value="API REST Cadastros")
@CrossOrigin(origins="*")//liberando todos os domínios para acessar a API
public class CadastroResource {

	@Autowired
	CadastroRepository cadastroRepository;
	
	//Método GET para listar todos os cadastros
	@GetMapping("/cadastros")
	@ApiOperation(value="Retorna lista de cadastrados")
	public List<Cadastro> listaCadastros(){
		return cadastroRepository.findAll();
	}
	
	//Método GET para listar único cadastro
	@GetMapping("/cadastro/{id}")
	@ApiOperation(value="Retorna um cadastro único")
	public Cadastro listaCadastroUnico(@PathVariable(value="id") long id){
		return cadastroRepository.findById(id);
	}
	
	//Método POST salva determinado cadastro
	@PostMapping("/cadastro")
	@ApiOperation(value="Salva um cadastro")
	public Cadastro salvaCadastro(@RequestBody Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}
	
	//Método DELETE deleta determinado cadastro
		@DeleteMapping("/cadastro")
		@ApiOperation(value="Deleta um cadastro")
		public void deletaCadastro(@RequestBody Cadastro cadastro) {
			cadastroRepository.delete(cadastro);
		}
		
	//Método PUT atualiza determinado cadastro
		@PutMapping("/cadastro")
		@ApiOperation(value="Atualiza um cadastro")
		public Cadastro atualizaCadastro(@RequestBody Cadastro cadastro) {
			return cadastroRepository.save(cadastro);
		}
	
}
