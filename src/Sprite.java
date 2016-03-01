import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {
  
  // The x-y location of the sprite in pixels.
  // For our purposes, the region is 640 by 480.
   int x;
   int y;
   
   private String fileName;

  // The image of the sprite.
  private BufferedImage spriteImage;
  
  // The size of the sprite.
  public static int WIDTH;
  public static int HEIGHT;
  
  // The constructor for the Sprite class. This allows
  // the user to specify the location of a sprite.
  public Sprite(String spriteFileName, int x, int y) {
    try {
      spriteImage = ImageIO.read(new URL("file:" + spriteFileName));
      fileName = spriteFileName;
    } catch (IOException e) {
      System.out.println("Failed to load" + spriteFileName + "image.");
    }
    WIDTH = spriteImage.getWidth();
    HEIGHT = spriteImage.getHeight();
    set_location(x, y);
  }
  
  // Set the location of the sprite.
  public void set_location(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  // Get the x-axis location of the sprite.
  public int get_x() {
    return this.x;
  }
  
  // Get the y-axis location of the sprite.
  public int get_y() {
    return this.y;
  }
  
  // Draw the sprite at its location in the window.
  public void draw(Graphics2D g2) {
    g2.drawImage(spriteImage, null, x, y);
  }
  
  public String toString()
  {
	  return fileName;
  }
  
}