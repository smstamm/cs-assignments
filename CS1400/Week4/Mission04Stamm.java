/********************************************************
* Mission04Stamm.java
* Stephanie Stamm
*
*
* Translates user inputted word to Pig Latin
********************************************************/

import java.util.Scanner;

public class Mission04Stamm
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);
		String wordToTranslate = "";
		String consonantCluster = "";
		char firstletter = ' ';
		String translatedWord = "";

		System.out.println("Welcome to the Pig Latin Translator!");
		System.out.println("Please enter a word:");
		wordToTranslate = in.nextLine().toLowerCase();
		firstletter = wordToTranslate.charAt(0);

		do
		{
			if (isVowel(firstletter))
			{
				translatedWord = wordToTranslate + "way";
			}
			else
			{
				consonantCluster = findConsonantCluster(wordToTranslate);
				translatedWord = wordToTranslate.substring(consonantCluster.length()) + consonantCluster + "ay";
			}
			
			System.out.println("The translation is: " + translatedWord);
			System.out.println("Enter another word to be translated (or press Q to quit):");
			wordToTranslate = in.nextLine().toLowerCase();
			firstletter = wordToTranslate.charAt(0);

		} while (!wordToTranslate.equalsIgnoreCase("q"));
	}

	public static boolean isVowel (char letter)
	{
		return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
	}

	public static String findConsonantCluster (String word)
	{
		String consonantCluster = "";
		for (int i = 0; i < word.length(); i++)
		{
			if (isVowel(word.charAt(i)))
			{
				consonantCluster = word.substring(0, i);
				return consonantCluster;
			}
		}
		return "";
	}
}