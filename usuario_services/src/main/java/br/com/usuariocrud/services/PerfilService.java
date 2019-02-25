/**
 * 
 */
package br.com.usuariocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usuariocrud.model.PerfilModel;
import br.com.usuariocrud.repository.PerfilRepository;

/**
 * @author Thiago Ripardo
 *
 */
@Service
public class PerfilService implements IPerfilService {

	@Autowired
	private PerfilRepository perfilRepository;

	@Override
	public void perfilSave(PerfilModel perfil) {
		this.perfilRepository.save(perfil);		
	}

	@Override
	public void perfilDelete(PerfilModel perfil) {
		this.perfilRepository.save(perfil);
	}

	@Override
	public List<PerfilModel> findAll() {
		return this.perfilRepository.findAll();
	}

	@Override
	public PerfilModel findPerfilById(Integer id) {
		PerfilModel perfil = this.perfilRepository.findById(id).get();
		return perfil;
	}

}
