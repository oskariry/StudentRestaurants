package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

// Sodexo allergens
// G = Gluten free
// L = Lactose free
// M = Milkless
// VL = low-lactose


public class SodexoRestaurant extends Restaurant{

	
	SodexoRestaurant(String name, String url) {
		super(name, url);
	}
	
	public void getMenu(String urlSite) {
		URL url;
		try {
			url = new URL(urlSite);
			URLConnection conn = url.openConnection();
		    conn.setRequestProperty("User-Agent", "Mozilla/5.0");
			InputStreamReader input = new InputStreamReader(conn.getInputStream());
			BufferedReader reader = new BufferedReader(input);
			StringBuffer jsonText = new StringBuffer(readAll(reader));
			reader.close();
			JSONObject jObj = new JSONObject (jsonText.toString().trim());
			JSONArray menuArr = jObj.getJSONArray("mealdates");
			for (int i = 0; i < menuArr.length(); i++) {
				JSONObject dayObj = menuArr.getJSONObject(i);
				String day = dayObj.getString("date");
				JSONObject courses = dayObj.getJSONObject("courses");
				writeToArr(day, courses);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
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
	
	private void writeToArr(String day, JSONObject object) {
		String date = day.toLowerCase();
		switch(date) {
		
		case "maanantai":
			menuMon = addDish(object);
			break;
		case "tiistai":
			menuTue = addDish(object);
			break;
		case "keskiviikko":
			menuWed = addDish(object);
			break;
		case "torstai":
			menuThu = addDish(object);
			break;
		case "perjantai":
			menuFri = addDish(object);
			break;
		case "lauantai":
			menuSat = addDish(object);
			break;
		case "sunnuntai":
			menuSun = addDish(object);
			break;
		default:
			break;
		}
	}
	
	private static ArrayList<String> addDish(JSONObject object) {
		Integer index = 1;
		//System.out.println(price + "\n" + allergens + "\n" + dish + "\n" + title);
		ArrayList<String> dayMenu = new ArrayList<String>();
		while (!object.isNull(index.toString())) {
			String price = "Hinta: ";
			String allergens = "";
			String dish = "";
			String title = "";
			JSONObject meal = object.getJSONObject(index.toString());
			if (meal.isNull("price")) {
				price += "Ei saatavilla;";
			}else {
				price += meal.getString("price");
			}
			if (!meal.isNull("properties")) {
				allergens += meal.getString("properties");
			}
			if (meal.isNull("title_fi")) {
				dish += "Annosta ei saatavilla";
			}else {
				dish += meal.getString("title_fi");
			}
			if (meal.isNull("category")) {
				title += "Nimeä ei saatavilla";
			}else {
				title += meal.getString("category") + ";";
			}
			dayMenu.add(title + "\nHinta: " + price + ";\n" + dish + " (" + allergens + ")");
			index += 1;
		}
		return dayMenu;
	}
	
}
