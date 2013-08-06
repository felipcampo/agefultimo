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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e"),
    @NamedQuery(name = "Empresas.findByNitEmp", query = "SELECT e FROM Empresas e WHERE e.nitEmp = :nitEmp"),
    @NamedQuery(name = "Empresas.findByRazSocEmp", query = "SELECT e FROM Empresas e WHERE e.razSocEmp = :razSocEmp"),
    @NamedQuery(name = "Empresas.findByDirEmp", query = "SELECT e FROM Empresas e WHERE e.dirEmp = :dirEmp"),
    @NamedQuery(name = "Empresas.findByTel1Emp", query = "SELECT e FROM Empresas e WHERE e.tel1Emp = :tel1Emp"),
    @NamedQuery(name = "Empresas.findByTel2Emp", query = "SELECT e FROM Empresas e WHERE e.tel2Emp = :tel2Emp"),
    @NamedQuery(name = "Empresas.findByEmaEmp", query = "SELECT e FROM Empresas e WHERE e.emaEmp = :emaEmp"),
    @NamedQuery(name = "Empresas.findByWwwEmp", query = "SELECT e FROM Empresas e WHERE e.wwwEmp = :wwwEmp")})
public class Empresas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit_emp")
    private Integer nitEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "raz_soc_emp")
    private String razSocEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "dir_emp")
    private String dirEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tel1_emp")
    private int tel1Emp;
    @Column(name = "tel2_emp")
    private Integer tel2Emp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 56)
    @Column(name = "ema_emp")
    private String emaEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "www_emp")
    private String wwwEmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nitEmp")
    private List<ContratosProyectos> contratosProyectosList;
    @JoinColumn(name = "cod_zon", referencedColumnName = "cod_zon")
    @ManyToOne(optional = false)
    private ZonasEmpresas codZon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nitEmp")
    private List<SeguimientosProductiva> seguimientosProductivaList;

    public Empresas() {
    }

    public Empresas(Integer nitEmp) {
        this.nitEmp = nitEmp;
    }

    public Empresas(Integer nitEmp, String razSocEmp, String dirEmp, int tel1Emp, String emaEmp, String wwwEmp) {
        this.nitEmp = nitEmp;
        this.razSocEmp = razSocEmp;
        this.dirEmp = dirEmp;
        this.tel1Emp = tel1Emp;
        this.emaEmp = emaEmp;
        this.wwwEmp = wwwEmp;
    }

    public Integer getNitEmp() {
        return nitEmp;
    }

    public void setNitEmp(Integer nitEmp) {
        this.nitEmp = nitEmp;
    }

    public String getRazSocEmp() {
        return razSocEmp;
    }

    public void setRazSocEmp(String razSocEmp) {
        this.razSocEmp = razSocEmp;
    }

    public String getDirEmp() {
        return dirEmp;
    }

    public void setDirEmp(String dirEmp) {
        this.dirEmp = dirEmp;
    }

    public int getTel1Emp() {
        return tel1Emp;
    }

    public void setTel1Emp(int tel1Emp) {
        this.tel1Emp = tel1Emp;
    }

    public Integer getTel2Emp() {
        return tel2Emp;
    }

    public void setTel2Emp(Integer tel2Emp) {
        this.tel2Emp = tel2Emp;
    }

    public String getEmaEmp() {
        return emaEmp;
    }

    public void setEmaEmp(String emaEmp) {
        this.emaEmp = emaEmp;
    }

    public String getWwwEmp() {
        return wwwEmp;
    }

    public void setWwwEmp(String wwwEmp) {
        this.wwwEmp = wwwEmp;
    }

    @XmlTransient
    public List<ContratosProyectos> getContratosProyectosList() {
        return contratosProyectosList;
    }

    public void setContratosProyectosList(List<ContratosProyectos> contratosProyectosList) {
        this.contratosProyectosList = contratosProyectosList;
    }

    public ZonasEmpresas getCodZon() {
        return codZon;
    }

    public void setCodZon(ZonasEmpresas codZon) {
        this.codZon = codZon;
    }

    @XmlTransient
    public List<SeguimientosProductiva> getSeguimientosProductivaList() {
        return seguimientosProductivaList;
    }

    public void setSeguimientosProductivaList(List<SeguimientosProductiva> seguimientosProductivaList) {
        this.seguimientosProductivaList = seguimientosProductivaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nitEmp != null ? nitEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.nitEmp == null && other.nitEmp != null) || (this.nitEmp != null && !this.nitEmp.equals(other.nitEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Empresas[ nitEmp=" + nitEmp + " ]";
    }
    
}
