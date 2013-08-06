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
import javax.persistence.Lob;
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
@Table(name = "proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p"),
    @NamedQuery(name = "Proyectos.findByCodPro", query = "SELECT p FROM Proyectos p WHERE p.codPro = :codPro"),
    @NamedQuery(name = "Proyectos.findByNumResAprEsp", query = "SELECT p FROM Proyectos p WHERE p.numResAprEsp = :numResAprEsp"),
    @NamedQuery(name = "Proyectos.findByNumResAprTra", query = "SELECT p FROM Proyectos p WHERE p.numResAprTra = :numResAprTra"),
    @NamedQuery(name = "Proyectos.findByNumResAprBas", query = "SELECT p FROM Proyectos p WHERE p.numResAprBas = :numResAprBas")})
public class Proyectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_pro")
    private String codPro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nom_pro")
    private String nomPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_res_apr_esp")
    private int numResAprEsp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_res_apr_tra")
    private int numResAprTra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_res_apr_bas")
    private int numResAprBas;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "pla_prb")
    private String plaPrb;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "jus_pro")
    private String jusPro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obj_gen")
    private String objGen;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obj_esp")
    private String objEsp;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "ben_pro")
    private String benPro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "imp_soc")
    private String impSoc;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "imp_eco")
    private String impEco;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "imp_amb")
    private String impAmb;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "imp_tec")
    private String impTec;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "rie_aso")
    private String rieAso;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "res_pro")
    private String resPro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "ges_tec")
    private String gesTec;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "val_prd")
    private String valPrd;
    @ManyToMany(mappedBy = "proyectosList")
    private List<FasesProyecto> fasesProyectoList;
    @JoinColumn(name = "cod_est_pro", referencedColumnName = "cod_est_pro")
    @ManyToOne(optional = false)
    private EstadosProyectos codEstPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPro")
    private List<FichasCaracterizacion> fichasCaracterizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPro")
    private List<PraxisPedagogica> praxisPedagogicaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPro")
    private List<SeguimientoInstructores> seguimientoInstructoresList;

    public Proyectos() {
    }

    public Proyectos(String codPro) {
        this.codPro = codPro;
    }

    public Proyectos(String codPro, String nomPro, int numResAprEsp, int numResAprTra, int numResAprBas, String plaPrb, String jusPro, String objGen, String objEsp, String benPro, String impSoc, String impEco, String impAmb, String impTec, String rieAso, String resPro, String gesTec, String valPrd) {
        this.codPro = codPro;
        this.nomPro = nomPro;
        this.numResAprEsp = numResAprEsp;
        this.numResAprTra = numResAprTra;
        this.numResAprBas = numResAprBas;
        this.plaPrb = plaPrb;
        this.jusPro = jusPro;
        this.objGen = objGen;
        this.objEsp = objEsp;
        this.benPro = benPro;
        this.impSoc = impSoc;
        this.impEco = impEco;
        this.impAmb = impAmb;
        this.impTec = impTec;
        this.rieAso = rieAso;
        this.resPro = resPro;
        this.gesTec = gesTec;
        this.valPrd = valPrd;
    }

    public String getCodPro() {
        return codPro;
    }

    public void setCodPro(String codPro) {
        this.codPro = codPro;
    }

    public String getNomPro() {
        return nomPro;
    }

    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public int getNumResAprEsp() {
        return numResAprEsp;
    }

    public void setNumResAprEsp(int numResAprEsp) {
        this.numResAprEsp = numResAprEsp;
    }

    public int getNumResAprTra() {
        return numResAprTra;
    }

    public void setNumResAprTra(int numResAprTra) {
        this.numResAprTra = numResAprTra;
    }

    public int getNumResAprBas() {
        return numResAprBas;
    }

    public void setNumResAprBas(int numResAprBas) {
        this.numResAprBas = numResAprBas;
    }

    public String getPlaPrb() {
        return plaPrb;
    }

    public void setPlaPrb(String plaPrb) {
        this.plaPrb = plaPrb;
    }

    public String getJusPro() {
        return jusPro;
    }

    public void setJusPro(String jusPro) {
        this.jusPro = jusPro;
    }

    public String getObjGen() {
        return objGen;
    }

    public void setObjGen(String objGen) {
        this.objGen = objGen;
    }

    public String getObjEsp() {
        return objEsp;
    }

    public void setObjEsp(String objEsp) {
        this.objEsp = objEsp;
    }

    public String getBenPro() {
        return benPro;
    }

    public void setBenPro(String benPro) {
        this.benPro = benPro;
    }

    public String getImpSoc() {
        return impSoc;
    }

    public void setImpSoc(String impSoc) {
        this.impSoc = impSoc;
    }

    public String getImpEco() {
        return impEco;
    }

    public void setImpEco(String impEco) {
        this.impEco = impEco;
    }

    public String getImpAmb() {
        return impAmb;
    }

    public void setImpAmb(String impAmb) {
        this.impAmb = impAmb;
    }

    public String getImpTec() {
        return impTec;
    }

    public void setImpTec(String impTec) {
        this.impTec = impTec;
    }

    public String getRieAso() {
        return rieAso;
    }

    public void setRieAso(String rieAso) {
        this.rieAso = rieAso;
    }

    public String getResPro() {
        return resPro;
    }

    public void setResPro(String resPro) {
        this.resPro = resPro;
    }

    public String getGesTec() {
        return gesTec;
    }

    public void setGesTec(String gesTec) {
        this.gesTec = gesTec;
    }

    public String getValPrd() {
        return valPrd;
    }

    public void setValPrd(String valPrd) {
        this.valPrd = valPrd;
    }

    @XmlTransient
    public List<FasesProyecto> getFasesProyectoList() {
        return fasesProyectoList;
    }

    public void setFasesProyectoList(List<FasesProyecto> fasesProyectoList) {
        this.fasesProyectoList = fasesProyectoList;
    }

    public EstadosProyectos getCodEstPro() {
        return codEstPro;
    }

    public void setCodEstPro(EstadosProyectos codEstPro) {
        this.codEstPro = codEstPro;
    }

    @XmlTransient
    public List<FichasCaracterizacion> getFichasCaracterizacionList() {
        return fichasCaracterizacionList;
    }

    public void setFichasCaracterizacionList(List<FichasCaracterizacion> fichasCaracterizacionList) {
        this.fichasCaracterizacionList = fichasCaracterizacionList;
    }

    @XmlTransient
    public List<PraxisPedagogica> getPraxisPedagogicaList() {
        return praxisPedagogicaList;
    }

    public void setPraxisPedagogicaList(List<PraxisPedagogica> praxisPedagogicaList) {
        this.praxisPedagogicaList = praxisPedagogicaList;
    }

    @XmlTransient
    public List<SeguimientoInstructores> getSeguimientoInstructoresList() {
        return seguimientoInstructoresList;
    }

    public void setSeguimientoInstructoresList(List<SeguimientoInstructores> seguimientoInstructoresList) {
        this.seguimientoInstructoresList = seguimientoInstructoresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPro != null ? codPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.codPro == null && other.codPro != null) || (this.codPro != null && !this.codPro.equals(other.codPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Proyectos[ codPro=" + codPro + " ]";
    }
    
}
