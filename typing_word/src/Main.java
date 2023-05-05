import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static public Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> words = new ArrayList<String>();
        ArrayList<String> correct_words = new ArrayList<String>();
        ArrayList<String> incorrect_words = new ArrayList<String>();

        File file = new File("/Users/fuadhassan/Desktop/CIS_2168/typing_word/src/words.txt");
        Scanner in = new Scanner(file);
        while (in.hasNextLine()){
            String word = in.nextLine();
            words.add(word);
        }

        long startTime = System.currentTimeMillis();
        do {
            String word = getWord(words,correct_words.size());

            System.out.println(String.format("%25s %20s %2d %20s %2d",word,"✅:",correct_words.size(), "❌:",incorrect_words.size()));

            String userInput = keyboard.nextLine();
            if(userInput.equals(word)){
                correct_words.add(userInput);

            }else {
                incorrect_words.add(word);
            }
        }while (incorrect_words.size()<3);
        long endTime = System.currentTimeMillis();
        long seconds = (endTime - startTime) / 1000;
        long HH = seconds / 3600;
        long MM = (seconds % 3600) / 60;
        long SS = seconds % 60;
        String timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);

        System.out.println(String.format("\t%5s %d   %s","✅:",correct_words.size(),correct_words));
        System.out.println(String.format("\t%5s %d   %s","❌:",incorrect_words.size(),incorrect_words));
        System.out.println(String.format("\t%6s %s","⏱️:",timeInHHMMSS));
    }

    public static String getWord(ArrayList words, int correct){
        Random rand = new Random();
        if(correct<=3){
            return getLenOf(words,0,4);
        } else if (correct<=5){
            return getLenOf(words,4,8);
        } else if (correct<=10){
            return getLenOf(words,8,11);
        } else if (correct<=15){
            return getLenOf(words,11,14);
        } else if (correct<=20){
            return getLenOf(words,14,17);
        } else if (correct<=25){
            return getLenOf(words,15,19);
        }
        else return getLenOf(words,0, 30);
    }
    public static String getLenOf(ArrayList words,int min, int max){
        Random rand = new Random();
        String word;
        do {
            word = (String) words.get(rand.nextInt(words.size()));
        } while (word.length()>max || word.length()<min);
        return word;
    }

}