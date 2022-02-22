package questions;

import net.serenitybdd.screenplay.Question;
import static userInterfaces.bandejaDeUsuarioPageUI.TEXT_NOMBRE_USUARIO_LOGUEADO;

public class verificarUsuarioQuestion
{
    public static Question<String> usuarioLogueado()
    {
        return actor -> TEXT_NOMBRE_USUARIO_LOGUEADO.resolveFor(actor).getText().toString();
    }
}
