package u0251055;

public class Triangle {
	int layer;
	char printChar;
	
	public Triangle(){
		layer = 1;
		printChar = '*';
	}//End of Constructor
	
	public Triangle(int setLayer,char setPrintChar){
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
		for(i=layer;i>0;i--){
			for(j=i;j>0;j--){
				System.out.print(printChar);
			}
			System.out.print("\n");
		}
	}//End of draw
}
