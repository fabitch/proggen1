class Division{

	public static double getNumber(String inLineText){

		double a;

		// repeating this loop until valid number has been provided
		do{
			try{
				String input = System.console().readLine(inLineText);
				a = (double) Float.parseFloat(input);
					break;
			}
			catch(NumberFormatException e){
				// because the whole loop will be repeated a \n is not needed to go to new line
				System.out.println("That was not a number. Try Again."); 
				continue;
			}	
		} while (true);

		return a;
	}

	public static double DivideToNumbers(double numerator, double denumerator){
		if (denumerator == 0){
			return Float.NaN;
		}

		return numerator / denumerator;
	}

	public static void main(String[] args){

		double a = 6;
		double b = 3;

		a = getNumber("Provide a number: ");
		b = getNumber("Provide another number: ");

		double result = DivideToNumbers(a, b);
		System.out.println(result);
	}
}