import java.util.Scanner; 

public class Polygon {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Polygonal Property Calculator!");
		System.out.println("");
		
		System.out.print("Enter your first name:\t\t\t"); 
		String firstName = in.next();
		String firstInitial = firstName.substring(0,1); // This will display the first letter of your first name
		System.out.print("Enter your last name:\t\t\t");
		String lastName = in.next();
		System.out.print("Enter the sides the property has:\t");
		int sides = in.nextInt();
		System.out.print("Enter side length in meters:\t\t");
		double sideLength = in.nextDouble();
		System.out.print("Enter property cost per square meter:\t$");
		double propertyCost = in.nextDouble();
		System.out.print("Enter fence cost per meter:\t\t$");
		double fenceCost = in.nextDouble();
		
		System.out.println("");
		
		System.out.print("Property Information for " + firstInitial);
		System.out.print(".");
		System.out.println(" " + lastName);
		System.out.println("****************************************************************");
		
		double apothem = 0.5*sideLength*(1/Math.tan((Math.toRadians(180.0))/sides)); // Degrees to Radians
		
		double area = 0.5*sides*sideLength*apothem;
		System.out.print("Total area:\t\t\t\t");
		System.out.format("%.3f" , area); 
		System.out.println(" square meters");
		
		double perimeter = sides * sideLength;
		System.out.print("Total perimeter:\t\t\t");
		System.out.format("%.3f", perimeter); 
		System.out.println(" meters");
		
		System.out.print("Lenght of apothem:\t\t\t");
		System.out.format("%.3f", apothem); 
		System.out.println(" meters");
		
		double angle = 180 * (sides - 2)/sides; 
		System.out.print("Interior angle:\t\t\t\t");
		System.out.format("%.3f", angle);
		System.out.println(" degrees");
		
		double landCost = propertyCost * area;
		System.out.print("Cost of land:\t\t\t\t");
		System.out.format("$%.2f", landCost);
		System.out.println("");
	
		double totalFenceCost = fenceCost * perimeter;
		System.out.print("Cost of fencing:\t\t\t");
		System.out.format("$%.2f", totalFenceCost);
		System.out.println("");
		
		double totalCost = landCost + totalFenceCost;
		System.out.print("Total cost:\t\t\t\t");
		System.out.format("$%.2f", totalCost);
		System.out.println("");
		
		System.out.println("");
		
		System.out.println("Loan Information");
		System.out.println("****************************************************************");
		
		System.out.print("Enter annual interest rate:\t\t");
		double interestRate = in.nextDouble();
		System.out.print("Enter length of loans in years:\t\t");
		int loanLength = in.nextInt();
		
		double costInterest = totalCost * Math.pow((1 + interestRate), loanLength);
		System.out.print("Total cost with interest:\t\t");
		System.out.format("$%.2f", costInterest);
		
	}

}
