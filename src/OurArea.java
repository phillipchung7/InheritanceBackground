import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class OurArea extends Area implements ActionListener {
  
	private Timer oceanClock = new Timer(100,this);
	private int numberOfTrees = 2;
	
  public OurArea() {
    super();
    oceanClock.start();
    
    boats = new BoatSprite[1];
    boats[0] = new BoatSprite(500, 200);
    
    trees = new TreeSprite[numberOfTrees];
    trees[0] = new TreeSprite(128, 200);
    trees[1] = new TreeSprite(128, 300);
    
            
    tiles = new int[numTilesX][numTilesY]; //default value is ocean because ocean equals 0
    tiles[0][0] = stone;
    tiles[2][1] = stone;
    tiles[8][3] = fire;
    for (int i = 0; i < numTilesX; i++) {
        for (int j = 3; j < 4; j++) {
            tiles[i][j] = sand;
          }
    }
 }
  
  // This function must draw each sprite to the screen.
  protected void drawBoats() {     //Draw the sprite.
    for (int i = 0; i < boats.length; i++) {
    	drawBoat(i);
    }
  }
  protected void drawTrees() {     //Draw the sprite.
	    for (int i = 0; i < trees.length; i++) {
	    	drawTree(i);
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
  
}
  
