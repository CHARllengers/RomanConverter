import java.util.*;

public enum Numeral {

	I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
	int weight;

	Numeral(int weight) {
		this.weight = weight;
	}
	final static Numeral[] values = Numeral.values();

	//Checks if the Roman numerals inserted are valid
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

	

		final Numeral[] values = Numeral.values();
		System.out.print(line);
		int arabic=0;
		int current=0;
		int last=0;
		
		for(int i=0;i<line.length();i++)
		{
			for(int j=0;j<values.length;j++)
			{
				if(values[j].toString().compareTo(line.substring(i, i+1)) == 0)
				{
					current=values[j].weight;
					//System.out.println(current);
					
					if(last<current&&last!=0)//checking for extreme case
					{
						current-=last;	//Keeping track of the last digit
						arabic-=last;	
						arabic+=current;
						last=current;  //updates Last for next Iteration(memoization)
						current=0;
					}
					else
					{
						last=current;//update the last
						arabic+=current;//Updating the last
						current=0;
						
					}
				}
					
			}
		}
		System.out.print(arabic);
		
		return null;
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

		System.out.println("What would you like to convert:(a/b)\n\n"
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

