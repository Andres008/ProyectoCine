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
@Table(name = "funciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funciones.findAll", query = "SELECT f FROM Funciones f"),
    @NamedQuery(name = "Funciones.findById", query = "SELECT f FROM Funciones f WHERE f.id = :id"),
    @NamedQuery(name = "Funciones.findByFecha", query = "SELECT f FROM Funciones f WHERE f.fecha = :fecha")})
public class Funciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_horario", referencedColumnName = "id_horario")
    @ManyToOne
    private Horario idHorario;
    @JoinColumn(name = "id_pelicula", referencedColumnName = "id")
    @ManyToOne
    private Peliculas idPelicula;
    @JoinColumn(name = "id_sala", referencedColumnName = "id")
    @ManyToOne
    private Salas idSala;
    @OneToMany(mappedBy = "idFuncion")
    private List<ReservarFuncion> reservarFuncionList;

    public Funciones() {
    }

    public Funciones(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Horario getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horario idHorario) {
        this.idHorario = idHorario;
    }

    public Peliculas getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Peliculas idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Salas getIdSala() {
        return idSala;
    }

    public void setIdSala(Salas idSala) {
        this.idSala = idSala;
    }

    @XmlTransient
    public List<ReservarFuncion> getReservarFuncionList() {
        return reservarFuncionList;
    }

    public void setReservarFuncionList(List<ReservarFuncion> reservarFuncionList) {
        this.reservarFuncionList = reservarFuncionList;
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
        if (!(object instanceof Funciones)) {
            return false;
        }
        Funciones other = (Funciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cine.entidades.Funciones[ id=" + id + " ]";
    }
    
}
