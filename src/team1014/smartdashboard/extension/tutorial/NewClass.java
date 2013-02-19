/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package team1014.smartdashboard.extension.tutorial;


import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author me
 */
public class NewClass extends StaticWidget{

    JLabel label;
    int timeLeft = 15;
    
     int delay = 1000; //milliseconds
    ActionListener taskPerformer = new ActionListener() {
    
        @Override
        public void actionPerformed(ActionEvent e) {
          timeLeft-=1;
          if(timeLeft>0)
          label.setText(timeLeft + "");  
        }
     };  
   
    
    @Override
    public void init() 
    {
        new Timer(delay, taskPerformer).start();
        
        NetworkTable table = NetworkTable.getTable("autonomous countdown");
        label = new JLabel();
        add(label);
        
        //while(table.getValue("started") == true && table.getValue("ended") == false)
        //{
           // label.setText(timeLeft + "");
        //}
    }
    
    @Override
    public void propertyChanged(Property prprt)
    {
        
    }
    
}
