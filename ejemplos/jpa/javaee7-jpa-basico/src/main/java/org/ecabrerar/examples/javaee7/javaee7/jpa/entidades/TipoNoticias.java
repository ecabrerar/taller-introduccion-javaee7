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
@Table(name = "tipo_noticias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoNoticias.findAll", query = "SELECT t FROM TipoNoticias t"),
    @NamedQuery(name = "TipoNoticias.findByTipoNoticia", query = "SELECT t FROM TipoNoticias t WHERE t.tipoNoticia = :tipoNoticia"),
    @NamedQuery(name = "TipoNoticias.findByDescripcion", query = "SELECT t FROM TipoNoticias t WHERE t.descripcion = :descripcion")})
public class TipoNoticias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_noticia")
    private Integer tipoNoticia;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoNoticia")
    private Collection<Noticias> noticiasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoNoticia")
    private Collection<Usuarios> usuariosCollection;

    public TipoNoticias() {
    }

    public TipoNoticias(Integer tipoNoticia) {
        this.tipoNoticia = tipoNoticia;
    }

    public TipoNoticias(Integer tipoNoticia, String descripcion) {
        this.tipoNoticia = tipoNoticia;
        this.descripcion = descripcion;
    }

    public Integer getTipoNoticia() {
        return tipoNoticia;
    }

    public void setTipoNoticia(Integer tipoNoticia) {
        this.tipoNoticia = tipoNoticia;
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
        hash += (tipoNoticia != null ? tipoNoticia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoNoticias)) {
            return false;
        }
        TipoNoticias other = (TipoNoticias) object;
        if ((this.tipoNoticia == null && other.tipoNoticia != null) || (this.tipoNoticia != null && !this.tipoNoticia.equals(other.tipoNoticia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ecabrerar.examples.javaee7.javaee7.jpa.entidades.TipoNoticias[ tipoNoticia=" + tipoNoticia + " ]";
    }
    
}
