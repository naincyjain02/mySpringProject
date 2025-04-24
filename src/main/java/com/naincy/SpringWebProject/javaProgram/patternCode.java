package com.naincy.SpringWebProject.javaProgram;

public class patternCode {
  public static void main(String[] args) {
	  int m=6;
	  int n=11;
	  for(int i=0;i<m;i++) {
		  for(int j=0;j<n;j++) {
			  if(i==0||i==(m-1)) {
				  System.out.print("* ");
			  }
			  else {
				  if(j==0||j==(n-1)) {
					  System.out.print("* ");
				  }
				  else {
					  if(j<=(n/2+1-i)-1)
						  System.out.print("  ");
					  else if(j>=(n/2+1+(2*i-1)/2)&& j<(n-1))
						  System.out.print("  ");
					  else
						  System.out.print("* ");
				  }
			  }
		  }
		  System.out.println();
	  }
	  int a=(m-2)*(m-2);
	   int b=a+2*m+2*(n-2);
	  System.out.println("Stars in Triangle are :"+a);
	  System.out.println("Stars in Rectangle are :"+b);
	  
  }
}

//Output
//* * * * * * * * * * * 
//*         *         * 
//*       * * *       * 
//*     * * * * *     * 
//*   * * * * * * *   * 
//* * * * * * * * * * * 
//Stars in Triangle are :16
//Stars in Rectangle are :46