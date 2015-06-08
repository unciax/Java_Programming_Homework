
public class Point {
	private int x;
	private int y;
	
	public Point(){
		x=0; y=0;
	}
	
	public Point(int rx,int ry){
		x=rx; y=ry;
	}
	
	public int[] getLocation(){
		int[] Location = new int[2];
		Location[0]=x;
		Location[1]=y;
		return Location;
	}
	
	public int getLocationX(){
		return x;
	}
	
	public int getLocationY(){
		return y;
	}
	
	public void setLocation(int XLocation,int YLocation){
		x=XLocation;
		y=YLocation;
	}
}
