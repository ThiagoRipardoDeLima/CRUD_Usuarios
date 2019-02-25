package br.com.usuariocrud.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="usuarios")
public class UsuariosModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long idUsuario;

	@Column(name="cod_autorizacao")
	private String codAutorizacao;

	@Column(name="cod_pessoa")
	private Long codPessoa;

	@Column(name="data_criacao")
	private Timestamp dataCriacao;
	
	@Column(name="email")
	private String email;
	
	@Column(name="login")
	private String login;

	@Column(name="nome_usuario")
	private String nomeUsuario;
	
	@Column(name="senha")
	private String senha;

	@Column(name="status_usuario")
	private String statusUsuario;

	@Column(name="tempo_expiracao_senha")
	private Integer tempoExpiracaoSenha;

	//bi-directional many-to-many association to Aparelho
	@ManyToMany
	@JoinTable(
			name="usuarios_aparelhos"
			, joinColumns={
					@JoinColumn(name="id_usuario")
			}
			, inverseJoinColumns={
					@JoinColumn(name="id_aparelho")
			}
			)
	private List<AparelhosModel> aparelhos;

	//bi-directional many-to-many association to Perfil
	@ManyToMany
	@JoinTable(
			name="usuarios_perfil"
			, joinColumns={
					@JoinColumn(name="id_usuario")
			}
			, inverseJoinColumns={
					@JoinColumn(name="id_perfil")
			}
			)
	
	private List<PerfilModel> perfils;

	public UsuariosModel() {
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodAutorizacao() {
		return this.codAutorizacao;
	}

	public void setCodAutorizacao(String codAutorizacao) {
		this.codAutorizacao = codAutorizacao;
	}

	public Long getCodPessoa() {
		return this.codPessoa;
	}

	public void setCodPessoa(Long codPessoa) {
		this.codPessoa = codPessoa;
	}

	public Timestamp getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Timestamp dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatusUsuario() {
		return this.statusUsuario;
	}

	public void setStatusUsuario(String statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public Integer getTempoExpiracaoSenha() {
		return this.tempoExpiracaoSenha;
	}

	public void setTempoExpiracaoSenha(Integer tempoExpiracaoSenha) {
		this.tempoExpiracaoSenha = tempoExpiracaoSenha;
	}

	public List<AparelhosModel> getAparelhos() {
		return this.aparelhos;
	}

	public void setAparelhos(List<AparelhosModel> aparelhos) {
		this.aparelhos = aparelhos;
	}

	public List<PerfilModel> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<PerfilModel> perfils) {
		this.perfils = perfils;
	}
	
}
