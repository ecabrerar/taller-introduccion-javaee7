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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ubicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicacion.findAll", query = "SELECT u FROM Ubicacion u"),
    @NamedQuery(name = "Ubicacion.findByCodigoUbicacion", query = "SELECT u FROM Ubicacion u WHERE u.codigoUbicacion = :codigoUbicacion"),
    @NamedQuery(name = "Ubicacion.findByNombre", query = "SELECT u FROM Ubicacion u WHERE u.nombre = :nombre")})
public class Ubicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_ubicacion")
    private Integer codigoUbicacion;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUbicacion")
    private Collection<Noticias> noticiasCollection;
    @JoinColumn(name = "codigo_ciudad", referencedColumnName = "codigo_ciudad")
    @ManyToOne(optional = false)
    private Ciudades codigoCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUbicacion")
    private Collection<Usuarios> usuariosCollection;

    public Ubicacion() {
    }

    public Ubicacion(Integer codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public Ubicacion(Integer codigoUbicacion, String nombre) {
        this.codigoUbicacion = codigoUbicacion;
        this.nombre = nombre;
    }

    public Integer getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setCodigoUbicacion(Integer codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Noticias> getNoticiasCollection() {
        return noticiasCollection;
    }

    public void setNoticiasCollection(Collection<Noticias> noticiasCollection) {
        this.noticiasCollection = noticiasCollection;
    }

    public Ciudades getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(Ciudades codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
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
        hash += (codigoUbicacion != null ? codigoUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.codigoUbicacion == null && other.codigoUbicacion != null) || (this.codigoUbicacion != null && !this.codigoUbicacion.equals(other.codigoUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ecabrerar.examples.javaee7.javaee7.jpa.entidades.Ubicacion[ codigoUbicacion=" + codigoUbicacion + " ]";
    }
    
}
