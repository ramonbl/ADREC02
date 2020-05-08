/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramonbl.adrec02.Ej2.handler;

import com.ramonbl.adrec02.Ej2.model.RecordsElement;
import com.ramonbl.adrec02.Ej2.model.Record;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//Crear handler para permitir el posterió procesado XML.
//Implementa la lógica para leer los elementos del xml, crear POJOs con la información y agregarlos a una lista con la información
public class RecordsHandler extends DefaultHandler {

  private boolean dateRep;
  private boolean day;
  private boolean month;
  private boolean year;
  private boolean cases;
  private boolean deaths;
  private boolean countriesAndTerritoires;
  private boolean geoId;
  private boolean countryterritoryCode;
  private boolean popData2018;
  private boolean continentExp;

  private Record currentRecord = new Record();
  private List<Record> records = new ArrayList<>();

  public List<Record> getRecords() {
    return records;
  }

  //Llamado al inicio de un elemento
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equals(RecordsElement.DATE_REP.getName())) {
      dateRep = true;
    }
    if (qName.equals(RecordsElement.DAY.getName())) {
      day = true;
    }
    if (qName.equals(RecordsElement.MONTH.getName())) {
      month = true;
    }
    if (qName.equals(RecordsElement.YEAR.getName())) {
      year = true;
    }
    if (qName.equals(RecordsElement.CASES.getName())) {
      cases = true;
    }
    if (qName.equals(RecordsElement.DEATHS.getName())) {
      deaths = true;
    }
    if (qName.equals(RecordsElement.COUNTRIES_AND_TERRITORIES.getName())) {
      countriesAndTerritoires = true;
    }
    if (qName.equals(RecordsElement.GEOID.getName())) {
      geoId = true;
    }
    if (qName.equals(RecordsElement.COUNTRYTERRYTORY_CODE.getName())) {
      countryterritoryCode = true;
    }
    if (qName.equals(RecordsElement.POP_DATA2018.getName())) {
      popData2018 = true;
    }
    if (qName.equals(RecordsElement.CONTINENT_EXP.getName())) {
      continentExp = true;
    }
  }

  //Llamado cuando se encuentre información dentro de un elemento
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    if (dateRep) {
      currentRecord.setDateRep(new String(ch, start, length));
      dateRep = false;
    }

    if (day) {
      currentRecord.setDay(Integer.parseInt(new String(ch, start, length)));
      day = false;
    }

    if (month) {
      currentRecord.setMonth(Integer.parseInt(new String(ch, start, length)));
      month = false;
    }

    if (year) {
      currentRecord.setYear(Integer.parseInt(new String(ch, start, length)));
      year = false;
    }

    if (cases) {
      currentRecord.setCases(Integer.parseInt(new String(ch, start, length)));
      cases = false;
    }

    if (deaths) {
      currentRecord.setDeatchs(Integer.parseInt(new String(ch, start, length)));
      deaths = false;
    }

    if (countriesAndTerritoires) {
      currentRecord.setCountriesAndTerritories(new String(ch, start, length));
      countriesAndTerritoires = false;
    }

    if (geoId) {
      currentRecord.setGeoId(new String(ch, start, length));
      geoId = false;
    }

    if (countryterritoryCode) {
      currentRecord.setCountryterritoryCode(new String(ch, start, length));
      countryterritoryCode = false;
    }

    if (popData2018) {
      currentRecord.setPopData2018(new String(ch, start, length));
      popData2018 = false;
    }

    if (continentExp) {
      currentRecord.setContinentExp(new String(ch, start, length));
      continentExp = false;
    }
  }

  //Llamado al final de un elemento
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equals(RecordsElement.RECORD.getName())) {
      records.add(currentRecord);
      currentRecord = new Record();
    }
  }

}
