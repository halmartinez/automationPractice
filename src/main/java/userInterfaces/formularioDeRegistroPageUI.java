package userInterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class formularioDeRegistroPageUI extends PageObject
{
    /** Información personal */

    public static final Target TEXT_NOMBRE =
            Target.the("Cuadro de texto nombre")
                    .located(By.id("customer_firstname"));

    public static final Target TEXT_APELLIDOS =
            Target.the("Cuadro de texto apellidos")
                    .located(By.id("customer_lastname"));

    public static final Target TEXT_CONTRASENA =
            Target.the("Cuadro de texto contraseña")
                    .located(By.id("passwd"));

    /** Información de Dirección de Residencia*/

    public static final Target TEXT_NOMBRE_2 =
            Target.the("Cuadro de texto nombre")
                    .located(By.id("firstname"));

    public static final Target TEXT_APELLIDOS_2 =
            Target.the("Cuadro de texto apellidos")
                    .located(By.id("lastname"));

    public static final Target TEXT_DIRECCION =
            Target.the("Cuadro de texto dirección de residencia")
                    .located(By.id("address1"));

    public static final Target TEXT_CIUDAD =
            Target.the("Cuadro de texto ciudad")
                    .located(By.id("city"));

    public static final Target LISTBOX_ESTADO_O_REGION =
            Target.the("Cuadro de texto Estado/Región")
                    .located(By.id("id_state"));

    public static final Target TEXT_CODIGO_POSTAL =
            Target.the("Cuadro de texto Código Postal")
                    .located(By.id("postcode"));

    public static final Target TEXT_PAIS =
            Target.the("Cuadro de texto País")
                    .located(By.id("id_country"));

    public static final Target TEXT_CELULAR =
            Target.the("Cuadro de texto Celular")
                    .located(By.id("phone_mobile"));

    public static final Target BTN_REGISTRAR_USUARIO =
            Target.the("Botón de Registrar Usuario")
                    .located(By.id("submitAccount"));


}
