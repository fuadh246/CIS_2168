import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main2 {
    public static Scanner scan = new Scanner(System.in);

    public static class WordDetails {
        public int length;
        public int numGuesses;

        public WordDetails(int length, int numGuesses) {
            this.length = length;
            this.numGuesses = numGuesses;
        }
    }

    public static void main(String[] args) {
        boolean continueGame = true;
        while (continueGame) {
            HashMap<String, Integer> words = readWords();
            HashSet<Character> guessedLetters = new HashSet<>();
            Set<String> wordList;
            WordDetails userWordDetails = getUserWordDetails(words);
            filterWordsByLength(words, userWordDetails.length);
            wordList = words.keySet();

            while (true) {
                displayGameInfo(guessedLetters, userWordDetails.numGuesses);
                char userGuess = getUserGuess(guessedLetters);
                HashMap<String, Set<String>> targetWord = createTargetWordMap(wordList, userGuess);
                Set<String> matchedWords = getMatchingWords(targetWord);

                updateWordListAndGuesses(matchedWords, userGuess, userWordDetails);
                boolean wordGuessed = isWordGuessed(wordList, guessedLetters);

                if (userWordDetails.numGuesses == 0 || wordGuessed) {
                    endGame(userWordDetails, wordList);
                    continueGame = playAgain();
                    break;
                } else {
                    displayProgressAndRemainingWords(wordList, guessedLetters);
                }
            }
        }
    }

    public static HashMap<String, Integer> readWords() {
        HashMap<String, Integer> words = new HashMap<>();
        try {
            Scanner in = new Scanner(new File("src/words.txt"));
            while (in.hasNextLine()) {
                String word = in.nextLine().toLowerCase();
                words.put(word, word.length());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }

    public static WordDetails getUserWordDetails(Map<String, Integer> words) {
        int size = 0;
        int numGuesses = 0;
        while (true) {
            System.out.println("Enter the length of the word: ");
            size = scan.nextInt();
            scan.nextLine();
            if (words.containsValue(size)) {
                break;
            }
            System.out.println("Invalid length. Please try again.");
        }
        System.out.println("Enter the number of wrong guesses allowed: ");
        numGuesses = scan.nextInt();
        scan.nextLine();
        return new WordDetails(size, numGuesses);
    }

    public static void filterWordsByLength(HashMap<String, Integer> words, int length) {
        words.values().removeIf(l -> l != length);
    }

    public static void displayGameInfo(HashSet<Character> guessedLetters, int numGuesses) {
        System.out.println("Already guessed letters: " + guessedLetters);
        System.out.println("Remaining guesses: " + numGuesses);
    }

    public static char getUserGuess(Set<Character> guessedLetters) {
        char userGuess = 0;
        while (true) {
            System.out.println("Enter your guess: ");
            String input = scan.nextLine().toLowerCase();
            if (!input.isEmpty() && Character.isAlphabetic(input.charAt(0))) {
                userGuess = input.charAt(0);
                if (!guessedLetters.contains(userGuess)) {
                    guessedLetters.add(userGuess);
                    break;
                } else {
                    System.out.println("You already guessed that letter. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a single letter.");
            }
        }
        return userGuess;
    }

    public static HashMap<String, Set<String>> createTargetWordMap(Set<String> wordList, char userGuess) {
        HashMap<String, Set<String>> targetWord = new HashMap<>();
        for (String word : wordList) {
            StringBuilder wordPattern = new StringBuilder();
            for (char c : word.toCharArray()) {
                if (c == userGuess) {
                    wordPattern.append(c);
                } else {
                    wordPattern.append("_");
                }
            }
            String pattern = wordPattern.toString();
            if (!targetWord.containsKey(pattern)) {
                targetWord.put(pattern, new HashSet<>());
            }
            targetWord.get(pattern).add(word);
        }
        return targetWord;
    }

    public static Set<String> getMatchingWords(HashMap<String, Set<String>> targetWord) {
        Set<String> matchedWords = new HashSet<>();
        String matchedPattern = "";
        for (String pattern : targetWord.keySet()) {
            Set<String> words = targetWord.get(pattern);
            if (words.size() > matchedWords.size()) {
                matchedWords = words;
                matchedPattern = pattern;
            }
        }
        System.out.println("Matched pattern: " + matchedPattern);
        return matchedWords;
    }

    public static void updateWordListAndGuesses(Set<String> matchedWords, char userGuess, WordDetails userWordDetails) {
        if (matchedWords.contains(String.valueOf(userGuess))) {
            System.out.println("Correct guess!");
        } else {
            System.out.println("Wrong guess!");
            userWordDetails.numGuesses--;
        }
    }

    public static boolean isWordGuessed(Set<String> wordList, HashSet<Character> guessedLetters) {
        if (wordList.size() != 1) {
            return false;
        } else {
            String word = wordList.iterator().next();
            for (char c : word.toCharArray()) {
                if (!guessedLetters.contains(c)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void endGame(WordDetails userWordDetails, Set<String> wordList) {
        if (userWordDetails.numGuesses == 0) {
            System.out.println("Sorry, you are out of guesses!");
        } else {
            System.out.println("Congratulations, you win!");
        }
        System.out.println("The word was: " + wordList.iterator().next());
    }

    public static boolean playAgain() {
        System.out.println("Do you want to play again? (y/n): ");
        String input = scan.nextLine().toLowerCase();
        return input.equals("y");
    }

    public static void displayProgressAndRemainingWords(Set<String> wordList, HashSet<Character> guessedLetters) {
        StringBuilder progress = new StringBuilder();
        for (char c : wordList.iterator().next().toCharArray()) {
            if (guessedLetters.contains(c)) {
                progress.append(c);
            } else {
                progress.append("_");
            }
        }
        System.out.println("Current Progress: " + progress);
        System.out.println("Remaining possible words: " + wordList);
    }
}




