import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        // Se le indica el nombre del archivo html
        Queue<HtmlTag> tags = HtmlReader.getTagsFromHtmlFile("index.html");

        // Validamos si el html está bien formateado
        Stack<HtmlTag> isValid = HtmlValidator.isValidHtml(tags);

        // Se llama al metodo de salida
        outIsValid(isValid);
    }

    // Metodo de salida
    public static void outIsValid(Stack<HtmlTag> isValid){
        if (isValid == null){
            System.out.println("El archivo HTML está mal formateado - NULL.");
        } else if (isValid.isEmpty()) {
            System.out.println("El archivo HTML está bien formateado.");
        }else {
            System.out.println("El archivo HTML está mal formateado.\nEtiquetas que quedaron sin cerrar:");
            for (HtmlTag elemento : isValid) {
                System.out.println(elemento);
            }
        }
    }
}
