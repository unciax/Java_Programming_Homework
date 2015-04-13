package u0251055;

public class myComplexTest {
	public static void main(String[] args){
		myComplex c1 = new myComplex(1.0f, 1.0f);
		myComplex c2 = new myComplex(2.0f, 3.0f);
		
		System.out.print("c1=");
		c1.List();
		System.out.print("c2=");
		c2.List();
		
		System.out.print("after conjugate     : ");
		c1.Conjugate();
		c1.List();

		System.out.print("after addition      : ");
		c1.Add(c2);
		c1.List();
		
		System.out.print("after subtraction   : ");
		c1.Sub(c2);
		c1.List();
		
		System.out.print("after multiplication: ");
		c1.Mul(c2);
		c1.List();
		
		System.out.print("after division      : ");
		c1.Div(c2);
		c1.List();
		
		System.out.print("after power         : ");
		c1.Pow(2);
		c1.List();
	}//End of main sub
}
