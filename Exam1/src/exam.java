import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class exam {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Fuad");
        list.add("Hassan");

        System.out.println(removePrefixStrings(list,"fu").toString());

    }

    public static <E> ArrayList<String> removePrefixStrings(List<String> list, String prefix) {
        ArrayList<String> withOutPrefix = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if (word.contains(prefix)){
                word=word.replace(prefix,"");
            }
            withOutPrefix.add(word);
        }
        return withOutPrefix;
    }
}
