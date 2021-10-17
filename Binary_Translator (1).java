import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Binary_Translator {
	
	public Binary_Translator() {
		
			System.out.println("Please enter \"file\" to enter a file of \"input\" to use the console.");
			Scanner scanner = new Scanner(System.in);
			String input =  scanner.nextLine();
			String numberInput = "";
			
			if (input.equals("file")) { // input from file
					try {
						System.out.println("Enter your file name.");  
						input = scanner.nextLine();
						Scanner fileScanner = new Scanner (new File(input));
						numberInput = fileScanner.nextLine();
					}
			
				
			
					catch (IOException ex) {
						System.out.println("File not found.");
						scanner.close();
						System.exit(1);
					}
	}
			
			
				System.out.println("if you are translating from decimal to binary, type \"dtb\" .");
				System.out.println("if you are translating from binary to decimal, type \"btd\" .");
				input = scanner.nextLine();
				
				if (input.equals("dtb")) {//decimal to binary
					Scanner getno = new Scanner(System.in);
					System.out.println("Enter your decimal number: ");
					int dnum = getno.nextInt();  //getting the decimal number 
					
					String answer = "";
					
					while (dnum>0) {
						// 5 = 101 in order to do this 5/2 = 2 r=1 ; 2/2 = 1 r = 0 ; 1/2 r = 1; which means that the binary = 101!
						int r = dnum%2;//first we find the modulus when dividing by 2
						
						dnum = dnum/2; // dividing consecutively until we achieve 0 
						
						answer = r+answer; // concatenate the string to find the binary
						
						
					}
					System.out.println(answer);  //printing out the binary 
					
				}
				
				
				
				else if (input.equals("btd")) { // binary to decimal
					
					Scanner sc = new Scanner(System.in);
					System.out.println("enter your binary number: ");
					int num = sc.nextInt(); //getting the binary number 
					
					int answer=0;
					int i = 0;
					
					while (num>0) {
						int r = num%10; //find the modulus when dividing by 10
						num = num/10; // divide by 10 
						answer = answer+r*(int) Math.pow(2, i++); //using the math.pow to find decimal number backwards! and then adding it 
					}
						System.out.println(answer); // printing out the decimal number
					
					
					
					
				}
				
					
					
				}

			     // Source 1: https://www.geeksforgeeks.org/program-binary-decimal-conversion/ 
				// Source 2:  https://www.youtube.com/watch?v=Bxis3XwcOUo
				
		

		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Binary_Translator ();

	}

}
