import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class BuildTreeFromDegreesArray {
	
	
	private static int[] build(int[] deg) {
		
		int sum = 0;
		int n = deg.length;
		for(int i=0;i<deg.length;i++) {
			sum += deg[i];
		}
		
		if(getDeg(n)!=sum) {throw new RuntimeErrorException(null, "invalid input");}
		
		int []tree = new int[n];
		Arrays.sort(deg);
		int j = findStartIndex(deg);
		
		for(int i=0;i<n-2;i++) {
			
			tree[i] = j;
			deg[j]--;
			
			if(deg[j]==1) {
				j++;
			}
				
		}
		
		tree[n-1] = n-2; // Check about the last one

		
		
		
		
		
		return tree;
	}
	
	private static int findStartIndex(int[] deg) {
		
		for(int i=0;i<deg.length;i++) {
			if(deg[i]>1) return i;
		}
		
		return 0;
	}

	private static int getDeg(int n) {
		return 2*n-2;
	}
	
	

	public static void main(String[] args) {
		
		int []deg = {1,1,1,1,2,2,3,3};
		int []tree = build(deg);
		
	}

	

}
