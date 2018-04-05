import java.util.*;

public enum Numeral {

	I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
	int weight;

	Numeral(int weight) {
		this.weight = weight;
	}
	final static Numeral[] values = Numeral.values();

	public static boolean isRoman(String n){

		for(int i = 0; i < n.length(); i++){
			//			char cursor = n.charAt(i);
			if(n.charAt(i) != 'I' && n.charAt(i) != 'V' && n.charAt(i) != 'X' && n.charAt(i) != 'L' &&
					n.charAt(i) != 'C' && n.charAt(i) != 'D' && n.charAt(i) != 'M'){
				return false;
			}
		}
		return true;
	}
	//method to convert Arabic to Roman
	public static String roman(int n) {

		if( n <= 0) {
			throw new IllegalArgumentException();
		}

		StringBuilder buf = new StringBuilder();


		for (int i = values.length - 1; i >= 0; i--) {
			while (n >= values[i].weight) {
				buf.append(values[i]);
				n -= values[i].weight;
			}
		}
		return buf.toString();
	}

	//method to convert Roman to Arabic
	public static long arabic(String line){

		//TODO
		return 0;
	}

	//prints Arabic
	public static void RomantoArabic(String n) {
		System.out.println(n + " = " + arabic(n));
	}

	//prints Roman
	public static void ArabictoRoman(int n) {
		System.out.println(n + " = " + roman(n));
	}

	public static void main(String[] args) {

		System.out.println("What would you like to convert:(a/b)\n"
				+ "a.Roman to Arabic numerals\nb.Arabic to Roman numerals");
		Scanner input = new Scanner(System.in);
		String choice = input.next();

		if(choice.compareTo("a") == 0){
			System.out.print("Insert Roman Numerals:");
			String romans = input.next();
			//check for valid Roman numerals
			while(!isRoman(romans)){
				System.out.println("Please insert valid line");
				romans = input.next();
			}
			RomantoArabic(romans);
		}else if(choice.compareTo("b") == 0){
			System.out.print("Insert Arabic Numerals:");
			int arabics = input.nextInt();
			ArabictoRoman(arabics);
		}else{
			System.out.println("goodbye");
		}
	}

}

