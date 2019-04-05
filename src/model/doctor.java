
package model;


public class doctor {
     //Encapsulamiento de los campos del doctor
    private int  idDoctor;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String especialidad;
    private String nombreHospital;
    private String direccionHospital;
    private String medio;
    private int numeroMedio;
    
    public int getIdDoctor() {
    return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }
    //Getter and Setter Nombre
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Getter and Setter Apellido Paterno
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    //Getter and Setter Apellido Materno
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    //Getter and Setter  Fecha de Nacimient
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //Getter and Setter Especialidad
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //Getter and Setter Nombre del Hospital
    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    //Getter and Setter Direccion del hospital
    public String getDireccionHospital() {
        return direccionHospital;
    }

    public void setDireccionHospital(String direccionHospital) {
        this.direccionHospital = direccionHospital;
    }
        
   //Getter and Setter Medio
    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }

    //Getter and Setter Numero medio
    public int getNumeroMedio() {
        return numeroMedio;
    }

    public void setNumeroMedio(int numeroMedio) {
        this.numeroMedio = numeroMedio;
    }
}
