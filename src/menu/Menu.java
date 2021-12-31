package menu;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Menu {

	
	// sodexo kvarkki: "https://www.sodexo.fi/ruokalistat/rss/weekly_rss/86/fi"
	// sodexo valimo: "https://www.sodexo.fi/ruokalistat/rss/weekly_rss/86/fi"
	// fazer Ablock: "https://www.fazerfoodco.fi/modules/json/json/Index?costNumber=3087&language=fi"
	// fazer Dipoli: "https://www.fazerfoodco.fi/modules/json/json/Index?costNumber=3101&language=fi"
	// fazer Alvari: "https://www.fazerfoodco.fi/modules/json/json/Index?costNumber=0190&language=fi"
	// fazer TUAS: "https://www.fazerfoodco.fi/modules/json/json/Index?costNumber=0199&language=fi"
	// sodexo tietotekniikantalo: "https://www.sodexo.fi/ruokalistat/output/weekly_json/86"
	
	private static ArrayList<String> ablockMenu;
	private static ArrayList<String> dipoliMenu;
	private static ArrayList<String> alvariMenu;
	private static ArrayList<String> tuasMenu;
	private static ArrayList<String> kvarkkiMenu;
	private static ArrayList<String> valimoMenu;
	private static ArrayList<String> tietMenu;
	// index: 0 = lactose free, 1 = low lactose, 2 =  milkless, 3 = not contain allergens, 4 = vegan. If radiobutton is false then example lactose free is
	// char is '&'
	public static char[] userAllergens = {'&', '&', '&', '&', '&'};
	
		
		public static void main(String[] arg) throws IOException, ParseException {
			createRestaurants();	
		}
		
		/*
		 * Creates every restaurant and get weekly menu.
		 */
		public static  void createRestaurants() throws IOException, ParseException {
			FazerRestaurant aBlock = new FazerRestaurant("Fazer Ablock",  "https://www.fazerfoodco.fi/modules/json/json/Index?costNumber=3087&language=fi");
		    FazerRestaurant dipoli = new FazerRestaurant("Fazer Dipoli", "https://www.fazerfoodco.fi/modules/json/json/Index?costNumber=3101&language=fi");
			FazerRestaurant alvari = new FazerRestaurant("Fazer Alvari", "https://www.fazerfoodco.fi/modules/json/json/Index?costNumber=0190&language=fi");
			FazerRestaurant tuas = new FazerRestaurant("Fazer TUAS", "https://www.fazerfoodco.fi/modules/json/json/Index?costNumber=0199&language=fi");
			SodexoRestaurant kvarkki = new SodexoRestaurant("Sodexo Kvarkki", "https://www.sodexo.fi/ruokalistat/output/weekly_json/86");
			SodexoRestaurant valimo = new SodexoRestaurant("Sodexo Valimo", "https://www.sodexo.fi/ruokalistat/output/weekly_json/86");
			SodexoRestaurant tiet = new SodexoRestaurant("Sodexo Tietotekniikantalo", "https://www.sodexo.fi/ruokalistat/output/weekly_json/86");
		
			
			aBlock.getMenu(aBlock.urlSite);
			dipoli.getMenu(dipoli.urlSite);
			alvari.getMenu(alvari.urlSite);
			tuas.getMenu(tuas.urlSite);
			kvarkki.getMenu(kvarkki.urlSite);
			valimo.getMenu(valimo.urlSite);
			tiet.getMenu(tiet.urlSite);
			
			ArrayList<Restaurant> list = new ArrayList<Restaurant>();
			list.add(aBlock);
			list.add(dipoli);
			list.add(alvari);
			list.add(tuas);
			list.add(kvarkki);
			list.add(valimo);
			list.add(tiet);
			
			dayMenus(getCurrentDay(), list);
			
			// Test
			System.out.println(ablockMenu + "\n\n\n");
			addOrRemoveAllergen(0, 'L', true);
			updateMenus(aBlock, ablockMenu);
			System.out.println(ablockMenu);		
		}
		
		
		/*
		 * Get daliy menu
		 */
		public static void dayMenus(String day, ArrayList<Restaurant> resList) {
			for (int i = 0; i < resList.size(); i++) {
				switch(day.toLowerCase()) {
				case "maanantai":
					updateMenus(resList.get(i), resList.get(i).menuMon);
					break;
				case "tiistai":
					updateMenus(resList.get(i), resList.get(i).menuTue);
					break;
				case "keskiviikko":
					updateMenus(resList.get(i), resList.get(i).menuWed);
					break;
				case "torstai":
					updateMenus(resList.get(i), resList.get(i).menuThu);
					break;
				case "perjantai":
					updateMenus(resList.get(i), resList.get(i).menuFri);
					break;
				case "lauantai":
					updateMenus(resList.get(i), resList.get(i).menuSat);
					break;
				case "sunnuntai":
					updateMenus(resList.get(i), resList.get(i).menuSun);
					break;
				default:
					break;
				}
			}	
		}
		
		
		private static String getCurrentDay() {
			Date now = new Date();
	        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
	        return (simpleDateformat.format(now));
		}
		
		

		public static void updateMenus(Restaurant res, ArrayList<String> currentMenu) {
			ArrayList<String> menu = new ArrayList<String>();
			switch (res.name.toLowerCase()) {
			
			case "fazer ablock":
				menu = filtFazerMenu(currentMenu);
				ablockMenu = menu;
				break;
			case "fazer dipoli":
				menu = filtFazerMenu(currentMenu);
				dipoliMenu = menu;
				break;
			case "fazer tuas":
				menu = filtFazerMenu(currentMenu);
				tuasMenu = menu;
				break;
			case "fazer alvari":
				menu = filtFazerMenu(currentMenu);
				alvariMenu = menu;
				break;
			case "sodexo valimo":
				menu = filtSodexoMenu(currentMenu);
				valimoMenu = menu;
				break;
			case "sodexo kvarkki":
				menu = filtSodexoMenu(currentMenu);
				kvarkkiMenu = menu;
				break;
			case "sodexo Tietotekniikantalo":
				menu = filtSodexoMenu(currentMenu);
				tietMenu = menu;
				break;
			default:
				break;
			}
		}
		
		
		public static void addOrRemoveAllergen(int index, char allergen, Boolean val) {
			if (val) {
				userAllergens[index] = allergen;
			}else {
				userAllergens[index] = '&';
			}
		}
		
		
		// Korjaa. Tällähetkellä mikään menu ei mene koska annokset yksi annos yhdestä listasta saattaa siältää allergeenin.
		public static ArrayList<String> filtFazerMenu(ArrayList<String> menu) {
			ArrayList<String> filtered = new ArrayList<String>();
			for (int i = 1; i < menu.size(); i++) {
				String meal = menu.get(i);
				String filtName = meal.substring(takeWhile(meal, ';').length() + 1);
				String filtPrice = filtName.substring(takeWhile(filtName, ';').length() + 1);
				String dishAllergens = filtPrice.substring(takeWhile(filtPrice, '(').length());
				if (userAllergens[4] != '&') {
					if(dishAllergens.contains("Veg")) {
						filtered.add(meal);
					}
				}else {
					if (!containAlrg(dishAllergens)) {
						filtered.add(meal);
					}
				}
			}
			return filtered;
		}
		
		public static ArrayList<String> filtSodexoMenu(ArrayList<String> menu) {
			ArrayList<String> filtered = new ArrayList<String>();
			for (int i = 0; i < menu.size(); i++) {
				String meal = menu.get(i);
				if (userAllergens[4] != '&') {
					if (menu.get(i).contains("Vegan") || menu.get(i).contains("Veggie")) {
						filtered.add(meal);
					}
				}else {
					String filtName = meal.substring(takeWhile(meal, ';').length() + 1);
					String filtPrice = filtName.substring(takeWhile(filtName, ';').length() + 1);
					String dishAllergens = filtPrice.substring(takeWhile(filtPrice, '(').length());
					if (!containAlrg(dishAllergens)) {
						filtered.add(meal);
					}	
				}
			}
			return filtered;
		}
		
		private static String takeWhile(String meal, char mark) {
			String result = "";
			for (int j = 0; j < meal.length(); j++) {
				if (meal.charAt(j) != mark) {
					result += meal.charAt(j);
				}else {
					break;
				}
			}
			return result;
		}
		
		private static Boolean containAlrg(String mealAlrg) {
			Boolean contain = false;
			for (int k = 0; k < userAllergens.length; k++) {
				String allergen = "" + userAllergens[k];
				if (mealAlrg.contains(allergen)) {
					contain = true;
				}
			}
			return contain;
		}
		
}
