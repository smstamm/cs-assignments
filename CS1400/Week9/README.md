# Mission 9

CS 1400 - Hilton

Write a program that allows users to encrypt and decrypt files. The file encryption technique we will use for this program is the highly secure "one letter off" system. So an "a" will be represented by a "b", and a "b" will be represented by a "c" in the encrypted file.

Encrypt only the letters in the file. If you come to a non-letter character (spaces, punctuation, numbers, etc.),just print them as is without encrypting.

Prompt the user for the file name. Then prompt the user as to whether they would like to encrypt or decrypt the file, and perform the encryption or decryption. Output the file to a new file named "Encrypted.txt" if the user chooses to Encrypt, or "Decrypted.txt" if the user chooses to Decrypt.

HINT: A "char" is a character from the ASCII Table. Because the ASCII Table is just an ordered set of characters,we can use the ++ or -- to move forward and backward in the ASCII Table just like we do to increment or decrement an integer.

The decrypted file should look exactly the same as the original file if we have done things correctly, even if the original file has multiple lines of text.

Also, keep in mind that these assignments build on each other, so we’ll be using a number of the prebuilt methods we previously learned about in this assignment.

Sample session:
Please enter the name of the file: *test.txt*
Would you like to encrypt or decrypt?: *encrypt*
File has been encrypted to Encrypted.txt

Please enter the name of the file: *Encrypted.txt*
Would you like to encrypt or decrypt?: *decrypt*
File has been decrypted to Decrypted.txt