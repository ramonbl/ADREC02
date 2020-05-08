/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramonbl.adrec02.Ej2.model;

import java.util.List;


public class Coronavirus {
  //private String name;
  private List<Continente> continentes;

  public Coronavirus() {
  }

  public Coronavirus(List<Continente> continentes) {
   // this.name = name;
    this.continentes = continentes;
  }


  public List<Continente> getContinentes() {
    return continentes;
  }

  public void setContinentes(List<Continente> continentes) {
    this.continentes = continentes;
  }
  
  
}
