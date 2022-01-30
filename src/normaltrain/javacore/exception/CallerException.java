package normaltrain.javacore.exception;

import java.io.IOException;

public class CallerException {

    private final NullStringClass nullStringClass;

    public CallerException(NullStringClass nullStringClass) {
        this.nullStringClass = nullStringClass;
    }

    //this method handle exception of call method at self block code but throw checked exception and must be use throws in method signature
    public String getSampleFromNullClass() throws IOException{
        try {
            return nullStringClass.getSample();
        }catch (NullPointerException nullPointerException){
            throw new IOException(nullPointerException.getMessage());
        }
    }


}
