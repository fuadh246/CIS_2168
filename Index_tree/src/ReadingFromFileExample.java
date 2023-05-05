import java.io.*;
import java.util.Scanner;

public class ReadingFromFileExample {
	
	public static void main(String [] args) {

		String fileName = "src/pg100.txt";
		
		try {
			Scanner scanner = new Scanner(new File(fileName));
			int count=0;
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				System.out.println(line);
				String[] words = line.split("\\s+");
				for(String word : words){
					word = word.replaceAll(":", "");
					word = word.replaceAll(",", "");
					System.out.println(word);
					count++;
				}
			}
			System.out.println(count);
			scanner.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}


