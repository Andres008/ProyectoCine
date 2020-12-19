/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author acardenas
 */
@Entity
@Table(name = "actor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actor.findAll", query = "SELECT a FROM Actor a"),
    @NamedQuery(name = "Actor.findById", query = "SELECT a FROM Actor a WHERE a.id = :id"),
    @NamedQuery(name = "Actor.findByNombre", query = "SELECT a FROM Actor a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Actor.findByApellido", query = "SELECT a FROM Actor a WHERE a.apellido = :apellido"),
    @NamedQuery(name = "Actor.findByPais", query = "SELECT a FROM Actor a WHERE a.pais = :pais")})
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "pais")
    private String pais;
    @OneToMany(mappedBy = "idActor")
    private List<PeliculasActor> peliculasActorList;

    public Actor() {
    }

    public Actor(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @XmlTransient
    public List<PeliculasActor> getPeliculasActorList() {
        return peliculasActorList;
    }

    public void setPeliculasActorList(List<PeliculasActor> peliculasActorList) {
        this.peliculasActorList = peliculasActorList;
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
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cine.entidades.Actor[ id=" + id + " ]";
    }
    
}
