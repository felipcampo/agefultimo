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
@Table(name = "medidas_formativas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedidasFormativas.findAll", query = "SELECT m FROM MedidasFormativas m"),
    @NamedQuery(name = "MedidasFormativas.findByCodMedFor", query = "SELECT m FROM MedidasFormativas m WHERE m.codMedFor = :codMedFor"),
    @NamedQuery(name = "MedidasFormativas.findByNomMedFor", query = "SELECT m FROM MedidasFormativas m WHERE m.nomMedFor = :nomMedFor")})
public class MedidasFormativas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cod_med_for")
    private String codMedFor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_med_for")
    private String nomMedFor;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMedFor")
    private List<Comites> comitesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMedFor")
    private List<Faltas> faltasList;

    public MedidasFormativas() {
    }

    public MedidasFormativas(String codMedFor) {
        this.codMedFor = codMedFor;
    }

    public MedidasFormativas(String codMedFor, String nomMedFor) {
        this.codMedFor = codMedFor;
        this.nomMedFor = nomMedFor;
    }

    public String getCodMedFor() {
        return codMedFor;
    }

    public void setCodMedFor(String codMedFor) {
        this.codMedFor = codMedFor;
    }

    public String getNomMedFor() {
        return nomMedFor;
    }

    public void setNomMedFor(String nomMedFor) {
        this.nomMedFor = nomMedFor;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
    }

    @XmlTransient
    public List<Comites> getComitesList() {
        return comitesList;
    }

    public void setComitesList(List<Comites> comitesList) {
        this.comitesList = comitesList;
    }

    @XmlTransient
    public List<Faltas> getFaltasList() {
        return faltasList;
    }

    public void setFaltasList(List<Faltas> faltasList) {
        this.faltasList = faltasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMedFor != null ? codMedFor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedidasFormativas)) {
            return false;
        }
        MedidasFormativas other = (MedidasFormativas) object;
        if ((this.codMedFor == null && other.codMedFor != null) || (this.codMedFor != null && !this.codMedFor.equals(other.codMedFor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.MedidasFormativas[ codMedFor=" + codMedFor + " ]";
    }
    
}
