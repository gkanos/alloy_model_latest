package at.jku.isse.models.collaboration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import atoms.Collaboration;
import atoms.Delta;
import atoms.Engineer__Ws;
import atoms.Trigger;
import graphicElements.LogGraphics;

/**
 * Collaboration Model!!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame("FrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setMinimumSize(new Dimension(800, 800));
        
        
        Panel panel = new Panel() 
        {
        	
        	@Override
        	public void paint(Graphics g) {
        		super.paint(g);
        		
        		Graphics2D g2 = (Graphics2D) g;
        		ArrayList<Shape> shapes = new ArrayList<>();
        		
        		for(Object element : LogGraphics.getGraphElements()) 
        		{
        			if (element instanceof Engineer__Ws) 
        			{
        				Shape eng = new Rectangle(LogGraphics.getGraphElements().indexOf(element)*70 + 66, 10, 66, 30);
        				shapes.add(eng);
        				g2.drawString("Engineer", eng.getBounds().x + 10, eng.getBounds().y + 18);
        				System.out.println("Engineer");
        			}
        			else if (element instanceof Collaboration)
        			{
        				Shape collab = new Rectangle(LogGraphics.getGraphElements().indexOf(element)*70 + 66, 10, 66, 30);
        				shapes.add(collab);
        				g2.drawString("Element", collab.getBounds().x + 13, collab.getBounds().y + 18);
        				System.out.println("collab");
        			}
        			else if (element instanceof Delta)
        			{
        				Shape delta = new Rectangle(LogGraphics.getGraphElements().indexOf(element)*70 + 66, 10, 66, 30);
        				shapes.add(delta);
        				g2.drawString("Delta", delta.getBounds().x + 15, delta.getBounds().y + 18);
        				System.out.println("Delta");
        			}
        			else if (element instanceof Trigger)
        			{
        				Shape trigger = new Rectangle(LogGraphics.getGraphElements().indexOf(element)*70 + 66, 10, 66, 30);
//        				JLabel label = new JLabel("Trigger");
//        				label.setBounds(trigger.getBounds().x, trigger.getBounds().y, trigger.getBounds().width, trigger.getBounds().height);
        				shapes.add(trigger);
        				g2.drawString("Trigger", trigger.getBounds().x + 15, trigger.getBounds().y + 18);
        				
        				System.out.println("Trigger");
        			}
        		}
        		
        		for(Shape shape:shapes) 
        		{
        			g2.draw(shape);
        			g2.drawLine((int)shape.getBounds().getCenterX(), 40 , (int)shape.getBounds().getCenterX(), 300);
        		}
        		
        		ArrayList<Object> elements = (ArrayList<Object>) LogGraphics.getGraphElements();
        		
        		for(Object element:elements) 
        		{
        			 
        		}
        	}
        };
        
//        panel.setBackground(Color.blue);
//        panel.setSize(300,300);
        	
        
        
        
        
        
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
