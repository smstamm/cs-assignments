import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MemoryCountingGame
{
   public JFrame main = new JFrame ();
   public JLabel lblInstructions;
   public JTextField txtInput;
   public int num = 1;
   public String[] colors = {"red", "green", "blue", "brown", "yellow"};
   
   // constructor
   public MemoryCountingGame ()
   {
      main.setSize(400,200);
      main.setTitle("Memory Counting Game");
      main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
      main.setLayout(new FlowLayout());
      
      createContents ();
      
      main.setVisible (true);
   }
   
   public void createContents ()
   {
      lblInstructions = new JLabel ();
      txtInput = new JTextField (15);
      
      // Create contents
      lblInstructions.setText("Enter color number " + num + ":");
      
      
      // Add contents
      main.add(lblInstructions);
      main.add(txtInput);
      
      // Add action listener to text input
      txtInput.addActionListener(new GameListener ());
   }
   
   public class GameListener implements ActionListener
   {
      public void actionPerformed (ActionEvent e)
      {
         String guess = "";
         guess = txtInput.getText();

         if (colors[num-1].equalsIgnoreCase(guess))
         {
            System.out.println("nice!");
            txtInput.setText("");
            lblInstructions.setText("Enter color number " + ++num + ":");
         }
         else
         {
            lblInstructions.setText("You lose :(");
            txtInput.setVisible(false);
         }
         
         if (num == 6)
         {
            lblInstructions.setText("You win!");
            txtInput.setVisible(false);
         }
      }
   }
}