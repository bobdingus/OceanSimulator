package UserInterface;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JPanel;

import UserInterface.Images.ImageLoader;
/**
 * Simple panel that loads and paints the backround image onto the panel
 * @author Ian McNeilly
 *
 */
@SuppressWarnings("serial")
class BackroundPanel extends JPanel{
		
	private Image image;

		public Point size;
		public BackroundPanel(){
			image = ImageLoader.loadImage(this, "/UserInterface/Images/backgroundCover.png");
			size = new Point(image.getWidth(null), image.getHeight(null));
			//setSize(size.x,size.y);
			setPreferredSize(new Dimension(size.x,size.y));
			setLayout(new BorderLayout());
			setVisible(true);
		}
		@Override
		public void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			 g2d.drawImage(image, 0, 0,size.x,size.y, null);
		}
	}