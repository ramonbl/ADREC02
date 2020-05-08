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
public class Continente {
  
  private String nombre_continente;
  private int casos;
  private int muertes;

  public Continente() {
  }

  
  public Continente(String continente, int casos, int muertes) {
    this.nombre_continente = continente;
    this.casos = casos;
    this.muertes = muertes;
  }

  public String getNombre_continente() {
    return nombre_continente;
  }

  public void setNombre_continente(String nombre_continente) {
    this.nombre_continente = nombre_continente;
  }

  public int getCasos() {
    return casos;
  }

  public void setCasos(int casos) {
    this.casos = casos;
  }

  public int getMuertes() {
    return muertes;
  }

  public void setMuertes(int muertes) {
    this.muertes = muertes;
  }

  @Override
  public String toString() {
    return "Continente{" + "continente=" + nombre_continente + ", casos=" + casos + ", muertes=" + muertes + '}';
  }
  
  
}
