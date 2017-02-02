/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseopeningsim;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Zach
 */
public class CaseOpeningSim extends JFrame {
    
    int milspec,restricted,classified,covert,knife,STknife,STmilspec,STrestricted,STclassified,STcovert,total = 0;
    private String keyCost = "";
    private final JButton roll = new JButton("Roll!");
    private final JButton reset = new JButton("Reset");
    private final JButton getKnife = new JButton("Open a Knife!");
    private final JTextArea count = new JTextArea(5, 20);
    private JLabel item = new JLabel("");
    private JPanel listPane = new JPanel();
    
        public CaseOpeningSim(){
            setLayout(new FlowLayout());
 
            add(roll);
            add(getKnife);
            add(reset);
            add(item);
            add(count);

            
            action rand  = new action();
                roll.addActionListener (rand);
            
            empty set = new empty();
                reset.addActionListener (set);
                
            openKnife cKnife = new openKnife();
                getKnife.addActionListener (cKnife);
        
        
        }
        
        public void OpenCase(){
         
            double randomNum = (double)(Math.random() * 100.0 + 0.0);

            if(randomNum >= 16.26){
                item.setText("Mil-Spec "+randomNum);
                milspec++;
                
                double STRandomNum = (double)(Math.random() * 100.0 + 0.0);
                    if(STRandomNum <= 10){
                        item.setText("StatTrak Mil-Spec"+randomNum);
                        STmilspec++;}
                }

            else if(randomNum >= 3.16 && randomNum < 16.26){
                item.setText("Restricted "+randomNum);
                restricted++;
                
                double STRandomNum = (double)(Math.random() * 100.0 + 0.0);
                    if(STRandomNum <= 10){
                        item.setText("StatTrak Restricted"+randomNum);
                        STrestricted++;}
                }

            else if(randomNum >= 0.57 && randomNum < 3.16){
                item.setText("Classified "+randomNum);
                classified++;
                
                double STRandomNum = (double)(Math.random() * 100.0 + 0.0);
                    if(STRandomNum <= 10){
                        item.setText("StatTrak Classified"+randomNum);
                        STclassified++;}
                }

            else if(randomNum >= 0.21 && randomNum < 0.57){
                item.setText("Covert "+randomNum);
                covert++;
                
                double STRandomNum = (double)(Math.random() * 100.0 + 0.0);
                    if(STRandomNum <= 10){
                        item.setText("StatTrak Covert"+randomNum);
                        STcovert++;}
                }

            else if(randomNum >= 0.0 && randomNum < 0.21){
                item.setText("!KNIFE! "+randomNum);
                knife++;
            
                double STRandomNum = (double)(Math.random() * 100.0 + 0.0);
                    if(STRandomNum <= 10){
                        item.setText("!STATTRAK KNIFE! "+randomNum);
                        STknife++;}
                }
                
            
            total++;

            UpdateCount();
        }
        
        public void OpenKnife(){
            
            double randomNum = 100;    

            while(randomNum > 0.21)
                OpenCase();
        }
        
        public void ResetStats(){
            milspec = 0;
            restricted = 0;
            classified = 0;
            covert = 0;
            knife = 0;
            STmilspec = 0;
            STrestricted = 0;
            STclassified = 0;
            STcovert = 0;
            STknife = 0;
            keyCost = "";
            total = 0;

            UpdateCount();
            item.setText("");   
        }
        
        public void UpdateCount(){
            
            keyCost="$"+((total*2.50)-(total*0.01));
            
            count.setText("Milspec Count: "+milspec+"              ST: "+STmilspec+"\n"
                    + "Restricted Count: "+restricted+"              ST: "+STrestricted+"\n"
                    + "Classified Count: "+classified+"              ST: "+STclassified+"\n"
                    + "Covert Count: "+covert+"              ST: "+STcovert+"\n"
                    + "Knife Count: "+knife+"              ST: "+STknife+"\n"
                    + "\n"
                    + "Total Case Count: "+total+"\n"
                    + "Total Key Cost (at $2.49 ea): "+keyCost);
            count.setEditable(false);
        }
        
//roll button
        
public class action implements ActionListener{ 
    public void actionPerformed(ActionEvent rand){
        OpenCase();}}


//reset button

public class empty implements ActionListener {
    public void actionPerformed(ActionEvent set){
        ResetStats();}}

//open a knife
public class openKnife implements ActionListener {
    public void actionPerformed(ActionEvent cKnife){
        OpenKnife();}}
      
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CaseOpeningSim gui = new CaseOpeningSim();
        
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(300, 270);
        gui.setTitle("Case Opening Sim");
        
    
    }
    
}
