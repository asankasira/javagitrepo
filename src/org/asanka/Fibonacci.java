package org.asanka;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
//		System.out.println(getFibonacci(10));
		performanceTest(3, 24);
	}
	
	static long getFibonacci(int n){
		
		long f_p = 1;
		long f_pp = 0;
		
		long F_n = 0;
		
		if(n == 0 || n == 1)
			return n;
		else{
			
			for (int i = 2; i <= n; i++) {
				
				F_n = f_p + f_pp;
				
				f_pp = f_p;
				f_p = F_n;		
			}
			
			return F_n;
		}
	}
	
	static void performanceTest(int a, int n){
		getNthPower(a, n);
		System.out.println("\n----------------------------\n");
		getNthPowerWithArrays(a, n);
	}
	
	static void getNthPower(int a, int n){
		
		List<Boolean> hList = new ArrayList<Boolean>();
		long startUPNano = System.nanoTime();
		
		while (n > 1){		
			    boolean remainder = (n % 2 == 1);
				hList.add(remainder);
				n = n/2;
		}
		
		
		long result = a;
		
		for(int i = hList.size(); i > 0; i--){
			
			boolean remainder = hList.get(i-1);
			
			result =  remainder ? result * result * a : result * result; 
		}
		
		System.out.println("Result with ArrayList: "+ result);
		System.out.println("Elasped time in Nanos: " +(System.nanoTime() - startUPNano));
	}
	
    static void getNthPowerWithArrays(int a, int n){
		
    	int height = logOfBase(2, n);	
		boolean[] hArr = new boolean[height];
		long startUPNano = System.nanoTime();
	
		
		while (n > 1){		
			    boolean remainder = (n % 2 == 1);
				hArr[--height] = remainder;
				n = n/2;
		}
		
		long result = a;
		
		for(int i=0; i < hArr.length; i++){
			
			boolean remainder = hArr[i];		
			result =  remainder ? result * result * a : result * result; 
		}
		
		System.out.println("Results with Array: "+ result);
		System.out.println("Elasped time in Nanos: " +(System.nanoTime() - startUPNano));
	}
	
    static int logOfBase(int base, int power){
    	return (int)(Math.log10(power)/Math.log10(base));
    }
}