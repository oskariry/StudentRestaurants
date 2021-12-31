package menu;

import java.util.ArrayList;

public abstract class Restaurant {

	String name;
	String urlSite;
	ArrayList<String> menuMon;
	ArrayList<String> menuTue;
	ArrayList<String> menuWed;
	ArrayList<String> menuThu;
	ArrayList<String> menuFri;
	ArrayList<String> menuSat;
	ArrayList<String> menuSun;
	
	Restaurant(String name, String url) {
		this.name = name;
		this.urlSite = url;
		this.menuMon = new ArrayList<String>();
		this.menuTue = new ArrayList<String>();
		this.menuWed = new ArrayList<String>();
		this.menuThu = new ArrayList<String>();
		this.menuFri = new ArrayList<String>();
		this.menuSat = new ArrayList<String>();
		this.menuSun = new ArrayList<String>();
	}
	
}
