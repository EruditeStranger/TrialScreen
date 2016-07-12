package com.rb;

import java.awt.*;
import javax.swing.*;

/**
 * Created by Rahul Basu on 7/12/2016.
 */
public class Housekeeping1 extends JFrame
{
    public static void main(String[] args)
    {
        DisplayMode dm = new DisplayMode(800,800,50,DisplayMode.REFRESH_RATE_UNKNOWN);
        Housekeeping1 h = new Housekeeping1();
        h.run(dm);
    }
    public void run(DisplayMode dm)
    {
        setBackground(Color.black);
        setForeground(Color.white);
        setFont(new Font("Centaur", Font.PLAIN,24));

        Screen1 s = new Screen1();
        try
        {
            s.setFullScreen(dm,this);
            try
            {
                Thread.sleep(5000); //displays the text for 5 seconds if all the tries are successful
            }
            catch(Exception ex){}
        }
        finally
        {
            s.restoreScreen();
        }
    }
    public void paint(Graphics g)
    {
        if(g instanceof Graphics2D)
        {
            Graphics2D g2 = (Graphics2D)g; //typecast 'g' to a 2D object 'g2'
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // It puts the antialiasing on the object
                                                                                                        // or it gets the hose again
        }
        g.drawString("Rahul Basu", 200,200);
    }
}
