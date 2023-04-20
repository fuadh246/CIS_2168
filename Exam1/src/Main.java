import java.util.List;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList <String> words = new DoublyLinkedList<>();
        words.add("Fuad");
        words.add("Hassan");
        System.out.println(words);
        System.out.println(reverseWords(words));
    }
    public static DoublyLinkedList<String> reverseWords(DoublyLinkedList<String> words){
        DoublyLinkedList <String> reverseWords = new DoublyLinkedList<>();
        // this is using the StringBuilder library
        for (int i = 0; i < words.size(); i++) {
            StringBuilder element = new StringBuilder(words.get(i));
            reverseWords.add(element.reverse().toString());
        }
        // this one is looping and reversing
//        for (int i = 0; i < words.size(); i++) {
//            String element = "";
//            for (int j = words.get(i).length()-1; j >= 0; j--) {
//                element += words.get(i).charAt(j);
//            }
//            reverseWords.add(element);
//        }
        return reverseWords;
    }

}
