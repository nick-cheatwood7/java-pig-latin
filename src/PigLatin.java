
public class PigLatin {
	
	// Attributes
	private String english;
	private String pigLatinPhrase;
	
	// Constructor
	public PigLatin(String text) {
		this.english = text;
		this.pigLatinPhrase = "";
	}
	
	// Getter
	public String getPigLatinPhrase() {
		return pigLatinPhrase;
	}
	

	// Check for vowel
	public static boolean isVowel(char letter) {
		if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
			return true;
		} else {
			return false;
		}
	}
	
	// Check for punctuation
	public static boolean isPunctuation(char ch) {
		if( ch == ',' || ch == '.' || ch == '?' || ch == '!' ) {
			return true;
		} else {
			return false;
		}
	}
	
	// Handle vowel
	public static String vowel(String text) {
		return ( text + "way" );
	}
	
	// Handle consonant
	public static String consonant(String text) {
		
		// initialize any variables needed
		boolean isReadingStart = false;
		boolean containsUpper = false;
		String end = "";
		String start = "";
		String punct = "";
		
		for( int i = 0; i < text.length(); i++ ) {
			
			// for each char in the text, determine what to do with it
			char target = text.charAt(i);
			
			if(i == 0 && target == Character.toUpperCase(target)) {
				// Dealing with upper-cased word
				containsUpper = true;
			}
			
			if(isVowel(Character.toLowerCase(target))) {
				
				// Vowel
				if(!isReadingStart) {
					// flag here
					isReadingStart = true;
				}
				
				if(containsUpper && start.length() == 0) {
					// capitalize and continue to end of word
					start += String.valueOf(Character.toUpperCase(target));
				} else {
					// continue to end of word
					start += String.valueOf(Character.toLowerCase(target));
				}
				
				
			} else if(isPunctuation(target)) {
				// punctuation
				punct += String.valueOf(target);
				
			} else {
				
				// consonant
				if(!isReadingStart) {
					// append to "end string"
					end += String.valueOf(Character.toLowerCase(target));
				} else {
					// continue to end of word
					start += String.valueOf(Character.toLowerCase(target));
				}
				
			}
		}
		
		return ( start + end + "ay" + punct);
	}
	
	public void translate() {
		String[] words = this.english.split(" ");
		
		for(int i = 0; i < words.length ; i ++) {
			// test if the first character is a vowel
			if(isVowel(words[i].charAt(0))) {
				// if the word starts with a vowel, call vowel to handle
				words[i] = vowel(words[i]);
			} else {
				// consonant
				words[i] = consonant(words[i]);
			}
		}
		
		// Need to loop through word list to form Pig Latin sentence
		for(int x = 0 ; x < words.length ; x ++) {
			pigLatinPhrase += words[x] + " ";
		}
	}

}
