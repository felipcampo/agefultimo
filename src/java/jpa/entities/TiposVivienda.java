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
@Table(name = "tipos_vivienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposVivienda.findAll", query = "SELECT t FROM TiposVivienda t"),
    @NamedQuery(name = "TiposVivienda.findByCodTipViv", query = "SELECT t FROM TiposVivienda t WHERE t.codTipViv = :codTipViv"),
    @NamedQuery(name = "TiposVivienda.findByNomTipViv", query = "SELECT t FROM TiposVivienda t WHERE t.nomTipViv = :nomTipViv")})
public class TiposVivienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tip_viv")
    private Integer codTipViv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nom_tip_viv")
    private String nomTipViv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipViv")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public TiposVivienda() {
    }

    public TiposVivienda(Integer codTipViv) {
        this.codTipViv = codTipViv;
    }

    public TiposVivienda(Integer codTipViv, String nomTipViv) {
        this.codTipViv = codTipViv;
        this.nomTipViv = nomTipViv;
    }

    public Integer getCodTipViv() {
        return codTipViv;
    }

    public void setCodTipViv(Integer codTipViv) {
        this.codTipViv = codTipViv;
    }

    public String getNomTipViv() {
        return nomTipViv;
    }

    public void setNomTipViv(String nomTipViv) {
        this.nomTipViv = nomTipViv;
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
        hash += (codTipViv != null ? codTipViv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposVivienda)) {
            return false;
        }
        TiposVivienda other = (TiposVivienda) object;
        if ((this.codTipViv == null && other.codTipViv != null) || (this.codTipViv != null && !this.codTipViv.equals(other.codTipViv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposVivienda[ codTipViv=" + codTipViv + " ]";
    }
    
}
