/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramonbl.adrec02.Ej2.model;

//Enumeración con el nombre de los elementos XML (etiquetas) que nos interesa procesar
public enum RecordsElement {
  RECORD("record"),
  DATE_REP("dateRep"),
  DAY("day"), 
  MONTH("month"), 
  YEAR("year"), 
  CASES("cases"), 
  DEATHS("deaths"), 
  COUNTRIES_AND_TERRITORIES("countriesAndTerritories"), 
  GEOID("geoId"), 
  COUNTRYTERRYTORY_CODE("countryterritoryCode"), 
  POP_DATA2018("popData2018"), 
  CONTINENT_EXP("continentExp");
  
  private String name; //Nombre del elemento (DAY, MONTH,...)
  
  private RecordsElement(String name){
    this.name=name;
  }
  
  public String getName(){
    return name;
  }
}

