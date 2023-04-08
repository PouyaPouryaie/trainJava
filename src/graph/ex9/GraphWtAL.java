package graph.ex9;
//****************************************************
// GraphWtAL.java -- basic class for weighted graphs
//                 uses adjacency lists
//     Modified 2023-Apr-5
//****************************************************


public class GraphWtAL
{
    protected int n;
    protected GNode AdjList[];
    protected int mark[];
    
    public GraphWtAL(int size)
    {
	n = size;
	AdjList = new GNode[n];
	mark = new int[n];
	for(int i=0;i<n;i++) {
	    AdjList[i] = null;
	    mark[i] = 0;
	}
    }
    
    public void reset(int unmarked)
    {
	for(int i=0;i<n;i++) {
	    mark[i] = unmarked;
	}
    }

    public void edgeReset(int unmarked)
    {
	for(int i=0;i<n;i++) {
	    for(GNode list=AdjList[i];list!=null;list=list.next) {
		list.mark = unmarked;

	    }
	}
    }


    public void addEdge(int x, int y, int wt)
    {

	GNode forward, backward;

	forward = new GNode(y, wt);
	backward = new GNode(x, wt);
	forward.partner = backward;
	backward.partner = forward;

	forward.next = AdjList[x]; // prev is already null
	AdjList[x] = forward;
	if(forward.next != null) {
	    forward.next.prev = forward;
	} // else is first to be added, no prev to set

	backward.next = AdjList[y]; // prev is already null
	AdjList[y] = backward;
	if(backward.next != null){
	    backward.next.prev = backward;
	} // else is first to be added, no prev to set


    }

    public void delEdge(int x, int y)
    {
	GNode entry = null;
	for(GNode list=AdjList[x];list!=null;list=list.next) {
	    if(list.nbr == y) {
		entry = list;
	    }
	}
	if(entry!=null) {
	    GNode rev = entry.partner;
	    if(entry.next!=null) {
		entry.next.prev = entry.prev;
	    }
	    if(entry.prev!=null) {
		entry.prev.next = entry.next;
	    }
	    else {
		AdjList[x] = entry.next;
	    }
	    entry.next = null;
	    entry.prev = null;
	    if(rev.next!=null) {
		rev.next.prev = rev.prev;
	    }
	    if(rev.prev!=null) {
		rev.prev.next = rev.next;
	    }
	    else {
		AdjList[y] = rev.next;
	    }
	    rev.next = null;
	    rev.prev = null;
	}
    }

    public String toString()
    {
	Integer iobj;
	String result = "";
	for(int i=0;i<n;i++) {
	    result += i + " (" + mark[i] + ") : ";
	    for(GNode list=AdjList[i];list!=null;list=list.next) {
		result += "\t" + list.nbr + " ("+list.weight+") ";
	    }
	    result += "\n";
	}
	return result;
    }
    

    protected class GNode
    {
	int nbr;
	int weight;
	int mark;
	GNode partner;
	GNode next;
	GNode prev;

	protected GNode(int index, int wt)
	{
	    nbr = index;
	    weight = wt;
	    mark = 0;
	    partner = null;
	    next = null;
	    prev = null;
	}

	public String toString()
	{
	    Integer iobj = Integer.valueOf(nbr);
	    return iobj.toString();
	}
    }

}
