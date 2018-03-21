/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profe;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Joel Cartuche
 */
public class Controlador_base {

    private final String url = "jdbc:derby://localhost:1527/Profesores";
    private final String usuario = "bryan";
    private final String clave = "1234";
    private Connection conexion;
    private PreparedStatement seleccionarPersonas;
    private PreparedStatement seleccionarPersonasPorApellido;
    private PreparedStatement insertarNuevaPersona;

    public Controlador_base() {
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException ex) {
            System.out.println("error al establecer coneccion " + ex);

//            Logger.getLogger(Controlador_base.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Profesor> getProfesor() {
        List<Profesor> listita = new ArrayList<Profesor>();

        try {
            Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select*from profesores");

            while (reg.next()) {
               String cedula = reg.getString("cedula");
                String nombre = reg.getString("nombre");
                String apellidob = reg.getString("apellido");
                int horas_clase = reg.getInt("horas_clase");
                int horas_complementarias = reg.getInt("horas_complementarias");
                String carrera = reg.getString("carrera");
                String tipo = reg.getString("tipo");
                //Profesor nuevo = new;

                //listita.add(nuevo);
            }

            reg.close();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controlador_base.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listita;
    }

    public List<Profesor> getProfesorApellido(String apellido) {
        apellido = "B";
        List<Profesor> listita = new ArrayList<Profesor>();

        try {
            Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select*from Profesores where apellido like '" + apellido + "%'");

            while (reg.next()) {
                String cedula = reg.getString("cedula");
                String nombre = reg.getString("nombre");
                String apellidob = reg.getString("apellido");
                int horas_clase = reg.getInt("horas_clase");
                int horas_complementarias = reg.getInt("horas_complementarias");
                String carrera = reg.getString("carrera");
                String tipo = reg.getString("tipo");

                //persona nuevo = new persona(id, nombre, apellidob, email, telefono);

                //listita.add(nuevo);
            }

            reg.close();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(Controlador_base.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listita;
    }

    public int agregarProfesorTCompleto(String cedula, String nombre, String apellido, int horasClase, String carrera, String tipo) {
        int r = 0;
        boolean satisfac = true;
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select*from profesores");
            ProfesorTiempoCompleto pc = new ProfesorTiempoCompleto(cedula, nombre, apellido, horasClase, carrera, tipo);
            int horas_complementarias = pc.horasComplementarias();
            //while (reg.next()) {
            String sqlInsert = String.format("INSERT INTO profesores VALUES('%s','%s','%s','%d','%d','%s')",
                    cedula,
                    nombre,
                    apellido,
                    horasClase,
                    horas_complementarias,
                    carrera,
                    tipo,
                    this.getProfesor().size() + 1
            );//insertando un nueva fila en la tabla

            r = sentencia.executeUpdate(sqlInsert);

            //}
            reg.close();
            sentencia.close();
            

        } catch (SQLException e) {
            System.out.println("error al enviar consulta: " + e);
            satisfac=false;
        }
        if(satisfac==true){
            JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO INGRESADOS SATISFACTORIAMENTE");
        }

        return r;
    }
    public int agregarProfesorTMedio(String cedula, String nombre, String apellido, int horas_clase, String carrera,String tipo) {
        int r = 0;
        boolean satisfac = true;
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select*from persona");
            ProfesorMedioTiempo pm = new ProfesorMedioTiempo(cedula, nombre, apellido, horas_clase, carrera, tipo);
            int horas_complementarias = pm.horasComplementarias();
            //while (reg.next()) {
            String sqlInsert = String.format("INSERT INTO profesores VALUES('%s','%s','%s','%d','%d','%s','%s')",
                    cedula,
                    nombre,
                    apellido,
                    horas_clase,
                    horas_complementarias,
                    carrera,
                    tipo,
                    this.getProfesor().size() + 1
            );//insertando un nueva fila en la tabla

            r = sentencia.executeUpdate(sqlInsert);

            //}
            reg.close();
            sentencia.close();
            

        } catch (SQLException e) {
            System.out.println("error al enviar consulta: " + e);
            satisfac=false;
        }
        if(satisfac==true){
            JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO INGRESADOS SATISFACTORIAMENTE");
        }

        return r;
    }
    public int agregarProfesorTparcial(String cedula, String nombre, String apellido, int horas_clase,int horas_semanales,String tipo) {
        int r = 0;
        boolean satisfac = true;
        try {
            Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select*from profesores");
             Profesor pp = new ProfesorTiempoParcial(horas_semanales, cedula, nombre, apellido, horas_clase, cedula, tipo);
             int  horas_complementarias = pp.horasComplementarias();
            //while (reg.next()) {
            String sqlInsert = String.format("INSERT INTO persona VALUES('%s','%s','%s','%d','%d','%s')",
                    cedula,
                    nombre,
                    apellido,
                    horas_clase,
                    horas_complementarias,
                    tipo,
                    this.getProfesor().size() + 1
            );//insertando un nueva fila en la tabla

            r = sentencia.executeUpdate(sqlInsert);

           
            
            //}
            reg.close();
            sentencia.close();
            

        } catch (SQLException e) {
            System.out.println("error al enviar consulta: " + e);
            satisfac=false;
        }
        if(satisfac==true){
            JOptionPane.showMessageDialog(null, "LOS DATOS HAN SIDO INGRESADOS SATISFACTORIAMENTE");
        }

        return r;
    }

    public static void main(String[] args) {
        Controlador_base con = new Controlador_base();
        int op = Integer.parseInt(JOptionPane.showInputDialog("Agregar Profesor :\n"
                + "Tiempo Parcial\n"
                + "Medio Tiempo\n"
                + "Tiempo Completo","Agregar Profesor"));
        boolean continuar=true;
        do{
        switch(op){
            case 1 :
                String cedula= JOptionPane.showInputDialog("ingrese cedula");
                String nombre=JOptionPane.showInputDialog("ingrese nombre");
                String apellido=JOptionPane.showInputDialog("ingrese apellido");
                int horas_clase=Integer.parseInt(JOptionPane.showInputDialog("ingrese horas de clase"));
                int horas_semanales=Integer.parseInt(JOptionPane.showInputDialog("ingrese horas semanales"));
                String carrera=JOptionPane.showInputDialog("ingrese carrera");
                 String tipo=JOptionPane.showInputDialog("ingrese tipo");
                con.agregarProfesorTparcial(cedula, nombre, apellido, horas_clase, horas_semanales, tipo);
                 for (Profesor p : con.getProfesor()) {
                  System.out.println(p);
                 }
                break;
            case 2 :
                cedula= JOptionPane.showInputDialog("ingrese cedula");
                nombre=JOptionPane.showInputDialog("ingrese nombre");
                apellido=JOptionPane.showInputDialog("ingrese apellido");
                horas_clase=Integer.parseInt(JOptionPane.showInputDialog("ingrese horas de clase"));
                
                 tipo=JOptionPane.showInputDialog("ingrese tipo de maestro");
                break;
            case 3:
                cedula= JOptionPane.showInputDialog("ingrese cedula");
                nombre=JOptionPane.showInputDialog("ingrese nombre");
                apellido=JOptionPane.showInputDialog("ingrese apellido");
                horas_clase=Integer.parseInt(JOptionPane.showInputDialog("ingrese horas de clase"));
                
                 tipo=JOptionPane.showInputDialog("ingrese cedula");
                break;
            default : continuar = false;
                JOptionPane.showMessageDialog(null, "Opcion invalida");
        }
        //con.agregarPersona();
        //for (persona p : con.getPersona()) {
          //  System.out.println(p);
        }while(continuar);
        System.out.println("------------------");
       for (Profesor p : con.getProfesorApellido("cueva")) {
           System.out.println(p);
        }
        }
        
}
    



