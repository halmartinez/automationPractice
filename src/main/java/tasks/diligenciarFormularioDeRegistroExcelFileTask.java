package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userInterfaces.formularioDeRegistroPageUI.*;

public class diligenciarFormularioDeRegistroExcelFileTask implements Task
{
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String password;
    private final String address;
    private final String zipcode;
    private final String country;
    private final String state;
    private final String city;
    private final String mobile;
    private final String fullname;

    public diligenciarFormularioDeRegistroExcelFileTask(String firstname,
                                                        String lastname,
                                                        String email,
                                                        String password,
                                                        String address,
                                                        String zipcode,
                                                        String country,
                                                        String state,
                                                        String city,
                                                        String mobile,
                                                        String fullname)
    {
        this.firstname  = firstname;
        this.lastname   = lastname;
        this.email      = email;
        this.password   = password;
        this.address    = address;
        this.zipcode    = zipcode;
        this.country    = country;
        this.state      = state;
        this.city       = city;
        this.mobile     = mobile;
        this.fullname   = fullname;
    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        actor.attemptsTo
                (
                        Enter.theValue(firstname).into(TEXT_NOMBRE),
                        Enter.theValue(lastname).into(TEXT_APELLIDOS),
                        Enter.theValue(password).into(TEXT_CONTRASENA),
                        Enter.theValue(firstname).into(TEXT_NOMBRE_2),
                        Enter.theValue(lastname).into(TEXT_APELLIDOS_2),
                        Enter.theValue(address).into(TEXT_DIRECCION),
                        Enter.theValue(city).into(TEXT_CIUDAD),
                        //Enter.theValue(state).into(LISTBOX_ESTADO_O_REGION),
                        SelectFromOptions.byVisibleText(state).from(LISTBOX_ESTADO_O_REGION),
                        Enter.theValue(zipcode).into(TEXT_CODIGO_POSTAL),
                        //Enter.theValue(country).into(TEXT_NOMBRE),
                        Enter.theValue(mobile).into(TEXT_CELULAR),
                        Click.on(BTN_REGISTRAR_USUARIO)
                );
    }

    public static diligenciarFormularioDeRegistroTask conLosSiguientesDatos(String firstname,
                                                                            String lastname,
                                                                            String email,
                                                                            String password,
                                                                            String address,
                                                                            String zipcode,
                                                                            String country,
                                                                            String state,
                                                                            String city,
                                                                            String mobile,
                                                                            String fullname)
    {
        return instrumented(diligenciarFormularioDeRegistroTask.class, firstname,
                                                                        lastname,
                                                                        email,
                                                                        password,
                                                                        address,
                                                                        zipcode,
                                                                        country,
                                                                        state,
                                                                        city,
                                                                        mobile,
                                                                        fullname);
    }
}
