public class ShowPointRangeForGrade {
	public static void main(String[] args) {

		int grade = 0;

		do{ 
			try{
				String userInput = System.console().readLine("What is your grade? ");
				float input = Float.parseFloat(userInput);
				if (input == 0){
					System.out.println("Zero is not allowed. Try again.");
				}
				else if (input < 10){
					grade = (int) (input * 10);
					break;
				}
				else if (input == 0){
					
				}
				else{
					grade = (int) input;
					break;
				}
				
			}catch(NumberFormatException e){
				System.out.println("That was not a number. Try again.");
				continue;
			}
		}while(true);


		switch(grade){
			case 10:
			System.out.println("38 40.0");
			break;
			case 13:
			System.out.println("36 37.5");
			break;
			case 17:
			System.out.println("34 35.5");
			break;
			case 20:
			System.out.println("32 33.5");
			break;
			case 23:
			System.out.println("30 31.5");
			break;
			case 27:
			System.out.println("28 29.5");
			break;
			case 30:
			System.out.println("26 27.5");
			break;
			case 33:
			System.out.println("24 25.5");
			break;
			case 37:
			System.out.println("22 23.5");
			break;
			case 40:
			System.out.println("20 21.5");
			break;
			case 50:
			System.out.println("00 19.5");
			break;
			default:
			System.out.println("Provided Grade is not in 10, 13, 17, 20, 23, 27, 30, 33, 37, 40, 50. Please select your grade.");
			break;
		}

	}
}