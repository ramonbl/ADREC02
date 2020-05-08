/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramonbl.adrec02.Ej2.model;

/**
 *
 * @author ramonbl
 */
public enum ContinentesElement {
  CONTINENTE("continente"),
  NOMBRE_CONTINENTE("nombre_continente"),
  CASOS("casos"),
  MUERTES("muertes");
  
  private String name;
  
  private ContinentesElement(String name){
    this.name = name;
  }
  
  public String getName(){
    return name;
  }
}
