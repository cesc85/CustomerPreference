package TotallyMoney;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Input {
	
	//map containing users who chose a specified day of the month
	private Map<Integer, ArrayList<String>> specifiedDay;
	//map containing users who chose a specified day of the week
	private Map<String, ArrayList<String>> specifiedDayOfWeek;
	//list of users who are always available
	private ArrayList<String> everyDay;
	//list of users who are never available, we may not need to save this list I just use to verify input is correct
	private ArrayList<String> never;
	
	public Input(){
		//Inizialize all arraylists
		specifiedDay = new HashMap<Integer, ArrayList<String>>();
		for(int i = 1; i <= 28; i++){
			specifiedDay.put(i, new ArrayList<String>());
		}
		specifiedDayOfWeek = new HashMap<String, ArrayList<String>>();
		for(String d : Utility.weekDays){
			specifiedDayOfWeek.put(d, new ArrayList<String>());
		}
		everyDay = new ArrayList<String>();
		never = new ArrayList<String>();
	}
	
	public Map<Integer, ArrayList<String>> getSpecifiedDay() {
		return specifiedDay;
	}
	public void setSpecifiedDay(Map<Integer, ArrayList<String>> specifiedDay) {
		this.specifiedDay = specifiedDay;
	}
	public Map<String, ArrayList<String>> getSpecifiedDayOfWeek() {
		return specifiedDayOfWeek;
	}
	public void setSpecifiedDayOfWeek(
			Map<String, ArrayList<String>> specifiedDayOfWeek) {
		this.specifiedDayOfWeek = specifiedDayOfWeek;
	}
	public ArrayList<String> getEveryDay() {
		return everyDay;
	}
	public void setEveryDay(ArrayList<String> everyDay) {
		this.everyDay = everyDay;
	}
	public ArrayList<String> getNever() {
		return never;
	}
	public void setNever(ArrayList<String> never) {
		this.never = never;
	}

}
