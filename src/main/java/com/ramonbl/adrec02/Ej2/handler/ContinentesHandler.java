/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramonbl.adrec02.Ej2.handler;

import com.ramonbl.adrec02.Ej2.model.Continente;
import com.ramonbl.adrec02.Ej2.model.ContinentesElement;
import com.ramonbl.adrec02.Ej2.model.Record;
import com.ramonbl.adrec02.Ej2.model.RecordsElement;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author ramonbl
 */
public class ContinentesHandler extends DefaultHandler {

  private boolean nombre_continente;
  private boolean casos;
  private boolean muertes;

  private Continente currentContinente = new Continente();

  private List<Continente> continentes = new ArrayList<>();

  public List<Continente> getContinentes() {
    return continentes;
  }

  //Llamado al inicio de un elemento
  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equals(ContinentesElement.CONTINENTE.getName())) {
      nombre_continente = true;
    }
    if (qName.equals(ContinentesElement.CASOS.getName())) {
      casos = true;
    }
    if (qName.equals(ContinentesElement.MUERTES.getName())) {
      muertes = true;
    }

  }//Fin startElement()
  
  
   //Llamado cuando se encuentre información dentro de un elemento
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    if (nombre_continente) {
      currentContinente.setNombre_continente(new String(ch, start, length));
      nombre_continente = false;
    }

    if (casos) {
      currentContinente.setCasos(Integer.parseInt(new String(ch, start, length)));
      casos = false;
    }

    if (muertes) {
      currentContinente.setMuertes(Integer.parseInt(new String(ch, start, length)));
      muertes = false;
    }
  }// FIN characters
  
  
    //Llamado al final de un elemento
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equals(ContinentesElement.CONTINENTE.getName())) {
      continentes.add(currentContinente);
      currentContinente = new Continente();
    }
  } //FIN endElement
  
}
