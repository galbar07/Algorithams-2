
public class Best {
	
	int startIndex;
	int endIndex;
	int sum;
	
	
	public void bestMax(int[] a) {

		
		int temp_max = 0,start = 0, end = 0, s = 0; 
		int max =Integer.MIN_VALUE;
		 for (int i = 0; i < a.length; i++)  
	        { 
	        	temp_max += a[i]; 
	  
	            if (max < temp_max)  
	            { 
	            	max = temp_max; 
	                start = s; 
	                end = i;   
	            } 
	  
	            if (temp_max < 0)  
	            { 
	            	temp_max = 0; 
	                s = i + 1; 
	            } 
	        } 
	        sum =  max; 
	        startIndex =  start; 
	        endIndex = end;
		
	}
	
	
	
//	public static int bestCycle(int[] a) {
//		
//		int b[]= new int[a.length];
//		int sum =0;
//		for (int i = 0; i < a.length; i++) {
//			sum+=a[i];
//			b[i]=a[i]*-1;
//		}
//		System.out.println("hello");
//		System.out.println(sum);
//		int max = Math.max(bestMax(a), sum+(bestMax(b)));
//		return max;
//		
//		//7,6 - 
//	}
	

	public static void main(String[] args) {
		int arr[] = {5,-3,4,-7,1,7,-2,3,-2};
		Best b = new Best();
		b.bestMax(arr);
		System.out.println(b.startIndex);
		System.out.println(b.endIndex);
		System.out.println(b.sum);
		
	}

}
