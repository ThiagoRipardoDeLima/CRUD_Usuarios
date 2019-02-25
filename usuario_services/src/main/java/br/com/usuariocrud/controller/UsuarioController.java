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

import br.com.usuariocrud.model.ResponseModel;
import br.com.usuariocrud.model.UsuariosModel;
import br.com.usuariocrud.services.UsuarioServices;

/**
 * @author Thiago Ripardo
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsuarioController {
		
	@Autowired
	private UsuarioServices usuarioServices;

	/* SALVAR UM NOVO REGISTRO
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="/usuarios", method = RequestMethod.POST)
	public @ResponseBody ResponseModel salvar(@RequestBody UsuariosModel usuario) {
		
		
		try {

			this.usuarioServices.usuarioSave(usuario);

			return new ResponseModel(1,"Registro salvo com sucesso!");

		} catch(Exception e) {
			return new ResponseModel(0,e.getMessage());
		}
	}

	/*
	 * ATUALIZAR O REGISTRO DE UM USUARIO
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="/usuarios", method = RequestMethod.PUT)
	public @ResponseBody ResponseModel atualizar(@RequestBody UsuariosModel usuario) {

		try {

			this.usuarioServices.usuarioSave(usuario);

			return new ResponseModel(1,"Registro atualizado com sucesso!");

		} catch(Exception e) {
			return new ResponseModel(0,e.getMessage());
		}
	}

	/*
	 * CONSULTA TODOS OS USUARIO
	 * @param
	 * @return
	 */
	@RequestMapping(value="/usuarios", method = RequestMethod.GET)
	public @ResponseBody List<UsuariosModel> consultar() {
		return this.usuarioServices.findAll();
	}

	/*
	 * CONSULTA UM USUARIO PELO CODIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/usuarios/{codigo}", method = RequestMethod.GET)
	public @ResponseBody UsuariosModel buscar(@PathVariable("codigo") Integer codigo) {
		return this.usuarioServices.findUsuarioById(codigo);
	}

	/*
	 * REMOVE UM USUARIO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/usuarios/{codigo}", method = RequestMethod.POST)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo) {

		UsuariosModel usuarioModel = usuarioServices.findUsuarioById(codigo);

		try {

			usuarioServices.usuarioDelete(usuarioModel);

			return new ResponseModel(1,"Registro Excluído com sucesso!");

		} catch(Exception e){
			return new ResponseModel(0,e.getMessage());
		}
	}

}
