import java.util.Random;

public class InheritanceDriver {
  
  // The main driver method.
  public static void main(String args[]) {
    
    OurArea area = new OurArea(3);
    
    // Use our area, and show the window.
    Window window = new Window("Inheritance Lecture");
    window.add(area);
    window.setVisible(true);
  }
  
}
