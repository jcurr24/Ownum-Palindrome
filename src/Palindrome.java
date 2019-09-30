import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Palindrome {
	
	public static void main(String args[]) throws FileNotFoundException {

		File f = new File("word-list.txt");

		List<String> words = new ArrayList<String>();

		List<String> winner = new ArrayList<String>();
		

		try (Scanner scanner = new Scanner(f)) {

			while (scanner.hasNextLine()) {
				String list = scanner.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase();
				words.add(list);

			}

			for (String test : words) {

				if (test.charAt(0) != test.charAt(test.length() - 1)) {
					System.out.println(test + " is not a palindrome.");
				}

				if (isPali(test) == true) {
					winner.add(test);
					System.out.println(test + " is a palindrome!");
				} else {
					if (test.charAt(0) == test.charAt(test.length() - 1)) {
						System.out.println(test + " is not a palindrome, but these letters matched " + test.charAt(0));
					}
				}

			}
			Collections.sort(winner);
			System.out.println(winner);

		}

	}

	public static boolean isPali(String word) {
		StringBuilder sb = new StringBuilder(word);
		return word.equals(sb.reverse().toString());
	}


}
