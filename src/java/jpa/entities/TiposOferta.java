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
@Table(name = "tipos_oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposOferta.findAll", query = "SELECT t FROM TiposOferta t"),
    @NamedQuery(name = "TiposOferta.findByCodOfe", query = "SELECT t FROM TiposOferta t WHERE t.codOfe = :codOfe"),
    @NamedQuery(name = "TiposOferta.findByNomOfe", query = "SELECT t FROM TiposOferta t WHERE t.nomOfe = :nomOfe")})
public class TiposOferta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ofe")
    private Integer codOfe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "nom_ofe")
    private String nomOfe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codOfe")
    private List<FichasCaracterizacion> fichasCaracterizacionList;

    public TiposOferta() {
    }

    public TiposOferta(Integer codOfe) {
        this.codOfe = codOfe;
    }

    public TiposOferta(Integer codOfe, String nomOfe) {
        this.codOfe = codOfe;
        this.nomOfe = nomOfe;
    }

    public Integer getCodOfe() {
        return codOfe;
    }

    public void setCodOfe(Integer codOfe) {
        this.codOfe = codOfe;
    }

    public String getNomOfe() {
        return nomOfe;
    }

    public void setNomOfe(String nomOfe) {
        this.nomOfe = nomOfe;
    }

    @XmlTransient
    public List<FichasCaracterizacion> getFichasCaracterizacionList() {
        return fichasCaracterizacionList;
    }

    public void setFichasCaracterizacionList(List<FichasCaracterizacion> fichasCaracterizacionList) {
        this.fichasCaracterizacionList = fichasCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOfe != null ? codOfe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposOferta)) {
            return false;
        }
        TiposOferta other = (TiposOferta) object;
        if ((this.codOfe == null && other.codOfe != null) || (this.codOfe != null && !this.codOfe.equals(other.codOfe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposOferta[ codOfe=" + codOfe + " ]";
    }
    
}
