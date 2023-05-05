import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static class word_details {
        public int length;
        public int num_of_Guesses;

        public word_details(int length, int num_of_Guesses) {
            this.length = length;
            this.num_of_Guesses = num_of_Guesses;
        }
    }
    public static void main(String[] args) {
        boolean game_continue= true;
     while (game_continue) {
         HashMap<String, Integer> words = read_words();
         HashSet<Character> guessedLetters = new HashSet<>();
         Set<String> wordList;
         word_details User_word_details = get_user_word_details(words);
         words.values().retainAll(Collections.singleton(User_word_details.length));
         wordList = words.keySet();
         while (true) {
             System.out.println("Already guessed letters: " + guessedLetters);
             System.out.println("Remaining guesses: " + User_word_details.num_of_Guesses);
             char user_guess = get_user_guess(guessedLetters);

             HashMap<String, Set<String>> target_word = new HashMap<>();
             for (Iterator<String> iterator = wordList.iterator(); iterator.hasNext(); ) {
                 String nextWord = iterator.next();
                 String word = "";
                 for (char c : nextWord.toCharArray()) {
                     if (c == user_guess) {
                         word+= c;
                     } else {
                         word+= "_";
                     }
                 }
                 if (!target_word.containsKey(word)) {
                     target_word.put(word, new HashSet<>());
                 }
                 target_word.get(word).add(nextWord);
             }
             Set<String> matched_words = new HashSet<>();
             String matched_word = "";
             for (String word : target_word.keySet()) {
                 if (target_word.get(word).size() > matched_words.size()) {
                     matched_word = word;
                     matched_words = target_word.get(word);
                 }
             }
             wordList = matched_words;
             if (matched_words.contains("" + user_guess)) {
                 System.out.println("Correct guess");
             } else {
                 System.out.println("Wrong guess");
                 User_word_details.num_of_Guesses--;
             }
             boolean word_guessed = true;
             if (wordList.size() != 1) {
                 word_guessed = false;
             } else {
                 for (char c : wordList.toArray()[0].toString().toCharArray()) {
                     if (!guessedLetters.contains(c)) {
                         word_guessed = false;
                         break;
                     }
                 }
             }
             if (User_word_details.num_of_Guesses == 0 || word_guessed) {
                 if (User_word_details.num_of_Guesses == 0) {
                     System.out.println("Sorry but you are out of guesses");
                 } else {
                     System.out.println("You win!");
                 }
                 System.out.println("The word was " + wordList.iterator().next());
                 System.out.println("Enter y to play again");
                 char c = scan.nextLine().toLowerCase().charAt(0);
                 if (c != 'y') game_continue = false;
                 break;
             } else {
                 String gussing_chars = "";
                 for (char c : ((String) wordList.toArray()[0]).toCharArray()) {
                     if (guessedLetters.contains(c)) gussing_chars += c;
                     else gussing_chars += "_";
                 }
                 System.out.println("Current Progress: " + gussing_chars);
                 System.out.println("The word Words " + wordList);
             }
         }
     }

    }
    public static char get_user_guess(Set<Character> guessedLetters){
        char user_guess=0;
        while (true){
            System.out.println("Enter your guess:");
            String input = scan.nextLine().toLowerCase();
            if (!input.isEmpty() && Character.isAlphabetic(input.charAt(0))) {
                user_guess = input.charAt(0);
                if(!guessedLetters.contains(user_guess)){
                    guessedLetters.add(user_guess);
                    break;
                }
                else {
                    System.out.println("Already guessed");
                }
            }else{
                System.out.println("invaid input");
            }
        }
        return user_guess;
    }

    public static word_details get_user_word_details(Map<String,Integer>words){
        int size=0;
        int num_of_Guesses=0;
        while (true) {
            System.out.println("Enter size of word");
            size = scan.nextInt();
            scan.nextLine();
            if (words.containsValue(size)) {
                break;
            }
            System.out.println("Invalid size");

        }
        System.out.println("Enter number of wrong guesses");
        num_of_Guesses = scan.nextInt();
        return new word_details(size,num_of_Guesses);
    }
    public static HashMap<String,Integer> read_words(){
        HashMap<String,Integer> words = new HashMap<>();
        try{
            Scanner in = new Scanner(new File("src/words.txt"));
            while (in.hasNextLine()){
                String word = in.nextLine().toLowerCase();
                words.put(word,word.length());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return words;
    }
}