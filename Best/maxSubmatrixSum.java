import java.util.Arrays;

public class maxSubmatrixSum {
	
	
	private static int[][] trans(int[][]mat){
		
		int [][]mat_h = new int [mat[0].length][mat.length];
		for(int i=0;i<mat[0].length;i++) {
			for(int j=0;j<mat.length;j++) {		
				mat_h[i][j] = mat[j][i];
			}
		}
		
		return mat_h;
	}
	
	
	public static int MaxSubMat(int[][]mat) {
		
		if(mat.length>mat[0].length) {
			mat = trans(mat);
		}
		
		
		Best b = new Best();
		int starti=0, startj=0, endk=0, endl=0, sum=0;
		int max = Integer.MIN_VALUE;
		int arr[] = new int[mat.length];
		for(int i=0;i<mat[0].length;i++) {
			
			arr = new int[mat.length];
			for(int j=i;j<mat[0].length;j++) {	
				for(int k=0;k<mat.length;k++) {	
					arr[k]+=mat[k][j];
				}
				
				b.bestMax(arr);
				if(b.sum>max) {
					max = b.sum;
					starti = i;
					startj = b.startIndex;
					endk = j;
					endl = b.endIndex;
					
				}
			}
		}
		System.out.println("final max is" + max);
		System.out.println("Start index row is "+starti);
		System.out.println("Start index col is "+startj);
		System.out.println("finish index row is "+endk);
		System.out.println("finish index col is "+endl);
		return 0;
		
		
		
	}
	
	
	
	

	public static void main(String[] args) {
		int[][] mat = {{2,1,-3,-4,5},{0,-8,3,4,1},{2,-2,-1,4,-5},{-3,3,1,0,3}};		
		
		for(int i=0;i<mat.length;i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println(" ");
		
		MaxSubMat(mat);
	
	}

}
