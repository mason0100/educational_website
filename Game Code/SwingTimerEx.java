
import java.awt.EventQueue;
import javax.swing.JFrame;
public class SwingTimerEx extends JFrame{ 

  
  public SwingTimerEx() {
    
    initUI();
  }
  
  private void initUI() {
    
    add(new Board());
    
    setResizable(false);
    pack();
    
    setTitle("Board Game");
    setLocationRelativeTo(null);        
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void square() {
    
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        SwingTimerEx ex = new SwingTimerEx();
        ex.setVisible(true);
      }}
    );
  }
}

