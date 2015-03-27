package u0251055;

public class Diamond {
	int layer;
	char printChar;
	
	public Diamond(){
		layer = 1;
		printChar = '*';
	}//End of Constructor
	
	public Diamond(int setLayer,char setPrintChar){
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
		
		for(i=1;i<=((layer-1)/2)+1;i++){
			for(j=0;j<(layer-(i*2-1))/2;j++){ System.out.print(" "); }
			for(j=0;j<(i*2-1);j++){ System.out.print(printChar); }
			System.out.print("\n");
		}//End of Draw Diamond (1/2)
		
		for(i=((layer-1)/2);i>0;i--){
			for(j=0;j<(layer-(i*2-1))/2;j++){ System.out.print(" "); }
			for(j=0;j<(i*2-1);j++){ System.out.print(printChar); }
			System.out.print("\n");
		}//End of Draw Diamond (2/2)
		
	}//End of draw
}
