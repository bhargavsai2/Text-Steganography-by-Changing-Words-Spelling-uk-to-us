import java.util.*;
import java.lang.*;
import java.io.*;
import java.security.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.util.Base64;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  


/* Name of the class has to be "Main" only if the class is public. */
public class test
{

  final static int NO_WORDS = 5;   
    final static int NO_SENTS = 20; 
    final static String SPACE = " ";    
    final static String PERIOD = ".";
    static Random r = new Random();
 /* private static String makeSentence(){
    Random rand = new Random();
    int[] index = new int[6];
    String sent = new String();
 
    for(int i=0;i<noun.length;i++){
         index[i]= rand.nextInt(5);
    }
    for(int i=0;i<6;i++){
    sent = article[i] + " " + noun[i] + " " + verb[i] + " " + preposition[i] + " " + article[i] + " " + noun[i];
    }
    return sent;
  }*/
    static int rand(){
        int ri = r.nextInt() % NO_WORDS;
        if ( ri < 0 )
            ri += NO_WORDS;
        return ri;
    }
    public static void main (String[] args) throws java.lang.Exception
       
    {
         //my test
     


        Scanner s=new Scanner(System.in);
        System.out.print("Enter the message: ");
        String str=s.nextLine();
        str=str.replaceAll(" ","").toLowerCase();
        System.out.println(str);
        str=str.replace("", " ").trim();
        //char[] strarr=str.toCharArray();
    //  String str1 = String.valueOf(strarr);
        

        System.out.println("your message :"+str);
    //  System.out.println(strarr.length);
        String[] strarr=str.split(" ");
 for(int i=0;i<strarr.length;i++)
  System.out.println(strarr[i]);
        

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
    String[] ukwords1={
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
"aeroplanes",
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
    String[] ukwords2={
        "backpedalled",
"backpedalling",
"bannister",
"bannisters",
"baptise",
"baptised",
"baptises",
"baptising",
"bastardise",
"bastardised",
"bastardises",
"bastardising",
"battleaxe",
"baulk",
"baulked",
"baulking",
"baulks",
"bedevilled",
"bedevilling",
"behaviour",
"behavioural",
"behaviourism",
"behaviourist",
"behaviourists",
"behaviours",
"behove"
    };
    String[] ukwords3={
        "caesarean",
"caesareans",
"calibre",
"calibres",
"calliper",
"callipers",
"callisthenics",
"canalise",
"canalised",
"canalises",
"canalising",
"cancellation",
"cancellations",
"cancelled",
"cancelling",
"candour",
"cannibalise",
"cannibalised",
"cannibalises",
"cannibalising",
"canonise",
"canonised",
"canonises",
"canonising",
"capitalise",
"capitalised"
    };
    //as replaceAll tends to some buggy situations better we use another Array of String and do it
    String ukwordsupper1[]=new String[ukwords1.length];
    String ukwordsupper2[]=new String[ukwords2.length];
    String ukwordsupper3[]=new String[ukwords3.length];
    for(int j=0;j<ukwords1.length;j++){
        ukwordsupper1[j]=ukwords1[j].toUpperCase();
        ukwordsupper2[j]=ukwords2[j].toUpperCase();
        ukwordsupper3[j]=ukwords3[j].toUpperCase();
        //System.out.println(ukwordsupper[j]+" ");
    }

        //finding all occurances of alphabets and change them to words
        
        for(int i=0;i<cover.length;i++){
   
          

               str=str.replace(cover[i],ukwordsupper1[i]);

        }

        str=str.toLowerCase();
        System.out.println(str);
    
       String[] temp=str.split(" ");
 /*for(int i=0;i<temp.length;i++)
  System.out.println("The"+" "+temp[i]+" "+"is something");
*/
String article[] = { "the", "a", "one", "some", "any" };
        String noun[] = { "boy", "girl", "dog", "town", "car" };
        String verb[] = { "drove", "jumped", "ran", "walked", "skipped" };
        String preposition[] = { "to", "from", "over", "under", "on" };

        String sentence,temporary="";
        for (int i = 0; i < temp.length; i++){
            sentence = article[rand()];
            char c = sentence.charAt(0);
            sentence = sentence.replace( c, Character.toUpperCase(c) );
            sentence += SPACE + temp[i] + SPACE;
            sentence += SPACE + noun[rand()] + SPACE;
            sentence += (verb[rand()] + SPACE + preposition[rand()]);
            sentence += (SPACE + article[rand()] + SPACE + noun[rand()]);
            sentence += PERIOD;
            temporary+=sentence+"\n";
            System.out.println(sentence);
            sentence = "";
        }  
        
    /* for(int i=2;i<cover.length;i+=3){
   
          

            str=str.replaceFirst(cover[i],ukwordsupper3[i]);
        
               

        }*/
            //for testing
        /*str=str.toLowerCase();
            System.out.println("Cover Text is: "+str+".");

            String[] replacesplit= str.split(" ");
*/
           
            //confirmation from user side base on alphabet map
       /*     try {
                File confirm = new File("confirm.txt");
                FileWriter f = new FileWriter(confirm);
        
         
        
          
            for(int i=0;i<strarr.length;i++){
                String steganotext="'"+strarr[i]+"'"+" "+"hidden in"+" "+"'"+replacesplit[i]+"'";
                //System.out.println(str1);
                System.out.println(steganotext);
               
                f.write(steganotext+"\n");

           // f.write("\n\n\n");
        
            
        } 
        
        f.flush();    
        f.close();
    }catch (IOException iox) {
            iox.printStackTrace();
}
*/


            //generating file
         try {
          
            File coverfile = new File("Covertext.txt");

            FileWriter fw = new FileWriter(coverfile);
         
            fw.write(temporary);
            fw.close();
            if(coverfile.exists()){
        System.out.println("Cover File Generated Sucessfully");
         }
        } catch (IOException iox) {
            iox.printStackTrace();
        }

/*
        //Encryption and decryption




        String plainText = str;
        SecretKey secKey = getSecretEncryptionKey();

        byte[] cipherText = encryptText(plainText, secKey);

        String decryptedText = decryptText(cipherText, secKey);

         

      //  System.out.println("Original Text:" + plainText);

        System.out.println("AES Key (Hex Form):"+bytesToHex(secKey.getEncoded()));

       // System.out.println("Encrypted Text (Hex Form):"+bytesToHex(cipherText));

       // System.out.println("Descrypted Text:"+decryptedText);

         String cipherstring=bytesToHex(cipherText); //i have stored in byte[] as it is unreadable



// creating the cipher file



            try {
          
            File cipherfile = new File("Cipherfile.txt");

            FileWriter fw = new FileWriter(cipherfile);
         
            fw.write(cipherstring);
            fw.close();
            if(cipherfile.exists()){
        System.out.println("CipherFile Generated Sucessfully");
         }
        } catch (IOException iox) {
            iox.printStackTrace();
        }



 // creating decipher file
 try {
          
            File decipherfile = new File("Decipherfile.txt");

            FileWriter fw = new FileWriter(decipherfile);
         
            fw.write(decryptedText);
            fw.close();
            if(decipherfile.exists()){
        System.out.println("DecipherFile Generated Sucessfully");
         }
        } catch (IOException iox) {
            iox.printStackTrace();
        }       

    }

    public static SecretKey getSecretEncryptionKey() throws Exception{

        KeyGenerator generator = KeyGenerator.getInstance("AES");

        generator.init(128); // The AES key size in number of bits

        SecretKey secKey = generator.generateKey();

        return secKey;

    }

    public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception{
        // AES defaults to AES/ECB/PKCS5Padding in Java 7

        Cipher aesCipher = Cipher.getInstance("AES");

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());

        return byteCipherText;

    }

    public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {

        // AES defaults to AES/ECB/PKCS5Padding in Java 7

        Cipher aesCipher = Cipher.getInstance("AES");

        aesCipher.init(Cipher.DECRYPT_MODE, secKey);

        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);

        return new String(bytePlainText);

    }

    private static String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);
    

    }*/
}
}