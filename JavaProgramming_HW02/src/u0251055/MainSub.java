package u0251055;
import java.util.Scanner;

public class MainSub {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		int layer = 0;
		char printChar='*';
		System.out.print("Set Layer:");
		layer = input.nextInt();
		
		Square s = new Square(layer,printChar);
		System.out.println("Result of Square:");
		s.draw();
		
		Triangle tri = new Triangle(layer,printChar);
		System.out.println("Result of Triangle:");
		tri.draw();
		
		if((layer%2) != 0){
			Diamond d = new Diamond(layer,printChar);
			System.out.println("Result of Diamond:");
			d.draw();
		}else{
			System.out.println("Result of Diamond:\n"
							 + "Because you set layer with an even number, this process is ignored.");
		}
		
		
		input.close();
	}//End of main
	
}//End of MainSub
