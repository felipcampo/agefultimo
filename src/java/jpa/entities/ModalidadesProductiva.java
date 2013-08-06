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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "modalidades_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModalidadesProductiva.findAll", query = "SELECT m FROM ModalidadesProductiva m"),
    @NamedQuery(name = "ModalidadesProductiva.findByCodMod", query = "SELECT m FROM ModalidadesProductiva m WHERE m.codMod = :codMod"),
    @NamedQuery(name = "ModalidadesProductiva.findByDetMod", query = "SELECT m FROM ModalidadesProductiva m WHERE m.detMod = :detMod"),
    @NamedQuery(name = "ModalidadesProductiva.findByDurMod", query = "SELECT m FROM ModalidadesProductiva m WHERE m.durMod = :durMod")})
public class ModalidadesProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_mod")
    private Integer codMod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "det_mod")
    private String detMod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dur_mod")
    private int durMod;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "inf_req")
    private String infReq;
    @JoinColumn(name = "cod_tdm", referencedColumnName = "cod_tdm")
    @ManyToOne(optional = false)
    private TiposModalidadesProductiva codTdm;
    @JoinColumn(name = "cod_cop", referencedColumnName = "cod_cop")
    @ManyToOne(optional = false)
    private ContratosProyectos codCop;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMod")
    private List<SeguimientosProductiva> seguimientosProductivaList;

    public ModalidadesProductiva() {
    }

    public ModalidadesProductiva(Integer codMod) {
        this.codMod = codMod;
    }

    public ModalidadesProductiva(Integer codMod, String detMod, int durMod, String infReq) {
        this.codMod = codMod;
        this.detMod = detMod;
        this.durMod = durMod;
        this.infReq = infReq;
    }

    public Integer getCodMod() {
        return codMod;
    }

    public void setCodMod(Integer codMod) {
        this.codMod = codMod;
    }

    public String getDetMod() {
        return detMod;
    }

    public void setDetMod(String detMod) {
        this.detMod = detMod;
    }

    public int getDurMod() {
        return durMod;
    }

    public void setDurMod(int durMod) {
        this.durMod = durMod;
    }

    public String getInfReq() {
        return infReq;
    }

    public void setInfReq(String infReq) {
        this.infReq = infReq;
    }

    public TiposModalidadesProductiva getCodTdm() {
        return codTdm;
    }

    public void setCodTdm(TiposModalidadesProductiva codTdm) {
        this.codTdm = codTdm;
    }

    public ContratosProyectos getCodCop() {
        return codCop;
    }

    public void setCodCop(ContratosProyectos codCop) {
        this.codCop = codCop;
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
        hash += (codMod != null ? codMod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModalidadesProductiva)) {
            return false;
        }
        ModalidadesProductiva other = (ModalidadesProductiva) object;
        if ((this.codMod == null && other.codMod != null) || (this.codMod != null && !this.codMod.equals(other.codMod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ModalidadesProductiva[ codMod=" + codMod + " ]";
    }
    
}
