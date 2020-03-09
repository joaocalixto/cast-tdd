package hamcrest.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    String name;
    String address;

    public Person(String personName, String personAddress) {
        name = personName;
        address = personAddress;
    }
}
