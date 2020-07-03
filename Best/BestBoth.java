public class BestBoth{
	
	int startIndex;
	int endIndex;
	int sum;
	

	public static void main(String[] args) {
		int b [] = {0,-4,8,-2};
		BestBoth a = new BestBoth();
		a.NegCalculate(b);
		System.out.println("Sum is  " + a.sum);
		System.out.println("Start is " + a.startIndex);
		System.out.println("End index is " + a.endIndex);

		
	}
	
		
		
		public int[] Calculate(int[] a)
		{
	        int max = a[0], 
	        temp_max = 0,start = 0, 
	        end = 0, s = 0; 
	  
	        for (int i = 0; i < a.length; i++)  
	        { 
	        	temp_max += a[i]; 
	  
	            if (max < temp_max)  
	            { 
	            	max = temp_max; 
	                start = s; 
	                end = i; 
	            } 
	  
	            if (temp_max <= 0)  
	            { 
	            	temp_max = 0; 
	                s = i + 1; 
	            } 
	        } 
	        sum =  max; 
	        startIndex =  start; 
	        endIndex = end;
	        return new int[]{max,start,end};
		}
		
		public void NegCalculate(int[] a) {
			int n=a.length,sum=0;
			int na[]= new int[n];
			for(int i=0; i<n; i++) {
				sum+=a[i];
				na[i]= -a[i];				
			}
			int best1[] = Calculate(a);
			int best2[] = Calculate(na);
			if(best1[0]<0 || best1[0]>= sum + best2[0]) {
				this.sum = best1[0];
				this.startIndex = best1[1];
				this.endIndex = best1[2];
				
			}
			else {
				this.sum = best2[0] + sum;
				this.startIndex = (best2[2]+1)%n;
				this.endIndex = (best2[1]-1);
			}
			
		}
}