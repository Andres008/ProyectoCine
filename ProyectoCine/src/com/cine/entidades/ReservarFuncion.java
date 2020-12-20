/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cine.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "reservar_funcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReservarFuncion.findAll", query = "SELECT r FROM ReservarFuncion r"),
    @NamedQuery(name = "ReservarFuncion.findById", query = "SELECT r FROM ReservarFuncion r WHERE r.id = :id"),
    @NamedQuery(name = "ReservarFuncion.findByNumeroPuestos", query = "SELECT r FROM ReservarFuncion r WHERE r.numeroPuestos = :numeroPuestos")})
public class ReservarFuncion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "RESERVA_FUN_GENERATOR", sequenceName = "SEQ_RESERVA_FUN", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVA_FUN_GENERATOR")
    @Basic(optional = false)
    @Column(name = "id")
    private BigDecimal id;
    @Column(name = "numero_puestos")
    private BigInteger numeroPuestos;
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    @ManyToOne
    private Cliente cedula;
    @JoinColumn(name = "id_funcion", referencedColumnName = "id")
    @ManyToOne
    private Funciones idFuncion;

    public ReservarFuncion() {
    }

    public ReservarFuncion(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getNumeroPuestos() {
        return numeroPuestos;
    }

    public void setNumeroPuestos(BigInteger numeroPuestos) {
        this.numeroPuestos = numeroPuestos;
    }

    public Cliente getCedula() {
        return cedula;
    }

    public void setCedula(Cliente cedula) {
        this.cedula = cedula;
    }

    public Funciones getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(Funciones idFuncion) {
        this.idFuncion = idFuncion;
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
        if (!(object instanceof ReservarFuncion)) {
            return false;
        }
        ReservarFuncion other = (ReservarFuncion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cine.entidades.ReservarFuncion[ id=" + id + " ]";
    }
    
}
