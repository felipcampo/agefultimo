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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "fases_proyecto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FasesProyecto.findAll", query = "SELECT f FROM FasesProyecto f"),
    @NamedQuery(name = "FasesProyecto.findByCodFasPro", query = "SELECT f FROM FasesProyecto f WHERE f.codFasPro = :codFasPro"),
    @NamedQuery(name = "FasesProyecto.findByNomFasPro", query = "SELECT f FROM FasesProyecto f WHERE f.nomFasPro = :nomFasPro"),
    @NamedQuery(name = "FasesProyecto.findByDurHorFas", query = "SELECT f FROM FasesProyecto f WHERE f.durHorFas = :durHorFas")})
public class FasesProyecto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "cod_fas_pro")
    private String codFasPro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nom_fas_pro")
    private String nomFasPro;
    @Lob
    @Size(max = 65535)
    @Column(name = "des_fas_pro")
    private String desFasPro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dur_hor_fas")
    private int durHorFas;
    @JoinTable(name = "proyectos_fases", joinColumns = {
        @JoinColumn(name = "cod_fas_pro", referencedColumnName = "cod_fas_pro")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_pro", referencedColumnName = "cod_pro")})
    @ManyToMany
    private List<Proyectos> proyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFasPro")
    private List<ActividadesProyecto> actividadesProyectoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFasPro")
    private List<Alistamientos> alistamientosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFasPro")
    private List<SeguimientoProyectos> seguimientoProyectosList;

    public FasesProyecto() {
    }

    public FasesProyecto(String codFasPro) {
        this.codFasPro = codFasPro;
    }

    public FasesProyecto(String codFasPro, String nomFasPro, int durHorFas) {
        this.codFasPro = codFasPro;
        this.nomFasPro = nomFasPro;
        this.durHorFas = durHorFas;
    }

    public String getCodFasPro() {
        return codFasPro;
    }

    public void setCodFasPro(String codFasPro) {
        this.codFasPro = codFasPro;
    }

    public String getNomFasPro() {
        return nomFasPro;
    }

    public void setNomFasPro(String nomFasPro) {
        this.nomFasPro = nomFasPro;
    }

    public String getDesFasPro() {
        return desFasPro;
    }

    public void setDesFasPro(String desFasPro) {
        this.desFasPro = desFasPro;
    }

    public int getDurHorFas() {
        return durHorFas;
    }

    public void setDurHorFas(int durHorFas) {
        this.durHorFas = durHorFas;
    }

    @XmlTransient
    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @XmlTransient
    public List<ActividadesProyecto> getActividadesProyectoList() {
        return actividadesProyectoList;
    }

    public void setActividadesProyectoList(List<ActividadesProyecto> actividadesProyectoList) {
        this.actividadesProyectoList = actividadesProyectoList;
    }

    @XmlTransient
    public List<Alistamientos> getAlistamientosList() {
        return alistamientosList;
    }

    public void setAlistamientosList(List<Alistamientos> alistamientosList) {
        this.alistamientosList = alistamientosList;
    }

    @XmlTransient
    public List<SeguimientoProyectos> getSeguimientoProyectosList() {
        return seguimientoProyectosList;
    }

    public void setSeguimientoProyectosList(List<SeguimientoProyectos> seguimientoProyectosList) {
        this.seguimientoProyectosList = seguimientoProyectosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFasPro != null ? codFasPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FasesProyecto)) {
            return false;
        }
        FasesProyecto other = (FasesProyecto) object;
        if ((this.codFasPro == null && other.codFasPro != null) || (this.codFasPro != null && !this.codFasPro.equals(other.codFasPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.FasesProyecto[ codFasPro=" + codFasPro + " ]";
    }
    
}
