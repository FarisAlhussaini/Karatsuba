import java.math.BigInteger;
import java.util.*;


/* Copyright © 2018. All rights reserved.
 * Any copyright violation would result in lawsuit.
 * Authors: Faris Alhussaini.
 */


	public class project {

	int[] arr1;
	int[] arr2;
	
	
	public BigInteger classical(int[] a, int[] b){
		BigInteger c = new BigInteger("0");
		BigInteger ten = new BigInteger("10");
		int alen = a.length-1;
		int blen = b.length-1;
		for(int i = 0; i<a.length; i++){
			BigInteger v = new BigInteger(String.valueOf(a[i]));
			BigInteger con = new BigInteger(String.valueOf((v.multiply(ten.pow(alen--)))));
			 blen = b.length-1;
				for(int j=0; j < b.length; j++){
					if(blen>=0){
				BigInteger d = new BigInteger(String.valueOf(b[j]));
				BigInteger con2 = new BigInteger(String.valueOf((d.multiply(ten.pow(blen--)))));
				BigInteger added = new BigInteger(String.valueOf(con2.multiply(con)));
				c=c.add(added); 
				}}
		}
								                            // A = A1A2,   B=B1B2, AxB = A1 * 10 power 2 * B2 .... etc
		
			return c;
	}
		public BigInteger recursiveTrace(int[]a, int[]b){
			
			BigInteger a1 = toBigInt(a);
			BigInteger b1 = toBigInt(b);
			
			return subrecursiveTrace(a1,b1);
		}
		public BigInteger subrecursiveTrace(BigInteger a, BigInteger b){
			if(a.toString().length() == 1 || b.toString().length() == 1)
				return a.multiply(b);
			
			String alen = a.toString();
			String blen = b.toString();
			int len = Math.max(alen.length(), blen.length());
			int nby2 = len /2;
			
			BigInteger afirstHalf = a.divide(BigInteger.TEN.pow(nby2));                   //A1
			BigInteger asecondHalf = a.mod(BigInteger.TEN.pow(nby2));						//A2
			BigInteger bfirstHalf = b.divide(BigInteger.TEN.pow(nby2));						//B1	
			BigInteger bsecondHalf = b.mod(BigInteger.TEN.pow(nby2));						//B2
			
			BigInteger a1plusa2 = afirstHalf.add(asecondHalf);						
			BigInteger b1plusb2 = bfirstHalf.add(bsecondHalf);
			
			System.out.println("A1: " + afirstHalf.toString());
			System.out.println("A2: " + asecondHalf.toString());
			System.out.println("B1: " + bfirstHalf.toString());
			System.out.println("B2: " + bsecondHalf.toString());
			

			BigInteger a1b1 = subrecursiveTrace(afirstHalf,bfirstHalf);	
			System.out.println("A1 * B1 = : " + a1b1.toString());

			BigInteger a2b2 = subrecursiveTrace(asecondHalf,bsecondHalf);
			System.out.println("A2 * B2 = : " + a2b2.toString());

			BigInteger a1b2plusb1a2 = subrecursiveTrace(a1plusa2, b1plusb2).subtract(a1b1).subtract(a2b2);		//middleTerm improvement
			System.out.println("(A1*B2) + (A2*B1) = : " + a1b2plusb1a2.toString());

			BigInteger res = a1b1.multiply(BigInteger.TEN.pow(2*nby2)).add(a1b2plusb1a2.multiply(BigInteger.TEN.pow(nby2))).add(a2b2);
			return res;
			}
		
		public BigInteger recursive(int[]a, int[]b){
			
			BigInteger a1 = toBigInt(a);
			BigInteger b1 = toBigInt(b);
			
			return subrecursive(a1,b1);
		}
		public BigInteger subrecursive(BigInteger a, BigInteger b){
			if(a.toString().length() == 1 || b.toString().length() == 1)
				return a.multiply(b);
			
			String alen = a.toString();
			String blen = b.toString();
			int len = Math.max(alen.length(), blen.length());
			int nby2 = len /2;
			
			BigInteger afirstHalf = a.divide(BigInteger.TEN.pow(nby2));                     //A1
			BigInteger asecondHalf = a.mod(BigInteger.TEN.pow(nby2));						//A2
			BigInteger bfirstHalf = b.divide(BigInteger.TEN.pow(nby2));						//B1	
			BigInteger bsecondHalf = b.mod(BigInteger.TEN.pow(nby2));						//B2
			
			BigInteger a1plusa2 = afirstHalf.add(asecondHalf);						
			BigInteger b1plusb2 = bfirstHalf.add(bsecondHalf);
			
		

			BigInteger a1b1 = subrecursive(afirstHalf,bfirstHalf);	

			BigInteger a2b2 = subrecursive(asecondHalf,bsecondHalf);

			BigInteger a1b2plusb1a2 = subrecursive(a1plusa2, b1plusb2).subtract(a1b1).subtract(a2b2);		//middleTerm improvement

			BigInteger res = a1b1.multiply(BigInteger.TEN.pow(2*nby2)).add(a1b2plusb1a2.multiply(BigInteger.TEN.pow(nby2))).add(a2b2);
			return res;
			}


		public BigInteger toBigInt(int[] a){                     //array converter
		BigInteger res = new BigInteger("0");
		int alen = a.length-1;
		for (int i = 0; i < a.length; i++){
			if (alen >=0)
		    res = res.add(BigInteger.TEN.pow(alen--).multiply(BigInteger.valueOf(a[i])));
		}
		return res;
		
		}

			
		
		

		
		

		public static void main(String[] args) {
	// TODO Auto-generated method stub
	project p = new project();
	int a[] = new int[] {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9};            //Sample inputs: //A1:1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9 //B1:9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1 //A2:1,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,9,3,2,1,0,0,0,0,0,0,0,0,0 //B2:1,2,3,4,5,6,7,8,9,0,0,0,0,0,0,0,0,0,1,1,1,1,2,2,2,3,6,5,4,7,8,9,9,9,0,0,0,0 //A3&B3:1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,1 //A4:1,1,2,3,4,5,6,7,8,9,4,5,6,1,2,3,4,5,3,2,1,1,2,3,4,5,9,8,7,0,0,1,2,3,2,0,1,2,0,1,2,3,1 //B4:3,1
	int b[] = new int[] {9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1};
	
	System.out.println(p.classical(a, b));
	System.out.println(p.recursive(a, b));		
	p.recursiveTrace(a, b);
	
}

}
		

		
		

		

