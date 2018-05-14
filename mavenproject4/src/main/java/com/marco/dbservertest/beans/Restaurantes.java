/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marco.dbservertest.beans;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author marco
 */
@Entity
public class Restaurantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRestaurantes;
    @Column
    private String nome;
    @Column
    private String endereco="";
    
    @Column
    private LocalDate liberado;
    @Column
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

  
    

    public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getLiberado() {
		return liberado;
	}

	public void setLiberado(LocalDate liberado) {
		this.liberado = liberado;
	}

	public Long getIdRestaurantes() {
        return idRestaurantes;
    }

    public void setIdRestaurantes(Long idRestaurantes) {
        this.idRestaurantes = idRestaurantes;
    }
    
    
    
 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRestaurantes != null ? idRestaurantes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurantes)) {
            return false;
        }
        Restaurantes other = (Restaurantes) object;
        if ((this.idRestaurantes == null && other.idRestaurantes != null) || (this.idRestaurantes != null && !this.idRestaurantes.equals(other.idRestaurantes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marco.usuario.Restaurantes.Restaurantes[ id=" + idRestaurantes + " ]";
    }
    
}
