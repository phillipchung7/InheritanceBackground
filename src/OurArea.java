import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class OurArea extends Area implements ActionListener, KeyListener {
  
	private Timer oceanClock = new Timer(20,this);
	private int numberOfSprites = 3;
	private Ocean oceanAnimationFrames[];
	private int frameNumber = 0;
	
  public OurArea() {
    super();
    oceanClock.start();
    addKeyListener(this);
    setFocusable(true);
    
    sprites = new Sprite[numberOfSprites];
    sprites[0] = new BoatSprite(128, 400);
    sprites[1] = new SharkSprite(200, 400);

	oceanAnimationFrames = new Ocean[11];
	for (int i=0; i < 11; i++ ) {
			oceanAnimationFrames[i] = new Ocean("OceanAnimation/OceanGif-" + (i+1) + ".png");
	}
	
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
        	t = oceanAnimationFrames[frameNumber];
        }
        drawTile(t, i, j);
      }
    }
  }

  public void actionPerformed(ActionEvent e){
      if (e.getSource() == oceanClock){
    	  frameNumber++;
    	  if (frameNumber == 11) {
    		  frameNumber = 0;
    	  }
    	  repaint();
      }
  }

@Override
public void keyTyped(KeyEvent key)
{
	switch(key.getKeyCode()) {
    	case KeyEvent.VK_UP:
    		System.out.println("Up tapped");
    		break;
    		
    	case KeyEvent.VK_DOWN:
    		System.out.println("Down tapped");
    		break;
    		
    	case KeyEvent.VK_LEFT:
    		System.out.println("Left tapped");
    		break;
    		
    	case KeyEvent.VK_RIGHT:
    		System.out.println("Right tapped");
    		break;
	}
}

@Override
public void keyPressed(KeyEvent key)
{
	switch(key.getKeyCode()) {
    	case KeyEvent.VK_UP:
    		System.out.println("Up pressed");
    		break;
    		
    	case KeyEvent.VK_DOWN:
    		System.out.println("Down pressed");
    		break;
    		
    	case KeyEvent.VK_LEFT:
    		System.out.println("Left pressed");
    		break;
    		
    	case KeyEvent.VK_RIGHT:
    		System.out.println("Right pressed");
    		break;
    }
}

@Override
public void keyReleased(KeyEvent key)
{
	switch(key.getKeyCode()) {
    	case KeyEvent.VK_UP:
    		System.out.println("Up released");
    		break;
    		
    	case KeyEvent.VK_DOWN:
    		System.out.println("Down released");
    		break;
    		
    	case KeyEvent.VK_LEFT:
    		System.out.println("Left released");
    		break;
    		
    	case KeyEvent.VK_RIGHT:
    		System.out.println("Right released");
    		break;
    }	
}
  
}
  
