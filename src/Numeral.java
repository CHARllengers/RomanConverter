import java.util.*;

public enum Numeral {
	
	I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);
	int weight;

	Numeral(int weight) {
		this.weight = weight;
	}

	//method to convert Arabic to Roman
	public static String roman(long n) {

		if( n <= 0) {
			throw new IllegalArgumentException();
		}

		StringBuilder buf = new StringBuilder();

		final Numeral[] values = Numeral.values();

		for (int i = values.length - 1; i >= 0; i--) {
			while (n >= values[i].weight) {
				buf.append(values[i]);
				n -= values[i].weight;
			}
		}
		System.out.println(buf.toString());
		return buf.toString();
		
	}
	static int count=0;
	
	//method to convert Roman to Arabic
	public static String arabic(String line){
		if( line==null) {
			throw new IllegalArgumentException();
		}

	

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
	}
	
	//prints Arabic
	public static void RomantoArabic(String n) {
		System.out.println(n + " = " + arabic(n));
	}
	
	//prints Roman
	public static void ArabictoRoman(long n) {
		System.out.println(n + " = " + roman(n));
	}

	public static void main(String[] args) {
		//TODO
		arabic("XLIV");
		System.out.println("");
	}

}

