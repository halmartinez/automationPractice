package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class bandejaDeUsuarioPageUI extends PageObject
{
    public static final Target TEXT_NOMBRE_USUARIO_LOGUEADO =
            Target.the("Texto de usuario logueado")
                    .located(By.xpath("//span[contains(text(),'prueba automatizada')]"));
}