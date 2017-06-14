import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class test
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
		System.out.println("your message :"+str);
	//	System.out.println(strarr.length);
//	for(int i=0;i<strarr.length;i++)
//	System.out.println(strarr[i]);
		

		//every instance of the word is converted
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

//these are the words considered as cover message
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
"agonised"
		
	};
	//as replaceAll tends to some buggy situations better we use another Array of String and do it
	String ukwordsupper[]=new String[ukwords.length];
	for(int j=0;j<ukwords.length;j++){
		ukwordsupper[j]=ukwords[j].toUpperCase();
		//System.out.println(ukwordsupper[j]+" ");
	}

		//finding all occurances of alphabets and change them to words
		for(int i=0;i<cover.length;i++){
			str=str.replace(cover[i],ukwordsupper[i]);
		}
			//for testing
			System.out.println("Cover Text is: "+str+".");

			String[] replacesplit= str.split(" ");


			//conformation from user side base on alphabet map
			try {
				File confirm = new File("confirm.txt");
				FileWriter f = new FileWriter(confirm);
		
		
		
          
            for(int i=0;i<strarr.length;i++){
				String steganotext="'"+strarr[i]+"'"+" "+"hidden in"+" "+"'"+replacesplit[i]+"'";
				System.out.println(steganotext);
            f.write(steganotext+"\n");
           // f.write("\n\n\n");
        
			
        } 
        
        f.flush();    
       	f.close();
	}catch (IOException iox) {
            iox.printStackTrace();
}



			//generating file
			try {
          
            File coverfile = new File("Covertext.txt");

            FileWriter fw = new FileWriter(coverfile);
         
            fw.write(str+".");
            fw.close();
			if(coverfile.exists()){
    	System.out.println("File Generated Sucessfully");
   		 }
        } catch (IOException iox) {
            iox.printStackTrace();
        }


        //deciphering process continues here



	}
}