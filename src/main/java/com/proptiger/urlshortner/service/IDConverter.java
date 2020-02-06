package com.proptiger.urlshortner.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class IDConverter {
	static {
		initializeCharTable();
		initializeIndexTable();
	}
	// a->0
	private static HashMap<Character, Integer> charTable;
	// 0-->a
	private static List<Character> indexTable;

	private static   void initializeCharTable() {
		charTable = new HashMap<Character, Integer>();
		for (int i = 0; i < 26; ++i) {
			char c = 'a';
			c += i;
			charTable.put(c, i + 1);
		}
		for (int i = 26; i < 52; ++i) {
			char c = 'A';
			c += (i - 26);
			charTable.put(c, i + 1);
		}
		for (int i = 52; i < 62; ++i) {
			char c = '0';
			c += (i - 52);
			charTable.put(c, i + 1);
		}
	}

	private static void initializeIndexTable() {

		indexTable = new ArrayList<Character>();
		indexTable.add('#');
		for (int i = 0; i < 26; ++i) {
			char c = 'a';
			c += i;
			indexTable.add(c);
		}
		for (int i = 26; i < 52; ++i) {
			char c = 'A';
			c += (i - 26);
			indexTable.add(c);
		}
		for (int i = 52; i < 62; ++i) {
			char c = '0';
			c += (i - 52);
			indexTable.add(c);
		}
	}

	// get short_url from id after changing to base 63
	public static String createID(long id) {
		List<Integer> baseID = changeBaseID(id);
		StringBuilder uniqueID = new StringBuilder();
		for (int digit : baseID) {
			uniqueID.append(indexTable.get(digit));
		}
		return uniqueID.toString();

	}

	//Convert decimal to base 63
	private static List<Integer> changeBaseID(long id) {
		List<Integer> digits = new LinkedList<Integer>();
		while (id > 0) {
			int remainder = (int) (id % 63);
			((LinkedList<Integer>) digits).addFirst(remainder);
			id /= 63;
		}
		return digits;
	}
	
	/*
	 * public long getID(String uniqueID) { List<Character> changebaseIDs = new
	 * ArrayList<Character>(); for (int i = 0; i < uniqueID.length(); ++i) {
	 * changebaseIDs.add(uniqueID.charAt(i)); } // get value from id long Key =
	 * Rebase(changebaseIDs); return Key; }
	 * 
	 * // function to get value private long Rebase(List<Character> ids) { long id =
	 * 0l; for (int i = 0, exp = ids.size() - 1; i < ids.size(); ++i, --exp) { int
	 * base10 = charTable.get(ids.get(i)); id += (base10 * Math.pow(63.0, exp)); }
	 * return id;
	 * 
	 * }
	 */
	
	

}
