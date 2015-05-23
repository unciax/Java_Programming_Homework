import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class CalcFrame extends JFrame {
	private JLabel lblNum1,lblNum2,lblResult;
	private JTextField tbNum1,tbNum2,tbResult;
	private JRadioButton btnGCD,btnLCM,btnPrime;
	private JButton btnCalc;
	private JPanel panNum,panChoice,panResult;
	private int func; // 0:GCD 1:LCM 2:Prime
	public CalcFrame(){
		//GUI
		super("Graphic User Interface");
		GridLayout grid = new GridLayout(3,1,5,5);
		FlowLayout flow = new FlowLayout();
		setLayout(grid);
		
		panNum = new JPanel();
		panNum.setLayout(flow);
		panChoice = new JPanel();
		panChoice.setLayout(flow);
		panResult = new JPanel();
		panResult.setLayout(flow);
		
		lblNum1 = new JLabel("Number1");
		lblNum1.setToolTipText("請輸入第一組數字.");
		panNum.add(lblNum1);
		
		tbNum1 = new JTextField(7);
		panNum.add(tbNum1);
		
		lblNum2 = new JLabel("Number2");
		lblNum2.setToolTipText("請輸入第二組數字.");
		panNum.add(lblNum2);
		
		tbNum2 = new JTextField(7);
		panNum.add(tbNum2);
		
		btnGCD = new JRadioButton("最大公因數",true);
		btnLCM = new JRadioButton("最小公倍數",false);
		btnPrime = new JRadioButton("互質",false);
		panChoice.add(btnGCD);
		panChoice.add(btnLCM);
		panChoice.add(btnPrime);
		
		ButtonGroup btnGroup = new ButtonGroup(); 
		btnGroup.add(btnGCD);
		btnGroup.add(btnLCM);
		btnGroup.add(btnPrime);
		
		btnCalc = new JButton("開始計算");
		panResult.add(btnCalc);
		
		lblResult = new JLabel("結果");
		lblNum1.setToolTipText("計算結果.");
		panResult.add(lblResult);
		
		tbResult = new JTextField(7);
		panResult.add(tbResult);
		
		add(panNum);
		add(panChoice);
		add(panResult);
		
		// Handler
		RadioButtonHandler radioButtonHandler = new RadioButtonHandler();
		btnGCD.addItemListener(radioButtonHandler);
		btnLCM.addItemListener(radioButtonHandler);
		btnPrime.addItemListener(radioButtonHandler);
		
		ButtonHandler buttonHandler = new ButtonHandler();
		btnCalc.addActionListener(buttonHandler);
		//Initialization
		func=0;
	}/* End of CalcFrame */
	
	private class RadioButtonHandler implements ItemListener{
		public void itemStateChanged(ItemEvent event){
			if(event.getSource() == btnGCD){
				func=0;
			}else if(event.getSource() == btnLCM){
				func=1;
			}else if(event.getSource() == btnPrime){
				func=2;
			}
		}/* End of itemStateChanged */
	}/* End of class RadioButtonHandler */

	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			switch(func){
			case 0:
				tbResult.setText(String.format("%d", GCD(Integer.parseInt(tbNum1.getText()),Integer.parseInt(tbNum2.getText()))));
				break;
			case 1:
				tbResult.setText(String.format("%d", LCM(Integer.parseInt(tbNum1.getText()),Integer.parseInt(tbNum2.getText()))));
				break;
			case 2:
				tbResult.setText(Boolean.toString(Prime(Integer.parseInt(tbNum1.getText()),Integer.parseInt(tbNum2.getText()))));
				break;
			}
		}/* End of actionPerformed */
	}/* End of ButtonHandler */
	
	private int GCD(int a,int b){
		int i,result=1;
		if(a>b) i=b;
		else  i =a; 
		for(;i>1;i--){
			if((a % i == 0) && (b % i == 0)){
				result = i;
				break;
			}
		}
		return result;
	}
	private int LCM(int a,int b){
		int result=1;
		result = Math.abs(a*b)/GCD(a,b);
		return result;
	}	
	private boolean Prime(int a,int b){
		boolean result=false;
		if(GCD(a,b)==1) result =true;
		return result;
	}	
}/* End of CalcFrame */
