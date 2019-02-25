package br.com.usuariocrud.services;

import java.util.List;

import br.com.usuariocrud.model.UsuariosModel;;

public interface IUsuarioService {
	
	void usuarioSave(UsuariosModel usuario);
	void usuarioDelete(UsuariosModel usuario);
	List<UsuariosModel> findAll();
	UsuariosModel findUsuarioById(Integer id);
}
