package u0251055;
import java.util.Scanner;

public class MainSub {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in) ;
		int action = 0;
		Square s = new Square();
		Triangle tri = new Triangle();
		Diamond d = new Diamond();		
		while(action != 5){
			showHelp();
			action = input.nextInt();
			System.out.println("");
			switch(action){
				case 1:
					System.out.print("Set Layer:");
					s.setLayer(input.nextInt());
					tri.setLayer(s.getLayer());
					d.setLayer(s.getLayer());
					break;
				case 2:
					System.out.print("Set PrintChar:");
					s.setPrintChar(input.next().charAt(0));
					tri.setPrintChar(s.getPrintChar());
					d.setPrintChar(s.getPrintChar());
					break;
				case 3:
					System.out.printf("Now Setting:\n  Layer:%d\n  PrintChar:%c\n",s.getLayer(),s.getPrintChar());
					break;
				case 4:
					System.out.println("Result of Square:");
					s.draw();
										
					System.out.println("Result of Triangle:");
					tri.draw();
					
					System.out.println("Result of Diamond:");
					if((d.getLayer()%2) != 0){
						d.draw();
					}else{
						System.out.println("Because you set layer with an even number, this process is ignored.");
					}				
					break;
				case 5:
					break;
				default:
					System.out.println("Invaild Value. Please try again.");
			}
			
			

		}//End of while
		input.close();
	}//End of main
	
	public static void showHelp(){
		System.out.print("================================\n"
						 + "1. Set Layer\n"
						 + "2. Set PrintChar\n"
						 + "3. Show Now Setting\n"
						 + "4. Draw\n"
						 + "5. Exit\n"
						 + "================================\n"
						 + "\n"
						 + " Select action : ");
	}//End of showHelp

}//End of MainSub
