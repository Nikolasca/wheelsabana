
package proyecto.pkgfinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import sql.newpackage.Conexion;

/**
 *
 * @author Nikolas
 */
public class Conductor extends Usuario {
    Carro carro;
    
    
   public Conductor (long id,String nombre, String apellido,String nick,String password,String tipo,long telefono){
   super(id,nombre,apellido,nick,password,tipo,telefono);
   this.carro = null;
   
   }
   Conductor(){}

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public  long getID() {
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

   

   public void AgregarUsuario (Usuario conductor){
  Conexion con = new Conexion();
Connection cn =con.conectar();
try{
   PreparedStatement pre = cn.prepareStatement("INSERT INTO Usuarios (id_users,Nombre,Apellido,Telefono,Nick,Contrasena,Direccion,Tipo)" + "VALUES (?,?,?,?,?,?,?,?)");
          pre.setFloat(1, (conductor.getID()));
          pre.setString(2, conductor.getNombre());
          pre.setString(3, conductor.getApellido());
          pre.setFloat(4, (conductor.getTelefono()));
          pre.setString(5, conductor.getNick());
          pre.setString(6, conductor.getPassword());
          pre.setString(7, "NA");
          pre.setString(8, conductor.getTipo());
          pre.executeUpdate();
}
catch(Exception e){ System.err.println(e);

}
  }
}
