import java.util.ArrayList;

public class Dijkstra {


	
	static int inf = 1000000;
	public static void main(String[] args) {
		int[][] mat = {{0 ,1 ,2 ,inf ,inf ,inf ,inf ,inf },
					  {1 ,0 ,4 ,inf ,5 ,inf ,inf ,inf },
					  {2 ,4 ,0 ,7 ,inf ,3 ,inf ,inf },
					  {inf ,inf ,7 ,0 ,3 ,8 ,inf ,inf },
					  {inf ,5 ,inf ,3 ,0 ,inf ,1 ,4 },
					  {inf ,inf ,3 ,8 ,inf ,0 ,2 ,inf },
					  {inf ,inf ,inf ,inf ,1 ,2 ,0 ,5 },
					  {inf ,inf ,inf ,inf ,4 ,inf ,5 ,0 }};
		
		ArrayList<ArrayList<Integer>> G = InitializeGraph();
		DijkstraAlgorithm(G, 0, 7, mat);
		
	}
	
	private static void DijkstraAlgorithm(ArrayList<ArrayList<Integer>> G, int s, int t, int[][] weightMatrix) {

		int n = G.size();
		int[] weight = new int[n];
		int[] prev = new int[n];
		boolean[] visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			weight[i] = inf;
			prev[i] = -1;
			visited[i] = false;
			
		}
		weight[s] = 0;
		int v = 0;
		
		while (((v = ExtractMin(weight, visited)) != -1)) {
			
			for(int u : G.get(v)) {
				if(visited[u]==false && weight[u] > weight[v] + weightMatrix[v][u]) {
					weight[u] = weight[v] + weightMatrix[v][u];
					prev[u] = v;

				}
			}
			visited[v] = true; 
			
			if(v == t) {
				break;
			}
			
			
		}
		
		System.out.println("dist = " + weight[t]);
		int k = t;
		String path = "";
		while(prev[k] != -1) {
			
			path =  "->" + k + path  ;
			k = prev[k];
			
		}
		path = k  + path;
		System.out.println(path);
		// 4  <-  1 <- 0
		

		
		
		
		
		
	}
	
	private static void PrintPath(int[] prev, int i) {
		
		

	}

	
	private static int ExtractMin(int[] dist, boolean[] visited) {

		int min_index = Integer.MAX_VALUE , min_value = Integer.MAX_VALUE;
		
		for(int i=0;i<visited.length;i++) {
			if(visited[i]==false && dist[i]<min_value) {
				min_index = i;
				min_value = dist[i];
			}
		}
		return min_index;
	}
	
	
	public static ArrayList<ArrayList<Integer>> InitializeGraph()
	{
		ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
		int numOfVertices = 8;

		for (int i = 0; i < numOfVertices; i++) {
			G.add(new ArrayList<Integer>());
		}

		G.get(0).add(1);
		G.get(0).add(2);

		G.get(1).add(0);
		G.get(1).add(2);
		G.get(1).add(4);

		G.get(2).add(0);
		G.get(2).add(1);
		G.get(2).add(3);
		G.get(2).add(5);

		G.get(3).add(2);
		G.get(3).add(4);
		G.get(3).add(5);

		G.get(4).add(1);
		G.get(4).add(3);
		G.get(4).add(7);

		G.get(5).add(2);
		G.get(5).add(3);
		G.get(5).add(6);

		G.get(6).add(4);
		G.get(6).add(5);
		G.get(6).add(7);

		G.get(7).add(4);
		G.get(7).add(6);

		return G;
	}
	
	
	
	
}
