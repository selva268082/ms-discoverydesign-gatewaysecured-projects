package com.java.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCollection_ConcurrentModification {
	
	public static void main(String[] args) {
		
		List<String> lstStr= new ArrayList<String>();
		lstStr.add("Selva");
		lstStr.add("Pandy");
		lstStr.add("Senthil");
		lstStr.add("Kumar");
		
		System.out.println("Before 1st Remove :: " + lstStr);
		lstStr.remove(3);
		
		Iterator<String> itr=lstStr.iterator();
		
		while(itr.hasNext()) {
			
			String str=itr.next();
			
			if(str.equalsIgnoreCase("Senthil"))
			{
				//lstStr.remove("Senthil");  //Exception in thread "main" java.util.ConcurrentModificationException
				itr.remove(); // remove
			}
			
			
		}
		
		System.out.println("Before 2st Remove :: " + lstStr);
		
		
	}

}
