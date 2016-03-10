import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * Algs 4th Ch1- union find
 * @author hp
 */
public class UF {
	private int[] id;
	private int count;
	
	public  UF(int N){
		count = N;
		id = new int[N];
		for(int i = 0; i<N; i++){
			id[i] = i;
		}
		
	}
	
	void union(int p, int q){
		int pID = id[p];
		int qID = id[q];
		
		if(pID == qID)
			return ;
		for(int i = 0; i <id.length; i++){
			if(id[i] == pID)
				id[i] = qID;
		}
		count--;
	}
	
	int find(int p){
		return id[p];
	}
	
	boolean connected(int p, int q){
		return id[p] == id[q];
	}
	
	int count(){
		return count;
	}
	
	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF uf = new UF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			
			if(uf.connected(p, q) )
				continue;
			uf.union(p, q);
			
			StdOut.print(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}

}
