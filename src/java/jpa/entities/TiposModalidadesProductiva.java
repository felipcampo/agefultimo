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
@Table(name = "tipos_modalidades_productiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposModalidadesProductiva.findAll", query = "SELECT t FROM TiposModalidadesProductiva t"),
    @NamedQuery(name = "TiposModalidadesProductiva.findByCodTdm", query = "SELECT t FROM TiposModalidadesProductiva t WHERE t.codTdm = :codTdm"),
    @NamedQuery(name = "TiposModalidadesProductiva.findByNomTdm", query = "SELECT t FROM TiposModalidadesProductiva t WHERE t.nomTdm = :nomTdm")})
public class TiposModalidadesProductiva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tdm")
    private Integer codTdm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_tdm")
    private String nomTdm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTdm")
    private List<ModalidadesProductiva> modalidadesProductivaList;

    public TiposModalidadesProductiva() {
    }

    public TiposModalidadesProductiva(Integer codTdm) {
        this.codTdm = codTdm;
    }

    public TiposModalidadesProductiva(Integer codTdm, String nomTdm) {
        this.codTdm = codTdm;
        this.nomTdm = nomTdm;
    }

    public Integer getCodTdm() {
        return codTdm;
    }

    public void setCodTdm(Integer codTdm) {
        this.codTdm = codTdm;
    }

    public String getNomTdm() {
        return nomTdm;
    }

    public void setNomTdm(String nomTdm) {
        this.nomTdm = nomTdm;
    }

    @XmlTransient
    public List<ModalidadesProductiva> getModalidadesProductivaList() {
        return modalidadesProductivaList;
    }

    public void setModalidadesProductivaList(List<ModalidadesProductiva> modalidadesProductivaList) {
        this.modalidadesProductivaList = modalidadesProductivaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTdm != null ? codTdm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposModalidadesProductiva)) {
            return false;
        }
        TiposModalidadesProductiva other = (TiposModalidadesProductiva) object;
        if ((this.codTdm == null && other.codTdm != null) || (this.codTdm != null && !this.codTdm.equals(other.codTdm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.TiposModalidadesProductiva[ codTdm=" + codTdm + " ]";
    }
    
}
