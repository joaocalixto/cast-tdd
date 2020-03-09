package hamcrest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Person {

    private String name;

    private List<String> names = new ArrayList<String>();

    public Person(String... name){
        names.addAll(names);
    }
}
