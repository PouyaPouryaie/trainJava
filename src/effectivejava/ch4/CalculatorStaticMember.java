package effectivejava.ch4;

/**
 * item 24: Favor static member classes over nonstatic
 */
public class CalculatorStaticMember {

    private static class Operation{

        private static String staticName = "operationStaticName";
        private String name = "operation";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class PublicOperation{
        private String name = "PublicOperation";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private String staticName = Operation.staticName;
    private String publicName = new Operation().getName();

    public String getStaticName() {
        return staticName;
    }

    public void setStaticName(String staticName) {
        this.staticName = staticName;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }
}
