/* 
 * Panel for Conway's life simulation. This draws the grid and cells
 * Date: 9-23-2021
 * Author: Aida Fatme Fakhry 
 * 
 */

import java.awt.Color; // Importing color for grid
import java.awt.Graphics;
import java.lang.reflect.Array;

import javax.swing.JPanel;

public class LifePannel extends JPanel{ // Automatic JPanel tools
	
	boolean[][] cells; // Grid format/layout: 
	double width; 
	double height; 

	
	public LifePannel(boolean[][] in) { // Frame boolean 
		cells = in; 
	}
	public void setCells(boolean[][] newcells) { //Re-named cells
		cells = newcells; 
	}
	
	public void paintComponent(Graphics g) { 
		super.paintComponent(g); //JPanel paint component 
		width = (double)this.getWidth() / cells[0].length; 
		height = (double)this.getHeight() / cells.length; 
		
		// Draw the cells 
		g.setColor(Color.BLUE);
		for (int row = 0; row < cells.length; row++) { 
			for (int columns = 0; columns < cells[0].length; columns++) {
				if (cells[row][columns] == true) { 
					g.fillRect((int)Math.round(columns*width),(int)Math.round(row*height), // Fill rectangle function
					(int)width+1, (int)height+1);
				}
			
		}
	}
		// Draw the grid
		g.setColor(Color.BLACK); // Color importation 
		for (int x = 0; x < cells[0].length + 1; x++) { // Creation of forloop for 
			g.drawLine((int)Math.round(x*width),0,(int)Math.round(x*width),this.getHeight()); // Determining coordinate X's
			
		}
		for (int y = 0; y < cells[0].length +1; y++) { // Creation of forloop for 
			g.drawLine(0,(int)Math.round(y*height),this.getWidth(),(int)Math.round(y*height)); 
		
		}
	}
}
