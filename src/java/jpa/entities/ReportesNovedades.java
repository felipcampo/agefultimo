/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "reportes_novedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportesNovedades.findAll", query = "SELECT r FROM ReportesNovedades r"),
    @NamedQuery(name = "ReportesNovedades.findByNumRep", query = "SELECT r FROM ReportesNovedades r WHERE r.numRep = :numRep"),
    @NamedQuery(name = "ReportesNovedades.findByFecRep", query = "SELECT r FROM ReportesNovedades r WHERE r.fecRep = :fecRep"),
    @NamedQuery(name = "ReportesNovedades.findByNumAccCor", query = "SELECT r FROM ReportesNovedades r WHERE r.numAccCor = :numAccCor"),
    @NamedQuery(name = "ReportesNovedades.findByConAccCor", query = "SELECT r FROM ReportesNovedades r WHERE r.conAccCor = :conAccCor"),
    @NamedQuery(name = "ReportesNovedades.findByFecUltPlaMej", query = "SELECT r FROM ReportesNovedades r WHERE r.fecUltPlaMej = :fecUltPlaMej")})
public class ReportesNovedades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_rep")
    private Integer numRep;
    @Column(name = "fec_rep")
    @Temporal(TemporalType.DATE)
    private Date fecRep;
    @Column(name = "num_acc_cor")
    private Integer numAccCor;
    @Column(name = "con_acc_cor")
    private Integer conAccCor;
    @Lob
    @Size(max = 65535)
    @Column(name = "des_ant")
    private String desAnt;
    @Column(name = "fec_ult_pla_mej")
    @Temporal(TemporalType.DATE)
    private Date fecUltPlaMej;
    @Lob
    @Size(max = 65535)
    @Column(name = "hechos")
    private String hechos;
    @Lob
    @Size(max = 65535)
    @Column(name = "testigos")
    private String testigos;
    @Lob
    @Size(max = 65535)
    @Column(name = "pruebas")
    private String pruebas;
    @Lob
    @Size(max = 65535)
    @Column(name = "des_fal")
    private String desFal;
    @Lob
    @Size(max = 65535)
    @Column(name = "des_pru")
    private String desPru;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numRep")
    private List<Comites> comitesList;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_res_apr", referencedColumnName = "cod_res_apr")
    @ManyToOne(optional = false)
    private ResultadosAprendizaje codResApr;
    @JoinColumn(name = "cod_des", referencedColumnName = "cod_des")
    @ManyToOne(optional = false)
    private Deserciones codDes;
    @JoinColumn(name = "cod_fic", referencedColumnName = "cod_fic")
    @ManyToOne(optional = false)
    private FichasCaracterizacion codFic;

    public ReportesNovedades() {
    }

    public ReportesNovedades(Integer numRep) {
        this.numRep = numRep;
    }

    public Integer getNumRep() {
        return numRep;
    }

    public void setNumRep(Integer numRep) {
        this.numRep = numRep;
    }

    public Date getFecRep() {
        return fecRep;
    }

    public void setFecRep(Date fecRep) {
        this.fecRep = fecRep;
    }

    public Integer getNumAccCor() {
        return numAccCor;
    }

    public void setNumAccCor(Integer numAccCor) {
        this.numAccCor = numAccCor;
    }

    public Integer getConAccCor() {
        return conAccCor;
    }

    public void setConAccCor(Integer conAccCor) {
        this.conAccCor = conAccCor;
    }

    public String getDesAnt() {
        return desAnt;
    }

    public void setDesAnt(String desAnt) {
        this.desAnt = desAnt;
    }

    public Date getFecUltPlaMej() {
        return fecUltPlaMej;
    }

    public void setFecUltPlaMej(Date fecUltPlaMej) {
        this.fecUltPlaMej = fecUltPlaMej;
    }

    public String getHechos() {
        return hechos;
    }

    public void setHechos(String hechos) {
        this.hechos = hechos;
    }

    public String getTestigos() {
        return testigos;
    }

    public void setTestigos(String testigos) {
        this.testigos = testigos;
    }

    public String getPruebas() {
        return pruebas;
    }

    public void setPruebas(String pruebas) {
        this.pruebas = pruebas;
    }

    public String getDesFal() {
        return desFal;
    }

    public void setDesFal(String desFal) {
        this.desFal = desFal;
    }

    public String getDesPru() {
        return desPru;
    }

    public void setDesPru(String desPru) {
        this.desPru = desPru;
    }

    @XmlTransient
    public List<Comites> getComitesList() {
        return comitesList;
    }

    public void setComitesList(List<Comites> comitesList) {
        this.comitesList = comitesList;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    public ResultadosAprendizaje getCodResApr() {
        return codResApr;
    }

    public void setCodResApr(ResultadosAprendizaje codResApr) {
        this.codResApr = codResApr;
    }

    public Deserciones getCodDes() {
        return codDes;
    }

    public void setCodDes(Deserciones codDes) {
        this.codDes = codDes;
    }

    public FichasCaracterizacion getCodFic() {
        return codFic;
    }

    public void setCodFic(FichasCaracterizacion codFic) {
        this.codFic = codFic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numRep != null ? numRep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportesNovedades)) {
            return false;
        }
        ReportesNovedades other = (ReportesNovedades) object;
        if ((this.numRep == null && other.numRep != null) || (this.numRep != null && !this.numRep.equals(other.numRep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ReportesNovedades[ numRep=" + numRep + " ]";
    }
    
}
