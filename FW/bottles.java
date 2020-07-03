import java.util.Arrays;

public class bottles {

	
	public static int[][] bottle(int a,int b){
		
		int n = (a+1)*(b+1);
		int mat[][] = new int [n][n];
		
		for(int i=0;i<=a;i++) {
			for(int j=0;j<=b;j++) {
				
				mat[convert(i, j, b)][convert(0, j, b)]=1;
				mat[convert(i, j, b)][convert(i, 0, b)]=1;
				mat[convert(i, j, b)][convert(a, j, b)]=1;
				mat[convert(i, j, b)][convert(i, b, b)]=1;
				mat[convert(i, j, b)][convert(Math.max(0,i-(b-j)),Math.min(i+j,b),b)]=1;
				mat[convert(i, j, b)][convert(Math.min(i+j, a),Math.max(0, j-(a-i)),b)]=1;
			}
		}
		
		
		print(mat);
		return mat;
		
		
		
	}
	
	static void print(int[][]mat) {
		
		for(int i=0;i<mat.length;i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		
	}
	
	public static int convert(int i,int j,int y) {
		return i*(y+1)+j;
	}
	
	
	
	public static void main(String[] args) {
		bottle(1, 2);
	}

}
