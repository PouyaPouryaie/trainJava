package threadtrain.computing;

public class ComputingSum{

    private long[] array;
    private SumResult sumResult;
    private String name;

    public ComputingSum(String name, long[] array, SumResult sumResult) {
        this.name = name;
        this.sumResult = sumResult;
        this.array = array;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sum() {

        System.out.println("thread " + this.getName() + " start");

        for(int i=0; i < array.length;i++){
            sumResult.setResult(sumResult.getResult() + array[i]);
        }

        System.out.println("thread name is : " + this.getName() + " and result is :" + sumResult.getResult());
    }

    public SumResult getSumResult() {
        return sumResult;
    }

    public void setSumResult(SumResult sumResult) {
        this.sumResult = sumResult;
    }
}
