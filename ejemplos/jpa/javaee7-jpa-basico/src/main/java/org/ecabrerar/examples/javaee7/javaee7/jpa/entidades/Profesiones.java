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
@Table(name = "profesiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesiones.findAll", query = "SELECT p FROM Profesiones p"),
    @NamedQuery(name = "Profesiones.findByCodigoProfesion", query = "SELECT p FROM Profesiones p WHERE p.codigoProfesion = :codigoProfesion"),
    @NamedQuery(name = "Profesiones.findByDescripcion", query = "SELECT p FROM Profesiones p WHERE p.descripcion = :descripcion")})
public class Profesiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_profesion")
    private Integer codigoProfesion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProfesion")
    private Collection<Usuarios> usuariosCollection;

    public Profesiones() {
    }

    public Profesiones(Integer codigoProfesion) {
        this.codigoProfesion = codigoProfesion;
    }

    public Profesiones(Integer codigoProfesion, String descripcion) {
        this.codigoProfesion = codigoProfesion;
        this.descripcion = descripcion;
    }

    public Integer getCodigoProfesion() {
        return codigoProfesion;
    }

    public void setCodigoProfesion(Integer codigoProfesion) {
        this.codigoProfesion = codigoProfesion;
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
        hash += (codigoProfesion != null ? codigoProfesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesiones)) {
            return false;
        }
        Profesiones other = (Profesiones) object;
        if ((this.codigoProfesion == null && other.codigoProfesion != null) || (this.codigoProfesion != null && !this.codigoProfesion.equals(other.codigoProfesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ecabrerar.examples.javaee7.javaee7.jpa.entidades.Profesiones[ codigoProfesion=" + codigoProfesion + " ]";
    }
    
}
