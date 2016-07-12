package com.rb;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 * Created by Rahul Basu on 7/13/2016.
 */
public class Images extends JFrame
    {
        private Screen1 s;
        private Image bg;
        private Image pic;
        private boolean loaded; //housekeeping variable to check if the picture's loaded
    public static void main(String[] args)
    {
        DisplayMode dm = new DisplayMode(800,800,50,DisplayMode.REFRESH_RATE_UNKNOWN);
        Images i = new Images();
        i.run(dm);
    }


    public void run(DisplayMode dm)
    {
        setBackground(Color.black);
        setForeground(Color.white);
        setFont(new Font("Centaur", Font.PLAIN,24));

        s = new Screen1();
        try
        {
            s.setFullScreen(dm,this);
            loadpics();
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

    public void loadpics()
    {
        bg = new ImageIcon("C:\\Users\\Rahul Basu\\Downloads\\New Downloads\\ACBack.jpg").getImage();
        pic = new ImageIcon("C:\\Users\\Rahul Basu\\Downloads\\New Downloads\\Ezio.jpg").getImage();
        loaded = true;
        repaint();
    }
    public void paint(Graphics g)
    {
        if(g instanceof Graphics2D)
        {
            Graphics2D g2 = (Graphics2D)g; //typecast 'g' to a 2D object 'g2'
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // It puts the antialiasing on the object
            // or it gets the hose again
        }

        if (loaded)
        {
            g.drawImage(bg,0,0,null);
            g.drawImage(pic,400,190,null);
        }
        g.drawString("THALL",50,50);
    }
}
