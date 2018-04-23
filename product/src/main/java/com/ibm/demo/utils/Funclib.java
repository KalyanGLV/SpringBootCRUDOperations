package com.ibm.demo.utils;

import org.springframework.stereotype.Component;

/*
 * kg972t
 * 
 */

@Component
public class Funclib {

	public static String nullCheckAndSet(Object o) {

		return (!Funclib.isNothing(o) ? String.valueOf(o) : "");

	}

	public static boolean isNothing(Object o) {

		return (o == null);
	}
	
	public static boolean isAllTrue(boolean... check) {
		boolean res = false;
		for (boolean b : check) {
			if (b) {
				res = true;

			} else {
				res = false;
				break;
			}

		}
		return res;

	}

}
