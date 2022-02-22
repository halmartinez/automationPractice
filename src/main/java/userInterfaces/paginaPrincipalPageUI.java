package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://automationpractice.com/")
public class paginaPrincipalPageUI extends PageObject
{
    public static final Target LNK_SIGN_IN =
            Target.the("Enlace para iniciar de sesión")
                    .located(By.className("login"));
}
