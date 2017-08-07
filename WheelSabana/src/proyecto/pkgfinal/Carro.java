/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkgfinal;




public class Carro {
    private String Modelo;
    private String Placas;
    private int NúmeroCupo;

    public Carro(String Modelo, String Placas, int NúmeroCupo) {
        this.Modelo = Modelo;
        this.Placas = Placas;
        this.NúmeroCupo = NúmeroCupo;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getPlacas() {
        return Placas;
    }

    public void setPlacas(String Placas) {
        this.Placas = Placas;
    }

    public int getNúmeroCupo() {
        return NúmeroCupo;
    }

    public void setNúmeroCupo(int NúmeroCupo) {
        this.NúmeroCupo = NúmeroCupo;
    }
   
 
 
 } 

