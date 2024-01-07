package edu.hw9;

import edu.hw9.Task2.FilesProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Task2Test {
    @TempDir
    private static Path path;

    @BeforeAll
    public static void initPath() throws IOException {
        resolveFiles(path.resolve("1"), ".txt", 15);
        resolveFiles(path.resolve("2"), ".zip", 7);
        resolveFiles(path.resolve("3"), ".tar", 3);
        resolveFiles(path.resolve("4"), ".trew", 1);
        resolveFiles(path.resolve("5"), ".fd", 2);
        resolveFiles(path.resolve("6"), ".exe", 11);
        resolveFiles(path.resolve("7"), ".docx", 5);
        Files.writeString(path.resolve("1").resolve("1.txt"), "test");
    }

    private static void resolveFiles(Path dir, String extension, int number) throws IOException {
        Files.createDirectories(dir);
        for (int i = 0; i < number; i++) {
            Path filePath = dir.resolve(i + extension);
            Files.createFile(filePath);
        }
    }

    @Test
    @DisplayName("findDirectories Test")
    public void findDirectoriesTest() {
        List<String> actual = FilesProcessor.findDirectoriesWithMoreThanNumberFiles(path, 3);
        List<String> directoryNames = actual.stream().map(el -> el.substring(el.lastIndexOf('/'))).toList();
        assertThat(directoryNames).containsExactlyInAnyOrder("/1", "/2", "/6", "/7");
    }

    @Test
    @DisplayName("filterFiles Test")
    public void filterFilesTest() {
        List<String> actual = FilesProcessor.filterFilesByPredicate(path, p -> p.toString().endsWith(".tar"));
        List<String> fileNames = actual.stream().map(el -> el.substring(el.lastIndexOf('/'))).toList();
        assertThat(fileNames).containsExactlyInAnyOrder("/0.tar", "/1.tar", "/2.tar");
    }

}
