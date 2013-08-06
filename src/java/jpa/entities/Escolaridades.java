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
@Table(name = "escolaridades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escolaridades.findAll", query = "SELECT e FROM Escolaridades e"),
    @NamedQuery(name = "Escolaridades.findByCodEsc", query = "SELECT e FROM Escolaridades e WHERE e.codEsc = :codEsc"),
    @NamedQuery(name = "Escolaridades.findByNomEsc", query = "SELECT e FROM Escolaridades e WHERE e.nomEsc = :nomEsc")})
public class Escolaridades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_esc")
    private Integer codEsc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nom_esc")
    private String nomEsc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEsc")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public Escolaridades() {
    }

    public Escolaridades(Integer codEsc) {
        this.codEsc = codEsc;
    }

    public Escolaridades(Integer codEsc, String nomEsc) {
        this.codEsc = codEsc;
        this.nomEsc = nomEsc;
    }

    public Integer getCodEsc() {
        return codEsc;
    }

    public void setCodEsc(Integer codEsc) {
        this.codEsc = codEsc;
    }

    public String getNomEsc() {
        return nomEsc;
    }

    public void setNomEsc(String nomEsc) {
        this.nomEsc = nomEsc;
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
        hash += (codEsc != null ? codEsc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escolaridades)) {
            return false;
        }
        Escolaridades other = (Escolaridades) object;
        if ((this.codEsc == null && other.codEsc != null) || (this.codEsc != null && !this.codEsc.equals(other.codEsc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Escolaridades[ codEsc=" + codEsc + " ]";
    }
    
}
