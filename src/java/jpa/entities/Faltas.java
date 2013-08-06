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
@Table(name = "faltas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faltas.findAll", query = "SELECT f FROM Faltas f"),
    @NamedQuery(name = "Faltas.findByCodFal", query = "SELECT f FROM Faltas f WHERE f.codFal = :codFal"),
    @NamedQuery(name = "Faltas.findByClaFal", query = "SELECT f FROM Faltas f WHERE f.claFal = :claFal"),
    @NamedQuery(name = "Faltas.findByCalFal", query = "SELECT f FROM Faltas f WHERE f.calFal = :calFal")})
public class Faltas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_fal")
    private String codFal;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "nom_fal")
    private String nomFal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cla_fal")
    private String claFal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cal_fal")
    private String calFal;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "cri_cal_fal")
    private String criCalFal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codFal")
    private List<Comites> comitesList;
    @OneToMany(mappedBy = "codFal")
    private List<PlanesMejoramiento> planesMejoramientoList;
    @JoinColumn(name = "cod_san", referencedColumnName = "cod_san")
    @ManyToOne(optional = false)
    private Sanciones codSan;
    @JoinColumn(name = "cod_med_for", referencedColumnName = "cod_med_for")
    @ManyToOne(optional = false)
    private MedidasFormativas codMedFor;

    public Faltas() {
    }

    public Faltas(String codFal) {
        this.codFal = codFal;
    }

    public Faltas(String codFal, String nomFal, String claFal, String calFal, String criCalFal) {
        this.codFal = codFal;
        this.nomFal = nomFal;
        this.claFal = claFal;
        this.calFal = calFal;
        this.criCalFal = criCalFal;
    }

    public String getCodFal() {
        return codFal;
    }

    public void setCodFal(String codFal) {
        this.codFal = codFal;
    }

    public String getNomFal() {
        return nomFal;
    }

    public void setNomFal(String nomFal) {
        this.nomFal = nomFal;
    }

    public String getClaFal() {
        return claFal;
    }

    public void setClaFal(String claFal) {
        this.claFal = claFal;
    }

    public String getCalFal() {
        return calFal;
    }

    public void setCalFal(String calFal) {
        this.calFal = calFal;
    }

    public String getCriCalFal() {
        return criCalFal;
    }

    public void setCriCalFal(String criCalFal) {
        this.criCalFal = criCalFal;
    }

    @XmlTransient
    public List<Comites> getComitesList() {
        return comitesList;
    }

    public void setComitesList(List<Comites> comitesList) {
        this.comitesList = comitesList;
    }

    @XmlTransient
    public List<PlanesMejoramiento> getPlanesMejoramientoList() {
        return planesMejoramientoList;
    }

    public void setPlanesMejoramientoList(List<PlanesMejoramiento> planesMejoramientoList) {
        this.planesMejoramientoList = planesMejoramientoList;
    }

    public Sanciones getCodSan() {
        return codSan;
    }

    public void setCodSan(Sanciones codSan) {
        this.codSan = codSan;
    }

    public MedidasFormativas getCodMedFor() {
        return codMedFor;
    }

    public void setCodMedFor(MedidasFormativas codMedFor) {
        this.codMedFor = codMedFor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFal != null ? codFal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faltas)) {
            return false;
        }
        Faltas other = (Faltas) object;
        if ((this.codFal == null && other.codFal != null) || (this.codFal != null && !this.codFal.equals(other.codFal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Faltas[ codFal=" + codFal + " ]";
    }
    
}
