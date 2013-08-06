/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "contratos_proyectos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContratosProyectos.findAll", query = "SELECT c FROM ContratosProyectos c"),
    @NamedQuery(name = "ContratosProyectos.findByCodCop", query = "SELECT c FROM ContratosProyectos c WHERE c.codCop = :codCop"),
    @NamedQuery(name = "ContratosProyectos.findByFinCop", query = "SELECT c FROM ContratosProyectos c WHERE c.finCop = :finCop"),
    @NamedQuery(name = "ContratosProyectos.findByFfiCop", query = "SELECT c FROM ContratosProyectos c WHERE c.ffiCop = :ffiCop"),
    @NamedQuery(name = "ContratosProyectos.findByArcCop", query = "SELECT c FROM ContratosProyectos c WHERE c.arcCop = :arcCop"),
    @NamedQuery(name = "ContratosProyectos.findByFecSub", query = "SELECT c FROM ContratosProyectos c WHERE c.fecSub = :fecSub")})
public class ContratosProyectos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cop")
    private Integer codCop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin_cop")
    @Temporal(TemporalType.DATE)
    private Date finCop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ffi_cop")
    @Temporal(TemporalType.DATE)
    private Date ffiCop;
    @Size(max = 128)
    @Column(name = "arc_cop")
    private String arcCop;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_sub")
    @Temporal(TemporalType.DATE)
    private Date fecSub;
    @JoinColumn(name = "nit_emp", referencedColumnName = "nit_emp")
    @ManyToOne(optional = false)
    private Empresas nitEmp;
    @JoinColumn(name = "id_usu", referencedColumnName = "id_usu")
    @ManyToOne(optional = false)
    private Usuarios idUsu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCop")
    private List<ModalidadesProductiva> modalidadesProductivaList;

    public ContratosProyectos() {
    }

    public ContratosProyectos(Integer codCop) {
        this.codCop = codCop;
    }

    public ContratosProyectos(Integer codCop, Date finCop, Date ffiCop, Date fecSub) {
        this.codCop = codCop;
        this.finCop = finCop;
        this.ffiCop = ffiCop;
        this.fecSub = fecSub;
    }

    public Integer getCodCop() {
        return codCop;
    }

    public void setCodCop(Integer codCop) {
        this.codCop = codCop;
    }

    public Date getFinCop() {
        return finCop;
    }

    public void setFinCop(Date finCop) {
        this.finCop = finCop;
    }

    public Date getFfiCop() {
        return ffiCop;
    }

    public void setFfiCop(Date ffiCop) {
        this.ffiCop = ffiCop;
    }

    public String getArcCop() {
        return arcCop;
    }

    public void setArcCop(String arcCop) {
        this.arcCop = arcCop;
    }

    public Date getFecSub() {
        return fecSub;
    }

    public void setFecSub(Date fecSub) {
        this.fecSub = fecSub;
    }

    public Empresas getNitEmp() {
        return nitEmp;
    }

    public void setNitEmp(Empresas nitEmp) {
        this.nitEmp = nitEmp;
    }

    public Usuarios getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuarios idUsu) {
        this.idUsu = idUsu;
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
        hash += (codCop != null ? codCop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratosProyectos)) {
            return false;
        }
        ContratosProyectos other = (ContratosProyectos) object;
        if ((this.codCop == null && other.codCop != null) || (this.codCop != null && !this.codCop.equals(other.codCop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ContratosProyectos[ codCop=" + codCop + " ]";
    }
    
}
