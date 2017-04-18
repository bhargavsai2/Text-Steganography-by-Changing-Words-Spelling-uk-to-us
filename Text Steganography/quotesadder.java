import java.util.*;
import java.lang.*;
import java.io.*;


class quotesadder
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sr=new Scanner(System.in);
		int n=1737;
		String s[]=new String[n];
		
		for(int i=0;i<n;i++){
			s[i]=sr.nextLine();
		}
		for(int i=0;i<n;i++){
			System.out.println('"'+s[i]+'"'+",");
		}
		
	}
}