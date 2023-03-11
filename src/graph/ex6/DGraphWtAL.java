//************************************************************
// DGraphWtAL.java -- basic class for directed weighted graphs
//                 uses adjacency lists
// Updated 21-Feb-2023
//************************************************************
package graph.ex6;

public class DGraphWtAL
{
    public int n;
    public GNode OutAL[];
    public GNode InAL[];
    public int mark[];
    
    public DGraphWtAL(int size)
    {
	n = size;
	OutAL = new GNode[n];
	InAL = new GNode[n];
	mark = new int[n];
	for(int i=0;i<n;i++) {
	    OutAL[i] = null;
	    InAL[i] = null;
	    mark[i] = 0;
	}
    }
    
    public void reset(int unmarked)
    {
	for(int i=0;i<n;i++) {
	    mark[i] = unmarked;
	}
    }


    public void addEdge(int x, int y, int wt, int used)
    {

	GNode forward, backward;

	forward = new GNode(y, wt, used);
	backward = new GNode(x, wt, used);
	forward.partner = backward;
	backward.partner = forward;

	forward.next = OutAL[x]; // prev is already null
	OutAL[x] = forward;
	if(forward.next != null) {
	    forward.next.prev = forward;
	} // else is first to be added, no prev to set

	backward.next = InAL[y]; // prev is already null
	InAL[y] = backward;
	if(backward.next != null){
	    backward.next.prev = backward;
	} // else is first to be added, no prev to set


    }


    public boolean testEdge(int x, int y)
    {
	boolean found = false;

	for(GNode list=OutAL[x];list!=null&&!found;list=list.next) {
	    if(list.nbr == y) {
		found = true;
	    }
	}
	return found;
    }


    public String toString()
    {
      	Integer iobj;
	String result = "";
	result += "Out: \n";
	for(int i=0;i<n;i++) {
	    result += i + " (" + mark[i] + ") : ";
	    for(GNode list=OutAL[i];list!=null;list=list.next) {
		result += "\t" + list.nbr + " ("+list.weight+","+list.mark+") ";
	    }
	    result += "\n";
	}
	result += "In: \n";
	for(int i=0;i<n;i++) {
	    result += i + " (" + mark[i] + ") : ";
	    for(GNode list=InAL[i];list!=null;list=list.next) {
		result += "\t" + list.nbr + " ("+list.weight+","+list.mark+") ";
	    }
	    result += "\n";
	}

	return result;
    }
    

    public class GNode
    {
	int nbr;
	int weight;
	int mark;
	GNode partner;
	GNode next;
	GNode prev;

	public GNode(int index, int wt, int used)
	{
	    nbr = index;
	    weight = wt;
	    mark = used;
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
