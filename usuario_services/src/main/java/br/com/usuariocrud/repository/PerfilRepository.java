package br.com.usuariocrud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.com.usuariocrud.model.PerfilModel;

public interface PerfilRepository extends CrudRepository<PerfilModel, Integer> {
	
	void delete(PerfilModel perfil);
	
	List<PerfilModel> findAll();

}
