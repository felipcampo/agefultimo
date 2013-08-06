/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "control_aprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlAprendiz.findAll", query = "SELECT c FROM ControlAprendiz c"),
    @NamedQuery(name = "ControlAprendiz.findByConsec", query = "SELECT c FROM ControlAprendiz c WHERE c.consec = :consec"),
    @NamedQuery(name = "ControlAprendiz.findByNumSegBie", query = "SELECT c FROM ControlAprendiz c WHERE c.numSegBie = :numSegBie"),
    @NamedQuery(name = "ControlAprendiz.findByFecConBie", query = "SELECT c FROM ControlAprendiz c WHERE c.fecConBie = :fecConBie"),
    @NamedQuery(name = "ControlAprendiz.findByFecHorCon", query = "SELECT c FROM ControlAprendiz c WHERE c.fecHorCon = :fecHorCon"),
    @NamedQuery(name = "ControlAprendiz.findByFirIns", query = "SELECT c FROM ControlAprendiz c WHERE c.firIns = :firIns")})
public class ControlAprendiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consec")
    private Integer consec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "num_seg_bie")
    private String numSegBie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_con_bie")
    @Temporal(TemporalType.DATE)
    private Date fecConBie;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "obj_ses")
    private String objSes;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "tem_abo")
    private String temAbo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "log_obj")
    private String logObj;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_hor_con")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHorCon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fir_ins")
    private String firIns;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "com_ins")
    private String comIns;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @JoinColumn(name = "cod_est_bie", referencedColumnName = "cod_est_bie")
    @ManyToOne(optional = false)
    private EstadosCasosBienestar codEstBie;

    public ControlAprendiz() {
    }

    public ControlAprendiz(Integer consec) {
        this.consec = consec;
    }

    public ControlAprendiz(Integer consec, String numSegBie, Date fecConBie, String objSes, String temAbo, String logObj, Date fecHorCon, String firIns, String comIns) {
        this.consec = consec;
        this.numSegBie = numSegBie;
        this.fecConBie = fecConBie;
        this.objSes = objSes;
        this.temAbo = temAbo;
        this.logObj = logObj;
        this.fecHorCon = fecHorCon;
        this.firIns = firIns;
        this.comIns = comIns;
    }

    public Integer getConsec() {
        return consec;
    }

    public void setConsec(Integer consec) {
        this.consec = consec;
    }

    public String getNumSegBie() {
        return numSegBie;
    }

    public void setNumSegBie(String numSegBie) {
        this.numSegBie = numSegBie;
    }

    public Date getFecConBie() {
        return fecConBie;
    }

    public void setFecConBie(Date fecConBie) {
        this.fecConBie = fecConBie;
    }

    public String getObjSes() {
        return objSes;
    }

    public void setObjSes(String objSes) {
        this.objSes = objSes;
    }

    public String getTemAbo() {
        return temAbo;
    }

    public void setTemAbo(String temAbo) {
        this.temAbo = temAbo;
    }

    public String getLogObj() {
        return logObj;
    }

    public void setLogObj(String logObj) {
        this.logObj = logObj;
    }

    public Date getFecHorCon() {
        return fecHorCon;
    }

    public void setFecHorCon(Date fecHorCon) {
        this.fecHorCon = fecHorCon;
    }

    public String getFirIns() {
        return firIns;
    }

    public void setFirIns(String firIns) {
        this.firIns = firIns;
    }

    public String getComIns() {
        return comIns;
    }

    public void setComIns(String comIns) {
        this.comIns = comIns;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    public EstadosCasosBienestar getCodEstBie() {
        return codEstBie;
    }

    public void setCodEstBie(EstadosCasosBienestar codEstBie) {
        this.codEstBie = codEstBie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consec != null ? consec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlAprendiz)) {
            return false;
        }
        ControlAprendiz other = (ControlAprendiz) object;
        if ((this.consec == null && other.consec != null) || (this.consec != null && !this.consec.equals(other.consec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ControlAprendiz[ consec=" + consec + " ]";
    }
    
}
