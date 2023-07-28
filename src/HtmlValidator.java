import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {
    public static Stack<HtmlTag> isValidHtml (Queue<HtmlTag> colaHtml){
        Stack<HtmlTag> pilaEtiquetas = new Stack<>();

        for(HtmlTag etiqueta: colaHtml){
            // Se verifica si es una etiqueta de apertura
            if(etiqueta.isOpenTag()){
                pilaEtiquetas.push(etiqueta);

            // Se verifica si la etiqueta se cierra sola
            }else if (!etiqueta.isSelfClosing()){

                // Se evalua si la pila está vacía, para retornar null, en casos como el siguiente
                //</div>
                //</body>
                //</html>
                if(pilaEtiquetas.isEmpty()){
                    return null;

                // Se evalúa que las etiquetas correspondan, para posteriormente borrarla de la pila
                } else if (pilaEtiquetas.peek().matches(etiqueta)) {
                    pilaEtiquetas.pop();
                }
            }
        }
        return pilaEtiquetas;
    }
}

