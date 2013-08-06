/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "criterios_seguimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CriteriosSeguimientos.findAll", query = "SELECT c FROM CriteriosSeguimientos c"),
    @NamedQuery(name = "CriteriosSeguimientos.findByIdCsp", query = "SELECT c FROM CriteriosSeguimientos c WHERE c.idCsp = :idCsp"),
    @NamedQuery(name = "CriteriosSeguimientos.findByValCep", query = "SELECT c FROM CriteriosSeguimientos c WHERE c.valCep = :valCep")})
public class CriteriosSeguimientos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_csp")
    private Integer idCsp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "val_cep")
    private boolean valCep;
    @Lob
    @Size(max = 65535)
    @Column(name = "obs_cep")
    private String obsCep;
    @JoinColumn(name = "cod_seg_pro", referencedColumnName = "cod_seg_pro")
    @ManyToOne(optional = false)
    private SeguimientosProductiva codSegPro;
    @JoinColumn(name = "cod_cri", referencedColumnName = "cod_cri")
    @ManyToOne
    private CriteriosEvaluacion codCri;

    public CriteriosSeguimientos() {
    }

    public CriteriosSeguimientos(Integer idCsp) {
        this.idCsp = idCsp;
    }

    public CriteriosSeguimientos(Integer idCsp, boolean valCep) {
        this.idCsp = idCsp;
        this.valCep = valCep;
    }

    public Integer getIdCsp() {
        return idCsp;
    }

    public void setIdCsp(Integer idCsp) {
        this.idCsp = idCsp;
    }

    public boolean getValCep() {
        return valCep;
    }

    public void setValCep(boolean valCep) {
        this.valCep = valCep;
    }

    public String getObsCep() {
        return obsCep;
    }

    public void setObsCep(String obsCep) {
        this.obsCep = obsCep;
    }

    public SeguimientosProductiva getCodSegPro() {
        return codSegPro;
    }

    public void setCodSegPro(SeguimientosProductiva codSegPro) {
        this.codSegPro = codSegPro;
    }

    public CriteriosEvaluacion getCodCri() {
        return codCri;
    }

    public void setCodCri(CriteriosEvaluacion codCri) {
        this.codCri = codCri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCsp != null ? idCsp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CriteriosSeguimientos)) {
            return false;
        }
        CriteriosSeguimientos other = (CriteriosSeguimientos) object;
        if ((this.idCsp == null && other.idCsp != null) || (this.idCsp != null && !this.idCsp.equals(other.idCsp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CriteriosSeguimientos[ idCsp=" + idCsp + " ]";
    }
    
}
