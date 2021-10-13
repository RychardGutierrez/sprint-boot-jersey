package com.jalasoft.evaluation.home.datafake;

import com.jalasoft.evaluation.home.datatypes.Home;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataHome implements CrudRepository<Home> {

    public List<Home> getAll() {
        Home welcomeHome = new Home();
        welcomeHome.setId(1);
        welcomeHome.setTitle("Home");
        welcomeHome.setDescription("This section is Home");
        welcomeHome.setMessageToUser("Welcome! we are ready to provide the best service :)");

        Home welcomeHomeRegister = new Home();
        welcomeHomeRegister.setId(2);
        welcomeHomeRegister.setTitle("Home");
        welcomeHomeRegister.setDescription("This section is Home - we try to get the user to register");
        welcomeHomeRegister.setMessageToUser("Welcome! Sign up for all services");

        Home welcomeHomeCustomer = new Home();
        welcomeHomeCustomer.setId(3);
        welcomeHomeCustomer.setTitle("Home");
        welcomeHomeCustomer.setDescription("This section is Home - We welcome our customer");
        welcomeHomeCustomer.setMessageToUser("Welcome! We are happy to provide you with the best service");

        return Arrays.asList(welcomeHome, welcomeHomeRegister, welcomeHomeCustomer);
    }
}
