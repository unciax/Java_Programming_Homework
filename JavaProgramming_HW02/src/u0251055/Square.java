package u0251055;

public class Square {
	int layer;
	char printChar;
	
	public Square(){
		layer = 1;
		printChar = '*';
	}//End of Constructor
	
	public Square(int setLayer,char setPrintChar){
		layer = setLayer;
		printChar = setPrintChar;
	}//End of Constructor	 
	

	public int getLayer(){
		return layer;
	}//End of getLayer
	
	public void setLayer(int value){
		layer = value;
	}//End of setLayer


	public char getPrintChar(){
		return printChar;
	}//End of getPrintChar
	
	public void setPrintChar(char value){
		printChar = value;
	}//End of setPrintChar
	
	
	public void draw(){
		int i=0,j=0;
		for(i=0;i<layer;i++){
			for(j=0;j<layer;j++){
				if((i==0)||(j==0)||(i==layer-1)||(j==layer-1)) System.out.print(printChar);
				else System.out.print(" ");
			}
			System.out.print("\n");
		}
	}//End of draw
	
}// End of Square
