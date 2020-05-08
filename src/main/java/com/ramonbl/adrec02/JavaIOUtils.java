/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramonbl.adrec02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 *
 * @author ramonbl
 */
public class JavaIOUtils {

  private void comprobarCrearDirectorio(String ruta) {
    File directorio = new File(ruta);
    if (!directorio.exists()) {
      directorio.mkdirs();
    }
  } //Fin comprobarCrearDirectorio

  int archivosCopiados =0;
  private void copiarArchivo(String sOrigen, String sDestino) {
    archivosCopiados++;
    try {
      File origen = new File(sOrigen);
      File destino = new File(sDestino);
      InputStream in = new FileInputStream(origen);
      OutputStream out = new FileOutputStream(destino);

      byte[] buf = new byte[1024];
      int len;

      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }

      in.close();
      out.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  } //copiarArchivo()

  public int copiarDirectorio(String origen, String destino) {
    comprobarCrearDirectorio(destino);
    int numFicheros = 0;
    File directorio = new File(origen);
    File f;
    if (directorio.isDirectory()) {
      comprobarCrearDirectorio(destino);

      String[] files = directorio.list();
      if (files.length > 0) {
        for (String archivo : files) {
          f = new File(origen + File.separator + archivo);
          if (f.isDirectory()) {
            comprobarCrearDirectorio(destino + File.separator + archivo + File.separator);
            archivosCopiados++;
            copiarDirectorio(origen + File.separator + archivo + File.separator, destino + File.separator + archivo + File.separator);

          } else { //Es un archivo
            copiarArchivo(origen + File.separator + archivo, destino + File.separator + archivo + ".backup");
          }

        }
      }
    }
    return archivosCopiados;
  } //Fin copiarDirectorio

  public static String leerJson(String archivo) {
    String fichero = "";
    //Lectura del archivo JSON
    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
      String linea;
      while ((linea = br.readLine()) != null) {
        fichero += linea;
      }

    } catch (FileNotFoundException ex) {
      System.out.println(ex.getMessage());
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
    return fichero;
  }
  
    public static void escribirFicheroJson(String json, String destino) {
    FileWriter fwInforme = null;
    PrintWriter pwInforme = null;
    try {
      fwInforme = new FileWriter(destino);
      pwInforme = new PrintWriter(fwInforme);

      pwInforme.println(json);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (null != fwInforme) {
          fwInforme.close();
        }
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
  }//FIN escribirFicheroJson

} //FIN class JavaIOUtils


