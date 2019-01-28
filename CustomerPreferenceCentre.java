package TotallyMoney;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomerPreferenceCentre {

	public static void main(String[] args) throws IOException {
        File outputFile = new File(Utility.OUTPUT_FILE);
        FileOutputStream fos = new FileOutputStream(outputFile);
        PrintWriter pw = new PrintWriter(fos);
        //string that will be printed as output
        String out = "";
    	try{
            Input input = Utility.readInput(Utility.INPUT_FILE);
    		Date currentDate = new Date();
    		Calendar c = Calendar.getInstance();
    		for(int i = 0; i < 90; i++){
    			//add one day
    			c.add(Calendar.DATE, 1);
    			currentDate = c.getTime();
    			out += Utility.outputFormat.format(currentDate);
    			//check people who chose option 'a' (one day of the month)
    			StringBuilder sb = new StringBuilder();
    			int day = c.get(Calendar.DAY_OF_MONTH);
    			ArrayList<String> usersDay = day <= 28 ? input.getSpecifiedDay().get(day) : new ArrayList<String>();
    			//check people who chose option 'b' (one day of the week)
    			String dayWeek = new SimpleDateFormat("EEE", new Locale("EN")).format(currentDate);
    			ArrayList<String> usersDayWeek = input.getSpecifiedDayOfWeek().get(dayWeek);
    			//check people who chose option 'c' (every day)
    			ArrayList<String> usersEveryDay = input.getEveryDay();
    			
    			//add list of customers to output line
    			for (String u : usersEveryDay) {
    			    sb.append(u).append(", ");
    			}
    			for (String u : usersDay) {
    			    sb.append(u).append(", ");
    			}
    			for (String u : usersDayWeek) {
    			    sb.append(u).append(", ");
    			}
    			out += " " + sb.toString().trim().replaceAll(",$", "") + "\n";
    		}
			pw.write(out);
    		pw.close();
    		fos.close();
    		
    	} catch (Exception e){
    		pw.write("Error during execution: " + e.getMessage());
    		pw.close();
    		fos.close();
    	}
    }
}