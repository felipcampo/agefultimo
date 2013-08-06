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
@Table(name = "subactividades_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubactividadesProyecto.findAll", query = "SELECT s FROM SubactividadesProyecto s"),
    @NamedQuery(name = "SubactividadesProyecto.findByCodSubPro", query = "SELECT s FROM SubactividadesProyecto s WHERE s.codSubPro = :codSubPro"),
    @NamedQuery(name = "SubactividadesProyecto.findByNomSubPro", query = "SELECT s FROM SubactividadesProyecto s WHERE s.nomSubPro = :nomSubPro")})
public class SubactividadesProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "cod_sub_pro")
    private String codSubPro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nom_sub_pro")
    private String nomSubPro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSubPro")
    private List<EvidenciasAprendizaje> evidenciasAprendizajeList;
    @JoinColumn(name = "cod_act_pro", referencedColumnName = "cod_act_pro")
    @ManyToOne(optional = false)
    private ActividadesProyecto codActPro;

    public SubactividadesProyecto() {
    }

    public SubactividadesProyecto(String codSubPro) {
        this.codSubPro = codSubPro;
    }

    public SubactividadesProyecto(String codSubPro, String nomSubPro) {
        this.codSubPro = codSubPro;
        this.nomSubPro = nomSubPro;
    }

    public String getCodSubPro() {
        return codSubPro;
    }

    public void setCodSubPro(String codSubPro) {
        this.codSubPro = codSubPro;
    }

    public String getNomSubPro() {
        return nomSubPro;
    }

    public void setNomSubPro(String nomSubPro) {
        this.nomSubPro = nomSubPro;
    }

    @XmlTransient
    public List<EvidenciasAprendizaje> getEvidenciasAprendizajeList() {
        return evidenciasAprendizajeList;
    }

    public void setEvidenciasAprendizajeList(List<EvidenciasAprendizaje> evidenciasAprendizajeList) {
        this.evidenciasAprendizajeList = evidenciasAprendizajeList;
    }

    public ActividadesProyecto getCodActPro() {
        return codActPro;
    }

    public void setCodActPro(ActividadesProyecto codActPro) {
        this.codActPro = codActPro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSubPro != null ? codSubPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubactividadesProyecto)) {
            return false;
        }
        SubactividadesProyecto other = (SubactividadesProyecto) object;
        if ((this.codSubPro == null && other.codSubPro != null) || (this.codSubPro != null && !this.codSubPro.equals(other.codSubPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.SubactividadesProyecto[ codSubPro=" + codSubPro + " ]";
    }
    
}
