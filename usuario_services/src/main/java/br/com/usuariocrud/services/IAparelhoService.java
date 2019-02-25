package br.com.usuariocrud.services;

import java.util.List;

import br.com.usuariocrud.model.AparelhosModel;

public interface IAparelhoService {
	void aparelhoSave(AparelhosModel usuario);
	void aparelhoDelete(AparelhosModel usuario);
	List<AparelhosModel> findAll();
	AparelhosModel findAparelhosById(Integer id);
}
