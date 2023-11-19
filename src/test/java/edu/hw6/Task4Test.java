package edu.hw6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Path;
import static edu.hw6.Task4.write;
import static org.assertj.core.api.Assertions.*;

public class Task4Test {

    @Test
    void testWrite(@TempDir Path path) throws IOException {
        String expected = "Programming is learned by writing programs. ― Brian Kernighan";

        write(path.toString(), expected);

        assertThat(path).hasContent(expected);
    }
}
