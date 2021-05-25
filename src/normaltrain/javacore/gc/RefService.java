package normaltrain.javacore.gc;

public class RefService {

    RefObj refObj = new RefObj(10, "pouya");

    //release resource
    public RefObj getRef(){
        try{
            return refObj;
        }finally {
            refObj = null;
        }
    }

    public String getName(){
        return refObj.getName();
    }
}
