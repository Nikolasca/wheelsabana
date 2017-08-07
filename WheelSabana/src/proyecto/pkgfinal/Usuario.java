/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sql.newpackage.Conexion;

/**
 *
 * @author Nikolas
 */
public abstract class Usuario {

    long ID;
    String Nombre;
    String Apellido;
    String Nick;
    String Password;
    String Tipo;
    long Telefono;

    Usuario(long id, String nombre, String apellido, String nick, String password, String tipo, long telefono) {
        this.ID = id;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Nick = nick;
        this.Password = password;
        this.Tipo = tipo;
        this.Telefono = telefono;

    }

    Usuario() {
    }

    public Usuario Verficar(long ID, String Pass) {
        Usuario user = new Conductor();
        try {
            Conexion con = new Conexion();
            Connection cn = con.conectar();

            ResultSet rs = con.ObtenerTodo("id_users", ID);
            String[] pass = new String[7];
            long[] id = new long[2];
            while (rs.next()) {
                id[0] = rs.getLong(1);//ID
                pass[0] = rs.getString(2); //Contraseña
                pass[1] = rs.getString(3);//Nombre
                pass[2] = rs.getString(4);//nick
                pass[3] = rs.getString(5);//Apellido
                pass[4] = rs.getString(7);//Tipo
                id[1] = rs.getLong(6);//Telefono

            }
            if (ID == id[0] || Pass.contentEquals(pass[0])) {
                System.out.println("Existe el usuario");
                if (pass[4].contentEquals("Conductor")) {
                    user.setID(id[0]);
                    user.setNombre(pass[1]);
                    user.setPassword(pass[0]);
                    user.setApellido(pass[3]);
                    user.setNick(pass[2]);
                    user.setTelefono(id[1]);
                    user.setPassword(pass[0]);
                    user.setTipo(pass[4]);

                } else {
                    user.setID(id[0]);
                    user.setNombre(pass[1]);
                    user.setPassword(pass[0]);
                    user.setApellido(pass[3]);
                    user.setNick(pass[2]);
                    user.setTelefono(id[1]);
                    user.setPassword(pass[0]);
                    user.setTipo(pass[4]);
                }

            } else {
                System.out.print("No se encontraron");
            }
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "Verifique ID y/o Contraseña");
           

        }
        return user;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID=" + ID + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Nick=" + Nick + ", Password=" + Password + ", Tipo=" + Tipo + ", Telefono=" + Telefono + '}';
    }

}
