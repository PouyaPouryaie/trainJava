package generic;

public class Cats extends Pets {

    String skinColor;

    public Cats(int numberFeet, String skins, String name, String skinColor) {
        super(numberFeet, skins, name);
        this.skinColor = skinColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    @Override
    public String toString() {
        return "Cats{" +
                "skinColor='" + skinColor + '\'' +
                '}';
    }
}
