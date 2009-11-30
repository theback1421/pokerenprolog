/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;

/**
 *
 * @author Ramon
 */
public class Puntuacion {
  public final String nombreJugador;
  public final int puntuacion;

  public Puntuacion(String nombreJugador, int puntuacion) {
    this.nombreJugador = nombreJugador;
    this.puntuacion = puntuacion;
  }
  public String getNombreJugador()
  {
      return nombreJugador;
  }
  public int getPuntuacion()
  {
      return puntuacion;
  }
}
