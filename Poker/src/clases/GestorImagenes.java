/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jdesktop.application.ResourceManager;

/**
 *
 * @author USUARIO
 */
public abstract class GestorImagenes {

   private static final String IMAGE_PATH_FORMAT = "images/card%s.jpg";

    /**
     * Returns the image of a specific card.
     *
     * @param card
     *            The card.
     *
     * @return The image.
     */
    public static ImageIcon getCardImage(Card card) {
        // Use image order, which is different from value order.
        Rank r = card.getRank();
        PRank j = new PRank();
        String num = j.rankToStringNumber(r);

        Suit s = card.getSuit();
        PSuit ps = new PSuit();
        String palo = ps.suitToStringNumber(s);





        
        String sequenceNr = num.concat(palo);//card.getSuit() * Card.NO_OF_RANKS + card.getRank();
        
        
        String path = String.format(IMAGE_PATH_FORMAT, sequenceNr);
        System.out.println("El path es :"+path);
        return getIcon(path);
    }

    /**
     * Returns an image resource.
     *
     * @param path
     *            The path on the classpath.
     *
     * @return The image resource.
     *
     * @throws RuntimeException
     *             If the resource could not be found.
     */
    public static ImageIcon getIcon(String path) {
        URL url = null;
        try {
            url = new URL("file:" + path);
        } catch (MalformedURLException ex) {
            Logger.getLogger(GestorImagenes.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (url != null) {
            return new ImageIcon(url);
        } else {
            throw new RuntimeException("Imagen no encontrada: " + path);
        }
    }

}