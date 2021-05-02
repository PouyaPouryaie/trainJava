package normaltrain.accesslevel;

public class FirstChild extends Parent{

    public FirstChild(int publicInt, int privateInt, int protectedInt) {
        super(publicInt, privateInt, protectedInt);
    }

/*    @Override
    public int usePublic() {
        return super.usePublic();
    }

    @Override
    protected int useProtected() {
        return super.useProtected() + 10;
    }*/
}
