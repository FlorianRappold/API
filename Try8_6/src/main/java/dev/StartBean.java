package dev;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.stream.Stream;

@Singleton
@Startup
public class StartBean {

    private final PersonReadWrite personReadWrite;

    @Inject
    public StartBean(PersonReadWrite personReadWrite) {
        this.personReadWrite = personReadWrite;
    }

    @PostConstruct
    private void startup(){

        Stream.of("Florian", "Simon", "Thomas", "blabla").forEach(name -> personReadWrite.addPerson(new Person(name)));
        personReadWrite.getAllPersons().forEach(System.out::println);

    }


}
