/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author acardenas
 */
@Entity
@Table(name = "peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peliculas.findAll", query = "SELECT p FROM Peliculas p"),
    @NamedQuery(name = "Peliculas.findById", query = "SELECT p FROM Peliculas p WHERE p.id = :id"),
    @NamedQuery(name = "Peliculas.findByNombre", query = "SELECT p FROM Peliculas p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Peliculas.findByFechaEstreno", query = "SELECT p FROM Peliculas p WHERE p.fechaEstreno = :fechaEstreno"),
    @NamedQuery(name = "Peliculas.findByFechaHasta", query = "SELECT p FROM Peliculas p WHERE p.fechaHasta = :fechaHasta")})
public class Peliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_estreno")
    @Temporal(TemporalType.DATE)
    private Date fechaEstreno;
    @Column(name = "fecha_hasta")
    @Temporal(TemporalType.DATE)
    private Date fechaHasta;
    @OneToMany(mappedBy = "idPelicula")
    private List<PeliculasActor> peliculasActorList;
    @OneToMany(mappedBy = "idPelicula")
    private List<Funciones> funcionesList;
    @JoinColumn(name = "id_tipo_pelicula", referencedColumnName = "id")
    @ManyToOne
    private TipoPelicula idTipoPelicula;

    public Peliculas() {
    }

    public Peliculas(BigDecimal id) {
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

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @XmlTransient
    public List<PeliculasActor> getPeliculasActorList() {
        return peliculasActorList;
    }

    public void setPeliculasActorList(List<PeliculasActor> peliculasActorList) {
        this.peliculasActorList = peliculasActorList;
    }

    @XmlTransient
    public List<Funciones> getFuncionesList() {
        return funcionesList;
    }

    public void setFuncionesList(List<Funciones> funcionesList) {
        this.funcionesList = funcionesList;
    }

    public TipoPelicula getIdTipoPelicula() {
        return idTipoPelicula;
    }

    public void setIdTipoPelicula(TipoPelicula idTipoPelicula) {
        this.idTipoPelicula = idTipoPelicula;
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
        if (!(object instanceof Peliculas)) {
            return false;
        }
        Peliculas other = (Peliculas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cine.entidades.Peliculas[ id=" + id + " ]";
    }
    
}
