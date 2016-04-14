package br.com.nosql.example.hibernateogm.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Indexed
public class Cliente implements Serializable {

	private static final long serialVersionUID = -8692233477911164408L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	@Field
	private String nome;
	@Field
	private String telefone;
	@Field
	private String endereco;
	@Field
	private String bairro;
	@Field
	private String numero;
	@ManyToOne(cascade = CascadeType.ALL)
	private Cidade cidade;
	@IndexedEmbedded
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Historico> historicos = new ArrayList<Historico>();

	public Cliente() {
		super();
	}

	public Cliente(Long iD, String nome, String telefone, String endereco, String bairro, String numero,
			Cidade cidade,List<Historico> historicos) {
		super();
		ID = iD;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.historicos = historicos;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
		Cliente other = (Cliente) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [ID=" + ID + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco
				+ ", bairro=" + bairro + ", numero=" + numero + ", cidade=" + cidade + ", historicos=" + historicos
				+ "]";
	}
}
