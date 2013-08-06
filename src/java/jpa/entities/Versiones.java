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
import javax.persistence.Id;
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
@Table(name = "versiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Versiones.findAll", query = "SELECT v FROM Versiones v"),
    @NamedQuery(name = "Versiones.findByCodVer", query = "SELECT v FROM Versiones v WHERE v.codVer = :codVer"),
    @NamedQuery(name = "Versiones.findByNomVer", query = "SELECT v FROM Versiones v WHERE v.nomVer = :nomVer")})
public class Versiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_ver")
    private String codVer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "nom_ver")
    private String nomVer;
    @ManyToMany(mappedBy = "versionesList")
    private List<Programas> programasList;

    public Versiones() {
    }

    public Versiones(String codVer) {
        this.codVer = codVer;
    }

    public Versiones(String codVer, String nomVer) {
        this.codVer = codVer;
        this.nomVer = nomVer;
    }

    public String getCodVer() {
        return codVer;
    }

    public void setCodVer(String codVer) {
        this.codVer = codVer;
    }

    public String getNomVer() {
        return nomVer;
    }

    public void setNomVer(String nomVer) {
        this.nomVer = nomVer;
    }

    @XmlTransient
    public List<Programas> getProgramasList() {
        return programasList;
    }

    public void setProgramasList(List<Programas> programasList) {
        this.programasList = programasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVer != null ? codVer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Versiones)) {
            return false;
        }
        Versiones other = (Versiones) object;
        if ((this.codVer == null && other.codVer != null) || (this.codVer != null && !this.codVer.equals(other.codVer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Versiones[ codVer=" + codVer + " ]";
    }
    
}
