
import java.awt.*;
import javax.swing.*;
public class SwingTimerEx extends JFrame{ 

  
  public SwingTimerEx() {
    
    initUI();
  }
  
  private void initUI() {
    Board b= new Board();
    add(b);
    setResizable(false);
    b.button.addActionListener(b);
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

