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
@Table(name = "tipos_familia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposFamilia.findAll", query = "SELECT t FROM TiposFamilia t"),
    @NamedQuery(name = "TiposFamilia.findByCodTipFam", query = "SELECT t FROM TiposFamilia t WHERE t.codTipFam = :codTipFam"),
    @NamedQuery(name = "TiposFamilia.findByNomTipFam", query = "SELECT t FROM TiposFamilia t WHERE t.nomTipFam = :nomTipFam")})
public class TiposFamilia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tip_fam")
    private Integer codTipFam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nom_tip_fam")
    private String nomTipFam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipFam")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public TiposFamilia() {
    }

    public TiposFamilia(Integer codTipFam) {
        this.codTipFam = codTipFam;
    }

    public TiposFamilia(Integer codTipFam, String nomTipFam) {
        this.codTipFam = codTipFam;
        this.nomTipFam = nomTipFam;
    }

    public Integer getCodTipFam() {
        return codTipFam;
    }

    public void setCodTipFam(Integer codTipFam) {
        this.codTipFam = codTipFam;
    }

    public String getNomTipFam() {
        return nomTipFam;
    }

    public void setNomTipFam(String nomTipFam) {
        this.nomTipFam = nomTipFam;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipFam != null ? codTipFam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposFamilia)) {
            return false;
        }
        TiposFamilia other = (TiposFamilia) object;
        if ((this.codTipFam == null && other.codTipFam != null) || (this.codTipFam != null && !this.codTipFam.equals(other.codTipFam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposFamilia[ codTipFam=" + codTipFam + " ]";
    }
    
}
