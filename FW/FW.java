import java.util.Arrays;

public class FW {

	static int inf = 1000000;

	private static int[][] floyd_warshall(int[][] mat) {

		int n = mat.length;
		
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
				mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);	
							
		}}}
		return mat;

	}
	
	private static String[][] InitPath(int size, int[][] mat) {
		String[][] path = new String[size][size];
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				if (mat[i][j] != inf)
					path[i][j] = (i) + "";
			}
		}
		return path;
	}
	
	
	private static void floyd_warshall(int[][] mat, String[][] path) {
		int size = mat.length;
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (mat[i][k]!= inf &&  mat[k][j]!= inf)
						if (mat[i][k] + mat[k][j] < mat[i][j])
						{
							mat[i][j] = mat[i][k] + mat[k][j];
							path[i][j] = path[i][k] + "->" + path[k][j];
						}
				}
			}
		}
		System.out.println();
	}
	
	private static void FixPath(String[][] path) {
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				path[i][j] += "->"+(j);
			}
		}
	}
	
	
	public static void print(int [][]mat) {
		for(int i=0;i<mat.length;i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
	}
	
	private static void PrintAllPath(String[][] path) {
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				System.out.print((i)+"->"+(j)+":\t");
				if (path[i][j] != null)
					System.out.println(path[i][j]);
				else
					System.out.println("NO..");
			}
		}
		System.out.println("-------------------------");
	}
	
	//האם יש מסלול מ vi ל vj? O(1)
	public static boolean isTherePathBetweenIJ(int [][]mat , int i , int j) {
		return mat[i][j] != inf;
	}
	
	//האם הגרף קשיר?  O(n)
	public static boolean isConnected(int[][] mat) {
		
		for(int i=0;i<mat.length;i++) {
			if(mat[0][i]==inf) return false;
		}
		return true;	
	}
	
	//כמה רכיבי קשירות יש? 

	public static int SubGraphCounter(int [][]mat) {
		
		int [] arr = new int [mat.length];
		boolean [] visted = new boolean[mat.length];
		int counter = 1;
		for(int i=0;i<arr.length;i++) {
			
			if(!visted[i]) {
				
				for(int j=0;j<mat.length;j++) {
					
					if(mat[i][j] != inf) {
						visted[j] = true;
						arr[j] = counter ;
					}
				}
				counter++;
			}
			
		}
		return counter-1;
		
	}

//	מהם הקודקודים בכל רכיב קשירות? 

	public static void SubGraphDisplay(int [][]mat) {
		
		int [] arr = new int [mat.length];
		boolean [] visted = new boolean[mat.length];
		int counter = 0;
		for(int i=0;i<arr.length;i++) {
			if(!visted[i]) {
				for(int j=0;j<mat.length;j++) {		
					if(mat[i][j] != inf) {
						visted[j] = true;
						arr[j] = counter ;
					}
				}
				counter++;
			}
			
		}
		for(int k=0;k<counter;k++) {
			System.out.println("SubGraph " + k + "Items are");
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==k) {
				System.out.print(i + "\t");
			}
		}
		System.out.println("");
		}
		
		
	}
	
	private static int IsNegativeCycle(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
				if (mat[i][i]<0)
					return i;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		
//		int[][] mat2 = {{0, 1, inf, 5},
//					   {1, 0, 10, inf},
//					   {inf, 10, 0, 3},
//					   {5, inf, 3, 0}};
//		String[][] path = InitPath(mat2.length, mat2);
//		floyd_warshall(mat2, path);
//		FixPath(path);
//		print(mat2);	
//		System.out.println();
//		PrintAllPath(path);	
//		SubGraphCounter(mat2);
//		SubGraphDisplay(mat2);
		
		int[][] mat3 = {{0, 1, inf, 5,inf},
					{1, 0, 10, inf,inf},
					{inf, 10, 0, 3,inf},
				   	{5, inf, 3, 0,inf},
				   	{inf,inf,inf,inf,0}};
		String[][] path1 = InitPath(mat3.length, mat3);
		floyd_warshall(mat3, path1);
		FixPath(path1);
		print(mat3);	
		System.out.println();
		PrintAllPath(path1);
		SubGraphDisplay(mat3);
		
		
	}






	

}
