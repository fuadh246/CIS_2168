import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // int arraylist
        List<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(6);
        num.add(4);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        num.add(15);
        // int arraylist
        List<Integer> num2 = new ArrayList<>();
        num2.add(15);
        num2.add(1);
        num2.add(6);
        num2.add(4);
        num2.add(3);
        num2.add(4);
        num2.add(5);
        num2.add(6);
        //String arraylist
        List<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Cat");
        animals.add("Lion");
        animals.add("Rabbit");
        animals.add("Bear");
        //@print arraylist num
        System.out.println(num);
        //@print arraylist animals
        System.out.println(animals);
        //@isPermutaion()
        System.out.println(isPermutaion(num,num2));
        //@unique()
        System.out.println(unique(num));
        //@unique()
        System.out.println(unique(animals));
        //@allMultiples()
        System.out.println(allMultiples(num, 5));
        //@allStringsOfSize()
        System.out.println(allStringsOfSize(animals, 4));
        //@stringToListOfWords()
        System.out.println(stringToListOfWords("Hello, world! How areeee    you?"));
        //@removeAllInstances()
        System.out.println(removeAllInstances(num,6));
    }

    /*
    * 2.1
    *  @function unique: it takes an arraylist and check if there is any duplicate. if not it is a unique list.
    * @ param: Arraylist list
    */
    public static <E> boolean unique(List<E> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    * 2.2
    * @function allMultiples: This method filters all multiples of a given number "x"
    * from a list of integers, returning a new list containing those multiples.
    * @param: integer Arraylist list, integer x
    */
    public static List<Integer> allMultiples(List<Integer> list, int x) {
        List<Integer> multipliers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % x == 0) {
                multipliers.add(list.get(i));
            }
        }
        return multipliers;
    }

    /*
    * @function allStringsOfSize: This method filters all strings with a given length "x" from
    * a list of strings, returning a new list containing those strings.
    * @param:String Arraylist list, integer x
    * */
    public static List<String> allStringsOfSize(List<String> list, int x) {
        List<String> lengthOfCha = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == x) {
                lengthOfCha.add(list.get(i));
            }
        }
        return lengthOfCha;
    }

    /*
     * @function stringToListOfWords: This function converts a given input string into a list
     * of words by using a Scanner to iterate through the string and adding each word (after
     *  removing punctuation) to an ArrayList. The resulting list of words is then returned.
     * @param:String line
     * */
    public static List<String> stringToListOfWords(String line){
        List<String> words = new ArrayList<>();
        Scanner in = new Scanner(line);
        while (in.hasNext()){
            words.add(removePun(in.next()));
        }
        return words;
    }

    /*
    * @function isPunct:This function checks if the given character is a punctuation by comparing it against
    * an array of common punctuation characters. If a match is found, the function returns
    * true indicating that the character is a punctuation. If no match is found, the function returns false.
    * @param: char c
    * */
    public static boolean isPunct(char c) {
        char[] Punctuations = { '\'', ',', '.', ';', ':', '!', '?' };
        for(int i = 0; i<Punctuations.length;i++){
            if(Punctuations[i]==c){
                return true;
            }
        }
        return false;
    }
    /*
     * @function removePun:This function removes any punctuation from a given input string by iterating
     * through the string and checking each character using the 'isPunct' method. If the character is a
     * punctuation, it is replaced with an empty string. The resulting string with punctuation removed is returned.
     * @param: String s
     * */
    public static String removePun(String s){
        for (int i = 0; i <s.length(); i++) {
            if(isPunct(s.charAt(i))){
                s =s.replace(Character.toString(s.charAt(i)),"");
            }
        }
        return s;
    }

    public static <E> boolean isPermutaion2(List<E> list1, List<E> list2){
        int len1 = list1.size();
        int len2 = list2.size();
        if(len1!=len2) return false;
        for (int i = 0; i < len1; i++) {

            for(int j=0; j< len2;j++){
                if(list1.get(i).equals(list2.get(j))){
                    System.out.println("-"+list1);
                    System.out.println(list2);
                    list2.remove(j);
                    list1.remove(i);
                    j=0;
                    i=0;
//                    len2-=1;
//                    len1-=1;
                }
            }
        }
        System.out.println(list1.size()+" "+list2.size());

        if(list1.size()==0 &&list2.size()==0){
            System.out.println(list1.size()+" "+list2.size());
            return true;
        }
        return false;
    }
    /*
     * @function isPermutaion: return true if it Permutaion else false.
     * @param: Arraylist A, Arraylist B
     * */

        public static <E> boolean isPermutaion(List<E> A, List<E> B){
            if(A.size() != B.size()) {
                return false;
            }
            for (E item : A){
                int countA = 0;
                int countB = 0;

                for (int i = 0; i < A.size(); i++) {
                    if(A.get(i).equals(item)){
                        countA++;
                    }
                }
                for (int i = 0; i < B.size(); i++) {
                    if(B.get(i).equals(item)){
                        countB++;
                    }
                }
                if(countA != countB) {
                    return false;
                }
            }
            return true;
        }

    /*
     * @function removeAllInstances: remove all the element that is equal to x and return a new list.
     * @param: Integer Arraylist A, Integer x
     * */

        public static List<Integer> removeAllInstances(List <Integer> list,int x){
        for (int i= 0; i < list.size();i++) {
            if(list.get(i)==x){
                list.remove(i);
            }
        }
        return list;

    }

}