/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramonbl.adrec02.Ej2.model;

//Información que se leerá del XML (valores)
public class Record {

  private String dateRep;
  private int day;
  private int month;
  private int year;
  private int cases;
  private int deatchs;
  private String countriesAndTerritories;
  private String geoId;
  private String countryterritoryCode;
  private String popData2018;
  private String continentExp;

  public Record() {
    this.dateRep = new String("");
    this.day = 0;
    this.month = 0;
    this.year = 0;
    this.cases = 0;
    this.deatchs = 0;
    this.countriesAndTerritories = new String("");
    this.geoId = new String("");
    this.countryterritoryCode = new String("");
    this.popData2018 = new String("");
    this.continentExp = new String("");
  }

  public Record(String dateRep, int day, int month, int year, int cases, int deatchs, String countriesAndTerritories, String geoId, String countryterritoryCode, String popData2018, String continentExp) {
    this.dateRep = dateRep;
    this.day = day;
    this.month = month;
    this.year = year;
    this.cases = cases;
    this.deatchs = deatchs;
    this.countriesAndTerritories = countriesAndTerritories;
    this.geoId = geoId;
    this.countryterritoryCode = countryterritoryCode;
    this.popData2018 = popData2018;
    this.continentExp = continentExp;
  }

  public String getDateRep() {
    return dateRep;
  }

  public void setDateRep(String dateRep) {
    this.dateRep = dateRep;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getCases() {
    return cases;
  }

  public void setCases(int cases) {
    this.cases = cases;
  }

  public int getDeatchs() {
    return deatchs;
  }

  public void setDeatchs(int deatchs) {
    this.deatchs = deatchs;
  }

  public String getCountriesAndTerritories() {
    return countriesAndTerritories;
  }

  public void setCountriesAndTerritories(String countriesAndTerritories) {
    this.countriesAndTerritories = countriesAndTerritories;
  }

  public String getGeoId() {
    return geoId;
  }

  public void setGeoId(String geoId) {
    this.geoId = geoId;
  }

  public String getCountryterritoryCode() {
    return countryterritoryCode;
  }

  public void setCountryterritoryCode(String countryterritoryCode) {
    this.countryterritoryCode = countryterritoryCode;
  }

  public String getPopData2018() {
    return popData2018;
  }

  public void setPopData2018(String popData2018) {
    this.popData2018 = popData2018;
  }

  public String getContinentExp() {
    return continentExp;
  }

  public void setContinentExp(String continentExp) {
    this.continentExp = continentExp;
  }

}
