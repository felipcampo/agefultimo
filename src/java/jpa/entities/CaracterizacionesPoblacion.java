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
@Table(name = "caracterizaciones_poblacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaracterizacionesPoblacion.findAll", query = "SELECT c FROM CaracterizacionesPoblacion c"),
    @NamedQuery(name = "CaracterizacionesPoblacion.findByCodCarPob", query = "SELECT c FROM CaracterizacionesPoblacion c WHERE c.codCarPob = :codCarPob"),
    @NamedQuery(name = "CaracterizacionesPoblacion.findByNomCarPob", query = "SELECT c FROM CaracterizacionesPoblacion c WHERE c.nomCarPob = :nomCarPob")})
public class CaracterizacionesPoblacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_car_pob")
    private Integer codCarPob;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nom_car_pob")
    private String nomCarPob;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCarPob")
    private List<MatrizCaracterizacion> matrizCaracterizacionList;

    public CaracterizacionesPoblacion() {
    }

    public CaracterizacionesPoblacion(Integer codCarPob) {
        this.codCarPob = codCarPob;
    }

    public CaracterizacionesPoblacion(Integer codCarPob, String nomCarPob) {
        this.codCarPob = codCarPob;
        this.nomCarPob = nomCarPob;
    }

    public Integer getCodCarPob() {
        return codCarPob;
    }

    public void setCodCarPob(Integer codCarPob) {
        this.codCarPob = codCarPob;
    }

    public String getNomCarPob() {
        return nomCarPob;
    }

    public void setNomCarPob(String nomCarPob) {
        this.nomCarPob = nomCarPob;
    }

    @XmlTransient
    public List<MatrizCaracterizacion> getMatrizCaracterizacionList() {
        return matrizCaracterizacionList;
    }

    public void setMatrizCaracterizacionList(List<MatrizCaracterizacion> matrizCaracterizacionList) {
        this.matrizCaracterizacionList = matrizCaracterizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCarPob != null ? codCarPob.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracterizacionesPoblacion)) {
            return false;
        }
        CaracterizacionesPoblacion other = (CaracterizacionesPoblacion) object;
        if ((this.codCarPob == null && other.codCarPob != null) || (this.codCarPob != null && !this.codCarPob.equals(other.codCarPob))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.CaracterizacionesPoblacion[ codCarPob=" + codCarPob + " ]";
    }
    
}
