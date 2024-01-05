package edu.hw6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import static edu.hw6.Task2.cloneFile;
import static edu.hw6.Task4.write;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task2Test {
    @Test
    @DisplayName("cloneFileTest")
    void cloneFileTest(@TempDir Path testDir) throws IOException {
        Path originalFile = testDir.resolve("test.txt");
        write(originalFile.toString(), "test");

        cloneFile(originalFile);
        cloneFile(originalFile);

        assertThat(testDir)
            .isDirectoryContaining(path -> path.getFileName().toString().contains("test – копия.txt"))
            .isDirectoryContaining(path -> path.getFileName().toString().contains("test – копия (2).txt"))
            .isDirectoryContaining(path -> path.getFileName().toString().contains("test.txt"));
    }
}
