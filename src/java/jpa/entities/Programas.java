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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "programas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programas.findAll", query = "SELECT p FROM Programas p"),
    @NamedQuery(name = "Programas.findByCodPrg", query = "SELECT p FROM Programas p WHERE p.codPrg = :codPrg"),
    @NamedQuery(name = "Programas.findByNomPrg", query = "SELECT p FROM Programas p WHERE p.nomPrg = :nomPrg"),
    @NamedQuery(name = "Programas.findByDurPrg", query = "SELECT p FROM Programas p WHERE p.durPrg = :durPrg"),
    @NamedQuery(name = "Programas.findByJusPrg", query = "SELECT p FROM Programas p WHERE p.jusPrg = :jusPrg"),
    @NamedQuery(name = "Programas.findByReqIngPrg", query = "SELECT p FROM Programas p WHERE p.reqIngPrg = :reqIngPrg"),
    @NamedQuery(name = "Programas.findByDesPrg", query = "SELECT p FROM Programas p WHERE p.desPrg = :desPrg"),
    @NamedQuery(name = "Programas.findByNumTotCom", query = "SELECT p FROM Programas p WHERE p.numTotCom = :numTotCom"),
    @NamedQuery(name = "Programas.findByNumTotResApr", query = "SELECT p FROM Programas p WHERE p.numTotResApr = :numTotResApr")})
public class Programas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "cod_prg")
    private String codPrg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_prg")
    private String nomPrg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dur_prg")
    private String durPrg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "jus_prg")
    private String jusPrg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "req_ing_prg")
    private String reqIngPrg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "des_prg")
    private String desPrg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_tot_com")
    private int numTotCom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_tot_res_apr")
    private int numTotResApr;
    @JoinTable(name = "programas_versiones", joinColumns = {
        @JoinColumn(name = "cod_prg", referencedColumnName = "cod_prg")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_ver", referencedColumnName = "cod_ver")})
    @ManyToMany
    private List<Versiones> versionesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPrg")
    private List<FichasCaracterizacion> fichasCaracterizacionList;
    @JoinColumn(name = "cod_cen", referencedColumnName = "cod_cen")
    @ManyToOne(optional = false)
    private CentrosFormacion codCen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPrg")
    private List<SeguimientoProyectos> seguimientoProyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPrg")
    private List<Competencias> competenciasList;

    public Programas() {
    }

    public Programas(String codPrg) {
        this.codPrg = codPrg;
    }

    public Programas(String codPrg, String nomPrg, String durPrg, String jusPrg, String reqIngPrg, String desPrg, int numTotCom, int numTotResApr) {
        this.codPrg = codPrg;
        this.nomPrg = nomPrg;
        this.durPrg = durPrg;
        this.jusPrg = jusPrg;
        this.reqIngPrg = reqIngPrg;
        this.desPrg = desPrg;
        this.numTotCom = numTotCom;
        this.numTotResApr = numTotResApr;
    }

    public String getCodPrg() {
        return codPrg;
    }

    public void setCodPrg(String codPrg) {
        this.codPrg = codPrg;
    }

    public String getNomPrg() {
        return nomPrg;
    }

    public void setNomPrg(String nomPrg) {
        this.nomPrg = nomPrg;
    }

    public String getDurPrg() {
        return durPrg;
    }

    public void setDurPrg(String durPrg) {
        this.durPrg = durPrg;
    }

    public String getJusPrg() {
        return jusPrg;
    }

    public void setJusPrg(String jusPrg) {
        this.jusPrg = jusPrg;
    }

    public String getReqIngPrg() {
        return reqIngPrg;
    }

    public void setReqIngPrg(String reqIngPrg) {
        this.reqIngPrg = reqIngPrg;
    }

    public String getDesPrg() {
        return desPrg;
    }

    public void setDesPrg(String desPrg) {
        this.desPrg = desPrg;
    }

    public int getNumTotCom() {
        return numTotCom;
    }

    public void setNumTotCom(int numTotCom) {
        this.numTotCom = numTotCom;
    }

    public int getNumTotResApr() {
        return numTotResApr;
    }

    public void setNumTotResApr(int numTotResApr) {
        this.numTotResApr = numTotResApr;
    }

    @XmlTransient
    public List<Versiones> getVersionesList() {
        return versionesList;
    }

    public void setVersionesList(List<Versiones> versionesList) {
        this.versionesList = versionesList;
    }

    @XmlTransient
    public List<FichasCaracterizacion> getFichasCaracterizacionList() {
        return fichasCaracterizacionList;
    }

    public void setFichasCaracterizacionList(List<FichasCaracterizacion> fichasCaracterizacionList) {
        this.fichasCaracterizacionList = fichasCaracterizacionList;
    }

    public CentrosFormacion getCodCen() {
        return codCen;
    }

    public void setCodCen(CentrosFormacion codCen) {
        this.codCen = codCen;
    }

    @XmlTransient
    public List<SeguimientoProyectos> getSeguimientoProyectosList() {
        return seguimientoProyectosList;
    }

    public void setSeguimientoProyectosList(List<SeguimientoProyectos> seguimientoProyectosList) {
        this.seguimientoProyectosList = seguimientoProyectosList;
    }

    @XmlTransient
    public List<Competencias> getCompetenciasList() {
        return competenciasList;
    }

    public void setCompetenciasList(List<Competencias> competenciasList) {
        this.competenciasList = competenciasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrg != null ? codPrg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programas)) {
            return false;
        }
        Programas other = (Programas) object;
        if ((this.codPrg == null && other.codPrg != null) || (this.codPrg != null && !this.codPrg.equals(other.codPrg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Programas[ codPrg=" + codPrg + " ]";
    }
    
}
