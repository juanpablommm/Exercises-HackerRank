import java.util.Arrays;
import java.util.Collection;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solucion {


    public static void main(String[] args) {
        String phrase = "He is a very very good boy, isn't he?";
        Pattern pattern = Pattern.compile("[A-Za-z !,?._'@]+");
        Collection<String> filters = Arrays.stream(phrase.split("[ !,?._'@]")).filter(x -> !x.isEmpty()
        && pattern.matcher(x).matches()).collect(Collectors.toList());
        System.out.println(filters.size());
        filters.forEach(System.out::println);
    }
}
