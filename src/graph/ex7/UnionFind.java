package graph.ex7;
//********************************
// UnionFind.java
//********************************


public class UnionFind
{
    int size;
    int [] rep; // parent pointer
    int [] rank; // rank for rank-based union
    
    public UnionFind(int n) 
    {
	size = n;
	rep = new int[size];
	rank = new int[size];
	for(int i=0;i<n;i++) { // initializes singleton sets
	    rep[i] = i;
	    rank[i] = 0;
	}

    }

    public int find(int i) { 

	int parent = rep[i];
	if(parent != i) {
	    parent = find(parent); // recursively find representative
	    rep[i] = parent; // do path compression
	}
	return parent;
    }

    public void union(int i, int j) {
	int a, b, t;

	a = find(i); // find roots
	b = find(j);
	if(a!=b){
	    if(rank[a] < rank[b]) {
		t = a;
		a = b;
		b = t;
	    }
	    rep[b] = a;
	    if(rank[a] == rank[b]) {
		rank[a]++;
	    }
	}

    }

    public String toString()
    {
	String result = "";
	for(int i=0;i<size;i++) {
		result += rep[i] + "\t";
	}
	result += "\n";
	return result;

    }

}
