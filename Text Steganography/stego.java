
/**
 * text Stego
 * 
 * @author bhargav 
 * @version 1.0
 */
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


/* Name of the class has to be "Main" only if the class is public. */
public class stego extends JFrame implements ActionListener
{
    private String inpstr;
  
    JTextField t2;  JButton b; JLabel lb;
      test(){
    JFrame fr= new JFrame("Steganography");  
    
   lb=new JLabel("enter text to hide");
   lb.setBounds(50,20,100,30);
    t2=new JTextField();  
    t2.setBounds(50,50,200,30);  
    b=new JButton("Click Here");  
    b.setBounds(50,100,95,30);  
    fr.add(t2); fr.add(b);  fr.add(lb);
    fr.setSize(400,400);  
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.setLayout(null);  
    fr.setVisible(true);  
}
public void actionPerformed(ActionEvent e){
     
    if(e.getSource()==b){
        String inpstr=t2.getText(); 
   } 

}

	public static void main (String[] args) throws java.lang.Exception
	   
	{
         //my test
        test t=new test();



		//Scanner s=new Scanner(System.in);
		//System.out.print("Enter the message: ");
		String str=t.inpstr;//s.nextLine();
        //ends here
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the message: ");
        String str=s.nextLine();
        str=str.replaceAll(" ","").toLowerCase();
        System.out.println(str);
        str=str.replace("", " ").trim();
        //char[] strarr=str.toCharArray();
    //  String str1 = String.valueOf(strarr);
        String[] strarr=str.split(" ");
        System.out.println("your message :"+str);
    //  System.out.println(strarr.length);
//  for(int i=0;i<strarr.length;i++)
//  System.out.println(strarr[i]);
        

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
        str=str.toLowerCase();
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
        System.out.println("Cover File Generated Sucessfully");
         }
        } catch (IOException iox) {
            iox.printStackTrace();
        }


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
          
            File decipherfile = new     File("Decipherfile.txt");

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
    

    }
}
