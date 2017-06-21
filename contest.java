import java.util.*;
import java.lang.*;
import java.io.*;
public class contest{
	public static int flipping(String bits,int l1,int l2){
	//	String[] arr1=bits.split(" ");
		int count=0;
		bits=bits.replace("", " ").trim();
		String[] arr1=bits.split(" ");
		System.out.println(arr1);
	for(int i=0;i<arr1.length;i++)
		System.out.print(arr1[i]+" ");
//	System.out.println(arr1[0]);
System.out.println("");
	String[] arr2=bits.split(" ");
	for(int i=0;i<=l1;i++){

		arr1[i]=arr1[i].replaceAll("0","x");
		arr1[i]=arr1[i].replaceAll("1","0");
		arr1[i]=arr1[i].replaceAll("x","1");
	}
	

StringBuilder st = new StringBuilder();
for (int i = 0; i < arr1.length; i++) {
   st.append(arr1[i]);
}
String newString = st.toString();
//System.out.println(newString);
newString=newString.replaceAll(""," ").trim();
String[] arrstr=newString.split(" ");

for(int i=0;i<arrstr.length;i++)
	System.out.print(arrstr[i]+" ");

	for(int j=0;j<=l2;j++){

		arrstr[j]=arrstr[j].replaceAll("0","x");
		arrstr[j]=arrstr[j].replaceAll("1","0");
		arrstr[j]=arrstr[j].replaceAll("x","1");
	}
	System.out.println("");

for(int i=0;i<arrstr.length;i++)
	System.out.print(arrstr[i]+" ");

for(int k=0;k<=arr1.length;k++){
	if(arr1[k]==arrstr[k])
		count++;
}
System.out.println("");
System.out.println(count);
		return 0;

	}
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		String bits =s.nextLine().trim();
		int l1=Integer.parseInt(s.next());
		int l2=Integer.parseInt(s.next());
	 flipping(bits,l1,l2);
		


	}
}

