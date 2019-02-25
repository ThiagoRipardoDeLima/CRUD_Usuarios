package br.com.usuariocrud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.com.usuariocrud.model.AparelhosModel;

public interface AparelhoRepository extends CrudRepository<AparelhosModel, Integer> {
	
	void delete(AparelhosModel aparelhos);
	
	List<AparelhosModel> findAll();
}
