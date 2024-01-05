package edu.hw6;

import edu.hw6.Task3.Task3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task3Test {
    @TempDir
    private Path tempDir;
    private List<Path> allPaths;

    @Test
    @DisplayName("filterTestChain")
    void filterTest() {
        allPaths = new ArrayList<>();
        try {
            allPaths.add(Files.write(Files.createTempFile(tempDir,"testFile",".png"),
                new byte[] {(byte) 0x89, 'P', 'N', 'G'}));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DirectoryStream.Filter<Path> filter = Task3.magicNumber((byte) 0x89, (byte) 'P', (byte) 'N', (byte) 'G')
            .and(Task3.globMatches("*.png"));

        List<Path> actual = new ArrayList<>();

        try (DirectoryStream<Path> path = Files.newDirectoryStream(tempDir, filter)) {
            path.forEach(actual::add);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assertThat(actual).containsExactlyInAnyOrder(allPaths.get(0));
    }
}
