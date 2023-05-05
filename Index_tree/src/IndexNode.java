import java.util.ArrayList;
import java.util.List;

public class IndexNode  {

	// The word for this entry
	String word;
	// The number of occurrences for this word
	int occurences;
	// A list of line numbers for this word.
	List<Integer> list; 
	
	
	
	IndexNode left;
	IndexNode right;
	
	
	// Constructors
	// Constructor should take in a word and a line number
	// it should initialize the list and set occurrences to 1
	public IndexNode(String word, int line_num){
		this.word=word;
		int occurrences=1;
		list = new ArrayList<>();
		list.add(line_num);
	}
	public void add_line_num(int line_num){
		occurences++;
		list.add(line_num);
	}
	
	
	// Complete This
	// return the word, the number of occurrences, and the lines it appears on.
	// string must be one line
	
	public String toString(){
		return word+" "+(occurences+1)+" "+list;
	}
}
