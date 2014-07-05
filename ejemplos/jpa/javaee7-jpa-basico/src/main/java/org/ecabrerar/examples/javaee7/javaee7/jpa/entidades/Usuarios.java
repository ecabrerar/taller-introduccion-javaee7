/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ecabrerar.examples.javaee7.javaee7.jpa.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ecabrerar
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByCodigoUsuario", query = "SELECT u FROM Usuarios u WHERE u.codigoUsuario = :codigoUsuario"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByFechaIngreso", query = "SELECT u FROM Usuarios u WHERE u.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Usuarios.findByFechaNacimiento", query = "SELECT u FROM Usuarios u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuarios.findByFoto", query = "SELECT u FROM Usuarios u WHERE u.foto = :foto"),
    @NamedQuery(name = "Usuarios.findByCorreo", query = "SELECT u FROM Usuarios u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuarios.findBySexo", query = "SELECT u FROM Usuarios u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuarios.findByIdentificacion", query = "SELECT u FROM Usuarios u WHERE u.identificacion = :identificacion"),
    @NamedQuery(name = "Usuarios.findByClave", query = "SELECT u FROM Usuarios u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuarios.findByUsuarioLogin", query = "SELECT u FROM Usuarios u WHERE u.usuarioLogin = :usuarioLogin"),
    @NamedQuery(name = "Usuarios.findByRol", query = "SELECT u FROM Usuarios u WHERE u.rol = :rol")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "foto")
    private String foto;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "usuario_login")
    private String usuarioLogin;
    @Basic(optional = false)
    @Column(name = "rol")
    private String rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUsuario")
    private Collection<Noticias> noticiasCollection;
    @JoinColumn(name = "codigo_ocupacion", referencedColumnName = "codigo_ocupacion")
    @ManyToOne(optional = false)
    private Ocupaciones codigoOcupacion;
    @JoinColumn(name = "tipo_noticia", referencedColumnName = "tipo_noticia")
    @ManyToOne(optional = false)
    private TipoNoticias tipoNoticia;
    @JoinColumn(name = "codigo_profesion", referencedColumnName = "codigo_profesion")
    @ManyToOne(optional = false)
    private Profesiones codigoProfesion;
    @JoinColumn(name = "codigo_ubicacion", referencedColumnName = "codigo_ubicacion")
    @ManyToOne(optional = false)
    private Ubicacion codigoUbicacion;

    public Usuarios() {
    }

    public Usuarios(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Usuarios(Integer codigoUsuario, String nombre, Date fechaIngreso, Date fechaNacimiento, String correo, String sexo, String identificacion, String clave, String usuarioLogin, String rol) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.fechaNacimiento = fechaNacimiento;
        this.correo = correo;
        this.sexo = sexo;
        this.identificacion = identificacion;
        this.clave = clave;
        this.usuarioLogin = usuarioLogin;
        this.rol = rol;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @XmlTransient
    public Collection<Noticias> getNoticiasCollection() {
        return noticiasCollection;
    }

    public void setNoticiasCollection(Collection<Noticias> noticiasCollection) {
        this.noticiasCollection = noticiasCollection;
    }

    public Ocupaciones getCodigoOcupacion() {
        return codigoOcupacion;
    }

    public void setCodigoOcupacion(Ocupaciones codigoOcupacion) {
        this.codigoOcupacion = codigoOcupacion;
    }

    public TipoNoticias getTipoNoticia() {
        return tipoNoticia;
    }

    public void setTipoNoticia(TipoNoticias tipoNoticia) {
        this.tipoNoticia = tipoNoticia;
    }

    public Profesiones getCodigoProfesion() {
        return codigoProfesion;
    }

    public void setCodigoProfesion(Profesiones codigoProfesion) {
        this.codigoProfesion = codigoProfesion;
    }

    public Ubicacion getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setCodigoUbicacion(Ubicacion codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ecabrerar.examples.javaee7.javaee7.jpa.entidades.Usuarios[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
