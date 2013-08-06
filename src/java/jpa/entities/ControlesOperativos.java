/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "controles_operativos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ControlesOperativos.findAll", query = "SELECT c FROM ControlesOperativos c"),
    @NamedQuery(name = "ControlesOperativos.findByNumConOpe", query = "SELECT c FROM ControlesOperativos c WHERE c.numConOpe = :numConOpe"),
    @NamedQuery(name = "ControlesOperativos.findByFecDilConOpe", query = "SELECT c FROM ControlesOperativos c WHERE c.fecDilConOpe = :fecDilConOpe"),
    @NamedQuery(name = "ControlesOperativos.findByEleConOpe", query = "SELECT c FROM ControlesOperativos c WHERE c.eleConOpe = :eleConOpe"),
    @NamedQuery(name = "ControlesOperativos.findBySitConOpe", query = "SELECT c FROM ControlesOperativos c WHERE c.sitConOpe = :sitConOpe")})
public class ControlesOperativos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "num_con_ope")
    private Integer numConOpe;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_dil_con_ope")
    @Temporal(TemporalType.DATE)
    private Date fecDilConOpe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ele_con_ope")
    private String eleConOpe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "sit_con_ope")
    private String sitConOpe;
    @ManyToMany(mappedBy = "controlesOperativosList")
    private List<Usuarios> usuariosList;
    @JoinColumn(name = "cod_ali", referencedColumnName = "cod_ali")
    @ManyToOne(optional = false)
    private Alistamientos codAli;

    public ControlesOperativos() {
    }

    public ControlesOperativos(Integer numConOpe) {
        this.numConOpe = numConOpe;
    }

    public ControlesOperativos(Integer numConOpe, Date fecDilConOpe, String eleConOpe, String sitConOpe) {
        this.numConOpe = numConOpe;
        this.fecDilConOpe = fecDilConOpe;
        this.eleConOpe = eleConOpe;
        this.sitConOpe = sitConOpe;
    }

    public Integer getNumConOpe() {
        return numConOpe;
    }

    public void setNumConOpe(Integer numConOpe) {
        this.numConOpe = numConOpe;
    }

    public Date getFecDilConOpe() {
        return fecDilConOpe;
    }

    public void setFecDilConOpe(Date fecDilConOpe) {
        this.fecDilConOpe = fecDilConOpe;
    }

    public String getEleConOpe() {
        return eleConOpe;
    }

    public void setEleConOpe(String eleConOpe) {
        this.eleConOpe = eleConOpe;
    }

    public String getSitConOpe() {
        return sitConOpe;
    }

    public void setSitConOpe(String sitConOpe) {
        this.sitConOpe = sitConOpe;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public Alistamientos getCodAli() {
        return codAli;
    }

    public void setCodAli(Alistamientos codAli) {
        this.codAli = codAli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numConOpe != null ? numConOpe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ControlesOperativos)) {
            return false;
        }
        ControlesOperativos other = (ControlesOperativos) object;
        if ((this.numConOpe == null && other.numConOpe != null) || (this.numConOpe != null && !this.numConOpe.equals(other.numConOpe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ControlesOperativos[ numConOpe=" + numConOpe + " ]";
    }
    
}
