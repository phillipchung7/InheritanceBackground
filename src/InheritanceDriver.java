public class InheritanceDriver {
  
  // The main driver method.
  public static void main(String args[]) {
    
    OurArea area = new OurArea();
    
    // Use our area, and show the window.
    Window window = new Window("Phillip's Game");
    window.add(area);
    window.setVisible(true);
  }
  
}
