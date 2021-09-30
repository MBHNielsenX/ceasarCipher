import java.util.Scanner;


public class Cipher {
    public static void main(String[] args) {
        boolean accesCypher = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the cypher program." + "\n" +  "You can now press 1 to access the number cypher program and 2 to access the Ceasar Cypher program");
        int chooseCypher = scanner.nextInt();
        //The do while loop is to make sure that the user will not enter another value than 1 or 2
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
        //Here we make a string with the alphabet and an array that is the size of the word that is to be encoded
        String abc = " abcdefghijklmnopqrstuvwxyzæøå";
        int [] indexOfWord = new int[encodedWord.length()];
        //Here we make each of the elements in indexOfWord equal to the index of chars in encodedWord inside the index of abc
        for (int i = 0; i < encodedWord.length(); i++) {
            indexOfWord[i] = abc.indexOf(encodedWord.charAt(i));

        }
        System.out.println(encodedWord + " has the numbers: ");
        //Here the values are being printed to the terminal
        for (int i = 0; i < indexOfWord.length; i++) {
            System.out.println(indexOfWord[i]);
        }
    }

    public static void ceasarCypher () {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;

        System.out.println("Would you like to encode or decode? \n Press 1 to encode or 2 to decode: ");
        int encodeOrDecode = scanner.nextInt();

        do {
            if (encodeOrDecode == 1) {
                ceasarEncode();
                isValid = true;

            } else if (encodeOrDecode == 2) {
                ceasarDecode();
                isValid = true;
            } else {
                System.out.println("Enter 1 for number cypher or 2 for ceasar cypher");
                encodeOrDecode = scanner.nextInt();
            }
        } while (!isValid);
    }

    public static void ceasarEncode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the text to encrypt: ");
        String textToEncode = scanner.nextLine();

        System.out.println("Enter the value that you want to shift the encryption with: ");
        int cypherShift = scanner.nextInt();
        String encodedText = "";
        char alphabet;

        //This for loop takes each of the chars in the text to encode and adds the value of the shift to the value of the char
        //So if you type in "a" and shift it with "1" the value of the char "a" will go one up and thus become "b"
        for (int i = 0; i < textToEncode.length(); i++) {
            alphabet = textToEncode.charAt(i);
            if (textToEncode.charAt(i) == textToEncode.toLowerCase().charAt(i)) {
                if (alphabet >= 'a' && alphabet <= 'å') {
                    alphabet = (char) (alphabet + cypherShift);
                }
                if (alphabet > 'å') {
                    alphabet = (char) (alphabet + 'a' - 'å' - 1);
                }
                encodedText = encodedText + alphabet;
            //This else if statement does the same as the if statements above, except that it is for uppercase letters
            } else if (textToEncode.charAt(i) == textToEncode.toUpperCase().charAt(i)) {
                if (alphabet >= 'A' && alphabet <= 'Å') {
                    alphabet = (char) (alphabet + cypherShift);
                }
                if (alphabet > 'Z') {
                    alphabet = (char) (alphabet + 'A' - 'Å' - 1);
                }
                encodedText = encodedText + alphabet;
            }

        }

        System.out.println("Encoded text: " + encodedText);
    }

    public static void ceasarDecode() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the text to decrypt: ");
        String textToDecode = scanner.nextLine();

        System.out.println("Enter the value that you want to shift the text with: ");
        int cypherShift = scanner.nextInt();
        String decodedText = "";
        char alphabet;

        for (int i = 0; i < textToDecode.length(); i++) {
            alphabet = textToDecode.charAt(i);
            if (textToDecode.charAt(i) == textToDecode.toLowerCase().charAt(i)) {
                if (alphabet >= 'a' && alphabet <= 'å') {
                    alphabet = (char) (alphabet + cypherShift);
                }
                if (alphabet > 'å') {
                    alphabet = (char) (alphabet + 'a' - 'å' - 1);
                }
                decodedText = decodedText + alphabet;

            } else if (textToDecode.charAt(i) == textToDecode.toUpperCase().charAt(i)) {
                if (alphabet >= 'A' && alphabet <= 'Å') {
                    alphabet = (char) (alphabet + cypherShift);
                }
                if (alphabet > 'Z') {
                    alphabet = (char) (alphabet + 'A' - 'Å' - 1);
                }
                decodedText = decodedText + alphabet;
            }

        }

        System.out.println("Decoded text: " + decodedText);


        }

    }

