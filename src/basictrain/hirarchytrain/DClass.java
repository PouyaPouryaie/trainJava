package basictrain.hirarchytrain;

public class DClass {

    private CClass c = new CClass();

    public int result(int x){
        return c.dM(x);
    }

    public Object getObject(){
        return c;
    }
}
