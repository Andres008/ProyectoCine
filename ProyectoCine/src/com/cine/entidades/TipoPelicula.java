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
@Table(name = "tipo_pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPelicula.findAll", query = "SELECT t FROM TipoPelicula t"),
    @NamedQuery(name = "TipoPelicula.findById", query = "SELECT t FROM TipoPelicula t WHERE t.id = :id"),
    @NamedQuery(name = "TipoPelicula.findByTipo", query = "SELECT t FROM TipoPelicula t WHERE t.tipo = :tipo")})
public class TipoPelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(mappedBy = "idTipoPelicula")
    private List<Peliculas> peliculasList;

    public TipoPelicula() {
    }

    public TipoPelicula(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Peliculas> getPeliculasList() {
        return peliculasList;
    }

    public void setPeliculasList(List<Peliculas> peliculasList) {
        this.peliculasList = peliculasList;
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
        if (!(object instanceof TipoPelicula)) {
            return false;
        }
        TipoPelicula other = (TipoPelicula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cine.entidades.TipoPelicula[ id=" + id + " ]";
    }
    
}
