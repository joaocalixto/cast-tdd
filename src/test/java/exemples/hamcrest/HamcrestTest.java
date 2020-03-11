package exemples.hamcrest;

import br.com.cast.tdd.hamcrest.Animal;
import br.com.cast.tdd.hamcrest.Cat;
import br.com.cast.tdd.hamcrest.Person;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.typeCompatibleWith;
import static org.hamcrest.object.HasToString.hasToString;
import static org.junit.Assert.assertTrue;

public class HamcrestTest {


    @Test
    public void stringMatcherHamcrestTest(){
        String a = "foo";
        String b = "FOO";

        assertThat(a, equalToIgnoringCase(b));
    }

    @Test
    public void stringMatcherJunittTest(){
        String a = "foo";
        String b = "FOO";

        assertTrue(a.equalsIgnoreCase(b));
    }

    // -----

    @Test
    public void givenBean_whenToStringReturnsRequiredString_thenCorrect(){
        Person person = new Person("Barrack", "Billzinho");
        String str = person.toString();
        assertThat(person, hasToString(str));
    }

    @Test
    public void given2Classes_whenOneInheritsFromOther_thenCorrect(){
        assertThat(Cat.class, typeCompatibleWith(Animal.class));
    }


}
