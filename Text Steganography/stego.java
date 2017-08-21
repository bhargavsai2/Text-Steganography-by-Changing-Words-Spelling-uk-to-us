import java.util.*;
import java.lang.*;
import java.io.*;
import java.security.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
//import java.util.Base64;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/* Name of the class has to be "Main" only if the class is public. */
public class stego extends JFrame implements ActionListener 
{
     private static final String NULL = null;
     final static int NO_WORDS = 5;   
    final static int NO_SENTS = 20; 
    final static String SPACE = " ";    
    final static String PERIOD = ".";
    static Random r = new Random();
    //String inpstr="bhargav";
    static String str="";
    JTextField t2;  JButton sender,receiver; JLabel lb;//lb1;
     public stego(){
    JFrame fr= new JFrame("Steganography");  
    
  /* lb=new JLabel("enter text to hide");
   lb.setBounds(50,20,100,30);
    t2=new JTextField();  
    
    
    t2.setBounds(50,50,200,30);  
    b=new JButton("Click Here");  
    b.setBounds(50,100,95,30);  
 
    //lb1.setBounds(50,100,200,30);
    fr.add(t2); fr.add(b);  fr.add(lb); //fr.add(lb1);
    fr.setSize(400,400);  
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.setLayout(null);  
    fr.setVisible(true);  
    b.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            try
            {
            str=t2.getText();
            steganography_and_encryption();
            JOptionPane.showMessageDialog(null, "Sucessfully completed\nFiles Generated Are:\n\tcovertext.txt\ncipherfile\ndecipherfile");
      //     
            //System.out.println(str);
            }
            catch(Exception e)
            {
            }
            
            
        }
    });*/
    sender=new JButton("Sender");  
    sender.setBounds(150,100,95,30); 
    receiver=new JButton("Receiver");
    receiver.setBounds(150,200,95,30);
    fr.add(sender);
    fr.add(receiver);
    fr.setSize(400,400);  
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.setLayout(null);  
    fr.setVisible(true); 
     sender.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
           JFrame panel=new JFrame();  
           JLabel lb=new JLabel("input file");
           lb.setBounds(50,20,100,30);
           panel.add(lb);
           panel.setSize(400,400);  
        
        panel.setLayout(null);  
        panel.setVisible(true); 
     
}
 
});

receiver.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent arg0) {
           JFrame panel1=new JFrame();  
           JLabel lb1=new JLabel("cover file");
           lb1.setBounds(50,20,100,30);
           panel1.add(lb);
           panel1.setSize(400,400);  
        
        panel1.setLayout(null);  
        panel1.setVisible(true);
        
}
 
});

 }          
public void actionPerformed(ActionEvent e){
     
    if(e.getSource()==sender){
    //   lb1.setText("*covertext");
   } 

}

public void steganography_and_encryption() throws Exception
{
     
     System.out.print("Enter the message: ");
    // String str=s.nextLine();
     str=str.replaceAll(" ","").toLowerCase();
     System.out.println(str);
     str=str.replace("", " ").trim();
     //char[] strarr=str.toCharArray();
 //  String str1 = String.valueOf(strarr);
     String[] strarr=str.split(" ");
     System.out.println("your message :"+str);
     
 //  System.out.println(strarr.length);
//for(int i=0;i<strarr.length;i++)
//System.out.println(strarr[i]);
     

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
"z",
"!",
"#",
"$",
"%",
"&",
"'",
"(",
")",
"*",
"+",
",",
"-",
".",
"/",
"0",
"1",
"2",
"3",
"4",
"5",
"6",
"7",
"8",
"9",
":",
";",
"<",
"=",
">",
"@",
"[",
"]",
"^",
"_",
"`",
"{",
"|",
"}",
"~"


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
"agonises",
"agonising",
"agonisingly",
"almanack",
"almanacks",
"aluminium",
"amortisable",
"amortisation",
"amortisations",
"amortise",
"amortised",
"amortises",
"amortising",
"amphitheatre",
"amphitheatres",
"anaemia",
"anaemic",
"anaesthesia",
"anaesthetic",
"anaesthetics",
"anaesthetise",
"anaesthetised",
"anaesthetises",
"anaesthetising",
"anaesthetist",
"anaesthetists",
"anaesthetize",
"anaesthetized",
"anaesthetizes",
"anaesthetizing",
"analogue",
"analogues",
"analyse",
"analysed",
"analyses",
"analysing",
"anglicise",
"anglicised",
"anglicises"
     
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
"behove",
"behoved",
"behoves",
"bejewelled",
"belabour",
"belaboured",
"belabouring",
"belabours",
"bevelled",
"bevvies",
"bevvy",
"biassed",
"biassing",
"bingeing",
"bougainvillaea",
"bougainvillaeas",
"bowdlerise",
"bowdlerised",
"bowdlerises",
"bowdlerising",
"breathalyse",
"breathalysed",
"breathalyser",
"breathalysers",
"breathalyses",
"breathalysing",
"brutalise",
"brutalised",
"brutalises",
"brutalising",
"buses",
"busing",
"caesarean",
"caesareans",
"calibre",
"calibres",
"calliper",
"callipers",
"callisthenics",
"canalise"
 }; 
 String[] ukwords3={
"decentralisation",
"decentralise",
"decentralised",
"decentralises",
"decentralising",
"decriminalisation",
"decriminalise",
"decriminalised",
"decriminalises",
"decriminalising",
"defence",
"defenceless",
"defences",
"dehumanisation",
"dehumanise",
"dehumanised",
"dehumanises",
"dehumanising",
"demeanour",
"demilitarisation",
"demilitarise",
"demilitarised",
"demilitarises",
"demilitarising",
"demobilisation",
"demobilise",
"demobilised",
"demobilises",
"demobilising",
"democratisation",
"democratise",
"democratised",
"democratises",
"democratising",
"demonise",
"demonised",
"demonises",
"demonising",
"demoralisation",
"demoralise",
"demoralised",
"demoralises",
"demoralising",
"denationalisation",
"denationalise",
"denationalised",
"denationalises",
"denationalising",
"deodorise",
"deodorised",
"deodorises",
"deodorising",
"depersonalise",
"depersonalised",
"depersonalises",
"depersonalising",
"deputise",
"deputised",
"deputises",
"deputising",
"desensitisation",
"desensitise",
"desensitised",
"desensitises",
"desensitising"

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
       /* for(int i=1;i<cover.length;i+=2){
   
          

            str=str.replace(cover[i],ukwordsupper2[i]);
        
               

        }
         for(int i=2;i<cover.length;i+=3){
   
          

            str=str.replace(cover[i],ukwordsupper3[i]);
        
               

        }*/
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

    String[] temp=str.split(" ");
    String article[] = { "the", "a", "one", "some", "any" };
        String noun[] = { "boy", "girl", "dog", "cat", "rat" };
        String verb[] = { "drove", "jumped", "ran", "walked", "skipped" };
        String preposition[] = { "to", "from", "over", "under", "on" };

        String sentence,temporary="";
        for (int i = 0; i < temp.length; i++){
            sentence = article[rand()];
            char c = sentence.charAt(0);
            sentence = sentence.replace( c, Character.toUpperCase(c) );
            //sentence += SPACE + temp[i] + SPACE;
            sentence += SPACE + noun[rand()] + SPACE;
            sentence += (verb[rand()] + SPACE + preposition[rand()]);
            sentence += (SPACE + article[rand()] + SPACE + temp[i] + SPACE + noun[rand()]);
            sentence += PERIOD;
            temporary+=sentence+"\n";
            System.out.println(sentence);
            sentence = "";
        } 
         



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



//creating the cipher file



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


    public static void main (String[] args) throws Exception
       
    {
         //my test
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    stego frame = new stego();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    



        //Scanner s=new Scanner(System.in);
        //System.out.print("Enter the message: ");
//  String str=t.str;//s.nextLine();
        //ends here
        //Scanner s=new Scanner(System.in);
          

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
   public static int rand(){
        int ri = r.nextInt() % NO_WORDS;
        if ( ri < 0 )
            ri += NO_WORDS;
        return ri;
    }
}