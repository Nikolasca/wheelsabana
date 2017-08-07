    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sql.newpackage.Conexion;




public class Trayecto {
    Usuario User;
    String Punto_Inicio;
    String Punto_Destino;
    int Cupos;
    String Hora;
    String Fecha;
    String Info_Adicional;
    Carro Carro;
    int Tarifa;

    public Trayecto(Usuario User, String Punto_Inicio, String Punto_Destino, int Cupos, String Hora, String Fecha, String Info_Adicional, Carro Carro, int Tarifa) {
        this.User = User;
        this.Punto_Inicio = Punto_Inicio;
        this.Punto_Destino = Punto_Destino;
        this.Cupos = Cupos;
        this.Fecha = Fecha;
        this.Hora = Hora;
        this.Info_Adicional = Info_Adicional;
        this.Carro = Carro;
        this.Tarifa = Tarifa;
    }

    public Trayecto() {
    }
    
public void AgregarTrayecto (Trayecto trayecto){
 Conexion con = new Conexion();
Connection cn =con.conectar();
try{
   PreparedStatement pre = cn.prepareStatement("INSERT INTO Trayectos (users_id,Nombre,Punto_Partida,Punto_Llegada,Info_adicional,Carro,Placa,Cupos,Hora,Telefono,Tarifa)" + "VALUES (?,?,?,?,?,?,?,?,?,?,?)");
          pre.setLong(1, (trayecto.getUser().getID()));
          pre.setString(2, trayecto.getUser().getNombre());
          pre.setString(3, trayecto.getPunto_Inicio());
          pre.setString(4, (trayecto.getPunto_Destino()));
          pre.setString(5, trayecto.getInfo_Adicional());
          pre.setString(6, trayecto.getCarro().getModelo());
          pre.setString(7, trayecto.getCarro().getPlacas());
          pre.setInt(8, trayecto.getCupos());
          pre.setString(9, trayecto.getHora());
          pre.setLong(10, trayecto.getUser().getTelefono());
          pre.setInt(11, trayecto.getTarifa());
          pre.executeUpdate();
}
catch(Exception e){ System.err.println(e);

}
  }
public void visualizar_tabla(JTable tabla, String A , String B, String C) {
        Conexion conn = new Conexion();
        Connection con = conn.conectar();
        ResultSet rs = conn.ObtenerTrayecto(A,B,C);
        
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("ID Conductor");
        dt.addColumn("Nombre");
        dt.addColumn("Desde");
        dt.addColumn("Hasta");
        dt.addColumn("Informacioón Adicional");
        dt.addColumn("Vehiculo");
        dt.addColumn("Placa");
        dt.addColumn("Cupos");
        dt.addColumn("Hora");
        dt.addColumn("Teléfono");
        dt.addColumn("Tarifa");
        dt.addColumn("ID Trayecto");
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        int[] Int = new int[2];
        String[] String = new String[20];
        try {
          while (rs.next()) {
              String[0] = rs.getString(1);
              String[1] = rs.getString(2);
              String[2] = rs.getString(3);
              String[3] = rs.getString(4);
              String[4] = rs.getString(5);
              String[5] = rs.getString(6);
              String[6] = rs.getString(7);
              String[7] = rs.getString(8);
              String[8] = rs.getString(9);
              String[9] = rs.getString(10);
              String[10] = rs.getString(11);
              String[11] = rs.getString(13);
       
              dt.addRow(String);
                                       
            }
           
        } catch (Exception e) { System.err.println(" Error al visualizar la tabla "+e);
       }
        
    }    
public void ActualizarTabla (String Columna, int ID_Trayecto,String Tabla, int Set){
    Conexion con = new Conexion();
    con.Update(Columna, ID_Trayecto, Tabla, Set);

}

    public Usuario getUser() {
        return User;
    }

    public void setUser(Usuario User) {
        this.User = User;
    }

    public String getPunto_Inicio() {
        return Punto_Inicio;
    }

    public void setPunto_Inicio(String Punto_Inicio) {
        this.Punto_Inicio = Punto_Inicio;
    }

    public String getPunto_Destino() {
        return Punto_Destino;
    }

    public void setPunto_Destino(String Punto_Destino) {
        this.Punto_Destino = Punto_Destino;
    }

    public int getCupos() {
        return Cupos;
    }

    public void setCupos(int Cupos) {
        this.Cupos = Cupos;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String Hora) {
        this.Hora = Hora;
    }

    public String getInfo_Adicional() {
        return Info_Adicional;
    }

    public void setInfo_Adicional(String Info_Adicional) {
        this.Info_Adicional = Info_Adicional;
    }

    public Carro getCarro() {
        return Carro;
    }

    public void setCarro(Carro Carro) {
        this.Carro = Carro;
    }

    public int getTarifa() {
        return Tarifa;
    }

    public void setTarifa(int Tarifa) {
        this.Tarifa = Tarifa;
    }
    
    
    
    
    
}
