package basictrain.javacore.gc;

public class RefObj{

    private final long [] anArray = new long[4096];
    private final long id;
    private String name;

    public RefObj(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", name=" + name + '}';
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void finalize() throws Throwable {
        System.out.println("finalize() called for id: " + id);
    }
}
