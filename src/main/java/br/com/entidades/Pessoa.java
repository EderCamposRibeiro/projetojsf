package br.com.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
	@SequenceGenerator(name = "pessoa_seq", sequenceName = "seq_pessoa", allocationSize = 1, schema = "public", initialValue = 2)
	private Long id;

	private String nome;
	private String sobrenome;
	private Integer idade;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento = new Date();

	private String sexo;

	private String[] frameworks;
	
	private Boolean ativo;
	
	private String login;
	private String senha;
	private String perfilUser;
	private String nivelProgramador;
	
	private Integer[] linguagens;
	
	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String unidade;
	private String ibge;
	private String gia;
	
	@Transient /*Não fica perssistente, ou seja, não grava no banco*/
	private Estados estados;
	
	@ManyToOne
	private Cidades cidades;
	
	@Column(columnDefinition="text") /*Tipo text grava arquivos em base 64*/
	private String fotoIconBase64;
	
	private String extensao; /*extensão jpg, pnh, jpeg, etc*/
	
    @Lob/*Usado para gravar arquivos no banco de dados*/
	@Basic(fetch = FetchType.LAZY)
	private byte[] fotoIconBase64Original;
	
	public String getFotoIconBase64() {
		return fotoIconBase64;
	}

	public void setFotoIconBase64(String fotoIconBase64) {
		this.fotoIconBase64 = fotoIconBase64;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public byte[] getFotoIconBase64Original() {
		return fotoIconBase64Original;
	}

	public void setFotoIconBase64Original(byte[] fotoIconBase64Original) {
		this.fotoIconBase64Original = fotoIconBase64Original;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}
	
	public Estados getEstados() {
		return estados;
	}
	
	public Cidades getCidades() {
		return cidades;
	}
	
	public void setCidades(Cidades cidades) {
		this.cidades = cidades;
	}
	
	public Pessoa() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setFrameworks(String[] frameworks) {
		this.frameworks = frameworks;
	}
	
	public String[] getFrameworks() {
		return frameworks;
	}
	

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getPerfilUser() {
		return perfilUser;
	}
	
	public void setPerfilUser(String perfilUser) {
		this.perfilUser = perfilUser;
	}
	
	public void setNivelProgramador(String nivelProgramador) {
		this.nivelProgramador = nivelProgramador;
	}
	
	public String getNivelProgramador() {
		return nivelProgramador;
	}
	
	public void setLinguagens(Integer[] linguagens) {
		this.linguagens = linguagens;
	}
	
	public Integer[] getLinguagens() {
		return linguagens;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", idade=" + idade
				+ ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + "]";
	}

}
