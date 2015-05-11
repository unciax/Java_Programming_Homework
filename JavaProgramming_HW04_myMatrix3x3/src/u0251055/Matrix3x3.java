package u0251055;

public class Matrix3x3 {
	// field
	double[][] 	matrix = new double[3][3];
	
	//constructor
	public Matrix3x3(){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				matrix[i][j]=0;
			}
		}
	}// End of Matrix3x3
	public Matrix3x3(double[][] m){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				matrix[i][j]=m[i][j];
			}
		}
	}// End of Matrix3x3
	
	//operations		
	public void Identity(){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				if(i==j){ matrix[i][j]=(double)1.0; }
				else { matrix[i][j]=(double)0.0; }
			}
		}
	} // End of Identity
	
	public void Transpose(){
		double [][] temp = new double[matrix.length][matrix[0].length]; 
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				temp[i][j]= matrix[i][j];
			}
		}
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				matrix[i][j]= temp[j][i];
			}
		}
	} // End of Transpose
	
 	public void Multiplication(double[][] m){
 		double [][] temp = new double[matrix.length][m[0].length]; 
 	      for(int i=0;i<matrix.length;i++){
 	    	  for(int j=0;j<m[0].length;j++){
 	    		  for(int k=0;k<matrix[0].length;k++){
 	    			  temp[i][j]+=matrix[i][k]*m[k][j];
 	    		  }
 	    	  }
 	      }
 	      for(int i=0;i<matrix.length;i++){
 	    	  for(int j=0;j<matrix[i].length;j++){
 	    		  matrix[i][j]=temp[i][j];
 	    	  }
 	      }
 	}// End of Multiplication
 	
 	public double Determinant(){
 		double result=0.0;
 		result = matrix[0][0]*matrix[1][1]*matrix[2][2] + matrix[0][1]*matrix[1][2]*matrix[2][0]+matrix[0][2]*matrix[1][0]*matrix[2][1];
 		result -= (matrix[0][2]*matrix[1][1]*matrix[2][0]+matrix[1][2]*matrix[2][1]*matrix[0][0]+matrix[2][2]*matrix[1][0]*matrix[0][1]);
 		return result;
 	}// End of Determinant
 	
	public boolean Inverse(){
		boolean result=false;
		double[][] temp=new double[3][3];
		double det = Determinant();
		if(det !=0){
			temp[0][0]=(matrix[1][1]*matrix[2][2]-matrix[1][2]*matrix[2][1])/det;
			temp[0][1]=-(matrix[1][0]*matrix[2][2]-matrix[1][2]*matrix[2][0])/det;
			temp[0][2]=(matrix[1][0]*matrix[2][1]-matrix[1][1]*matrix[2][0])/det;
			temp[1][0]=-(matrix[0][1]*matrix[2][2]-matrix[0][2]*matrix[2][1])/det;
			temp[1][1]=(matrix[0][0]*matrix[2][2]-matrix[0][2]*matrix[2][0])/det;
			temp[1][2]=-(matrix[0][0]*matrix[2][1]-matrix[0][1]*matrix[2][0])/det;
			temp[2][0]=(matrix[0][1]*matrix[1][2]-matrix[0][2]*matrix[1][1])/det;
			temp[2][1]=-(matrix[0][0]*matrix[1][2]-matrix[0][2]*matrix[1][0])/det;
			temp[2][2]=(matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0])/det;
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[i].length;j++){
					matrix[i][j]= temp[i][j];
				}
			}
			Transpose();
			result=true;
		}else{
			result=false;
		}
		return result;
	}// End of Inverse
	
	public void	Show(){
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				System.out.printf("%f ",matrix[i][j]);
			}
			System.out.printf("\n");
		}		
	}// End of Show

}
