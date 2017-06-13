import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the message: ");
		String str=s.nextLine();
		str=str.replaceAll(" ","").toLowerCase();
		System.out.println(str);
		str=str.replace("", " ").trim();
		//char[] strarr=str.toCharArray();
	//	String str1 = String.valueOf(strarr);
		String[] strarr=str.split(" ");
		System.out.println(str);
	//	System.out.println(strarr.length);
//	for(int i=0;i<strarr.length;i++)
//	System.out.println(strarr[i]);
		String[] cover={
"a",
"b",
"c",
"d",
"e",
"f",
"g",
"h",
"i",
"j",
"k",
"l",
"m",
"n",
"o",
"p",
"q",
"r",
"s",
"t",
"u",
"v",
"w",
"x",
"y",
"z"
		};
	String[] ukwords={
		"accessorise",
"accessorised",
"accessorises",
"accessorising",
"acclimatisation",
"acclimatise",
"acclimatised",
"acclimatises",
"acclimatising",
"accoutrements",
"aeon",
"aeons",
"aerogramme",
"aerogrammes",
"aeroplane",
"aeroplanes ",
"aesthete",
"aesthetes",
"aesthetic",
"aesthetically",
"aesthetics",
"aetiology",
"ageing",
"aggrandisement",
"agonise",
"agonised",
		
	};
		//for(int i=0;i<=26;i++){
			str=str.replaceAll("h","accessorise");
		//}
	}
}