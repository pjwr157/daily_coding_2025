package com.peisia.c.site.display;

import com.peisia.c.util.Cw;

public class DispSite {
	static private String SITE_NAME = "Peisia";
	static private String VERSION = " V 4";
	static public void entranceTitle() {
		Cw.line();
		Cw.dot();
		Cw.space(22);
		Cw.w(SITE_NAME);
		Cw.w(VERSION);
		Cw.space(22);
		Cw.dot();
		Cw.wn();
		Cw.line();
	}	
}
