package br.com.nosql.example.hibernateogm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
public class Historico implements Serializable {

	private static final long serialVersionUID = -6387096063273912763L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ID;
	@Field
	private Date registro;
	@Field
	private String descricao;
	@ManyToOne
	private Cliente cliente;

	public Historico() {
		super();
	}

	public Historico(Long iD, Date registro, String descricao, Cliente cliente) {
		super();
		ID = iD;
		this.registro = registro;
		this.descricao = descricao;
		this.cliente = cliente;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Historico other = (Historico) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Historico [ID=" + ID + ", registro=" + registro + ", descricao=" + descricao + ", cliente=" + cliente
				+ "]";
	}
}
