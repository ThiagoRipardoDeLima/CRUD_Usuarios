package br.com.usuariocrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.usuariocrud.model.PerfilModel;
import br.com.usuariocrud.model.ResponseModel;
import br.com.usuariocrud.services.PerfilService;


/**
 * @author Thiago Ripardo
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PerfilController {

	@Autowired
	private PerfilService perfilService;

	/* SALVAR UM NOVO PERFIL
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="/perfil", method = RequestMethod.POST)
	public @ResponseBody ResponseModel salvar(@RequestBody PerfilModel perfil) {
		try {

			this.perfilService.perfilSave(perfil);

			return new ResponseModel(1,"Registro salvo com sucesso!");

		} catch(Exception e) {
			return new ResponseModel(0,e.getMessage());
		}
	}

	/*
	 * ATUALIZAR O REGISTRO DE UM PERFIL
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="/perfil", method = RequestMethod.PUT)
	public @ResponseBody ResponseModel atualizar(@RequestBody PerfilModel perfil) {

		try {

			this.perfilService.perfilSave(perfil);

			return new ResponseModel(1,"Registro atualizado com sucesso!");

		} catch(Exception e) {
			return new ResponseModel(0,e.getMessage());
		}
	}

	/*
	 * CONSULTA TODOS OS PERFIL
	 * @param
	 * @return
	 */
	@RequestMapping(value="/perfil", method = RequestMethod.GET)
	public @ResponseBody List<PerfilModel> consultar() {
		return this.perfilService.findAll();
	}

	/*
	 * CONSULTA UM PERFIL PELO CODIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/perfil/{codigo}", method = RequestMethod.GET)
	public @ResponseBody PerfilModel buscar(@PathVariable("codigo") Integer codigo) {
		return this.perfilService.findPerfilById(codigo);
	}

	/*
	 * REMOVE UM USUARIO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/perfil/{codigo}", method = RequestMethod.POST)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo) {

		PerfilModel perfilModel = perfilService.findPerfilById(codigo);

		try {

			perfilService.perfilDelete(perfilModel);

			return new ResponseModel(1,"Registro Excluído com sucesso!");

		} catch(Exception e){
			return new ResponseModel(0,e.getMessage());
		}
	}

}