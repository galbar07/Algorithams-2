import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class BFS {
	
	
	int[][] mat;
	int[] color;
	int[] distance;
	int[] father;
	int[] subGraphs;
	int V; //numberOfVertecies
	


	
	public BFS(int[][] matrix)
	{
		mat = matrix;
		V = mat.length;
		color = new int[V];
		distance = new int[V];
		father = new int[V];
		subGraphs = new int[V];
	}
	
	private void bfs(int s) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		Initialize();
		
		q.add(s);
		color[s] = 1;
		distance[s] = 0;
		father[s] = -1;
			
		
		int v;
		while (!q.isEmpty())
		{
			v = q.poll();
			for (int u = 0; u < V; u++)
			{
				if (color[u] == 0 && mat[v][u] == 1)
				{
					color[u] = 1;
					distance[u] = distance[v]+1;
					father[u] = v;
					q.add(u);
					
				}
				
				
			}
			color[v] = 2;
				
		}
	}
	
	
	private void Initialize() {
		for (int v = 0; v < V; v++) {
			color[v] = 0;//white
			distance[v] = 0;
			father[v] = -1;
		}	
	}
	
	
	public boolean IsConnected()
	{
		for (int v = 0; v < V; v++)
		{
			if (color[v] == 0)
				return false;
		}
		return true;
		
	}
	
	public boolean IsTherePathBetween_v_and_u(int v, int u)
	{
		bfs(v);
		if (color[u] == 2)
			return true;
		return false;
	}
	
	//after checking IsTherePathBetween_v_and_u
		public ArrayList<Integer> GetPathBetween_v_and_u(int v, int u)
		{
			ArrayList<Integer> path = new ArrayList<Integer>();
			
			int vertex = u;
			while(father[vertex] != -1)
			{
				path.add(vertex);
				vertex = father[vertex];
			}
			path.add(vertex);
			
			//reverse the list
			int temp;
			for (int i = 0; i < path.size()/2; i++) {
				temp = path.get(i);
				path.set(i, path.get(path.size()-1-i));
				path.set(path.size()-1-i, temp);
			}
			
			return path;
		}
		
		
		public int subGraph() {
			boolean [] visted = new boolean[V];
			int count = 0;
			for(int i=0;i<V;i++) {
				if(!visted[i]) {
				bfs(i);
				for(int j=0;j<V;j++) {
					if(color[j]==2) {
						visted[j] = true;
						subGraphs[j] = count;
					}
					
				}
				count++;
			}
		}
			return count;
			
		}
		
		public void printSubGraphs() {
			int count = subGraph();
			int s = 0;
			while(count>0) {
			System.out.println("Items for the First SubGraph " + s + " are ");
			for(int i=0;i<V;i++) {
				if(subGraphs[i]==s)
				System.out.print(i + "\t");
			}
			count--;
			s++;
			System.out.println(" ");
		}
			
		}
		
		
	public int diamter() {
		int v = 0 ;
		bfs(0);
		int maxIndex = findMax(this.distance);
		bfs(maxIndex);
		maxIndex = findMax(this.distance);
		return distance[maxIndex];
	}

	
	private int findMax(int [] dist) {
		
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i=0 ;i < dist.length; i++) {
			if(dist[i] > max) {
				max = dist[i];
				index = i;
			}
		}
		return index;
	
	}
	

	public static void main(String[] args) {
		int[][] graph = {{0,1,1,0,0,0},
				 {1,0,1,0,0,0},
				 {1,1,0,0,0,0},
				 {0,0,0,0,1,0},
				 {0,0,0,1,0,0},
				 {0,0,0,0,0,0}};

int[][] graph2 ={{0,1,1,0,0,0},
				 {1,0,1,0,0,0},
				 {1,1,0,0,0,0},
				 {0,0,0,0,1,1},
				 {0,0,0,1,0,1},
				 {0,0,0,1,1,0}};

int[][] graph1 ={{0,0,0,1,0,0},
			     {0,0,0,1,1,1},
			 	 {0,0,0,1,1,1},
				 {1,1,1,0,0,0},
				 {0,1,1,0,0,0},
				 {0,1,1,0,0,0}};

		 BFS bf = new BFS(graph);
		 System.out.println(bf.subGraph());
		 bf.printSubGraphs();
		 System.out.println("Diamter");
		 System.out.println(bf.diamter());
		// System.out.println(bf.GetPathBetween_v_and_u(1, 2));
		 
		 
	}

}
