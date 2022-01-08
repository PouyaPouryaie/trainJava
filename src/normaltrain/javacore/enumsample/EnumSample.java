package normaltrain.javacore.enumsample;

public class EnumSample {

    public static void main(String[] args) {
        String side = "1";
        SampleEnum sampleEnum = SampleEnum.of("0");

        System.out.println(sampleEnum.getSideCode());
    }
}
