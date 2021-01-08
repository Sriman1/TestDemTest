import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class DjikNode{
	int val;
	int edgeDist;
	
	DjikNode(int val, int edgeDist){
		this.val=val;
		this.edgeDist=edgeDist;
		
	}
}
public class Djikst {
	
	public static void sssp(List<List<DjikNode>> adjList, int v, int src) {
		
		int[] dist=new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<DjikNode> pq=new PriorityQueue<DjikNode>((a,b)->a.edgeDist-b.edgeDist);
		Set<Integer> relaxed=new HashSet<>();
		
		pq.add(new DjikNode(src,0));
		dist[src]=0;
		while(relaxed.size()!=v) {
			
			DjikNode polled=pq.poll();
			relaxed.add(polled.val);
			
			addNeighbours(pq,dist,adjList,polled.val);
		}
		
		
	}

	private static void addNeighbours(PriorityQueue<DjikNode> pq, int[] dist, List<List<DjikNode>> adjList, int src) {
		
		
		for(DjikNode u:adjList.get(src)) {
			
			int srcDist=dist[src];
			int edgeDist=u.edgeDist;
			if(srcDist+edgeDist<dist[u.val]) {
				dist[u.val]=srcDist+edgeDist;
			}
			
			pq.add(new DjikNode(u.val, dist[u.val]));
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<List<DjikNode>> adjList=new ArrayList<>();
int vertex=5;
for(int i=0;i<5;i++) {
	adjList.add(i,new ArrayList<>());
}

	adjList.get(0).add(new DjikNode(4,3));
	adjList.get(0).add(new DjikNode(3,1));
	adjList.get(0).add(new DjikNode(2,6));
	adjList.get(0).add(new DjikNode(1,9));
	adjList.get(2).add(new DjikNode(1, 2));
	adjList.get(3).add(new DjikNode(2, 1));
	
	sssp(adjList,vertex,0);

}
	}


