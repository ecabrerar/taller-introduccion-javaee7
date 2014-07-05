/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.examples.javaee7.javaee7.jpa.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ecabrerar
 */
@Entity
@Table(name = "ocupaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocupaciones.findAll", query = "SELECT o FROM Ocupaciones o"),
    @NamedQuery(name = "Ocupaciones.findByCodigoOcupacion", query = "SELECT o FROM Ocupaciones o WHERE o.codigoOcupacion = :codigoOcupacion"),
    @NamedQuery(name = "Ocupaciones.findByDescripcion", query = "SELECT o FROM Ocupaciones o WHERE o.descripcion = :descripcion")})
public class Ocupaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_ocupacion")
    private Integer codigoOcupacion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoOcupacion")
    private Collection<Usuarios> usuariosCollection;

    public Ocupaciones() {
    }

    public Ocupaciones(Integer codigoOcupacion) {
        this.codigoOcupacion = codigoOcupacion;
    }

    public Ocupaciones(Integer codigoOcupacion, String descripcion) {
        this.codigoOcupacion = codigoOcupacion;
        this.descripcion = descripcion;
    }

    public Integer getCodigoOcupacion() {
        return codigoOcupacion;
    }

    public void setCodigoOcupacion(Integer codigoOcupacion) {
        this.codigoOcupacion = codigoOcupacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOcupacion != null ? codigoOcupacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocupaciones)) {
            return false;
        }
        Ocupaciones other = (Ocupaciones) object;
        if ((this.codigoOcupacion == null && other.codigoOcupacion != null) || (this.codigoOcupacion != null && !this.codigoOcupacion.equals(other.codigoOcupacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ecabrerar.examples.javaee7.javaee7.jpa.entidades.Ocupaciones[ codigoOcupacion=" + codigoOcupacion + " ]";
    }
    
}
