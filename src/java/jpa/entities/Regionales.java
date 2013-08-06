/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "regionales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regionales.findAll", query = "SELECT r FROM Regionales r"),
    @NamedQuery(name = "Regionales.findByCodReg", query = "SELECT r FROM Regionales r WHERE r.codReg = :codReg"),
    @NamedQuery(name = "Regionales.findByNomReg", query = "SELECT r FROM Regionales r WHERE r.nomReg = :nomReg")})
public class Regionales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_reg")
    private String codReg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_reg")
    private String nomReg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codReg")
    private List<SeguimientoInstructores> seguimientoInstructoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codReg")
    private List<SeguimientoProyectos> seguimientoProyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codReg")
    private List<CentrosFormacion> centrosFormacionList;

    public Regionales() {
    }

    public Regionales(String codReg) {
        this.codReg = codReg;
    }

    public Regionales(String codReg, String nomReg) {
        this.codReg = codReg;
        this.nomReg = nomReg;
    }

    public String getCodReg() {
        return codReg;
    }

    public void setCodReg(String codReg) {
        this.codReg = codReg;
    }

    public String getNomReg() {
        return nomReg;
    }

    public void setNomReg(String nomReg) {
        this.nomReg = nomReg;
    }

    @XmlTransient
    public List<SeguimientoInstructores> getSeguimientoInstructoresList() {
        return seguimientoInstructoresList;
    }

    public void setSeguimientoInstructoresList(List<SeguimientoInstructores> seguimientoInstructoresList) {
        this.seguimientoInstructoresList = seguimientoInstructoresList;
    }

    @XmlTransient
    public List<SeguimientoProyectos> getSeguimientoProyectosList() {
        return seguimientoProyectosList;
    }

    public void setSeguimientoProyectosList(List<SeguimientoProyectos> seguimientoProyectosList) {
        this.seguimientoProyectosList = seguimientoProyectosList;
    }

    @XmlTransient
    public List<CentrosFormacion> getCentrosFormacionList() {
        return centrosFormacionList;
    }

    public void setCentrosFormacionList(List<CentrosFormacion> centrosFormacionList) {
        this.centrosFormacionList = centrosFormacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codReg != null ? codReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regionales)) {
            return false;
        }
        Regionales other = (Regionales) object;
        if ((this.codReg == null && other.codReg != null) || (this.codReg != null && !this.codReg.equals(other.codReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Regionales[ codReg=" + codReg + " ]";
    }
    
}
