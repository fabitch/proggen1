class Division{

	public static double getNumber(){

		double a;

		// repeating this loop until valid number has been provided
		do{
			try{
				String input = System.console().readLine("Provide a number: ");
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

	public static void main(String[] args){

		double a = 6;
		double b = 3;

		a = getNumber();
		b = getNumber();

		// it is enough to change the denumerator to NaN to get a NaN result in a division
		if (b == 0){
			b = Float.NaN;
		}

		System.out.println(a / b);
	}
}