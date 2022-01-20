/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conocer.marte;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author
 */
public class Movimiento {

// Variables globales
    int iPosX = 0;
    int iPosY = 0;
    String sCadMov = "";
    String sOrientacion = "";
    String sLastDireccion = "";

    public static void main(String... args) {
        Movimiento mov = new Movimiento();
        mov.init(1, 2, "N", "LMLMLMM");
        mov.moviVehiculo();
        mov.init(3, 3, "E", "MMRMMRMRM");
        mov.moviVehiculo();
    }
// Cargamos la posicion inicialMMRMMRMRM

    public boolean init(int iX, int iY, String sOrientacion, String sCadMov) {
        this.iPosX = iX;
        this.iPosY = iY;
        this.sOrientacion = sOrientacion;
        this.sCadMov = sCadMov;
        return true;
    }

    //  programar el moviento
    public Map moviVehiculo() {
        Map result = new HashMap();
        int indice = 0;
        String sChar = "";

        String sCopy = this.sCadMov;
        while (sCopy.length() > 1) {
            sChar = sCopy.substring(0, 1);
            sCopy = sCopy.substring(1, sCopy.length());
            switch (sChar) {
                case "M":
                    switch (this.sOrientacion) {
                        case "N":
                            this.iPosY = this.iPosY + 1;
                            break;
                        case "S":

                            this.iPosY = this.iPosY - 1;
                            break;
                        case "O":
                            this.iPosX = this.iPosX - 1;
                            break;
                        case "E":
                            this.iPosX = this.iPosX +1;
                            break;

                    }
                    break;
                case "R":
                    verificaOrientacion(sChar);
                    break;
                case "L":
                    verificaOrientacion(sChar);
                    break;
            }
            ++indice;
        }
        System.out.println("" + this.iPosX + " " + this.iPosY + " " + this.sOrientacion);
        result.put("result", "" + this.iPosX + " " + this.iPosY + " " +this.sOrientacion);
        return result;
    }





    public void verificaOrientacion(String movi) {
        switch (this.sOrientacion) {
            case "N":
                if (movi.equals("R")) {
                    this.sOrientacion = "E";
                } else {
                    this.sOrientacion = "O";
                }
                break;
            case "S":
                if (movi.equals("R")) {
                    this.sOrientacion = "O";
                } else {
                    this.sOrientacion = "E";
                }
                break;
            case "O":
                if (movi.equals("R")) {
                    this.sOrientacion = "N";
                } else {
                    this.sOrientacion = "S";
                }
                break;
            case "E":
                if (movi.equals("R")) {
                    this.sOrientacion = "S";
                } else {
                    this.sOrientacion = "N";
                }
                break;

        }

    }
}
