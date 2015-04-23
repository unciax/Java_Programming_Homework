package u0251055;

public class myComplex {
	float	real; 		// real part
	float	imaginary;  // imaginary part

	public myComplex(){
		real = (float)0.0;
		imaginary = (float)0.0;		
	}// End of myComplex constructor

	public myComplex(float r, float i){
		real = r;
		imaginary = i;
	}// End of myComplex constructor
	
	public void  Conjugate(){
		imaginary = (float)-1.0 * imaginary; 
	}// End of Conjugate
	
	public void  Add(myComplex c){
		real += c.real;
		imaginary += c.imaginary;
	}// End of Add operations
	
	public void  Sub(myComplex c){
		real -= c.real;
		imaginary -= c.imaginary;
	}// End of Sub operations
	
	public void  Mul(myComplex c){
		float tr,ti;
		tr = real*c.real - imaginary*c.imaginary;
		ti = real*c.imaginary + c.real*imaginary;
		real =tr;
		imaginary = ti;
	}// End of Mul operations
	
	public void  Div(myComplex c){
		float tr,ti;
		tr= (real*c.real + imaginary*c.imaginary)/(c.real*c.real + c.imaginary*c.imaginary);
		ti = (imaginary*c.real - real*c.imaginary)/(c.real*c.real + c.imaginary*c.imaginary);
		real =tr;
		imaginary = ti;
	}// End of Div operations

	public void  Pow(int order){
		myComplex c = new myComplex(real,imaginary);
		if (order<0) {
			for(int i=-0;i>=order;i--) this.Div(c);
		}else if ((0<order) && (order<1)){
			for(int i=2;i<=order;i++) this.Mul(c);
		}
		
	}// End of Power operations

	public void  List(){
		System.out.printf("(%f) + (%f)i\n",real ,imaginary);
	}// End of Add operations
}// End of myComplex class

