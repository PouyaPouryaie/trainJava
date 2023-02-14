//************************************************************
// DGraphWtAL.java -- basic class for directed weighted graphs
//                 uses adjacency lists
//************************************************************
package graph.ex3;

public class DGraphWtAL {
    protected int n;
    protected GNode OutAL[];
    protected GNode InAL[];
    protected int mark[];

    public DGraphWtAL(int size) {
        n = size;
        OutAL = new GNode[n];
        InAL = new GNode[n];
        mark = new int[n];
        for (int i = 0; i < n; i++) {
            OutAL[i] = null;
            InAL[i] = null;
            mark[i] = 0;
        }
    }

    public void reset(int unmarked) {
        for (int i = 0; i < n; i++) {
            mark[i] = unmarked;
        }
    }


    public void addEdge(int x, int y, int wt) {

        GNode forward, backward;

        forward = new GNode(y, wt);
        backward = new GNode(x, wt);
        forward.partner = backward;
        backward.partner = forward;

        forward.next = OutAL[x]; // prev is already null
        OutAL[x] = forward;
        if (forward.next != null) {
            forward.next.prev = forward;
        } // else is first to be added, no prev to set

        backward.next = InAL[y]; // prev is already null
        InAL[y] = backward;
        if (backward.next != null) {
            backward.next.prev = backward;
        } // else is first to be added, no prev to set


    }

    public String toString() {
        Integer iobj;
        String result = "";
        result += "Out: \n";
        for (int i = 0; i < n; i++) {
            result += i + " (" + mark[i] + ") : ";
            for (GNode list = OutAL[i]; list != null; list = list.next) {
                result += "\t" + list.nbr + " (" + list.weight + ") ";
            }
            result += "\n";
        }
        result += "In: \n";
        for (int i = 0; i < n; i++) {
            result += i + " (" + mark[i] + ") : ";
            for (GNode list = InAL[i]; list != null; list = list.next) {
                result += "\t" + list.nbr + " (" + list.weight + ") ";
            }
            result += "\n";
        }

        return result;
    }


    protected class GNode {
        int nbr;
        int weight;
        int mark;
        GNode partner;
        GNode next;
        GNode prev;

        protected GNode(int index, int wt) {
            nbr = index;
            weight = wt;
            mark = 0;
            partner = null;
            next = null;
            prev = null;
        }

        public String toString() {
            Integer iobj = Integer.valueOf(nbr);
            return iobj.toString();
        }
    }

}
