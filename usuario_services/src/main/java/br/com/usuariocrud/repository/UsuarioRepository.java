package br.com.usuariocrud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.usuariocrud.model.UsuariosModel;

public interface UsuarioRepository extends CrudRepository<UsuariosModel, Integer> {
	
	void delete(UsuariosModel usuario);
	
	List<UsuariosModel> findAll();

}
