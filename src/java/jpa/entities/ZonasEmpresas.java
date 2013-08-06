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
@Table(name = "zonas_empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonasEmpresas.findAll", query = "SELECT z FROM ZonasEmpresas z"),
    @NamedQuery(name = "ZonasEmpresas.findByCodZon", query = "SELECT z FROM ZonasEmpresas z WHERE z.codZon = :codZon"),
    @NamedQuery(name = "ZonasEmpresas.findByNomZon", query = "SELECT z FROM ZonasEmpresas z WHERE z.nomZon = :nomZon")})
public class ZonasEmpresas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_zon")
    private String codZon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nom_zon")
    private String nomZon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codZon")
    private List<Empresas> empresasList;

    public ZonasEmpresas() {
    }

    public ZonasEmpresas(String codZon) {
        this.codZon = codZon;
    }

    public ZonasEmpresas(String codZon, String nomZon) {
        this.codZon = codZon;
        this.nomZon = nomZon;
    }

    public String getCodZon() {
        return codZon;
    }

    public void setCodZon(String codZon) {
        this.codZon = codZon;
    }

    public String getNomZon() {
        return nomZon;
    }

    public void setNomZon(String nomZon) {
        this.nomZon = nomZon;
    }

    @XmlTransient
    public List<Empresas> getEmpresasList() {
        return empresasList;
    }

    public void setEmpresasList(List<Empresas> empresasList) {
        this.empresasList = empresasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codZon != null ? codZon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonasEmpresas)) {
            return false;
        }
        ZonasEmpresas other = (ZonasEmpresas) object;
        if ((this.codZon == null && other.codZon != null) || (this.codZon != null && !this.codZon.equals(other.codZon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ZonasEmpresas[ codZon=" + codZon + " ]";
    }
    
}
