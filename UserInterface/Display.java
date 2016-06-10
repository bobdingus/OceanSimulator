package UserInterface;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
/**
 * A simple set of static constants that contain information about the graphics of the device being used
 * 
 * @author Ian McNeilly
 *
 */

public class Display {
	public static GraphicsDevice GRAPHICS_DEVICE = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static final int MONITOR_WIDTH 	= GRAPHICS_DEVICE.getDisplayMode().getWidth();
	public static final int MONITOR_HEIGHT  = GRAPHICS_DEVICE.getDisplayMode().getHeight();
}
