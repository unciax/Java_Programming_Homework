package u0251055;

public class MatrixTest {
	// main method begins execution of Java application
		public static void main( String args[] ){
			// test identity	
			System.out.printf("[---Test Identity Operation---] \n");
			Matrix3x3 matrixIdentity = new Matrix3x3();
			matrixIdentity.Identity();
			matrixIdentity.Show();

			// test transpose
			/*System.out.printf("[---Test Transpose Operation---] \n");
			double[][] transpose = {{4.0,0.0,0.0},{4.0,-2.0,5.0},{2.0,8.0,7.0}};
			Matrix3x3 matrixTranspose = new Matrix3x3(transpose);
			matrixTranspose.Show();
			System.out.printf("\n");
			matrixTranspose.Transpose();
			matrixTranspose.Show();*/
			
			// test multiply
			System.out.printf("[---Test Multiply Operation---] \n");
			double[][] Mulmatrix1 = {{4.0,0.0,0.0},{4.0,-2.0,5.0},{2.0,8.0,7.0}};
			double[][] Mulmatrix2 = {{0.25,0.0,0.0},{0.083333,-0.12963,0.092593},{-0.166667,0.148148,0.037037}};
			Matrix3x3 matrixMultiply = new Matrix3x3(Mulmatrix1);
			matrixMultiply.Multiplication(Mulmatrix2);
			matrixMultiply.Show();
			
			// test determinant
			/*System.out.printf("[---Test Determinant Operation---] \n");
			double[][] determinant = {{4.0,0.0,0.0},{4.0,-2.0,5.0},{2.0,8.0,7.0}};
			Matrix3x3 matrixDeterminant = new Matrix3x3(determinant);
			System.out.printf("Value is %f\n",matrixDeterminant.Determinant());*/
			
			// test inverse
			System.out.printf("[---Test Inverse Operation---] \n");
			double[][] inverse={{4.0,0.0,0.0},{4.0,-2.0,5.0},{2.0,8.0,7.0}};
			Matrix3x3 matrixInverse = new Matrix3x3(inverse);
			matrixInverse.Show();
			System.out.printf("\n");
			if(matrixInverse.Inverse() == true){
				matrixInverse.Show();
				// verify the inverse
				System.out.printf("\n");
				matrixInverse.Multiplication(inverse);
				matrixInverse.Show();
			}else{
				System.out.printf("This matrix has no inverse\n");
			}//End of if-condition

		}// End of main class
}
