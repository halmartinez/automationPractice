package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class iniciarSesionYRegistrarUsuarioPageUI extends PageObject
{
    /** Ítems para iniciar sesión */
    public static final Target INPUT_EMAIL =
            Target.the("Input del correo")
                    .located(By.id("email"));

    public static final Target INPUT_CONTRASENA =
            Target.the("Input de la contraseña")
                    .located(By.id("passwd"));

    public static final Target BOTON_SIGN_IN =
            Target.the("Clic en el botón para iniciar sesión")
                    .located(By.id("SubmitLogin"));

    /** Ítems para registrar usuario */
    public static final Target INPUT_EMAIL_CREAR_USUARIO =
            Target.the("Input de la contraseña")
                    .located(By.id("email_create"));

    public static final Target BOTON_CREATE_ACCOUNT =
            Target.the("Input de la contraseña")
                    .located(By.id("SubmitCreate"));
}
