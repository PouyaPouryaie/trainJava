package lambdatrain.factorypattern.basic;

public class Apple implements Product {

    int weight;
    String name;
    String color;

    public Apple(int weight, String name, String color) {
        this.weight = weight;
        this.name = name;
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
