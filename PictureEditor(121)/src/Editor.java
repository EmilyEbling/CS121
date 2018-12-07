import java.util.Scanner;

import java.awt.Color;

public class Editor {

	public static Picture grow (Picture p){
		
		Picture big = new Picture (p.width()*2,p.height()*2); // creates a new picture double the size of the old one
		
		for (int i = 0; i < big.width(); i++){ // columns
			for (int j = 0; j < big.height(); j++){ // rows 
				int x = i/2; 
				int y = j/2;
				Color c1 = p.get(x, y); // gets the color from half of the original pixel

				big.set(i, j, c1); /* sets the new pixel, which is now double the size of the pixel from photo p, to the
				color at location x,y  */
			}
		}
	return big; // the image isn't growing so
	}
	
	public static Picture grayscale (Picture p){
		
		for (int i = 0; i < p.width(); i++){
			for (int j = 0; j < p.height(); j++){
				Color color = p.get(i, j); // gets pixel color at i,j
				int red = color.getRed(); // gets red value
				int green = color.getGreen(); // gets green value
				int blue = color.getBlue(); // gets blue value 
				
				int gray = (int)Math.round((red * 0.3) + (green * 0.59) + (blue * 0.11)); // changes RGB values to gray 
		          
		        red = gray; // sets each value to the new gray number
		        green = gray;
		        blue = gray;
		        
		        color = new Color (red, green, blue); // creates new color in which RGB parts are all gray
		        p.set(i, j, color); // sets p to new color i.e. gray 
			}
		}
		return p; // returns grayscale p 
	}
	
	public static Picture invert (Picture p){
		for (int i = 0; i < p.width(); i++){ 
			for (int j = 0; j < p.height(); j++){ 
				Color color = p.get(i, j);
				int red = color.getRed();
				int green = color.getGreen(); 
				int blue = color.getBlue(); 
				
				int invertRed = 255 - red; // inverts red
				int invertGreen = 255 - green; // inverts green
				int invertBlue = 255 - blue; // inverts blue
				
				color = new Color (invertRed, invertBlue, invertGreen); // creates new color with inverted RGB values
				p.set(i, j, color); // sets p to the new inverted color 
			}		
		}
		return p; // returns inverted picture
	}

	public static Picture rotateLeft (Picture p){
		
		Picture rotated = new Picture(p.height(), p.width()); // changes dimensions to match newly rotated image
	
		for (int i = 0; i < p.width(); i++){
			for (int j = 0; j < p.height(); j++){
				rotated.set(j, p.width() - 1 - i, p.get(i, j)); /* I've drawn this out on paper over and over
			 again and the algorithm checks out I think, but nothing rotates, I even tried the rotation code listed
			 in the notes and it won't rotate right either */
			}
		}
		return rotated;	
	}	
	
	public static Picture medianFilter (Picture p){
		
		Picture filter = new Picture(p.width(), p.height());
		
		int [] r = new int [p.width()*p.height()];
        int [] g = new int [p.width()*p.height()];
        int [] b = new int [p.width()*p.height()];
		
        int count = 0;
        
		for (int i = 1; i < p.width() - 1; i++){ // loops through the columns but skips edges
			for (int j = 1; j < p.height() - 1; j++){ // loops through rows but skips edges
				
				for (int col = i - 1; col < 3; col++){
					for (int row = j - 1; row < 3; row++){
					Color c = p.get(i + col - 1, j + row - 1);	
					r [count] = c.getRed();
		            g [count] = c.getBlue();
		            b [count] = c.getGreen();
		            
		            count ++;
					}	
				}
			
			count = 0;	
				
			sort(r);
			sort(g);
			sort(b);
			
			Color median = new Color (r[4], g[4], b[4]);
			filter.set(i, j, median); 
			}
		}
		
		return filter;
	}
	
	public static void sort (int[] values){
		int smallest = 0;
		int j;
		for (int i = 0; i < values.length - 1; i++) {
			smallest = i;
			for (j = i + 1; j < values.length; j++) {
				if (values[j] < values[smallest])
				smallest = j;
			}
			int temp = values[i];
			values[i] = values[smallest];
			values[smallest] = temp;	
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		System.out.print("What picture would you like to edit? ");
		String picture = in.next(); // reads in the name of the picture
		Picture p = new Picture (picture); // creates new picture 
		
		int command = 0;
		
		while (command != 7){
			System.out.print("\n");
			System.out.println("Operations");
			System.out.println("1. Grow");
			System.out.println("2. Grayscale");
			System.out.println("3. Invert");
			System.out.println("4. Rotate Left");
			System.out.println("5. Median Filter");
			System.out.println("6. Display");
			System.out.println("7. Quit");
			System.out.print("Enter command: ");
			command =in.nextInt();
			
			if (command == 1)
				grow(p); // calls grow method
			else if (command == 2)
				grayscale(p); // calls grayscale method
			else if (command == 3)
				invert(p); // calls invert method
			else if (command == 4)
				rotateLeft(p); // calls rotateLeft method
			else if (command == 5)
				medianFilter(p); // calls medianFilter method
			else if (command == 6)
				p.show(); // displays the picture
		}	
	}
}
