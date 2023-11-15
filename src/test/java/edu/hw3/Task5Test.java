package edu.hw3;

import edu.hw3.Task5.Contact;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static edu.hw3.Task5.Task5.parseContacts;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    private static Stream<Arguments> exampleTestTask5() {
        return Stream.of(
            Arguments.of(new String[] { "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes" },"ASC",
                List.of(new Contact("Thomas","Aquinas"),new Contact("Rene","Descartes"),
                    new Contact("David","Hume"),new Contact("John","Locke"))),
            Arguments.of(new String[]{"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, "DESC", List.of(new Contact
                    ("Carl","Gauss"),new Contact("Leonhard","Euler"),
                new Contact("Paul","Erdos"))
        ));
    }

    @ParameterizedTest
    @MethodSource("exampleTestTask5")
    void exampleTestTask5(String[] people, String order,List<Contact> excepted) {
        List<Contact> ans = parseContacts(people,order);

        assertThat(ans).isEqualTo(excepted);
    }

}
