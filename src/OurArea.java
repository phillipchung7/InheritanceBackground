import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class OurArea extends Area implements ActionListener {
  
	private Timer oceanClock = new Timer(100,this);
	int numberOfTrees = 3;
	
  public OurArea() {
    super(); 
    oceanClock.start();
    trees = new Tree[numberOfTrees];
    for (int i = 0; i < numberOfTrees; i++) {
      trees[i] = new Tree((int)(400), (int)(5));
      
    }
    tiles = new int[numTilesX][numTilesY]; //default value is grass because grass equals 0
    tiles[0][0] = stone;
    tiles[2][3] = stone;
    tiles[5][5] = fire;
    tiles[8][3] = fire;
    for (int i = 0; i < 4; i++) {
        for (int j = 3; j < numTilesY; j++) {
            tiles[i][j] = sand;
          }
    }
    for (int i = 0; i < 3; i++) {
        for (int j = 4; j < numTilesY; j++) {
            tiles[i][j] = ocean;
          }
    }
 }
  
  // This function must draw each tree to the screen.
  protected void drawTrees() {
    //* Exercise #2. Draw the trees.
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
  
