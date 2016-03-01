import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class OurArea extends Area implements ActionListener, KeyListener {
  
	private Timer oceanClock = new Timer(50,this);
	private Timer boatTimer = new Timer(20,this);
	private int numberOfSprites = 4;
	private Ocean oceanAnimationFrames[];
	private int frameNumber = 0;
	private boolean upKeyPressed = false;
	private boolean downKeyPressed = false;
	private boolean leftKeyPressed = false;
	private boolean rightKeyPressed = false;
	private int sharkVelocity1 = 6;
	private int sharkVelocity2 = 6;
	private int sharkVelocity3 = 6;

  public OurArea() {
    super();
    
    sprites = new Sprite[numberOfSprites];
    sprites[0] = new BoatSprite(20, 20);
    sprites[1] = new SharkSprite(200, 375);
    sprites[2] = new SharkSprite(150, 300);
    sprites[3] = new SharkSprite(400, 300);
    
    oceanClock.start();
    boatTimer.start();
    addKeyListener(this);
    setFocusable(true);

	oceanAnimationFrames = new Ocean[11];
	for (int i=0; i < 11; i++ ) {
		oceanAnimationFrames[i] = new Ocean("OceanAnimation/OceanGif-" + (i+1) + ".png");
	}
	
    tiles = new int[numTilesX][numTilesY]; //default value is ocean because ocean equals 0
    tiles[9][9] = grass;
    tiles[8][9] = grass;
    tiles[9][8] = grass;
    tiles[7][9] = grass;
    tiles[9][7] = grass;
    tiles[9][6] = grass;
    tiles[6][9] = grass;
    tiles[8][8] = sand;
    tiles[7][8] = sand;
    tiles[8][7] = sand;
 }
  
  // This function must draw each sprite to the screen.
  protected void drawSprites() {     //Draw the sprite.
    for (int i = 0; i < numberOfSprites; i++) {
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
      if (e.getSource() == boatTimer){
    	  if (upKeyPressed == true && sprites[0].get_y() > -5) { 						//The and statements set the boundaries for the boat.
        	  sprites[0] = new BoatSprite(sprites[0].get_x(), sprites[0].get_y()-3);
    	  }
    	  if (downKeyPressed == true && sprites[0].get_y() < 560) {
        	  sprites[0] = new BoatSprite(sprites[0].get_x(), sprites[0].get_y()+3);
    	  }
    	  if (leftKeyPressed == true && sprites[0].get_x() > -1) {
        	  sprites[0] = new BoatSprite(sprites[0].get_x()-3, sprites[0].get_y());
    	  }
    	  if (rightKeyPressed == true && sprites[0].get_x() < 575) {
        	  sprites[0] = new BoatSprite(sprites[0].get_x()+3, sprites[0].get_y());
    	  }
    	  if((sprites[1].get_x() > 500) || (sprites[1].get_x() < 0)) {
    		  sharkVelocity1 = -sharkVelocity1;
    	  }
    	  if((sprites[2].get_y() > 500) || (sprites[2].get_y() < 0)) {
    		  sharkVelocity2 = -sharkVelocity2;
    	  }
    	  if((sprites[3].get_y() > 400) || (sprites[3].get_y() < 0)) {
    		  sharkVelocity3 = -sharkVelocity3;
    	  }
       sprites[1] = new SharkSprite(sprites[1].get_x() + sharkVelocity1, sprites[1].get_y());
       sprites[2] = new SharkSprite(sprites[2].get_x(), sprites[2].get_y()+ sharkVelocity2);
       sprites[3] = new SharkSprite(sprites[3].get_x(), sprites[3].get_y()+ sharkVelocity3);
       repaint();
      }
  }

@Override
public void keyTyped(KeyEvent key)
{
    // TODO: Implement in a child class.
}

@Override
public void keyPressed(KeyEvent key)
{
	switch(key.getKeyCode()) {
    	case KeyEvent.VK_UP:
    		upKeyPressed = true;
    		break;
    		
    	case KeyEvent.VK_DOWN:
    		downKeyPressed = true;
    		break;
    		
    	case KeyEvent.VK_LEFT:
    		leftKeyPressed = true;
    		break;
    		
    	case KeyEvent.VK_RIGHT:
    		rightKeyPressed = true;
    		break;
    }
}

@Override
public void keyReleased(KeyEvent key)
{
	switch(key.getKeyCode()) {
    	case KeyEvent.VK_UP:
    		upKeyPressed = false;
    		break;
    		
    	case KeyEvent.VK_DOWN:
    		downKeyPressed = false;
    		break;
    		
    	case KeyEvent.VK_LEFT:
    		leftKeyPressed = false;
    		break;
    		
    	case KeyEvent.VK_RIGHT:
    		rightKeyPressed = false;
    		break;
    }	
}
  
}
  
