package cs414.a4.phanisag.utils;

public class Utilities {

	
	public static String handleNullPointerException(String s){
		
		try{
		
		if(s ==null)
			s="";
		}catch(Exception e){
			s="";
		}
		
		return s;
	}
}
