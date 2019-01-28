package TotallyMoney;
import java.io.File;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Utility {

	public static final List<String> weekDays = Arrays.asList(new DateFormatSymbols(new Locale("EN")).getShortWeekdays());
	
	public static Input readInput(String INPUT_FILE) throws Exception {
		Scanner sc = null;
        File inputFile = new File(INPUT_FILE);
        sc = new Scanner(inputFile);
        Input inp = new Input();
    	try{
    		//reading and checking inputs
    		for (int lineNum=2; sc.hasNext(); lineNum++) {
    			String line = sc.nextLine();
    			String[] userPreference = line.split("\\s+");
    			String customerId = userPreference[0];
    			String option = userPreference[1];
    			switch (option) {
				case "a":
					//I can choose only one integer from 1 to 28
					try {
						if (userPreference.length != 3){
							throw new Exception ("Input format not valid at line " + lineNum);
						}
						int day = Integer.valueOf(userPreference[2]);
						if(day < 1 || day > 28){
							throw new NumberFormatException();
						} else {
							//add the user to appropriate list
							inp.getSpecifiedDay().get(day).add(customerId);
						}
					} catch (NumberFormatException e){
		    			Exception ex = new Exception ("Number format error at line " + lineNum);
		        		throw ex;
					}
					break;
				case "b":
					//I can choose more strings from day of the week list
					if (userPreference.length < 3){
						throw new Exception ("Input format not valid at line " + lineNum);
					}
					for (int j = 2; j < userPreference.length; j++ ){
						String dayOfWeek = userPreference[j];
						if(!inp.getSpecifiedDayOfWeek().containsKey(dayOfWeek)){
							throw new Exception ("Invalid day of week at line " + lineNum);
						}
						//add the user to appropriate list
						inp.getSpecifiedDayOfWeek().get(dayOfWeek).add(customerId);
					}
					break;
				case "c":
					//Line must contain only id customer and chosen option
					if (userPreference.length > 2){
						throw new Exception ("Input format not valid at line " + lineNum);
					}
					//add the user to appropriate list
					inp.getEveryDay().add(customerId);
					break;
				case "d":
					//Line must contain only id customer and chosen option
					if (userPreference.length > 2){
						throw new Exception ("Input format not valid at line " + lineNum);
					}
					//add the user to appropriate list but I won't use it for this exercise
					inp.getNever().add(customerId);
					break;
				default:
					throw new Exception ("Chosen option not valid at line " + lineNum);
				}
    		}
    		
    	} catch (Exception e){
    		Exception ex = new Exception ("Error processing input file: " + e.getMessage());
    		sc.close();
    		throw ex;
    	}
    	return inp;
    }
}