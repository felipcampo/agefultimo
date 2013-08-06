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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "estados_fichas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadosFichas.findAll", query = "SELECT e FROM EstadosFichas e"),
    @NamedQuery(name = "EstadosFichas.findByCodEstFic", query = "SELECT e FROM EstadosFichas e WHERE e.codEstFic = :codEstFic"),
    @NamedQuery(name = "EstadosFichas.findByNomEstFic", query = "SELECT e FROM EstadosFichas e WHERE e.nomEstFic = :nomEstFic")})
public class EstadosFichas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_est_fic")
    private Integer codEstFic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nom_est_fic")
    private String nomEstFic;
    @JoinTable(name = "fichas_estados", joinColumns = {
        @JoinColumn(name = "cod_est_fic", referencedColumnName = "cod_est_fic")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")})
    @ManyToMany
    private List<FichasCaracterizacion> fichasCaracterizacionList;

    public EstadosFichas() {
    }

    public EstadosFichas(Integer codEstFic) {
        this.codEstFic = codEstFic;
    }

    public EstadosFichas(Integer codEstFic, String nomEstFic) {
        this.codEstFic = codEstFic;
        this.nomEstFic = nomEstFic;
    }

    public Integer getCodEstFic() {
        return codEstFic;
    }

    public void setCodEstFic(Integer codEstFic) {
        this.codEstFic = codEstFic;
    }

    public String getNomEstFic() {
        return nomEstFic;
    }

    public void setNomEstFic(String nomEstFic) {
        this.nomEstFic = nomEstFic;
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
        hash += (codEstFic != null ? codEstFic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadosFichas)) {
            return false;
        }
        EstadosFichas other = (EstadosFichas) object;
        if ((this.codEstFic == null && other.codEstFic != null) || (this.codEstFic != null && !this.codEstFic.equals(other.codEstFic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.EstadosFichas[ codEstFic=" + codEstFic + " ]";
    }
    
}
