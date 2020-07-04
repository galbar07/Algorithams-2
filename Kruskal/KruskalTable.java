
import java.util.Arrays;
public class KruskalTable {
	int vertexGroup[];
	Eedge [] graph;	
	Eedge [] tree;	
	int numOfEdges, numOfVertexes, numEdgesInMST;
	
	/// constructor
	public KruskalTable(Eedge [] graph){
		numOfEdges = graph.length;
		numEdgesInMST = 0;
		int numOfVertexes = 0;
		
	// number of vertexes calculation
		for (int i=0; i<numOfEdges; i++){
			Eedge e = graph[i];
			if (e.getVertexA() > numOfVertexes) numOfVertexes = e.getVertexA();
			if (e.getVertexB() > numOfVertexes) numOfVertexes = e.getVertexB();			
		}
		
		this.numOfVertexes = numOfVertexes;
		this.graph = graph;
		Arrays.sort(this.graph);
		vertexGroup = new int[numOfVertexes];
		tree = new Eedge [numOfVertexes];
		for (int i=0; i<numOfVertexes; i++){
			vertexGroup[i] = i;
		}
	}
	
	public void MSPCreate(){
		int i=0;
		while(numEdgesInMST<numOfVertexes && i < numOfEdges){
			Eedge e = graph[i];
			int grA = vertexGroup[e.getVertexA()-1];
			int grB = vertexGroup[e.getVertexB()-1];
			if (grA != grB){
				tree[numEdgesInMST++] = graph[i];
				union(graph[i].getVertexA(), graph[i].getVertexB());
			}
			i = i + 1;
		}
	}
	private void union(int vertexA, int vertexB){
		int grA = vertexGroup[vertexA-1];
		int grB = vertexGroup[vertexB-1];
		for (int i=0;i<numOfVertexes; i++){
			if (vertexGroup[i]==grB){
				vertexGroup[i] = grA;
			}
		}		
	}
	public double calcSummWieight(){
		double w = 0;
		for (int i=0; i<numEdgesInMST; i++){
			w = w + tree[i].getWeight();
		}
		return w;
	}
	public void printTree(){
		for (int i=0; i<numEdgesInMST; i++){
			System.out.println(tree[i].toString());
		}
	}
	public static void main(String[] args) {
		
		int numOfEdges = 14;
		Eedge[] graph  = new Eedge[numOfEdges];	
		graph[0] = new Eedge(1,2,4);	// 1-st edge
		graph[1] = new Eedge(2,3,8);	// 2-st edge
		graph[2] = new Eedge(3,4,7);	// 3-st edge
		graph[3] = new Eedge(4,5,9);	// 4-st edge
		graph[4] = new Eedge(5,6,10);// 5-st edge
		graph[5] = new Eedge(6,7,2);// 6-st edge
		graph[6] = new Eedge(7,8,1);// 7-st edge
		graph[7] = new Eedge(8,1,8);// 8-st edge
		graph[8] = new Eedge(2,8,11);// 9-st edge
		graph[9] = new Eedge(3,9,2);// 10-st edge
		graph[10] = new Eedge(3,6,4);// 11-st edge
		graph[11] = new Eedge(4,6,14);// 12-st edge
		graph[12] = new Eedge(7,9,6);// 13-st edge
		graph[13] = new Eedge(8,9,7);// 14-st edge
		
		KruskalTable kt = new KruskalTable(graph);
		kt.MSPCreate();
		kt.printTree();
		System.out.println("sum weight = "+kt.calcSummWieight());
	}
}
/**
   result init1
    (7,8,w:1)
	(6,7,w:2)
	(3,9,w:2)
	(1,2,w:4)
	(3,6,w:4)
	(3,4,w:7)
	(2,3,w:8)
	(4,5,w:9)
	sum weight = 37.0
	
  result init2
	(1,4,w:4)
	(2,3,w:5)
	(1,2,w:7)
	(4,5,w:10)
	(5,6,w:11)
	sum weight = 37.0
	
 result init3
	(5,7,w:2)
	(1,2,w:6)
	(7,8,w:8)
	(3,4,w:9)
	(7,1,w:11)
	(4,5,w:14)
	(5,6,w:21)
	sum weight = 71.0


**/
