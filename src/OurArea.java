public class OurArea extends Area {
  
  /*
  // The trees that are scattered around the area.
  Tree trees[];
  
  // The area tile map, with each tile represented as an integer.
  int tiles[][];
  
  // The tile values for grass (0) and stone (1) tiles.
  int grass;
  int stone;
  
  // The number of tiles on the x-axis, and y-axis.
  int numTilesX;
  int numTilesY;
  
  // The maximum position of a tree on the x-axis and y-axis.
  // Note: The minimum is simply (0, 0).
  double maxTreeX;
  double maxTreeY;
  */
  
  // The constructor for OurArea. It takes in a parameter for the
  // number of trees to place in the area.
  public OurArea(int numberOfTrees) {
    super(); // A magic function. I wonder what it does? 
    
    //* Exercise #1. Setup the tree objects at random locations.
    trees = new Tree[numberOfTrees];
    for (int i = 0; i < numberOfTrees; i++) {
      trees[i] = new Tree((int)(Math.random() * maxTreeX),
                          (int)(Math.random() * maxTreeY));
    }
    //*/
    
    //* Exercise #3. Initialize the tiles.
    tiles = new int[numTilesX][numTilesY]; //default value is grass because grass equals 0
    // Example: Draw specific at specific locations.
    tiles[0][0] = stone;
    tiles[2][3] = stone;
    tiles[5][5] = fire;
    tiles[8][3] = fire;
    tiles[2][2] = fire;
    tiles[0][9] = sand;
    tiles[1][9] = sand;
    tiles[2][9] = sand;
    tiles[0][8] = sand;
    tiles[1][8] = sand;
    tiles[2][8] = sand;
    //*/
  }
  
  // This function must draw each tree to the screen.
  protected void drawTrees() {
    //* Exercise #2. Draw the trees.
    for (int i = 0; i < trees.length; i++) {
      drawTree(i);
    }
    //*/
  }
  
  protected void drawTiles() {
    //* Exercise #4. Draw the tiles.
    for (int i = 0; i < numTilesX; i++) {
      for (int j = 0; j < numTilesY; j++) {

        if (tiles[i][j] == grass) {
        	Grass g = new Grass();
        	drawTile(g, i, j);
        } 
        else if (tiles[i][j] == stone) {
         	Stone s = new Stone();
        	drawTile(s, i, j);
        }
        else if (tiles[i][j] == fire) {
        	Fire f = new Fire();
         	drawTile(f, i, j);
        }
        else if (tiles[i][j] == sand) {
        	Sand sa = new Sand();
         	drawTile(sa, i, j);
        }
      }
    }
    //*/
  }
  
}
