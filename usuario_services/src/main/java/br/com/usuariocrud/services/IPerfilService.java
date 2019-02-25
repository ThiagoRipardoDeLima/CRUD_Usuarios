package br.com.usuariocrud.services;

import java.util.List;

import br.com.usuariocrud.model.PerfilModel;;

public interface IPerfilService {
	void perfilSave(PerfilModel usuario);
	void perfilDelete(PerfilModel usuario);
	List<PerfilModel> findAll();
	PerfilModel findPerfilById(Integer id);
}
