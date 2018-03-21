/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profe;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Bryan Requenes
 */
@Entity
@Table(name = "PROFESORES", catalog = "", schema = "BRYAN")
@NamedQueries({
    @NamedQuery(name = "Profesores.findAll", query = "SELECT p FROM Profesores p")
    , @NamedQuery(name = "Profesores.findByCedula", query = "SELECT p FROM Profesores p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Profesores.findByNombre", query = "SELECT p FROM Profesores p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Profesores.findByApellido", query = "SELECT p FROM Profesores p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Profesores.findByHorasClase", query = "SELECT p FROM Profesores p WHERE p.horasClase = :horasClase")
    , @NamedQuery(name = "Profesores.findByHorasComplementarias", query = "SELECT p FROM Profesores p WHERE p.horasComplementarias = :horasComplementarias")
    , @NamedQuery(name = "Profesores.findByCarrera", query = "SELECT p FROM Profesores p WHERE p.carrera = :carrera")
    , @NamedQuery(name = "Profesores.findByTipo", query = "SELECT p FROM Profesores p WHERE p.tipo = :tipo")})
public class Profesores implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "HORAS_CLASE")
    private Integer horasClase;
    @Column(name = "HORAS_COMPLEMENTARIAS")
    private Integer horasComplementarias;
    @Column(name = "CARRERA")
    private String carrera;
    @Column(name = "TIPO")
    private String tipo;

    public Profesores() {
    }

    public Profesores(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        String oldCedula = this.cedula;
        this.cedula = cedula;
        changeSupport.firePropertyChange("cedula", oldCedula, cedula);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String oldApellido = this.apellido;
        this.apellido = apellido;
        changeSupport.firePropertyChange("apellido", oldApellido, apellido);
    }

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        Integer oldHorasClase = this.horasClase;
        this.horasClase = horasClase;
        changeSupport.firePropertyChange("horasClase", oldHorasClase, horasClase);
    }

    public Integer getHorasComplementarias() {
        return horasComplementarias;
    }

    public void setHorasComplementarias(Integer horasComplementarias) {
        Integer oldHorasComplementarias = this.horasComplementarias;
        this.horasComplementarias = horasComplementarias;
        changeSupport.firePropertyChange("horasComplementarias", oldHorasComplementarias, horasComplementarias);
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        String oldCarrera = this.carrera;
        this.carrera = carrera;
        changeSupport.firePropertyChange("carrera", oldCarrera, carrera);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesores)) {
            return false;
        }
        Profesores other = (Profesores) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profe.Profesores[ cedula=" + cedula + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
