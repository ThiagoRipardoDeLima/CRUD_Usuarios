package br.com.usuariocrud.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="aparelhos")
public class AparelhosModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aparelho")
	private Long idAparelho;

	@Column(name="codigo_aparelho")
	private String codigoAparelho;

	@Column(name="descricao_aparelho")
	private String descricaoAparelho;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="aparelhos")
	private List<UsuariosModel> usuarios;

	public AparelhosModel() {
	}

	public Long getIdAparelho() {
		return this.idAparelho;
	}

	public void setIdAparelho(Long idAparelho) {
		this.idAparelho = idAparelho;
	}

	public String getCodigoAparelho() {
		return this.codigoAparelho;
	}

	public void setCodigoAparelho(String codigoAparelho) {
		this.codigoAparelho = codigoAparelho;
	}

	public String getDescricaoAparelho() {
		return this.descricaoAparelho;
	}

	public void setDescricaoAparelho(String descricaoAparelho) {
		this.descricaoAparelho = descricaoAparelho;
	}

	public List<UsuariosModel> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<UsuariosModel> usuarios) {
		this.usuarios = usuarios;
	}

}