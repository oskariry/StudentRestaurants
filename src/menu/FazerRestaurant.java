package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.*;

//Fazer allergens
//G = Gluten free
//L = Lactose free
//VL = Low-lactose
//M = Milkless
//* = Feel well
//Veg = Vegan
//VS = Contains fresh garlic
//A = Contains allergens

// Korjaa iskee errorin
public class FazerRestaurant extends Restaurant{
	
	
	FazerRestaurant(String name, String url) {
		super(name, url);
	}
	
	/*
	public static void main(String[] arg) {
		FazerRestaurant res = new FazerRestaurant("kK", "https://www.fazerfoodco.fi/modules/json/json/Index?costNumber=0199&language=fi");
		res.getMenu(res.urlSite);
		System.out.println(res.menuMon);
	}
	*/
	
	
	public void getMenu(String urlSite) {
		URL url;
		try {
			url = new URL(urlSite);
			URLConnection conn = url.openConnection();
		    conn.setRequestProperty("User-Agent", "Mozilla/5.0");
			InputStreamReader input = new InputStreamReader(url.openStream());
			BufferedReader reader = new BufferedReader(input);
			StringBuffer jsonText = new StringBuffer(readAll(reader));
			reader.close();
			JSONObject jObj = new JSONObject (jsonText.toString().trim());
			JSONArray menuArr = jObj.getJSONArray("MenusForDays");
			for (int i = 0; i < menuArr.length(); i++) {
				JSONObject dayObj = menuArr.getJSONObject(i);
				String day = dayObj.getString("Date").substring(0, 10);
				String lunchTime = "";
				if (dayObj.isNull("LunchTime")) {
					lunchTime = "Aukioloaikaa ei ole saatavilla";
				}else {
					lunchTime = dayObj.getString("LunchTime").toString();
				}
				JSONArray dishArr = dayObj.getJSONArray("SetMenus");
				writeToArr(day, lunchTime, dishArr);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static StringBuffer readAll(BufferedReader reader) throws IOException {
		StringBuffer result = new StringBuffer();
		String line = reader.readLine();
		while (line != null) {
			result.append(line);
			line = reader.readLine();
		}
		return result;
	}
	
	
	private void writeToArr(String date, String time, JSONArray arr) throws ParseException {
		 SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		 String day = form.parse(date).toString().substring(0, 3).toLowerCase();
		 ArrayList<String> info = new ArrayList<String>();
		 switch (day) {
		 
		 case "mon":
			 info.add(time);
			 addDish(arr, info);
			 menuMon = info;
			 break;
		 case "tue":
			 info.add(time);
			 addDish(arr, info);
			 menuTue = info;
			 break;
		 case "wed":
			 info.add(time);
			 addDish(arr, info);
			 menuWed = info;
			 break;
		 case "thu":
			 info.add(time);
			 addDish(arr, info);
			 menuThu = info;
			 break;
		 case "fri":
			 info.add(time);
			 addDish(arr, info);
			 menuFri = info;
			 break;
		 case "sat":
			 info.add(time);
			 addDish(arr, info);
			 menuSat = info;
			 break;
		 case "sun":
			 info.add(time);
			 addDish(arr, info);
			 menuSun = info;
			 break;
		default:
			break;
		 }
	}
	
	private static void addDish(JSONArray arr, ArrayList<String> list) {
		 String dish = "";
		 for (int i = 0; i < arr.length(); i++) {
			 JSONObject dishObj = arr.getJSONObject(i);
			 if (dishObj.isNull("Name")) {
				 dish += "Annoksen nimeä ei saatavilla;\n";
			 }else {
				 dish += dishObj.getString("Name") + ";\n";
			 }
			 if (dishObj.isNull("Price")) {
				 dish += "Hinta: Ei saatavilla;\n";
			 }else {
				 dish +=  "Hinta: " + dishObj.getString("Price") + ";\n"; 
			 }
			 JSONArray mealList = dishObj.getJSONArray("Components");
			 for (int j = 0; j < mealList.length(); j++) {
				 dish += mealList.get(j) + ",\n"; 
			 }
			 list.add(dish);
			 dish = "";
		 }
	}
	
	
}
