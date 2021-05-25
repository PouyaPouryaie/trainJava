package effectivejava.ch8;

//enable -ea in vm option
public class CheckMethodParameter {

    private static void sort(long[] a, int offset, int length){

        assert a != null : "is null";
        assert offset >= 0 && offset <= a.length : "is big";
        assert length >= 0 && length <= a.length - offset : "out of bound";
        System.out.println("ok");
    }

    public static void main(String[] args) {
        sort(new long[]{10,20,30}, 40, 30);
    }
}
