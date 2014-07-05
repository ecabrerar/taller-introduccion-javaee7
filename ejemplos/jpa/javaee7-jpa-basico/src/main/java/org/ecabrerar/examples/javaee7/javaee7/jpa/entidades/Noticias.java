/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.examples.javaee7.javaee7.jpa.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ecabrerar
 */
@Entity
@Table(name = "noticias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Noticias.findAll", query = "SELECT n FROM Noticias n"),
    @NamedQuery(name = "Noticias.findById", query = "SELECT n FROM Noticias n WHERE n.id = :id"),
    @NamedQuery(name = "Noticias.findByDescripcion", query = "SELECT n FROM Noticias n WHERE n.descripcion = :descripcion"),
    @NamedQuery(name = "Noticias.findByFecha", query = "SELECT n FROM Noticias n WHERE n.fecha = :fecha"),
    @NamedQuery(name = "Noticias.findByHora", query = "SELECT n FROM Noticias n WHERE n.hora = :hora"),
    @NamedQuery(name = "Noticias.findByFoto", query = "SELECT n FROM Noticias n WHERE n.foto = :foto"),
    @NamedQuery(name = "Noticias.findByVideo", query = "SELECT n FROM Noticias n WHERE n.video = :video"),
    @NamedQuery(name = "Noticias.findByVisitas", query = "SELECT n FROM Noticias n WHERE n.visitas = :visitas"),
    @NamedQuery(name = "Noticias.findByDescCorta", query = "SELECT n FROM Noticias n WHERE n.descCorta = :descCorta")})
public class Noticias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora")
    private String hora;
    @Column(name = "foto")
    private String foto;
    @Column(name = "video")
    private String video;
    @Column(name = "visitas")
    private Integer visitas;
    @Basic(optional = false)
    @Column(name = "desc_corta")
    private String descCorta;
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo_categoria")
    @ManyToOne(optional = false)
    private Categorias codigoCategoria;
    @JoinColumn(name = "tipo_noticia", referencedColumnName = "tipo_noticia")
    @ManyToOne(optional = false)
    private TipoNoticias tipoNoticia;
    @JoinColumn(name = "codigo_ubicacion", referencedColumnName = "codigo_ubicacion")
    @ManyToOne(optional = false)
    private Ubicacion codigoUbicacion;
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigo_usuario")
    @ManyToOne(optional = false)
    private Usuarios codigoUsuario;

    public Noticias() {
    }

    public Noticias(Integer id) {
        this.id = id;
    }

    public Noticias(Integer id, String descripcion, Date fecha, String hora, String descCorta) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.descCorta = descCorta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    public String getDescCorta() {
        return descCorta;
    }

    public void setDescCorta(String descCorta) {
        this.descCorta = descCorta;
    }

    public Categorias getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Categorias codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public TipoNoticias getTipoNoticia() {
        return tipoNoticia;
    }

    public void setTipoNoticia(TipoNoticias tipoNoticia) {
        this.tipoNoticia = tipoNoticia;
    }

    public Ubicacion getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setCodigoUbicacion(Ubicacion codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public Usuarios getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Usuarios codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
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
        if (!(object instanceof Noticias)) {
            return false;
        }
        Noticias other = (Noticias) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ecabrerar.examples.javaee7.javaee7.jpa.entidades.Noticias[ id=" + id + " ]";
    }
    
}
