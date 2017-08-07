/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql.newpackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nikolas
 */
public class Conexion {
    public Connection conectar (){
    Connection con =null;
    String url = "jdbc:mysql://localhost:3306/bd_prueba1";
    try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection(url,"root","");
    System.out.print("Conexión establecida");
    
    }
    catch (ClassNotFoundException | SQLException e){
        System.err.println("Error");
    }
    return con;
    }
public ResultSet Update (String NombreCol, int ID,String Tabla,int Dato){
Connection con = conectar();
ResultSet rs = null;
PreparedStatement ps = null;
try{
 ps = con.prepareStatement("UPDATE " + Tabla + " SET " + NombreCol + " = " + Dato + " WHERE ID = "+ID+";");
   System.out.print(ps);
    ps.executeUpdate();


}
catch(Exception e){


}

return rs;

}
public ResultSet ObtenerTodo (String NombreCol1, long Col2){
Connection con = conectar();
ResultSet rs = null;
PreparedStatement ps = null;
try{
 ps = con.prepareStatement("select " + NombreCol1+",Contrasena,Nombre,Nick,Apellido,Telefono,Tipo"+ " from Usuarios"+" where id_users = "+ Col2+";");

rs = ps.executeQuery();

}
catch(Exception e){
    System.err.println("Error en método Obtener"+e);

}

return rs;

}
public ResultSet ObtenerTrayecto (String A , String B, String C){
Connection con = conectar();
ResultSet rs = null;
try{
PreparedStatement ps = con.prepareStatement("select * from Trayectos where `Punto_Partida` = "+"'"+ A+"'" +" AND "+ "`Punto_Llegada` = "+"'"+ B+"'"+ " ; ");

rs = ps.executeQuery();

}
catch(Exception e){
    System.err.println("Error en método Obtener"+e);

}

return rs;

}



}
