import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class OurArea extends Area implements ActionListener, KeyListener {
  
	private Timer oceanClock = new Timer(100,this);
	int numberOfSprites = 3;
	
  public OurArea() {
    super();
    oceanClock.start();
    addKeyListener(this); 
    
    sprites = new Sprite[numberOfSprites];
    sprites[0] = new TreeSprite(128, 200);
    sprites[1] = new TreeSprite(128, 300);
    sprites[2] = new BoatSprite(128, 400);
            
    tiles = new int[numTilesX][numTilesY]; //default value is grass because grass equals 0
    tiles[0][0] = stone;
    tiles[2][3] = stone;
    tiles[8][3] = fire;
    for (int i = 0; i < numTilesX; i++) {
        for (int j = 3; j < numTilesY; j++) {
            tiles[i][j] = sand;
          }
    }
    for (int i = 0; i < numTilesX; i++) {
        for (int j = 5; j < numTilesY; j++) {
            tiles[i][j] = ocean;
          }
    }
 }
  
  // This function must draw each sprite to the screen.
  protected void drawSprites() {     //Draw the sprite.
    for (int i = 0; i < 3; i++) {
    	drawSprite(i);
    }
  }
  
  private int GifCounter = 1;

  protected void drawTiles() {
    for (int i = 0; i < numTilesX; i++) {
      for (int j = 0; j < numTilesY; j++) {
    	Tile t = null;
        if (tiles[i][j] == grass) {
        	t = new Grass();
        } 
        else if (tiles[i][j] == stone) {
        	t = new Stone();      	
        }
        else if (tiles[i][j] == fire) {
        	t = new Fire();
        }
        else if (tiles[i][j] == sand) {
        	t = new Sand();
        }
        else if (tiles[i][j] == ocean) {
        	t = new Ocean("OceanAnimation/OceanGif-" + GifCounter + ".png");
        }
        drawTile(t, i, j);
      }
    }
  }

  public void actionPerformed(ActionEvent e){
      if (e.getSource() == oceanClock){
    	  GifCounter++;
    	  if (GifCounter == 12) {
    		  GifCounter = 1;
    	  }
    	  repaint();
      }
  }

@Override
public void keyTyped(KeyEvent key)
{
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent key)
{
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent key)
{
	// TODO Auto-generated method stub
	
}
  
}
  
