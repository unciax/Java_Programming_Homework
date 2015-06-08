import java.awt.Color;
import java.awt.Graphics;
public class Shape {
	int type;
	Color c;
	Point startPoint,endPoint;
	int width,height;
	
	public Shape(){
		type=1;
		c=Color.LIGHT_GRAY;
		startPoint = new Point();
		endPoint = new Point();
	}
	
	public Shape(int DrawType,Color ObjectColor,Point sPoint,Point ePoint){
		// new Shape(繪圖類型,物件顏色,起始點[通常為左上角],結束點[通常為右下角])
		type=DrawType;
		c = ObjectColor;
		this.startPoint = new Point(sPoint.getLocationX(),sPoint.getLocationY());
		this.endPoint = new Point(ePoint.getLocationX(),ePoint.getLocationY());
		if(type!=0){
			width = Math.abs(startPoint.getLocationX() - endPoint.getLocationX());
			height = Math.abs(startPoint.getLocationY() - endPoint.getLocationY());
			
			if(startPoint.getLocationX()> endPoint.getLocationX()){
				int temp = startPoint.getLocationX();
				startPoint.setLocation(endPoint.getLocationX(),startPoint.getLocationY());
				endPoint.setLocation(temp,endPoint.getLocationY());
			}
			if(startPoint.getLocationY() > endPoint.getLocationY()){
				int temp = startPoint.getLocationY();
				startPoint.setLocation(startPoint.getLocationX(),endPoint.getLocationY());
				endPoint.setLocation(endPoint.getLocationX(),temp);
			}
			
		}
	}
	
	public void Paint(Graphics g){
		g.setColor(c);
		switch(type){
			//"Line","Rect","Round Rect","Fill Rect"
			case 0:
				g.drawLine(startPoint.getLocationX(), startPoint.getLocationY(), endPoint.getLocationX(), endPoint.getLocationY());
				break;
			case 1:
				g.drawRect(startPoint.getLocationX(), startPoint.getLocationY(), width, height);
				break;
			case 2:
				g.drawRoundRect(startPoint.getLocationX(), startPoint.getLocationY(), width, height, 10, 10);
				break;
			case 3:
				g.fillRect(startPoint.getLocationX(), startPoint.getLocationY(), width, height);
				break;
			default:
				System.out.println("Unknown Error.");
		}
	}
}
