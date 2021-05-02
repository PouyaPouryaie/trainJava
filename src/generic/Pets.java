package generic;

import java.util.Objects;

public class Pets {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pets pets = (Pets) o;
        return numberFeet == pets.numberFeet &&
                skins.equals(pets.skins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberFeet, skins);
    }

    int numberFeet;
    String skins;
    String name;

    public Pets(int numberFeet, String skins, String name) {
        this.numberFeet = numberFeet;
        this.skins = skins;
        this.name = name;
    }

    public int getNumberFeet() {
        return numberFeet;
    }

    public void setNumberFeet(int numberFeet) {
        this.numberFeet = numberFeet;
    }

    public String getSkins() {
        return skins;
    }

    public void setSkins(String skins) {
        this.skins = skins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "numberFeet=" + numberFeet +
                ", skins='" + skins + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
