package org.example;

import java.util.Scanner;

public class CaesarCipher {
    //creating encrypt method ()
    public static String encrypt (String text, int shift) {
        //creating a StringBuilder object
        StringBuilder result = new StringBuilder();
        //for each loop
        for (char character : text.toCharArray()) {
            /*same as for loop:
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
        char character = chars[i];
        }   */
    //encrypt only letter with the .isLetter() method that return a boolean if a character is a letter
            if (Character.isLetter(character)){
    //encrypt both lower and uppercase
        /*  char base;
            if (Character.isLowerCase(character)) {
                base = 'a';
            } else {
                base = 'A';
            }*/
    //if else shorthand (?:) called the ternary operator
    //condition ? valueIfTrue : valueIfFalse
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                //type casting (char): converts diff data types from one to another
                //to display the shifted character, not its numeric code
                char shifted = (char) ((character - base + shift) % 26 + base);

                //add each letter to a string that holds the new message
                //use .append() method to add each letter to the StringBuilder object called result
                result.append(shifted);

            //if it's not a letter, it won't be encrypted and will be added to result string
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
    public static String decrypt (String text, int shift){
        //shift becomes negative
        return encrypt (text, 26 - (shift % 26));
    }
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to encrypt: ");
        String inputText = scanner.nextLine();

        System.out.print("Enter shift key (0-25): ");
        int shiftKey = scanner.nextInt();

        String encrypted = encrypt(inputText, shiftKey);
        System.out.println("Encrypted text: " + encrypted);

        String decrypted = decrypt(encrypted, shiftKey);
        System.out.println("Decrypted text: " + decrypted);
    }
}