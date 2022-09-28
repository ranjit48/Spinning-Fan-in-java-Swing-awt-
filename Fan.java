

import javax.swing.*;
import java.awt.*;

public class Fan extends JPanel
{
private int angle1 = -15;
private int angle2 = 75;
private int angle3 = 165;
private int angle4 = 255;

public Fan()
{
    Runnable spinner = new SpinFan();

    Thread thread1 = new Thread(spinner);
    thread1.start();
}


public static void main(String[] args)
{   
    JFrame frame = new JFrame();
    frame.add(new Fan());
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}


@Override
protected void paintComponent(Graphics g)
{
    super.paintComponent(g);
    g.setColor(Color.RED);
    g.drawOval(200, 150, 150, 150);
    g.fillArc(210, 160, 130, 130, angle1, 30);
    g.fillArc(210, 160, 130, 130, angle2, 30);
    g.fillArc(210, 160, 130, 130, angle3, 30);
    g.fillArc(210, 160, 130, 130, angle4, 30);
    g.drawLine(280, 300, 280, 600);
    g.drawLine(270, 300, 270, 600);

}

class SpinFan implements Runnable
{
    @Override
    public void run() 
    {
        try
        {
            while(true)
            {
                angle1 = (angle1 - 1) % 360;
                angle2 = (angle2 - 1) % 360;
                angle3 = (angle3 - 1) % 360;
                angle4 = (angle4 - 1) % 360;

                System.out.println(angle1 + " " + angle2 + " " + angle3 + " " + angle4);

                repaint();

                Thread.sleep(5);
            }
        }

        catch(InterruptedException ex)
        {
            System.out.println("Problem while putting thread to sleep.");
        }
    }

}
}