import java.util.Scanner;
import java.util.Random;

public class Cipher {
    public static void main(String[] args) {
        boolean accesCypher = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the cypher program." + "\n" +  "You can now press 1 to access the number cypher program and 2 to access the Ceasar Cypher program");
        int chooseCypher = scanner.nextInt();
        do {
            if (chooseCypher == 1) {
                numberCypher();
                accesCypher = true;

            } else if (chooseCypher == 2) {
                ceasarCypher();
                accesCypher = true;

            } else {
                System.out.println("Enter 1 for number cypher or 2 for ceasar cypher");
                chooseCypher = scanner.nextInt();
            }
        } while (!accesCypher);
    }


    public static void numberCypher () {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Please enter a word you want to encode: ");
        String wordToEncode = scanner.nextLine();
        encryptWord(wordToEncode);

        System.out.println("Now you will have to enter the numbers you would like the encoded word to be: ");
        decryptWord(wordToEncode);




    }
    public static void decryptWord (String wordToEncode) {
        Scanner scanner = new Scanner(System.in);
        String abc = " abcdefghijklmnopqrstuvwxyzæøå";
        int[] newNumbers = new int[wordToEncode.length()];
        char[] encodedWord = new char[wordToEncode.length()];
        for (int i = 0; i < wordToEncode.length(); i++) {
            int setNewNumber = scanner.nextInt();
            newNumbers[i] = setNewNumber;

        }
        for (int i = 0; newNumbers.length < i; i++) {
            encodedWord[i] = abc.charAt(newNumbers[i]);
        }
        for (int i = 0; i < newNumbers.length; i++) {
            System.out.print(abc.charAt(newNumbers[i]));

        }
    }
    public  static void encryptWord (String encodedWord) {
        String abc = " abcdefghijklmnopqrstuvwxyzæøå";
        int [] indexOfWord = new int[encodedWord.length()];

        for (int i = 0; i < encodedWord.length(); i++) {
            indexOfWord[i] = abc.indexOf(encodedWord.charAt(i));

        }
        System.out.println(encodedWord + " has the numbers: ");
        for (int i = 0; i < indexOfWord.length; i++) {
            System.out.println(indexOfWord[i]);
        }
    }

    public static void ceasarCypher () {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the text to cypher: ");
        String textToCypher = scanner.nextLine();

        System.out.println("Enter the value that you want to shift the text with: ");
        int cypherShift = scanner.nextInt();
        String cypherText = "";
        char alphabet;

        for (int i = 0; i < textToCypher.length(); i++) {
            alphabet = textToCypher.charAt(i);
            if (textToCypher.charAt(i) == textToCypher.toLowerCase().charAt(i)) {
                if (alphabet >= 'a' && alphabet <= 'å') {
                    alphabet = (char) (alphabet + cypherShift);
                }
                if (alphabet > 'å') {
                    alphabet = (char) (alphabet + 'a' - 'å' - 1);
                }
                cypherText = cypherText + alphabet;
            } else if (textToCypher.charAt(i) == textToCypher.toUpperCase().charAt(i)) {
                if (alphabet >= 'A' && alphabet <= 'Å') {
                    alphabet = (char) (alphabet + cypherShift);
                }
                if (alphabet > 'Z') {
                    alphabet = (char) (alphabet + 'A' - 'Å' - 1);
                }
                cypherText = cypherText + alphabet;
            }

        }
        System.out.println("Ciphertext: " + cypherText);








        }

    }

