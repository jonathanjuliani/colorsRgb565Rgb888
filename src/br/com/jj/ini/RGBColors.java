package br.com.jj.ini;

import java.util.Scanner;

public class RGBColors {

	private static final String RGB565 = "RGB565";
	private static final String RGB888 = "RGB888";
	
	static String color = "";
	static String[] array;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {

			String rgbFormat = sc.nextLine();

			if (rgbFormat.equals("")) {
				break;
			}

			String color = sc.nextLine();
			String result = parseColor(rgbFormat, color);
			System.out.println(result);
		}

	}

	static String parseColor(String rgbFormat, String color) { 
		
		// Implementar aqui
		
		if( rgbFormat.equalsIgnoreCase( RGB565 ) ) {
			
			if( color.contains("0x") ) {
				
				return hexToDec565(color.toUpperCase());
				
			} else {
				
				return decToHex565(color.toUpperCase());
			}
			
		} else if ( rgbFormat.equalsIgnoreCase( RGB888 ) ) {
			
			if( color.contains("0x") ) {
				
				return hexToDec888(color.toUpperCase());
				
			} else {
				
				return decToHex888(color.toUpperCase());
			}

		}
		
		return null;
	}

	static String decToHex565(String param) {
		
		color = param;
		sb = new StringBuilder();
		
		array = color.split(" ");

		int r = Integer.parseInt(array[0]);
		int g = Integer.parseInt(array[1]);
		int b = Integer.parseInt(array[2]);

		String rS = Integer.toString(r, 2);
		String gS = Integer.toString(g, 2);
		String bS = Integer.toString(b, 2);

		if (rS.length() < 5) {
			rS = appendLeftZeros(rS, 5);
		}

		if (gS.length() < 5) {
			gS = appendLeftZeros(gS, 6);
		}

		if (bS.length() < 5) {
			bS = appendLeftZeros(bS, 5);
		}

		sb.append(rS);
		sb.append(gS);
		sb.append(bS);

		array = sb.toString().split("(?<=\\G.{8})");

		sb = new StringBuilder();
		sb.append("0x");

		for (String s : array) {
			int decimal = Integer.parseInt(s, 2);
			sb.append(decToHex(String.valueOf(decimal)));
		}
		
		return sb.toString();
	}

	static String hexToDec565(String param) {
		
		color = param;
		sb = new StringBuilder();
		
		color = color.substring(color.lastIndexOf("0x") + 2);
		array = color.split("(?<=\\G..)");

		for (String s : array) {
			String aux = hexToDec(s).trim();
			int n = Integer.parseInt(aux);
			s = Integer.toString(n, 2);
			sb.append(s);
		}

		String rgb = sb.toString();
		String r = rgb.substring(0, 5);
		String g = rgb.substring(5, 11);
		String b = rgb.substring(11, 16);

		sb = new StringBuilder();
		sb.append(Integer.parseInt(r, 2) + " ");
		sb.append(Integer.parseInt(g, 2) + " ");
		sb.append(Integer.parseInt(b, 2));
		
		return sb.toString();
	}

	static String appendLeftZeros(String param, int length) {

		String ret = ("000000" + param);
		ret = ret.substring(ret.length() - length, ret.length());
		return ret;
	}
	
	static String decToHex888(String param) {
		
		String color = param;
		String[] array;
		StringBuilder sb = new StringBuilder();
		
		array = color.split(" ");
		sb.append("0x");
		for (String s : array) {
			sb.append(decToHex(s));
		}
		
		return sb.toString();
	}

	static String hexToDec888(String param) {
		
		String color = param;
		String[] array;
		StringBuilder sb = new StringBuilder();
		
		color = color.substring(color.lastIndexOf("0x") + 2);
		array = color.split("(?<=\\G..)");
		for (String s : array) {
			sb.append(hexToDec(s));
		}
		
		return sb.toString();
	}

	static String hexToDec(String s) {
		return String.valueOf(Integer.parseInt(s, 16) + " ");
	}

	static String decToHex(String s) {
		return String.format("%02X", Integer.parseInt(s));
	}

}
