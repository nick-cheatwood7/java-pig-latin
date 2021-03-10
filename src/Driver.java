
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter English phrase: ");
		String phrase = scan.nextLine();
		scan.close();
		
		PigLatin translator = new PigLatin(phrase);
		
		translator.translate();
		
		System.out.println(phrase + " in Pig Latin is: " + translator.getPigLatinPhrase());
	}

}
