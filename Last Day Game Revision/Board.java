import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.Timer;


public class Board extends JPanel
  implements ActionListener {
  
  private final int B_WIDTH = 1200;
  private final int B_HEIGHT = 700;
  private final int INITIAL_X = 75;
  private final int INITIAL_Y = 575;
  private final int DELAY = 25;
  
  private Image piece;
  private Image board;
  private Timer timer;
  private int x, y;
  Random rand = new Random();
  int a = rand.nextInt(10)+1;
  int b = rand.nextInt(5)+1;
  int c = rand.nextInt(10)+1;
  int d = a*b*c;
  String prompt = a + " * " + b+"x = " + d + " \n Solve for x";
  String s = "";
  boolean endOfGame = false;
  int space=0;
  int targetSpace=rand.nextInt(6)+1;
 
  String answer="";
  String attempt="";
  boolean answered = false;
  
  Scanner input = new Scanner(System.in);
  JButton button = new JButton("Submit");
  JTextField t = new JTextField(16);
 
  int nextRoll = rand.nextInt(6)+1;
  int score=0;
  int coord[][]= {{75, 575}, {75, 475}, {75, 375}, {75, 275}, {75, 175}, {75, 75}, {175, 75}, {275, 75},{375, 75}, {475, 75}, {575, 75}, {675, 75}, {775,75}, {875, 75}, {975, 75}, {1075, 75}, {1075, 175}, {1075,275}, {1075,375}, {1075,475}, {1075,575},{975,575},{875,575},{775,575},{675,575},{575,575},{475,575},{375,575},{275,575},{175,575},{550,450}};
  public Board() {
    
    initBoard();
  }
  
  private void loadImage() {
    ImageIcon i = new ImageIcon("RevisedBoard.png");
    board = i.getImage();
    ImageIcon ii = new ImageIcon("RevisedPiece.png");
    piece = ii.getImage();
    
  }
  
  private void initBoard() {
    
    
    setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
    
    loadImage();
    
    
    
    x = INITIAL_X;
    y = INITIAL_Y;
    add(button);
   
    add(t);
     t.setBounds(390,425,50,100);
    timer = new Timer(DELAY, this);
    timer.start();
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawBoard(g);
    drawPiece(g);
    drawText(g);
  }
  private void drawBoard(Graphics g) {
    
    g.drawImage(board, 0, 0, this);
    Toolkit.getDefaultToolkit().sync();
  }
  private void drawPiece(Graphics g) {
    
    g.drawImage(piece, x, y, this);
    Toolkit.getDefaultToolkit().sync();
  }
  private void drawText(Graphics g) {
    
    Graphics2D g2 = (Graphics2D)g;
    String scoreString = " " + score + " ";
    String roll = " " + nextRoll + " ";
    g2.drawString(scoreString,285,230);
    g2.drawString(roll,890,230);
    g2.drawString(prompt,390,200);
    Toolkit.getDefaultToolkit().sync();
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    answer= "" +c+ "";
    
    
    
    
 
    if(answered==false && endOfGame==false){
      s = e.getActionCommand();
      if(s.equals("Submit")){
        attempt=""+t.getText()+"";
        t.setText("");
      }
      
     
      
      if(attempt.equals(answer)){
        answered=true;
        score+=5;
      }
      else
        score-=1;
    }
    if(answered==true && endOfGame==false){
       answered = false;
       
        targetSpace=nextRoll;
        space+=targetSpace;
        
        a = rand.nextInt(10)+1;
        b = rand.nextInt(5)+1;
        c = rand.nextInt(10)+1;
        d = a*b*c;
        prompt = a + " * " + b+"x = " + d + " \n Solve for x";
        if(space>30){
          space=30;
          prompt = "End of Game";
          endOfGame=true;
        }
      x= coord[space][0];
      y= coord[space][1];
      
     
       
      }
    
    
    nextRoll = rand.nextInt(6)+1;
    
    repaint();
  }
  public static boolean isInteger(String s) {
    try { 
      Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
      return false; 
    } catch(NullPointerException e) {
      return false;
    }
    
    return true;
  }

}
