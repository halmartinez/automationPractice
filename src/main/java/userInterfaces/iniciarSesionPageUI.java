package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class iniciarSesionPageUI extends PageObject
{
    public static final Target INPUT_EMAIL =
            Target.the("Input del correo")
                    .located(By.id("email"));

    public static final Target INPUT_CONTRASENA =
            Target.the("Input de la contraseña")
                    .located(By.id("passwd"));

    public static final Target BOTON_SIGN_IN =
            Target.the("Clic en el botón para iniciar sesión")
                    .located(By.id("SubmitLogin"));
}
