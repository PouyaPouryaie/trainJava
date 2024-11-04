package basictrain.accesslevel;

public class Parent {

    public int publicInt;
    private int privateInt;
    protected int protectedInt;

    public Parent() {
    }

    public Parent(int publicInt, int privateInt, int protectedInt) {
        this.publicInt = publicInt;
        this.privateInt = privateInt;
        this.protectedInt = protectedInt;
    }

    public int usePublic(){
        return publicInt;
    }

    private int usePrivate(){
        return privateInt;
    }

    protected int useProtected(){
        return protectedInt;
    }

    public int getPublicInt() {
        return publicInt;
    }

    public void setPublicInt(int publicInt) {
        this.publicInt = publicInt;
    }

    public int getPrivateInt() {
        return privateInt;
    }

    public void setPrivateInt(int privateInt) {
        this.privateInt = privateInt;
    }

    public int getProtectedInt() {
        return protectedInt;
    }

    public void setProtectedInt(int protectedInt) {
        this.protectedInt = protectedInt;
    }
}
