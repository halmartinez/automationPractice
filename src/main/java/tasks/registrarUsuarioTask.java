package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class registrarUsuarioTask implements Task
{
    private String firstname,
                    lastname,
                    email,
                    password,
                    address,
                    zipcode,
                    country,
                    state,
                    city;

    public registrarUsuarioTask(String firstname,
                                String lastname,
                                String email,
                                String password,
                                String address,
                                String zipcode,
                                String country,
                                String state,
                                String city)
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
    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {

    }
}
