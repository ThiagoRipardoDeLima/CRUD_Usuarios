package br.com.usuariocrud.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Table(name = "perfil")
@Entity
public class PerfilModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil")
	private Long idPerfil;

	@Column(name="nome_perfil")
	private String nomePerfil;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="perfils")
	private List<UsuariosModel> usuarios;

	public PerfilModel() {
	}

	public Long getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNomePerfil() {
		return this.nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public List<UsuariosModel> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<UsuariosModel> usuarios) {
		this.usuarios = usuarios;
	}	
	
}
