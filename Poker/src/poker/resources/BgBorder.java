/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package poker.resources;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

/**
 *
 * @author USUARIO
 */
public class BgBorder implements Border{

   private BufferedImage imagen=null;


    public BgBorder(BufferedImage Mimagen){
        imagen=Mimagen;


    }

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {


        if(imagen!=null){
            g.drawImage(imagen, 0,0,width,height,null);



        }
    }

    public Insets getBorderInsets(Component c) {
        return new Insets(0,0,0,0);
    }

    public boolean isBorderOpaque() {
        return true;
    }

}
