package exemples.hamcrest;

import hamcrest.bean.Person;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;


public class HamcrestJavaBeansTest {

    @Test
    public void givenBean_whenHasValue_thenCorrect() {
        Person person = new Person("Baeldung", "Rua eee");

        assertThat(person, hasProperty("name"));
    }

    @Test
    public void givenBean_whenHasCorrectValue_thenCorrect() {
        Person person = new Person("Baeldung", "New York");
        assertThat(person, hasProperty("address", equalTo("New York")));
    }
}
