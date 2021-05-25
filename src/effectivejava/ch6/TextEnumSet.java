package effectivejava.ch6;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class TextEnumSet {

    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    public void applyStyles(Set<Style> styles){
        System.out.printf("Applying styles %s to text%n", Objects.requireNonNull(styles));
    }

    public static void main(String[] args) {
        TextEnumSet textEnumSet = new TextEnumSet();
        textEnumSet.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }

}
