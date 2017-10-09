
/**
 * Write a description of stego here.
 * 
 * @author bhargav
 * @version 2.0 19-09-2017
 */

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.*;
import java.lang.*;
import java.lang.StringBuilder;
import java.lang.StringBuffer;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
//import java.util.Base64;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;
import javax.xml.bind.DatatypeConverter;

/* Name of the class has to be "Main" only if the class is public. */
public class stego extends JFrame implements ActionListener {
    private static final String NULL = null;
    final static int NO_WORDS = 5;
    final static int NO_SENTS = 20;
    final static String SPACE = " ";
    final static String PERIOD = ".";
    File file=null;
    File file1=null;
    static Random r = new Random();
    // String inpstr="bhargav";
    private static String str = "";
    private static String strtemp = "";
    private static String filename1 = "";
    private static String filename2 = "";
    //final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    final JFileChooser fc1 = new JFileChooser("F:/java projects/steganography");
    final JFileChooser fc2 = new JFileChooser("F:/java projects/steganography");
    JTextField t2;
    JButton sender, receiver, jb1, jb2, jb3, jb4, run1, run2;
    JLabel lb,heading;

    public stego() {
        JFrame fr = new JFrame("Steganography");
        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png"); 
        fr.setIconImage(icon);  
        try {
            fr.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("background.jpg")))));
        } catch (IOException n) {
            n.printStackTrace();
        }
        /*
         * lb=new JLabel("enter text to hide"); lb.setBounds(50,20,100,30);
         * t2=new JTextField();
         * 
         * 
         * t2.setBounds(50,50,200,30); b=new JButton("Click Here");
         * b.setBounds(50,100,95,30);
         * 
         * //lb1.setBounds(50,100,200,30); fr.add(t2); fr.add(b); fr.add(lb);
         * //fr.add(lb1); fr.setSize(400,400);
         * fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         * fr.setLayout(null); fr.setVisible(true); b.addActionListener(new
         * ActionListener() {
         * 
         * @Override public void actionPerformed(ActionEvent arg0) { // TODO
         * Auto-generated method stub try { str=t2.getText();
         * steganography_and_encryption(); JOptionPane.showMessageDialog(null,
         * "Sucessfully completed\nFiles Generated Are:\n\tcovertext.txt\ncipherfile\ndecipherfile"
         * ); // //System.out.println(str); } catch(Exception e) { }
         * 
         * 
         * } });
         */
        heading = new JLabel("Text Steganography tool");
        heading.setBounds(130, 20, 150, 30);
        heading.setFont(new Font("Serif", Font.BOLD, 14));
        heading.setForeground(Color.RED);
        sender = new JButton("Sender");
        sender.setBounds(150, 100, 95, 30);
        sender.setBackground(Color.GREEN);
        receiver = new JButton("Receiver");
        receiver.setBounds(150, 200, 95, 30);
        receiver.setBackground(Color.YELLOW);
        fr.add(heading);
        fr.add(sender);
        fr.add(receiver);
        fr.setSize(400, 400);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLayout(null);
        fr.setVisible(true);
        sender.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                JFrame panel = new JFrame("Encode");
                Image icon = Toolkit.getDefaultToolkit().getImage("icon.png"); 
                panel.setIconImage(icon);  
                 try {
                     panel.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("background.jpg")))));
                    } catch (IOException n) {
                        n.printStackTrace();
                    }   
                JLabel lb = new JLabel("input file !!!!!!");
                lb.setBounds(50, 20, 100, 30);
                lb.setFont(new Font("Serif", Font.BOLD, 14));
                lb.setForeground(Color.RED);
                final JTextField tf = new JTextField(20);
                tf.setBounds(50, 50, 300, 20);

                jb1 = new JButton("RESET");
                jb1.setBounds(50, 80, 100, 25);
                jb1.setBackground(Color.YELLOW);

                jb2 = new JButton("Browse");
                jb2.setBounds(200, 80, 100, 25);
                jb2.setBackground(Color.GREEN);
                
                run1 = new JButton("RUN");
                run1.setBounds(125, 150, 100, 25);
                run1.setBackground(Color.BLUE);
                
                // tf.setB
                panel.add(lb);
                panel.add(tf);
                panel.add(jb1);
                panel.add(jb2);
                panel.add(run1);
                panel.setSize(400, 400);

                panel.setLayout(null);
                panel.setVisible(true);
                jb1.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                            tf.setText("");
                    }
                });

                jb2.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        //System.out.println("hghghghg");
                         try
                         {
                             int returnVal = fc1.showOpenDialog(stego.this);
                             

                             if (returnVal == JFileChooser.APPROVE_OPTION) {
                                  file = fc1.getSelectedFile();
                                 //This is where a real application would open the file.
                                 tf.setText(file.getName());
                                filename1=file.getName();
                                
                            }
                            
                             /*BufferedReader in = new BufferedReader(new FileReader(file));
                            // if(in.readLine() == null){
                           //  JOptionPane.showMessageDialog(null, "File is empty!!! choose another");
                          /// }
                            // else {
                             String line = in.readLine();
                             if(line != null){
                             while(line != null){
                                 str += line;
                                 line = in.readLine();
                                }
                             //str=file.toString();
                            System.out.println(str);
                             steganography_and_encryption(str);
                             
                             JOptionPane.showMessageDialog(null, "Sucessfully completed\nFiles Generated Are:\n\tcovertext.txt\ncipherfile.txt\nconfirm.txt");
                            }
                          else
                            JOptionPane.showMessageDialog(null, "File is empty!!! choose another");
                             //     
                                //System.out.println(str);*/
                    }
                    catch(Exception ex)
                    {
                    }
                      /*  JOptionPane.showMessageDialog(null,
                                "This language just gets better and better!");*/
                    }
                });
                run1.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                            if(filename1!=NULL){
                                    try
                                    {
                                        
                                        BufferedReader in = new BufferedReader(new FileReader(file));
                                        // if(in.readLine() == null){
                                //  JOptionPane.showMessageDialog(null, "File is empty!!! choose another");
                                        /// }
                                        
                                            String line = in.readLine();
                                            if(line != null){
                                                while(line != null){
                                                    str += line;
                                                    line = in.readLine();
                                                }
                                                //str=file.toString();
                                                System.out.println(str);
                                                steganography_and_encryption(str);
                             
                                                JOptionPane.showMessageDialog(null, "Sucessfully completed\nFiles Generated Are:\n\tcovertext.txt\ncipherfile.txt\nconfirm.txt");
                                            }
                                            else
                                            JOptionPane.showMessageDialog(null, "File is empty!!! choose another");
                             //     
                                //System.out.println(str);
                            }
                            catch(Exception ex)
                            {
                            }
                            
                           }
                           else
                        JOptionPane.showMessageDialog(null, "Choose a file inorder to encode!");
                    
                           
                    }
                    
               });
            }
            

        });

        receiver.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg1) {
                JFrame panel1 = new JFrame("Decode");
                Image icon = Toolkit.getDefaultToolkit().getImage("icon.png"); 
                panel1.setIconImage(icon);  
                 try {
                     panel1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("background.jpg")))));
                    } catch (IOException n) {
                        n.printStackTrace();
                    }
                JLabel lb1 = new JLabel("Cover Text....!!!");
                lb1.setBounds(50, 20, 100, 30);
                lb1.setFont(new Font("Serif", Font.BOLD, 14));
                lb1.setForeground(Color.RED);
                final JTextField tf1 = new JTextField(20);
                tf1.setBounds(50, 50, 300, 20);
                jb3 = new JButton("RESET");
                jb3.setBounds(50, 80, 100, 25);
                jb3.setBackground(Color.YELLOW);
                jb4 = new JButton("Browse");
                jb4.setBounds(200, 80, 100, 25);
                jb4.setBackground(Color.GREEN);
                run2 = new JButton("RUN");
                run2.setBounds(125, 150, 100, 25);
                run2.setBackground(Color.BLUE);
                // tf.setB

                panel1.add(tf1);
                panel1.add(jb3);
                panel1.add(jb4);
                panel1.add(run2);
                panel1.setSize(400, 400);
                panel1.add(lb1);
                panel1.setSize(400, 400);

                panel1.setLayout(null);
                panel1.setVisible(true);
                //strtemp=str;
                jb3.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        tf1.setText("");
                    }
                });

                jb4.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                         try
                         {
                            
                             //still to do  
                             int returnVal1 = fc2.showOpenDialog(stego.this);

                             if (returnVal1 == JFileChooser.APPROVE_OPTION) {
                                  file1 = fc2.getSelectedFile();
                                 //This is where a real application would open the file.
                                  tf1.setText(file1.getName());
                                filename2=file1.getName();
                             }

                             /* BufferedReader in = new BufferedReader(new FileReader(file));
                              
                             String line = in.readLine();
                             if(line != null){
                             while(line != null){
                                 strtemp += line;
                                 line = in.readLine();
                                }
                               // strtemp=strtemp.replace("", " ").trim();
                            // strtemp=file1.toString();
                             //           steganography_and_encryption(str);
                              //System.out.println(str);
                            // JOptionPane.showMessageDialog(null, "Sucessfully completed\nFiles Generated Are:\n\tcovertext.txt\ncipherfile\ndecipherfile");
                                   
                               System.out.println("decoding starts here");
                                decrypt_and_decode(strtemp);
                                JOptionPane.showMessageDialog(null, "Message is in Originalfile!");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "File is empty!!! choose another");
                            }
                                //JOptionPane.showMessageDialog(null,"This language just gets better and better!");*/
                                 }
                    catch(Exception ex)
                    {
                    }
                    }
                });
                
                run2.addActionListener(new ActionListener() {
                    
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                            if(filename2!=NULL){
                                    try
                                    {
                                        
                                        BufferedReader in = new BufferedReader(new FileReader(file));
                                        // if(in.readLine() == null){
                                //  JOptionPane.showMessageDialog(null, "File is empty!!! choose another");
                                        /// }
                                        
                                            String line = in.readLine();
                                            if(line != null){
                                                while(line != null){
                                                    str += line;
                                                    line = in.readLine();
                                                }
                                                //str=file.toString();
                                               System.out.println("decoding starts here");
                                decrypt_and_decode(strtemp);
                                JOptionPane.showMessageDialog(null, "Message is in Originalfile!");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "File is empty!!! choose another");
                            }
                             //     
                                //System.out.println(str);
                            }
                            catch(Exception ex)
                            {
                            }
                            
                           }
                           else
                        JOptionPane.showMessageDialog(null, "Choose a file inorder to encode!");
                    
                           
                    }
                    
               });
            }

        });

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jb1) {

            // button action
        }

    }

    public void steganography_and_encryption(String str) throws Exception {

        System.out.print("Enter the message: ");
        // String str=s.nextLine();
        str = str.replaceAll(" ", "").toLowerCase();
        System.out.println(str);
        str = str.replace("", " ").trim();
        // char[] strarr=str.toCharArray();
        // String str1 = String.valueOf(strarr);
        String[] strarr = str.split(" ");
        System.out.println("your message :" + str);

        // System.out.println(strarr.length);
        // for(int i=0;i<strarr.length;i++)
        // System.out.println(strarr[i]);

        // every instance of the word is converted
        String[] cover = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z", "!", "#", "$", "%", "&", "'", "(", ")",
                "*", "+", ",", "-", ".", "/", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", ":", ";", "<", "=", ">", "@", "[", "]",
                "^", "_", "`", "{", "|", "}", "~"

        };

        // these are the words considered as cover message
        String[] ukwords1 = {   
                "accessorise", "accessorising", "acclimatisation",
                "acclimatise", "acclimatising", "aeon", 
                "aerogramme", "aeroplane", "aesthete",
                "aesthetic", "aesthetically", "aetiology", 
                "ageing", "aggrandisement", "agonise", 
                "agonised", "agonising", "agonisingly", 
                "almanack", "aluminium", "amortisable", 
                "amortisation", "amortise", "amortising",
                "agonising", "agonisingly", "almanack",
                "aluminium", "amortisable", "amortisation",
                "amortise", "amortising","amphitheatre", 
                "anaemia", "anaemic","anaesthesia",
                "anaesthetic", "anaesthetise", "anaesthetising",
                "anaesthetist", "anaesthetize","anaesthetized",
                "anaesthetizing", "analogue","analyse", 
                "analysing", "anglicise", "accessorise",
                "appetiser","appetising","appetisingly",
                "arbour","archaeological","archaeologically",
                "archaeologist","archaeology","ardour",
                "armour","armoured","armoury",
                "artefact","authorise","authorising",
                "axe","backpedalled"

        };
        String[] ukwords2 = { "backpedalled", "backpedalling", "bannister",
                "bannisters", "baptise", "baptised", "baptises", "baptising",
                "bastardise", "bastardised", "bastardises", "bastardising",
                "battleaxe", "baulk", "baulked", "baulking", "baulks",
                "bedevilled", "bedevilling", "behaviour", "behavioural",
                "behaviourism", "behaviourist", "behaviourists", "behaviours",
                "behove", "behoved", "behoves", "bejewelled", "belabour",
                "belaboured", "belabouring", "belabours", "bevelled",
                "bevvies", "bevvy", "biassed", "biassing", "bingeing",
                "bougainvillaea", "bougainvillaeas", "bowdlerise",
                "bowdlerised", "bowdlerises", "bowdlerising", "breathalyse",
                "breathalysed", "breathalyser", "breathalysers",
                "breathalyses", "breathalysing", "brutalise", "brutalised",
                "brutalises", "brutalising", "buses", "busing", "caesarean",
                "caesareans", "calibre", "calibres", "calliper", "callipers",
                "callisthenics", "canalise" 
};
        String[] ukwords3 = { "decentralisation", "decentralise",
                "decentralised", "decentralises", "decentralising",
                "decriminalisation", "decriminalise", "decriminalised",
                "decriminalises", "decriminalising", "defence", "defenceless",
                "defences", "dehumanisation", "dehumanise", "dehumanised",
                "dehumanises", "dehumanising", "demeanour", "demilitarisation",
                "demilitarise", "demilitarised", "demilitarises",
                "demilitarising", "demobilisation", "demobilise",
                "demobilised", "demobilises", "demobilising",
                "democratisation", "democratise", "democratised",
                "democratises", "democratising", "demonise", "demonised",
                "demonises", "demonising", "demoralisation", "demoralise",
                "demoralised", "demoralises", "demoralising",
                "denationalisation", "denationalise", "denationalised",
                "denationalises", "denationalising", "deodorise", "deodorised",
                "deodorises", "deodorising", "depersonalise", "depersonalised",
                "depersonalises", "depersonalising", "deputise", "deputised",
                "deputises", "deputising", "desensitisation", "desensitise",
                "desensitised", "desensitises", "desensitising"

        };
        // as replaceAll tends to some buggy situations better we use another
        // Array of String and do it
        String ukwordsupper1[] = new String[ukwords1.length];
        String ukwordsupper2[] = new String[ukwords2.length];
        String ukwordsupper3[] = new String[ukwords3.length];
        for (int j = 0; j < ukwords1.length; j++) {
            ukwordsupper1[j] = ukwords1[j].toUpperCase();
            ukwordsupper2[j] = ukwords2[j].toUpperCase();
            ukwordsupper3[j] = ukwords3[j].toUpperCase();
            // System.out.println(ukwordsupper[j]+" ");
        }

        // finding all occurances of alphabets and change them to words
        for (int i = 0; i < cover.length; i++) {

            str = str.replace(cover[i], ukwordsupper1[i]);

        }
        /*
         * for(int i=1;i<cover.length;i+=2){
         * 
         * 
         * 
         * str=str.replace(cover[i],ukwordsupper2[i]);
         * 
         * 
         * 
         * } for(int i=2;i<cover.length;i+=3){
         * 
         * 
         * 
         * str=str.replace(cover[i],ukwordsupper3[i]);
         * 
         * 
         * 
         * }
         */
        // for testing
        str = str.toLowerCase();
        System.out.println("Cover Text is: " + str + ".");

        String[] replacesplit = str.split(" ");

        // conformation from user side base on alphabet map
        try {
            File confirm = new File("confirm.txt");
            FileWriter f = new FileWriter(confirm);

            for (int i = 0; i < strarr.length; i++) {
                String steganotext = "'" + strarr[i] + "'" + " " + "hidden in"
                        + " " + "'" + replacesplit[i] + "'";
                System.out.println(steganotext);
                f.write(steganotext + "\n");
                // f.write("\n\n\n");

            }

            f.flush();
            f.close();
        } catch (IOException iox) {
            iox.printStackTrace();
        }

        String[] temp = str.split(" ");
        String article[] = { "the", "a", "one", "some", "any" };
        String noun[] = { "boy", "girl", "dog", "cat", "rat" };
        String verb[] = { "drove", "jumped", "ran", "walked", "skipped" };
        String preposition[] = { "to", "from", "over", "under", "on" };

        String sentence, temporary = "";
        for (int i = 0; i < temp.length; i++) {
            sentence = article[rand()];
            char c = sentence.charAt(0);
            sentence = sentence.replace(c, Character.toUpperCase(c));
            // sentence += SPACE + temp[i] + SPACE;
            sentence += SPACE + noun[rand()] + SPACE;
            sentence += (verb[rand()] + SPACE + preposition[rand()]);
            sentence += (SPACE + article[rand()] + SPACE + temp[i] + SPACE + noun[rand()]);
            sentence += PERIOD;
            temporary += sentence + "\n";
            System.out.println(sentence);
            sentence = "";
        }

        // generating file
        try {

            File coverfile = new File("Covertext.txt");

            FileWriter fw = new FileWriter(coverfile);

            fw.write(temporary);
            fw.close();
            if (coverfile.exists()) {
                System.out.println("Cover File Generated Sucessfully");
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }

        // Encryption and decryption

                        String plainText = str;
                        SecretKey secKey = getSecretEncryptionKey();

                        byte[] cipherText = encryptText(plainText, secKey);

                         String decryptedText = decryptText(cipherText, secKey);

                        // System.out.println("Original Text:" + plainText);

                        System.out.println("AES Key (Hex Form):"
                        + bytesToHex(secKey.getEncoded()));

                        // System.out.println("Encrypted Text (Hex Form):"+bytesToHex(cipherText));

                        // System.out.println("Descrypted Text:"+decryptedText);

                        String cipherstring = bytesToHex(cipherText); // i have stored in byte[]
                                                        // as it is unreadable

        // creating the cipher file

            try {

            File cipherfile = new File("Cipherfile.txt");

            FileWriter fw = new FileWriter(cipherfile);

            fw.write(cipherstring);
            fw.close();
            if (cipherfile.exists()) {
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
            if (decipherfile.exists()) {
                System.out.println("DecipherFile Generated Sucessfully");
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }
   // originalvalue(str);
    }
    
     /*   public static String originalvalue(String str){
            return str;
        }*/
            // my test
            public void decrypt_and_decode(String original){
                 
                       
              /*  try {
            File decipherfile = new File("Decipherfile.txt");
            FileWriter fw = new FileWriter(decipherfile);
            fw.write(decryptedText);
            fw.close();
            if (decipherfile.exists()) {
                System.out.println("DecipherFile Generated Sucessfully");
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }*/
            String[] cover = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z", "!", "#", "$", "%", "&", "'", "(", ")",
                "*", "+", ",", "-", ".", "/", "0", "1", "2", "3", "4", "5",
                "6", "7", "8", "9", ":", ";", "<", "=", ">", "@", "[", "]",
                "^", "_", "`", "{", "|", "}", "~"

            };

        // these are the words considered as cover message
            String[] ukwords1 = {    "accessorise", "accessorising", "acclimatisation",
                "acclimatise", "acclima", "acclimatising", "aeon", "aerogramme", "aeroplane", "aesthete", "aesthetic",
                "aesthetically", "aetiology", "ageing", "aggrandisement", "agonise", "agonised", "agonising",
                "agonisingly", "almanack", "aluminium", "amortisable", "amortisation", "amortise", "amortising",
                "agonising", "agonisingly", "almanack",
                "aluminium", "amortisable", "amortisation",
                "amortise", "amortising",
                "amphitheatre", "anaemia", "anaemic",
                "anaesthesia", "anaesthetic", "anaesthetise",
                 "anaesthetising",
                "anaesthetist", "anaesthetize",
                "anaesthetized", "anaesthetizing", "analogue",
                "analyse", "analysing",
                "anglicise", "accessorise",
                "appetiser", "appetising", "appetisingly",
                "arbour",
                "archaeological",
                "archaeologically",
                "archaeologist",
                "archaeology",
                "ardour",
                "armour",
                "armoured",
                "armoury",
                "artefact",
                "authorise",
                "authorising",
                "axe"

            };
            for (int i = 0; i < cover.length; i++) {

            original = original.replace(ukwords1[i],cover[i]);

        }
        System.out.println("original message is: "+original);
        //original file generation
        try {

            File Originalfile = new File("Originaltext.txt");

            FileWriter fw = new FileWriter(Originalfile);

            fw.write(original);
            fw.close();
            if (Originalfile.exists()) {
                System.out.println("Original File Generated Sucessfully");
            }
        } catch (IOException iox) {
            iox.printStackTrace();
        }
        
            
            }
            
    
    
    public static void main(String[] args) throws Exception

    {

        try {
            stego frame = new stego();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Scanner s=new Scanner(System.in);
        // System.out.print("Enter the message: ");
        // String str=t.str;//s.nextLine();
        // ends here
        // Scanner s=new Scanner(System.in);

    }

    public static SecretKey getSecretEncryptionKey() throws Exception {

        KeyGenerator generator = KeyGenerator.getInstance("AES");

        generator.init(128); // The AES key size in number of bits

        SecretKey secKey = generator.generateKey();

        return secKey;

    }

    public static byte[] encryptText(String plainText, SecretKey secKey)
            throws Exception {
        // AES defaults to AES/ECB/PKCS5Padding in Java 7

        Cipher aesCipher = Cipher.getInstance("AES");

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());

        return byteCipherText;

    }

    public static String decryptText(byte[] byteCipherText, SecretKey secKey)
            throws Exception {

        // AES defaults to AES/ECB/PKCS5Padding in Java 7

        Cipher aesCipher = Cipher.getInstance("AES");

        aesCipher.init(Cipher.DECRYPT_MODE, secKey);

        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);

        return new String(bytePlainText);

    }

    private static String bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash);

    }

    public static int rand() {
        int ri = r.nextInt() % NO_WORDS;
        if (ri < 0)
            ri += NO_WORDS;
        return ri;
    }
}