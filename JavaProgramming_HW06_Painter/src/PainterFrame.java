import javax.swing.*;

import java.awt.* ;
import java.awt.event.*;
public class PainterFrame extends JFrame{
	//GUI
	private JRadioButton[] JRBtnFunc;
	private String[] DrawFuncName =new String[] {"Line","Rect","Round Rect","Fill Rect"};
	private  JDrawPanel DrawPanel;
	private JPanel FuncPanel,BtnPanel;
	private JButton[] BtnFunc;
	private String[] FuncName = new String[] {"Color Chooser","Save","Load"};
	
	//Drawing Value
	
	private int Func = 0;
	private Color selectedColor = Color.LIGHT_GRAY;
	private Point startPoint,endPoint;
	private int PaintObjectCount;
	private Shape PaintObject[] = new Shape[200];
	
	public PainterFrame(){
		super("Painter");
		setLayout(new BorderLayout());
		
		//Function Panel
		FuncPanel = new JPanel();
		FuncPanel.setLayout(new GridLayout(2,2));
		
		JRBtnFunc = new JRadioButton[4];
		ButtonGroup group = new ButtonGroup();
		for(int i =0 ;i<DrawFuncName.length;i++){
			if (i==0) { 
				JRBtnFunc[i] = new JRadioButton(DrawFuncName[i],true);
			}else {
				JRBtnFunc[i] = new JRadioButton(DrawFuncName[i],false);
			}
			FuncPanel.add(JRBtnFunc[i]);
			group.add(JRBtnFunc[i]);
		}
		
		//Drawing Panel
		DrawPanel = new JDrawPanel();
		DrawPanel.setBackground(Color.white);
		
		//Button Panel
		BtnPanel = new JPanel();
		BtnPanel.setLayout(new GridLayout(1,3,5,5));
		BtnFunc = new JButton[3];
		for(int i = 0 ; i<FuncName.length;i++){
			BtnFunc[i] = new JButton(FuncName[i]);
			BtnPanel.add(BtnFunc[i]);
		}
		
		//Add All Panel
		add(FuncPanel,BorderLayout.NORTH);
		add(DrawPanel,BorderLayout.CENTER);
		add(BtnPanel,BorderLayout.SOUTH);
		
		
		//Add EventListener
		FunctionHandler funcHandler = new  FunctionHandler();
		for(int i =0 ;i<DrawFuncName.length;i++){
			JRBtnFunc[i].addItemListener(funcHandler);
		}
		ButtonHandler btnHandler = new ButtonHandler();
		for(int i = 0 ; i<FuncName.length;i++){
			BtnFunc[i].addActionListener(btnHandler);
		}
		
		startPoint = new Point();
		endPoint = new Point();
		
		MouseHanlder mHandler = new MouseHanlder();
		DrawPanel.addMouseListener(mHandler);
	}//End of Constructor
	
	public class JDrawPanel extends JPanel {
		public void paintComponent(Graphics g){
			super.paintComponent(g);

			for(int i=0; i < PaintObjectCount; i++){
				PaintObject[i].Paint(g);
			}// End of for-loop
			}// End of DrawJPanel 

	}
	
	//EventListener--Start
	private class FunctionHandler implements ItemListener {
		
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource() == JRBtnFunc[0]){
				//Line
				Func = 0;
			}else if(e.getSource() == JRBtnFunc[1]){
				//Rect
				Func = 1;
			}else if(e.getSource() == JRBtnFunc[2]){
				//Round Rect
				Func = 2;
			}else{
				//Fill Rect
				Func = 3;
			}
		}
		
	}//End of FunctionHandler
	
	private class ButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==BtnFunc[0]){
				//Color Chooser
				selectedColor = JColorChooser.showDialog(PainterFrame.this, "Color Chooser", selectedColor);
				if (selectedColor == null) selectedColor = Color.LIGHT_GRAY;
			}else if (e.getSource()==BtnFunc[1]){
				//Save
			}else{
				//Load
			}
		}
	}//End of ButtonHandler
	
	private class MouseHanlder implements MouseListener{

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			//Save StartPoint
			startPoint.setLocation(e.getX(), e.getY());
		}

		public void mouseReleased(MouseEvent e) {
			//Save EndPoint and Painting
			endPoint.setLocation(e.getX(), e.getY());
			PaintObject[PaintObjectCount] = new Shape(Func,selectedColor,startPoint,endPoint);
			PaintObjectCount+=1;
			DrawPanel.repaint();			
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}	
	}//End of MouseHanlder
	//EventListener--End
}
