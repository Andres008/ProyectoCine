/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acardenas
 */
@Entity
@Table(name = "peliculas_actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeliculasActor.findAll", query = "SELECT p FROM PeliculasActor p"),
    @NamedQuery(name = "PeliculasActor.findById", query = "SELECT p FROM PeliculasActor p WHERE p.id = :id")})
public class PeliculasActor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "PELICULA_ACTOR_GENERATOR", sequenceName = "SEQ_PELICULA_ACTOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PELICULA_ACTOR_GENERATOR")
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @JoinColumn(name = "id_actor", referencedColumnName = "id")
    @ManyToOne
    private Actor idActor;
    @JoinColumn(name = "id_pelicula", referencedColumnName = "id")
    @ManyToOne
    private Peliculas idPelicula;

    public PeliculasActor() {
    }

    public PeliculasActor(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Actor getIdActor() {
        return idActor;
    }

    public void setIdActor(Actor idActor) {
        this.idActor = idActor;
    }

    public Peliculas getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Peliculas idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeliculasActor)) {
            return false;
        }
        PeliculasActor other = (PeliculasActor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cine.entidades.PeliculasActor[ id=" + id + " ]";
    }
    
}
