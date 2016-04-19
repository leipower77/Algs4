import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Algs 4th Ch1- union find
 * 
 * @author hp
 */
public class UF {
	private int[] id;
	private int count;

	public UF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}

	}

	void union(int p, int q) {
		int pID = id[p];
		int qID = id[q];

		if (pID == qID)
			return;
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pID)
				id[i] = qID;
		}
		count--;
	}

	int find(int p) {
		return id[p];
	}

	boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	int count() {
		return count;
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		UF uf = new UF(N);
		NewCF ncf = new NewCF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();

			if (uf.connected(p, q)){
				if(ncf.connnected(p, q))
					continue;
				ncf.union(p,q);
				StdOut.println("ncf: " +p + " " + q);	
				continue;
			}
			uf.union(p, q);

			StdOut.println("cf: " +p + " " + q);
			
			
			if(ncf.connnected(p, q))
				continue;
			ncf.union(p,q);
			StdOut.println("ncf: " +p + " " + q);
		}
		StdOut.println(uf.count() + "components");
	}

}

class NewCF {

	private int id[];
	private int count;

	public NewCF(int N) {
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}

	}

	private int findLast(int p) {
		if (id[p] == p)
			return p;
		return findLast(id[p]);
	}

	public boolean connnected(int p, int q) {
		return findLast(p) == findLast(q);

	}

	public void union(int p, int q) {
		int lP = findLast(p);
		int lQ = findLast(q);

		if (lP == lQ)
			return;

		id[lQ] = id[lP];
		count--;
	}
	
	public int count(){
		return count;
	}

}

class WeighCF{
	private int id[];
	private int sz[];    //record the depth of the Node
	private int count;
	
	public WeighCF(int N){
		count = N;
		id = new int[N];
		for(int i=0; i<N;i++)
			id[i]=i;
		
		sz = new int[N];
		for(int i = 0; i<N; i++)
			sz[i] = 1;
	}
	
	private int find(int p){
		while(id[p] != p)
			p = id[p];
		return p;
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public int count(){
		return count;
	}
	public void union(int p, int q){
		int pf = find(p);
		int qf = find(q);
		
		if(pf == qf) return;
		
		if(sz[p] < sz[q]){
			id[pf] = qf;
			sz[qf] += sz[pf]; //只用更改根的深度即可，因为每次都是根据根的深度比较大小
		}
		
		else{
			id[qf] = pf;
			sz[pf] += sz[qf];
		}
		count--;
		
	}
	
	
	
}
