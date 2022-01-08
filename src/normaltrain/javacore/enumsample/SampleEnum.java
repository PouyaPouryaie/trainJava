package normaltrain.javacore.enumsample;

import java.util.Arrays;

public enum SampleEnum {

    SIDE_BUY("0"),
    SIDE_SALE("1");

    private final String sideCode;

    SampleEnum(String sideCode) {
        this.sideCode = sideCode;
    }

    public String getSideCode() {
        return sideCode;
    }

    public static SampleEnum of(String code) {
        return Arrays.stream(SampleEnum.values())
                .filter(cfOrderSide -> cfOrderSide.getSideCode().equals(code))
                .findFirst().orElseGet(null);
    }
}
