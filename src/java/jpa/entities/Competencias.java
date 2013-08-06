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
@Table(name = "competencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencias.findAll", query = "SELECT c FROM Competencias c"),
    @NamedQuery(name = "Competencias.findByCodCom", query = "SELECT c FROM Competencias c WHERE c.codCom = :codCom"),
    @NamedQuery(name = "Competencias.findByDurCom", query = "SELECT c FROM Competencias c WHERE c.durCom = :durCom")})
public class Competencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_com")
    private Integer codCom;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nom_com")
    private String nomCom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dur_com")
    private int durCom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCom")
    private List<ResultadosAprendizaje> resultadosAprendizajeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCom")
    private List<SeguimientoProyectos> seguimientoProyectosList;
    @JoinColumn(name = "cod_prg", referencedColumnName = "cod_prg")
    @ManyToOne(optional = false)
    private Programas codPrg;

    public Competencias() {
    }

    public Competencias(Integer codCom) {
        this.codCom = codCom;
    }

    public Competencias(Integer codCom, String nomCom, int durCom) {
        this.codCom = codCom;
        this.nomCom = nomCom;
        this.durCom = durCom;
    }

    public Integer getCodCom() {
        return codCom;
    }

    public void setCodCom(Integer codCom) {
        this.codCom = codCom;
    }

    public String getNomCom() {
        return nomCom;
    }

    public void setNomCom(String nomCom) {
        this.nomCom = nomCom;
    }

    public int getDurCom() {
        return durCom;
    }

    public void setDurCom(int durCom) {
        this.durCom = durCom;
    }

    @XmlTransient
    public List<ResultadosAprendizaje> getResultadosAprendizajeList() {
        return resultadosAprendizajeList;
    }

    public void setResultadosAprendizajeList(List<ResultadosAprendizaje> resultadosAprendizajeList) {
        this.resultadosAprendizajeList = resultadosAprendizajeList;
    }

    @XmlTransient
    public List<SeguimientoProyectos> getSeguimientoProyectosList() {
        return seguimientoProyectosList;
    }

    public void setSeguimientoProyectosList(List<SeguimientoProyectos> seguimientoProyectosList) {
        this.seguimientoProyectosList = seguimientoProyectosList;
    }

    public Programas getCodPrg() {
        return codPrg;
    }

    public void setCodPrg(Programas codPrg) {
        this.codPrg = codPrg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCom != null ? codCom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencias)) {
            return false;
        }
        Competencias other = (Competencias) object;
        if ((this.codCom == null && other.codCom != null) || (this.codCom != null && !this.codCom.equals(other.codCom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Competencias[ codCom=" + codCom + " ]";
    }
    
}
