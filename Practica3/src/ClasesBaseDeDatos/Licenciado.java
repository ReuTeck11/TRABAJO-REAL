/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesBaseDeDatos;

/**
 *
 * @author Alex
 */
public class Licenciado {

    private Integer idLicenciado;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefonoOficina;
    private String horarioAtencion;

    /**
     * @return the idLicenciado
     */
    public Integer getIdLicenciado() {
        return idLicenciado;
    }

    /**
     * @param idLicenciado the idLicenciado to set
     */
    public void setIdLicenciado(Integer idLicenciado) {
        this.idLicenciado = idLicenciado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the telefonoOficina
     */
    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    /**
     * @param telefonoOficina the telefonoOficina to set
     */
    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    /**
     * @return the horarioAtencion
     */
    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    /**
     * @param horarioAtencion the horarioAtencion to set
     */
    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

}
