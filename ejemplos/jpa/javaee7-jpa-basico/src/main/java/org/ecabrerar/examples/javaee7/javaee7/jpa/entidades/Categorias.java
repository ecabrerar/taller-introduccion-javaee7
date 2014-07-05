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
@Table(name = "categorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c"),
    @NamedQuery(name = "Categorias.findByCodigoCategoria", query = "SELECT c FROM Categorias c WHERE c.codigoCategoria = :codigoCategoria"),
    @NamedQuery(name = "Categorias.findByDescripcion", query = "SELECT c FROM Categorias c WHERE c.descripcion = :descripcion")})
public class Categorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_categoria")
    private Integer codigoCategoria;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCategoria")
    private Collection<Noticias> noticiasCollection;

    public Categorias() {
    }

    public Categorias(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Categorias(Integer codigoCategoria, String descripcion) {
        this.codigoCategoria = codigoCategoria;
        this.descripcion = descripcion;
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Noticias> getNoticiasCollection() {
        return noticiasCollection;
    }

    public void setNoticiasCollection(Collection<Noticias> noticiasCollection) {
        this.noticiasCollection = noticiasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCategoria != null ? codigoCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.codigoCategoria == null && other.codigoCategoria != null) || (this.codigoCategoria != null && !this.codigoCategoria.equals(other.codigoCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ecabrerar.examples.javaee7.javaee7.jpa.entidades.Categorias[ codigoCategoria=" + codigoCategoria + " ]";
    }
    
}
