/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramonbl.adrec02;

import com.ramonbl.adrec02.Ej2.model.Continente;
import com.ramonbl.adrec02.Ej2.model.Informe;
import com.ramonbl.adrec02.Ej2.handler.RecordsHandler;
import com.ramonbl.adrec02.Ej2.model.Record;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ramonbl.adrec02.Ej2.model.Coronavirus;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author ramonbl
 */
public class Main {

  public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    JavaIOUtils javaIOUtils = new JavaIOUtils();

    long inicio = System.currentTimeMillis();
    //Creamos pausa para que aumente el tiempo de ejecución
    try {
      Thread.sleep(2000);
    } catch (InterruptedException ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }

    System.out.println("\n\n---------- EJERCICIO 1----------");
    Gson gson = new Gson();

    //Leer Fichero config.json (ya creado en la raíz del proyecto)
    String fichero = JavaIOUtils.leerJson("config.json");

    //Recuperar las propiedades del JSON
    Properties properties = gson.fromJson(fichero, Properties.class);

    //Mostrar las propiedades (comprobar que va bien)
    System.out.println("\nValores obtenidos del JSON:");
    System.out.println(properties.get("directorio_orixe"));
    System.out.println(properties.get("directorio_backup"));

    //Obtener las rutas de los directorios origen y backup
    String rutaDirectorioOrixe = properties.get("directorio_orixe").toString();
    String rutaDirectorioBackup = properties.get("directorio_backup").toString();

    System.out.println("\n\n---------- EJERCICIO 2----------");
    //Copiar los directorios
    int numFicheros = javaIOUtils.copiarDirectorio(rutaDirectorioOrixe, rutaDirectorioBackup);
    System.out.println("Número de archivos y directorios creados: " + numFicheros);

    long fin = System.currentTimeMillis();
    long tiempo = (long) ((fin - inicio) / 1000);

    System.out.println("\n\n---------- EJERCICIO 3----------");
    //Obtener la cadena JSON para informe.json
    Gson gsonInforme = new GsonBuilder().setPrettyPrinting().create();

    Informe informe = new Informe(numFicheros, tiempo);
    String jsonInforme = gsonInforme.toJson(informe);

//  JsonObject informe = new JsonObject();
//  informe.addProperty("numero_de_arquivos_copiados", numFicheros);
//  informe.addProperty("nombre", "Ramon");
//  String jsonInforme = informe.toString();
    //Escribimos el JSON en nuestro fichero
    //Crear el `informe.json`
    javaIOUtils.escribirFicheroJson(jsonInforme, "informe.json");

    System.out.println("\n\n---------- EJERCICIO OPCIONAL 1----------");
    //Parseador XML
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();

    RecordsHandler handler = new RecordsHandler();

    saxParser.parse("coronavirus.xml", handler);

    List<Record> list = handler.getRecords();

    //EJ02. Imprimir por pantalla: nº de casos por país el 5 de mayo
    System.out.println("Nº de casos por país el 5 de mayo");
    for (Record record : list) {
      if (record.getDay() == 5 && record.getMonth() == 5) {
        System.out.println("\nPaís: " + record.getCountriesAndTerritories());
        System.out.println("Número de casos: " + record.getCases());
      }
    }

    System.out.println("\n\n---------- EJERCICIO OPCIONAL 2----------");
    //nº de casos y fallecimientos el 5 de mayo agrupados cor continente
    //Crear 3 ArrayList para los distintos continentes, casos  y muertes.
    //misma posición en el array implica mismo ente

    List<String> continentesNoRepetidos = new ArrayList<>();
    List<Integer> casosContinente = new ArrayList<>();
    List<Integer> muertesContinente = new ArrayList<>();

    //INICIALIZACIÓN DE LAS LISTAS
    for (Record record : list) {
      if (!continentesNoRepetidos.contains(record.getContinentExp())) {
        continentesNoRepetidos.add(record.getContinentExp());
        casosContinente.add(0);
        muertesContinente.add(0);
      }
    }

//    System.out.println("\nArrayList con los continentes no repetidos"
//            + "e inicialización de arrays de casos y muertes");
//    for (int i = 0; i < continentesNoRepetidos.size(); i++) {
//      System.out.println(continentesNoRepetidos.get(i));
//      System.out.println(casosContinente.get(i));
//      System.out.println(muertesContinente.get(i));
//    }

    int posContinenteEnArrayList = 0;

    for (Record record : list) {
      if (record.getDay() == 5 && record.getMonth() == 5) {
        posContinenteEnArrayList = continentesNoRepetidos.indexOf(record.getContinentExp());
//        System.out.println("\n\nContinente: " + record.getContinentExp());
//
//        System.out.println("Posición continente en el arrayList: " + posContinenteEnArrayList);
//        System.out.println("Casos hasta ahora en continente: " + casosContinente.get(posContinenteEnArrayList));
//        System.out.println("Muertes hasta ahora en continente: " + muertesContinente.get(posContinenteEnArrayList));
//
//        System.out.println("\nValores del registro acutal");
//        System.out.println("Casos del registro actual: " + record.getCases());
//
//        System.out.println("Muertes del registro actual: " + record.getDeatchs());

        casosContinente.set(posContinenteEnArrayList, casosContinente.get(posContinenteEnArrayList) + record.getCases());
//        System.out.println("Casos continente ahora: " + casosContinente.get(posContinenteEnArrayList));

        muertesContinente.set(posContinenteEnArrayList, muertesContinente.get(posContinenteEnArrayList) + record.getDeatchs());
//        System.out.println("Muertes continente ahora: " + muertesContinente.get(posContinenteEnArrayList));

      }
    }

//    System.out.println("\nArrayList con los continentes no repetidos"
//            + "arrays finales de casos y muertes");
//    for (int i = 0; i < continentesNoRepetidos.size(); i++) {
//      System.out.println(continentesNoRepetidos.get(i));
//      System.out.println(casosContinente.get(i));
//      System.out.println(muertesContinente.get(i));
//    }
//
//    System.out.println(continentesNoRepetidos);
//    System.out.println(casosContinente);
//    System.out.println(muertesContinente);

    List<Continente> continentes = new ArrayList<Continente>();
    Continente continente = new Continente();
    for (int i = 0; i < continentesNoRepetidos.size(); i++) {
      continente = new Continente(continentesNoRepetidos.get(i), casosContinente.get(i), muertesContinente.get(i));
      continentes.add(continente);
    }

//    System.out.println(continentes);

//    Gson gsonContinentes = new GsonBuilder().setPrettyPrinting().create();
//    
//    String jsonContinentes = gsonContinentes.toJson(continentes);
//    System.out.println("\n\n" +jsonContinentes);
//    System.out.println("\n\n\nPRUEBAA");

    Coronavirus coronavirus = new Coronavirus(continentes);
    Gson gsonCoronavirus = new GsonBuilder().setPrettyPrinting().create();

    String jsonCoronavirus = gsonCoronavirus.toJson(coronavirus);
//    System.out.println("\n\n" + jsonCoronavirus);

    javaIOUtils.escribirFicheroJson(jsonCoronavirus, "coronavirus.json");

  }

}
