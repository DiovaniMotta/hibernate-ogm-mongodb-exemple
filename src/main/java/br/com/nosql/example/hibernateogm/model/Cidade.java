package br.com.nosql.example.hibernateogm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
public class Cidade implements Serializable {

	private static final long serialVersionUID = -7966436842501430679L;
	@Id
	@DocumentId
	@GeneratedValue
	private Long ID;
	@Field
	private String descricao;
	@Field(index = Index.YES)
	private String cep;
	@Field(index = Index.YES)
	private String UF;

	public Cidade() {
		super();
	}

	public Cidade(Long iD, String descricao, String cep, String uF) {
		super();
		ID = iD;
		this.descricao = descricao;
		this.cep = cep;
		UF = uF;
	}

	public Cidade(String descricao, String cep, String uF) {
		super();
		this.descricao = descricao;
		this.cep = cep;
		UF = uF;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
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
		Cidade other = (Cidade) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cidade [ID=" + ID + ", descricao=" + descricao + ", cep=" + cep + ", UF=" + UF + "]";
	}
}
