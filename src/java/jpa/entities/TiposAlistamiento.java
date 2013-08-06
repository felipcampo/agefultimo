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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tipos_alistamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposAlistamiento.findAll", query = "SELECT t FROM TiposAlistamiento t"),
    @NamedQuery(name = "TiposAlistamiento.findByCodTipAli", query = "SELECT t FROM TiposAlistamiento t WHERE t.codTipAli = :codTipAli"),
    @NamedQuery(name = "TiposAlistamiento.findByNomTipAli", query = "SELECT t FROM TiposAlistamiento t WHERE t.nomTipAli = :nomTipAli")})
public class TiposAlistamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tip_ali")
    private Integer codTipAli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nom_tip_ali")
    private String nomTipAli;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipAli")
    private List<Alistamientos> alistamientosList;

    public TiposAlistamiento() {
    }

    public TiposAlistamiento(Integer codTipAli) {
        this.codTipAli = codTipAli;
    }

    public TiposAlistamiento(Integer codTipAli, String nomTipAli) {
        this.codTipAli = codTipAli;
        this.nomTipAli = nomTipAli;
    }

    public Integer getCodTipAli() {
        return codTipAli;
    }

    public void setCodTipAli(Integer codTipAli) {
        this.codTipAli = codTipAli;
    }

    public String getNomTipAli() {
        return nomTipAli;
    }

    public void setNomTipAli(String nomTipAli) {
        this.nomTipAli = nomTipAli;
    }

    @XmlTransient
    public List<Alistamientos> getAlistamientosList() {
        return alistamientosList;
    }

    public void setAlistamientosList(List<Alistamientos> alistamientosList) {
        this.alistamientosList = alistamientosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipAli != null ? codTipAli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposAlistamiento)) {
            return false;
        }
        TiposAlistamiento other = (TiposAlistamiento) object;
        if ((this.codTipAli == null && other.codTipAli != null) || (this.codTipAli != null && !this.codTipAli.equals(other.codTipAli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposAlistamiento[ codTipAli=" + codTipAli + " ]";
    }
    
}
