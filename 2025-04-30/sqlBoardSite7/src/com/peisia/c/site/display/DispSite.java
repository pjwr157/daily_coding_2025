package com.peisia.c.site.display;

import com.peisia.c.util.Cw;

public class DispSite {
	static private String SITE_NAME = "Peisia";
	static private String VERSION = " v0.0.7";
	static private String FEAT = " sm.ahn";
	static public void entranceTitle() {
		Cw.line();
		Cw.dot();
		Cw.space(22);
		Cw.w(SITE_NAME);
		Cw.w(VERSION);
		Cw.w(FEAT);
		Cw.space(22);
		Cw.dot();
		Cw.wn();
		Cw.line();
	}	
}
