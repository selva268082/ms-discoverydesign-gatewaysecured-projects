package com.java.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListCollection_RemoveDuplicates {
	public static void main(String[] args) {
		
		// creating ArrayList with duplicate elements
		List<Integer> primes = new ArrayList<Integer>(); 
		primes.add(2); 
		primes.add(3);
		primes.add(5);
		primes.add(7); //duplicate 
		primes.add(7);
		primes.add(11);
		
		
		List primesLst = Arrays.asList("Selva","Murugan");
		
			
		
		//primes.stream().sorted(().forEach(l-> System.out.println(l);); 
			
		
		//primes.sort( p->  );

		Set<Integer> uniqueList=new LinkedHashSet<Integer>(primes); //Remove and keep the order
		primes.clear(); //clear the existing list of objects
		primes.addAll(uniqueList); //adding the removed duplicates list
		
        System.out.println("Removed duplicates list : :"+ primes);		
		
	}

}
