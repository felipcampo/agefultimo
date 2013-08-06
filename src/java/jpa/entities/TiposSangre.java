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
@Table(name = "tipos_sangre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposSangre.findAll", query = "SELECT t FROM TiposSangre t"),
    @NamedQuery(name = "TiposSangre.findByCodTipSan", query = "SELECT t FROM TiposSangre t WHERE t.codTipSan = :codTipSan"),
    @NamedQuery(name = "TiposSangre.findByNomTipSan", query = "SELECT t FROM TiposSangre t WHERE t.nomTipSan = :nomTipSan")})
public class TiposSangre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tip_san")
    private Integer codTipSan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "nom_tip_san")
    private String nomTipSan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipSan")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public TiposSangre() {
    }

    public TiposSangre(Integer codTipSan) {
        this.codTipSan = codTipSan;
    }

    public TiposSangre(Integer codTipSan, String nomTipSan) {
        this.codTipSan = codTipSan;
        this.nomTipSan = nomTipSan;
    }

    public Integer getCodTipSan() {
        return codTipSan;
    }

    public void setCodTipSan(Integer codTipSan) {
        this.codTipSan = codTipSan;
    }

    public String getNomTipSan() {
        return nomTipSan;
    }

    public void setNomTipSan(String nomTipSan) {
        this.nomTipSan = nomTipSan;
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
        hash += (codTipSan != null ? codTipSan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposSangre)) {
            return false;
        }
        TiposSangre other = (TiposSangre) object;
        if ((this.codTipSan == null && other.codTipSan != null) || (this.codTipSan != null && !this.codTipSan.equals(other.codTipSan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposSangre[ codTipSan=" + codTipSan + " ]";
    }
    
}
