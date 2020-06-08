package dev;


import javafx.application.Application;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.stream.Collectors;

@Lock(LockType.READ)
@Singleton
@Path("/Person")
public class PersonResource {
    private final PersonReadWrite personReadWrite;

    @Inject
    public PersonResource(PersonReadWrite personReadWrite){
        this.personReadWrite = personReadWrite;
    }

    @GET
    public List <Person> getEverybody(){
        return personReadWrite.getAllPersons().stream()
                .collect(Collectors.toList());
    }
}
