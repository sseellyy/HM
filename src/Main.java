import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        File dictionary = new File("src/dictionary.txt");

        Scanner textScanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        while(textScanner.hasNextLine()){
            words.add(textScanner.nextLine());

        }
        String hidden_text = words.get((int)(Math.random()*words.size()));
        char[] textArray = hidden_text.toCharArray();

        char [] myAnswers = new char[textArray.length];
        for(int i = 0; i < textArray.length; i++){
            myAnswers[i] = '?';
        }
        boolean finished = false;
        int lives = 6;

        while(!finished){
            System.out.println("********************");

            String letter = input.next();
            //checks for valid input
            while(letter.length() != 1 || Character.isDigit(letter.charAt(0))){
                System.out.println("Error input - Try again");
                letter = input.next();
            }

            //checks if letter is in the word
            boolean found = false;
            for(int i = 0; i < textArray.length; i++){
                if (letter.charAt(0) == textArray[i]){
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }
            if(!found){
                lives--;

                System.out.println("Wrong letter");
            }
            boolean done = true;
            for (char myAnswer : myAnswers) {
                if (myAnswer == '?') {
                    System.out.println("_");
                    done = false;
                } else {
                    System.out.println(" " + myAnswer);
                }
            }
            System.out.println("\n" + "Lives left: " + lives);

            //checks if the game ends
            if (done){
                System.out.println("Congrats. You found the word");
            }
            if (lives <= 0){
                System.out.println("You are dead!");
                finished = true;
            }
        }

    }
}