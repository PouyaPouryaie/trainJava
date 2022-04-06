package normaltrain.javacore.collectionsample.list;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CompareTwoList {

    public static void main(String[] args) {
        Collection<String> listOne = Arrays.asList("milan","iga",
                "dingo","iga",
                "elpha","iga",
                "hafil","iga",
                "meat","iga",
                "neeta.peeta","iga");

        Collection<String> listTwo = Arrays.asList("hafil",
                "iga",
                "binga",
                "mike",
                "dingo","dingo","dingo");

        Collection<String> similar = new HashSet<>( listOne );
        Collection<String> different = new HashSet<>();
        different.addAll( listOne );
        different.addAll( listTwo );

        similar.retainAll( listTwo ); // return just data exist in two set
        different.removeAll( similar ); // return just data exist in one of two list, remove subscription between 2 set
    }
}
