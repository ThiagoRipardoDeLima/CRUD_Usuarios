
package br.com.usuariocrud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.usuariocrud.model.UsuariosModel;
import br.com.usuariocrud.repository.UsuarioRepository;

/**
 * @author Thiago Ripardo
 */
@Service
public class UsuarioServices implements IUsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void usuarioSave(UsuariosModel usuario) {
		this.usuarioRepository.save(usuario);
	}

	@Override
	public void usuarioDelete(UsuariosModel usuario) {
		this.usuarioRepository.delete(usuario);
	}

	@Override
	public List<UsuariosModel> findAll() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public UsuariosModel findUsuarioById(Integer id) {
		UsuariosModel usuario = this.usuarioRepository.findById(id).get();
		return usuario;
	}
	
}
