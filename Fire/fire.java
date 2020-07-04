import java.util.ArrayList;

public class fire {
	
	int center1,center2,radius,diameter;
	
	public fire(ArrayList<Integer>[] graph) {
		
		int n = graph.length;
		int []deg = new int[n];
		int r=0;
		
		ArrayList<Integer> leaves = new ArrayList<Integer>();//L
		ArrayList<Integer> newLeaves = new ArrayList<Integer>();//L'
		
		for(int i=0;i<n;i++) {
			deg[i] = graph[i].size();
			if(graph[i].size()==1) {
				leaves.add(i);
			}
			
		}
		
		while(n > 2) {
			
			newLeaves = new ArrayList<Integer>();
			r++;
			
			while(!leaves.isEmpty()) {
				
				int u = leaves.remove(0);
				deg[u]--;
				n--;
				
				for(int v:graph[u]) {
					
					if(deg[v]!=0) {
						deg[v]--;
						if(deg[v]==1) {newLeaves.add(v);}
					}
					
					
				}
				
			}
			leaves = newLeaves;
			
			
			
		}
		
		if(n==2) {
			center1 = leaves.remove(0);
			center2 = leaves.remove(0);
			radius = r+1;
			diameter = 2*radius-1;
			
			
		}
		else {
			center1=center2=leaves.remove(0);
			radius=r;
			diameter=2*r;
			
		}
		
		
		
		
	}
	
	
	
	
	

	public static void main(String[] args) {
		
		ArrayList<Integer>[] graph = new ArrayList[5];
		graph[0] = new ArrayList<Integer>();
		graph[1] = new ArrayList<Integer>();
		graph[2] = new ArrayList<Integer>();
		graph[3] = new ArrayList<Integer>();
		graph[4] = new ArrayList<Integer>();
		
		graph[0].add(1);//1->2
		
		graph[1].add(0);//2->1
		graph[1].add(2);//2->3
		
		graph[2].add(1);//3->2
		graph[2].add(4);//3->5
		
		graph[3].add(4);//3->5
		
		graph[4].add(2);//5->4
		graph[4].add(3);//5->3
		
		
		
		fire f = new fire(graph);
				
		System.out.println("diameter is" + f.diameter);
		System.out.println("radius is" + f.radius);
		
		
	}

}
