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
@Table(name = "ocupaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocupaciones.findAll", query = "SELECT o FROM Ocupaciones o"),
    @NamedQuery(name = "Ocupaciones.findByCodOcu", query = "SELECT o FROM Ocupaciones o WHERE o.codOcu = :codOcu"),
    @NamedQuery(name = "Ocupaciones.findByNomOcu", query = "SELECT o FROM Ocupaciones o WHERE o.nomOcu = :nomOcu")})
public class Ocupaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ocu")
    private Integer codOcu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_ocu")
    private String nomOcu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codOcu")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public Ocupaciones() {
    }

    public Ocupaciones(Integer codOcu) {
        this.codOcu = codOcu;
    }

    public Ocupaciones(Integer codOcu, String nomOcu) {
        this.codOcu = codOcu;
        this.nomOcu = nomOcu;
    }

    public Integer getCodOcu() {
        return codOcu;
    }

    public void setCodOcu(Integer codOcu) {
        this.codOcu = codOcu;
    }

    public String getNomOcu() {
        return nomOcu;
    }

    public void setNomOcu(String nomOcu) {
        this.nomOcu = nomOcu;
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
        hash += (codOcu != null ? codOcu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocupaciones)) {
            return false;
        }
        Ocupaciones other = (Ocupaciones) object;
        if ((this.codOcu == null && other.codOcu != null) || (this.codOcu != null && !this.codOcu.equals(other.codOcu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Ocupaciones[ codOcu=" + codOcu + " ]";
    }
    
}
