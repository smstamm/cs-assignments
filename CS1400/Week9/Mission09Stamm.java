/********************************************************
 * Mission09Stamm.java Stephanie Stamm
 *
 *
 * Encrypts and decrypts file of user's choosing
 ********************************************************/
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Mission09Stamm
{
   public static void main (String[] args)
   {  
      Scanner in = new Scanner (System.in);
      Scanner fileIn;
      File f;
      
      // Variables
      String filename = "";
      String transformationType = "";
      String transformedWord = "";
      char character = ' ';
      int ascii = 0;
      
      // Array lists
      ArrayList<String> transformedWords = new ArrayList<String>();
      ArrayList<String> untransformedWords = new ArrayList<String>();
      
      try
      {
         // Gets filename and transformation type from user
         System.out.println("Please enter the name of the file:");
         filename = in.nextLine();
         
         System.out.println("Would you like to encrypt or decrypt?:");
         transformationType = in.nextLine();
         
         //Attaches scanner to user's file
         f = new File (filename);
         fileIn = new Scanner (f);
         
         // Encrypts file
         if (transformationType.equalsIgnoreCase("encrypt"))
         {
            PrintWriter fileOut = new PrintWriter ("Encrypted.txt");

            // Creates array of words to loop through
            while (fileIn.hasNext())
            {
               untransformedWords.add(fileIn.nextLine());
            }
            
            // Loops through array of words, and then each character in each word
            for (int i = 0; i < untransformedWords.size(); i++)
            {
               transformedWord = "";
               
               // Applies encryption to each character and converts to ASCII value
               for (int j= 0; j < untransformedWords.get(i).length(); j++)
               {
                  character = untransformedWords.get(i).charAt(j);
                  ascii = (int) character;
                  
                  // Wraps around the alphabet for z and Z
                  if (ascii == 90)
                  {
                     transformedWord += (char) 65;
                  }
                  else if (ascii == 122)
                  {
                     transformedWord += (char) 97;
                  }
                  
                  // Ensures only letters are being encrypted
                  else if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122))
                  {
                     transformedWord += (char) (ascii + 1);
                  }
                  else
                  {
                     transformedWord += (char) ascii;
                  }
               }
               
               // Adds newly encrypted word to array
               transformedWords.add(transformedWord);
            }
            
            // Loops through transformed words array and saves to file
            for (int i = 0; i < transformedWords.size(); i++)
            {
               fileOut.println(transformedWords.get(i) + " ");
            }

            // Closes file so it can be opened and read by user
            fileOut.close();

            System.out.println("File has been encrypted to Encrypted.txt");
         }
         
         // Decrypts file
         else if (transformationType.equalsIgnoreCase("decrypt"))
         {
            PrintWriter fileOut = new PrintWriter ("Decrypted.txt");

            // Creates array of words to loop through
            while (fileIn.hasNext())
            {
               untransformedWords.add(fileIn.nextLine());
            }
            
            // Loops through array of words, and then each character in a word
            for (int i = 0; i < untransformedWords.size(); i++)
            {
               transformedWord = "";

               // Applies decryption to each character and saves it
               for (int j= 0; j < untransformedWords.get(i).length(); j++)
               {
                  character = untransformedWords.get(i).charAt(j);
                  ascii = (int) character; // Casts character to ascii code
                  
                  // Wraps around the alphabet for a and A
                  if (ascii == 65)
                  {
                     transformedWord += (char) 90;
                  }
                  else if (ascii == 97)
                  {
                     transformedWord += (char) 122;
                  }
                  
                  // Ensures only letters are being decrypted
                  else if ((ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122))
                  {
                     transformedWord += (char) (ascii - 1);
                  }
                  else
                  {
                     transformedWord += (char) ascii;
                  }
               }
               
               // Adds decrypted word to array
               transformedWords.add(transformedWord);
            }
            
            // Outputs decrypted words to file
            for (int i = 0; i < transformedWords.size(); i++)
            {
               fileOut.println(transformedWords.get(i) + " ");
            }

            // Closes file so it can be opened and read by user
            fileOut.close();
            
            System.out.println("File has been decrypted to Decrypted.txt");
         }
         else
         {
            System.out.println("Sorry, that is not a valid answer");
         }
      }
      catch (FileNotFoundException e)
      {
         System.out.println("Sorry, that file name is not found.");
      }
   }
}