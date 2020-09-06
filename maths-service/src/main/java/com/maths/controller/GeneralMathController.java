package com.maths.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("v1")
public class GeneralMathController {
	
	
	//2,3,5,7,13..
	@GetMapping("v1/prime/{number}")
	public ResponseEntity<Boolean> primeCheck(@PathVariable String number){
		int num=Integer.parseInt(number);
		boolean isPrime=true;
		for(int i=2; i<=num/2 ;i++) {
			if(num % 2==0)
			{
				isPrime= false;
				break;
			}
		}
		
		return ResponseEntity.ok().body(isPrime);
	}
	
	
	//5! = 5*4*3*2*1=120
	@GetMapping("v1/factorial/{number}")
	public ResponseEntity<Integer> factorialCheck(@PathVariable String number){
		int num=Integer.parseInt(number);
 
		int fact=1;
		for(int i=num; i>=1 ;i--) {
		 fact= fact*i;
		}
		
		return ResponseEntity.ok().body(Integer.valueOf(fact));
	}
	
	//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
	@GetMapping("v1/fibbanocci/{number}")	
	public ResponseEntity<List> fibbonacciCheck(@PathVariable String number){
		int num=Integer.parseInt(number);
        List<Integer> ls=new ArrayList<Integer>();
		
		
	    int a=0;
	    int b=1;
	    
	   for(int i=0;i<=num;i++) { 
	    ls.add(b);
	    int c=a+b;
	    a=b;
	    b=c;
	   }
		
		return ResponseEntity.ok().body(ls);
	}
	
	
	//371 = 3*3*3 + 7*7*7 + 1*1*1 =371
	@GetMapping("v1/armstrong/{number}")	
	public ResponseEntity<String> armstrongCheck(@PathVariable String number){
		int num=Integer.parseInt(number);
        
		int original_number=num;
		
		int length = String.valueOf(number).length();
				
	    Double output = 0.0;
		
		while(num >0) {
			int rem=num%10;
			num=num/10;
			output=output+Math.pow(rem, length);
						
		}
		String res=""; 
		if(original_number == output)
		{
			res="Armstrong number !";
			System.out.println(original_number+ "Is Armstrong number" );
		}else {
			res="Not Armstrong Number !";
			System.out.println(original_number+ "Is not an Armstrong number" );
		}
		
		return ResponseEntity.ok().body(res);
	}
	
}
