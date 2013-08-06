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
@Table(name = "clubes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clubes.findAll", query = "SELECT c FROM Clubes c"),
    @NamedQuery(name = "Clubes.findByCodClu", query = "SELECT c FROM Clubes c WHERE c.codClu = :codClu"),
    @NamedQuery(name = "Clubes.findByNomClu", query = "SELECT c FROM Clubes c WHERE c.nomClu = :nomClu")})
public class Clubes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_clu")
    private Integer codClu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_clu")
    private String nomClu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codClu")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public Clubes() {
    }

    public Clubes(Integer codClu) {
        this.codClu = codClu;
    }

    public Clubes(Integer codClu, String nomClu) {
        this.codClu = codClu;
        this.nomClu = nomClu;
    }

    public Integer getCodClu() {
        return codClu;
    }

    public void setCodClu(Integer codClu) {
        this.codClu = codClu;
    }

    public String getNomClu() {
        return nomClu;
    }

    public void setNomClu(String nomClu) {
        this.nomClu = nomClu;
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
        hash += (codClu != null ? codClu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clubes)) {
            return false;
        }
        Clubes other = (Clubes) object;
        if ((this.codClu == null && other.codClu != null) || (this.codClu != null && !this.codClu.equals(other.codClu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Clubes[ codClu=" + codClu + " ]";
    }
    
}
