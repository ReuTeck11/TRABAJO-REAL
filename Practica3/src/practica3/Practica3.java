/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author hp
 */
import ClasesBaseDeDatos.*;
public class Practica3 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        deportista D = new deportista();
        D.setIdDeportista(3);
        D.setApellidoMaterno("Ponce");
        D.setApellidoPaterno("Diaz");
        D.setDeporte("Futboll");
        D.setFechaNacimiento("1998-09-20");
        D.setGenero("Masculino");
        D.setNombre("Alberto");
        conDeportista c = new conDeportista();
        c.eliminarDeportista("4");
    }
}
