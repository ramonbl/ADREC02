/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramonbl.adrec02.Ej2.model;


public class Informe {
  private int numero_de_arquivos_copiados;
  private long tempo_utilizado_en_segundos;

  public Informe(int numero_de_arquivos_copiados, long tempo_utilizado_en_segundos) {
    this.numero_de_arquivos_copiados = numero_de_arquivos_copiados;
    this.tempo_utilizado_en_segundos = tempo_utilizado_en_segundos;
  }

  public int getNumero_de_arquivos_copiados() {
    return numero_de_arquivos_copiados;
  }

  public void setNumero_de_arquivos_copiados(int numero_de_arquivos_copiados) {
    this.numero_de_arquivos_copiados = numero_de_arquivos_copiados;
  }

  public long getTempo_utilizado_en_segundos() {
    return tempo_utilizado_en_segundos;
  }

  public void setTempo_utilizado_en_segundos(long tempo_utilizado_en_segundos) {
    this.tempo_utilizado_en_segundos = tempo_utilizado_en_segundos;
  }

  @Override
  public String toString() {
    return "Informe{" + "numero_de_arquivos_copiados=" + numero_de_arquivos_copiados + ", tempo_utilizado_en_segundos=" + tempo_utilizado_en_segundos + '}';
  }
  
  
  
}
