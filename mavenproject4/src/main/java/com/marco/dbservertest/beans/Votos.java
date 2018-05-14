/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marco.dbservertest.beans;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 *
 * @author marco
 */
@Entity
public class Votos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVotos;
    
    @Column
    private LocalDate ld;
    
    @JoinColumn
    private Restaurantes restaurant;

    public LocalDate getLd() {
        return ld;
    }

    public void setLd(LocalDate ld) {
        this.ld = ld;
    }

    public Restaurantes getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurantes restaurant) {
        this.restaurant = restaurant;
    }

   
    
    
    
    public Long getIdVotos() {
        return idVotos;
    }

    public void setIdVotos(Long idVotos) {
        this.idVotos = idVotos;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVotos != null ? idVotos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Votos)) {
            return false;
        }
        Votos other = (Votos) object;
        if ((this.idVotos == null && other.idVotos != null) || (this.idVotos != null && !this.idVotos.equals(other.idVotos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marco.votacao.Votos[ id=" + idVotos + " ]";
    }
    
}
