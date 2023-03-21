import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {

        /** al momento de palicar expresiones regulares sobre las cadenas de texto en metodos como split() que
         * esta disponible con {@link Pattern} com con un String, y tener que sacar esto en un array, es mejor relizarlo con Pattern
         * dadas cuestiones de rendimineto
         */


        String phrase ="juan 8 hello, i'm juan too";

        /*estamod indicando que nos me importa ni lo que halla antes ni lo que halla despues de la palabra que
        * quiero encontrar con mi regex, esto con ayuda del .*.* */
        Pattern pattern = Pattern.compile("juan", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(phrase);

        /*matches practicmaente me estara evaluando si mi regex cumple con toda la cadena de texto en la qu estamos
        * buscando, por ende, estavamos busjando por .*.* para que no importe ni lo que existe delante de lo que estoy
        * queriendo buscar en mi expresion regular ni lo que este despues, sino simplmente estariasmo comparando
        * toda la cadena con lo que estamos buscando en la regex, es decir como si tuevieran que ser iguales*/
        System.out.println("se contro: " + matcher.matches());

        int contador = 1;
        /*el metodo find() nos evaluara cuantas veces encontro lo que estamos buscando por medio de la regex en
        * la cadena de texto, si si hemos utlizando el metodo lookingAt antes, el metodo find solo empezara a encontrar l
        * las concidencias despues de la primera primera concidencia si esta es por la que empeiza la cadena de texto,
        * en dado caso de que no utlicemos el metodo lookingAt antes, entonces contara la primera concidencia si esta es
        * por la que empieza la cadena de texto mas la demas concidencias que encuentre*/
        while (matcher.find()){
            System.out.println("palabra encontrada #" + contador++);
        }

        /*este metodo lookingAt() lo que me va a evaluar es si mi expresion regular cumple con la cadena con la
         * que inica el texto*/
        System.out.println("se contro: " + matcher.lookingAt());

        /*Algunas regex

        .  el punto basicamte lo que hara es ecompararnos que exista cualquier caracter al nosotros defirni la regex
        con ayuda de la clase Pattern
        * */
        System.out.println("evaluamos que nuestra cadena de texto tenga un caracter => cadena `m` regex . " + Pattern.matches(".", "m"));
        /*para este ejemplo en el caso de que existan mas de un caracter en la cadena de texto nos arrojara false,
        * ya que nuestra expresion regular esta realizando match con toda la cadena de texto y solo estamos comparando de que tenga n unico caracter
        * independientemete de cual sea*/

        /*
        * comparamos que en el texto que estamos buscando contenga una de las letras que definamos dentro de las []
        * al no aber ninguna de las letras mencionadas nos dara false*/
        System.out.println("cadena 'e' regex [abc] " + Pattern.matches(".*[abc].*", "e"));

        /*para definir una expresion regular distinta a las letras que estemos busncado, es decir realizaer alguna especie de negacion
        * lo hacemos con ^ por ejemplo vamos ahcer el caso contrario del anterioa ahora con nuestra regex vamos comparar que la cadena
        * de texto tenga cualquier letra diferente a las mencionadas dentro de []*/
        System.out.println("cadena 'a' regex [^abc] " + Pattern.matches("[^abc]", "a"));
    }
}
