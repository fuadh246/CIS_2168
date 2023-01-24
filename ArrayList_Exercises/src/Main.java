import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(6);
        num.add(4);
        num.add(3);
        num.add(4);
        num.add(5);
        num.add(6);
        num.add(15);
        List<Integer> num2 = new ArrayList<>();
        num2.add(1);
        num2.add(6);
        num2.add(3);
        num2.add(4);
        num2.add(4);
        num2.add(5);
        num2.add(6);
        num2.add(15);
        List<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Cat");
        animals.add("Lion");
        animals.add("Rabbit");
        animals.add("Bear");
        System.out.println(num);
        System.out.println(animals);
        System.out.println(unique(num));
        System.out.println(unique(animals));
        System.out.println(allMultiples(num, 5));
        System.out.println(allStringsOfSize(animals, 3));
        System.out.println(stringToListOfWords("Hello, world!"));
        //System.out.println(removeAllInstances(num,5));
        System.out.println(isPermutaion(num,num2));
    }

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

    public static List<Integer> allMultiples(List<Integer> list, int x) {
        List<Integer> multipliers = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % x == 0) {
                multipliers.add(list.get(i));
            }
        }
        return multipliers;
    }

    public static List<String> allStringsOfSize(List<String> list, int x) {
        List<String> lengthOfCha = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == x) {
                lengthOfCha.add(list.get(i));
            }
        }
        return lengthOfCha;
    }
    public static List<String> stringToListOfWords(String line){
        List<String> words = new ArrayList<>();
        Scanner in = new Scanner(line);
        while (in.hasNext()){
            words.add(removePun(in.next()));
        }
        return words;
    }
    public static boolean isPunct(char c) {
        char[] Punctuations = { '\'', ',', '.', ';', ':', '!', '?' };
        for(int i = 0; i<Punctuations.length;i++){
            if(Punctuations[i]==c){
                return true;
            }
        }
        return false;
    }
    public static String removePun(String s){
        for (int i = 0; i <s.length(); i++) {
            if(isPunct(s.charAt(i))){
                s =s.replace(Character.toString(s.charAt(i)),"");
            }
        }
        return s;
    }
    public static <E> boolean isPermutaion(List<E> list1, List<E> list2){
/*
* list1 = [1,2,2,4], list2 = [1,2,4,2]
*
* */
//        if(list1.size()!=list2.size()) return false;

        int l = list1.size();
        int l2 = list2.size();
        for (int i = 0; i < l2; i++) {
            System.out.println("-"+list1);
            System.out.println(list2);
            for(int j=0; i<l;j++){
                if(list1.get(i).equals(list2.get(j))){
                   list1.remove(i);
                   list2.remove(j);
                   l--;
                   l2--;
                }
            }
        }
//        if(list1.size()==0 &&list2.size()==0){
////            System.out.println(list1.size()+" "+list2.size());
//            return true;
//        }
        return false;
    }
    public static List<Integer> removeAllInstances(List <Integer> list,int x){
        for (int i= 0; i < list.size();i++) {
            if(list.get(i)==x){
                list.remove(i);
            }
        }
        return list;

    }

}