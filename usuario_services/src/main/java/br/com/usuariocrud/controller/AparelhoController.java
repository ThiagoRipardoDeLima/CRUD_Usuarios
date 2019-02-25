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

import br.com.usuariocrud.model.AparelhosModel;
import br.com.usuariocrud.model.ResponseModel;
import br.com.usuariocrud.services.AparelhoService;


/**
 * @author Thiago Ripardo
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AparelhoController {
	
	@Autowired
	private AparelhoService aparelhoService;

	/* SALVAR UM NOVO PERFIL
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="/aparelho", method = RequestMethod.POST)
	public @ResponseBody ResponseModel salvar(@RequestBody AparelhosModel aparelho) {
		try {

			this.aparelhoService.aparelhoSave(aparelho);

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
	@RequestMapping(value="/aparelho", method = RequestMethod.PUT)
	public @ResponseBody ResponseModel atualizar(@RequestBody AparelhosModel aparelho) {

		try {

			this.aparelhoService.aparelhoSave(aparelho);

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
	@RequestMapping(value="/aparelho", method = RequestMethod.GET)
	public @ResponseBody List<AparelhosModel> consultar() {
		return this.aparelhoService.findAll();
	}

	/*
	 * CONSULTA UM PERFIL PELO CODIGO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/aparelho/{codigo}", method = RequestMethod.GET)
	public @ResponseBody AparelhosModel buscar(@PathVariable("codigo") Integer codigo) {
		return this.aparelhoService.findAparelhosById(codigo);
	}

	/*
	 * REMOVE UM USUARIO
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/aparelho/{codigo}", method = RequestMethod.POST)
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo) {

		AparelhosModel aparelhoModel = aparelhoService.findAparelhosById(codigo);

		try {

			aparelhoService.aparelhoDelete(aparelhoModel);

			return new ResponseModel(1,"Registro Excluído com sucesso!");

		} catch(Exception e){
			return new ResponseModel(0,e.getMessage());
		}
	}

}