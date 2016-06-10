package UserInterface.Images;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Handles the loading of buffered images. 
 * Prints out an error to the console if there is an error loading images.
 * 
 * @author Ian McNeilly					
 */
public class ImageLoader {
	
	public static BufferedImage loadImage(Object caller,String resourceLocation){
		BufferedImage image = null;
		try {                
			image = ImageIO.read(caller.getClass().getResource(resourceLocation));
	    } 
		catch (IOException ex) {
	            System.out.println("READ OF " + resourceLocation + " FAILED" );
		}
		return image;
	}
}

