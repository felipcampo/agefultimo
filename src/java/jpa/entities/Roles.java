/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findByCodRol", query = "SELECT r FROM Roles r WHERE r.codRol = :codRol"),
    @NamedQuery(name = "Roles.findByNomRol", query = "SELECT r FROM Roles r WHERE r.nomRol = :nomRol")})
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_rol")
    private Short codRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_rol")
    private String nomRol;
    @ManyToMany(mappedBy = "rolesList")
    private List<EstadosAprendiz> estadosAprendizList;
    @JoinTable(name = "usuarios_roles", joinColumns = {
        @JoinColumn(name = "cod_rol", referencedColumnName = "cod_rol")}, inverseJoinColumns = {
        @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")})
    @ManyToMany
    private List<Usuarios> usuariosList;

    public Roles() {
    }

    public Roles(Short codRol) {
        this.codRol = codRol;
    }

    public Roles(Short codRol, String nomRol) {
        this.codRol = codRol;
        this.nomRol = nomRol;
    }

    public Short getCodRol() {
        return codRol;
    }

    public void setCodRol(Short codRol) {
        this.codRol = codRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    @XmlTransient
    public List<EstadosAprendiz> getEstadosAprendizList() {
        return estadosAprendizList;
    }

    public void setEstadosAprendizList(List<EstadosAprendiz> estadosAprendizList) {
        this.estadosAprendizList = estadosAprendizList;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRol != null ? codRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.codRol == null && other.codRol != null) || (this.codRol != null && !this.codRol.equals(other.codRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Roles[ codRol=" + codRol + " ]";
    }
    
}
