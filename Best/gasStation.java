
public class gasStation {
	
	
	public static int GasStationLocation(int [] gas , int cost []) {
		
		BestBoth b = new BestBoth();
		int [] sum = new int[gas.length];
		for(int i=0;i<sum.length;i++) {
			sum[i] = gas[i] - cost[i];
		}
		b.NegCalculate(sum);
		
		return b.startIndex;
		
	}
	
	
	

	public static void main(String[] args) {
		int[] arr = {5,6,2,3,9};
		int[] brr = {6,4,3,1,4};
		System.out.println(GasStationLocation(arr, brr));

	}

}
