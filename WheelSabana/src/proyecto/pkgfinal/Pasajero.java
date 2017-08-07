
package proyecto.pkgfinal;

public class Pasajero extends Usuario {

Pasajero(int id, String nombre, String apellido, String nick, String password, String tipo, int telefono) {
        super(id, nombre, apellido, nick, password, tipo, telefono);
    }
public Pasajero(){

}

    @Override
    public Usuario Verficar(long ID, String Pass) {
        return super.Verficar(ID, Pass); 
    }

   
    

    
    
    
    public long getID() {
        return ID;
    }

    public void setID(int ID) {
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

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

}
