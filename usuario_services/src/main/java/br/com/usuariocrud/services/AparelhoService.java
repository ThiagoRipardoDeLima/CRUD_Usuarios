/**
 * 
 */
package br.com.usuariocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usuariocrud.model.AparelhosModel;
import br.com.usuariocrud.repository.AparelhoRepository;

/**
 * @author Thiago Ripardo
 *
 */
@Service
public class AparelhoService implements IAparelhoService {

	@Autowired
	private AparelhoRepository aparelhoRepository;

	@Override
	public void aparelhoSave(AparelhosModel aparelho) {
		this.aparelhoRepository.save(aparelho);		
	}

	@Override
	public void aparelhoDelete(AparelhosModel aparelho) {
		this.aparelhoRepository.save(aparelho);
	}

	@Override
	public List<AparelhosModel> findAll() {
		return this.aparelhoRepository.findAll();
	}

	@Override
	public AparelhosModel findAparelhosById(Integer id) {
		AparelhosModel perfil = this.aparelhoRepository.findById(id).get();
		return perfil;
	}

}
