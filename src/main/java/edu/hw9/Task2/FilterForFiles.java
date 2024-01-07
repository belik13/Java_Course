package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class FilterForFiles extends RecursiveTask<List<String>> {

    private final Path directory;
    private final Predicate<Path> predicate;

    public FilterForFiles(Path directory, Predicate<Path> predicate) {
        this.predicate = predicate;
        this.directory = directory;
    }

    @Override
    protected List<String> compute() {
        List<String> result = new ArrayList<>();
        List<FilterForFiles> forks = new ArrayList<>();
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(directory)) {
            for (Path path : paths) {
                if (Files.isRegularFile(path)) {
                    if (predicate.test(path)) {
                        result.add(path.toString());
                    }
                } else if (Files.isDirectory(path)) {
                    FilterForFiles task = new FilterForFiles(path, predicate);
                    task.fork();
                    forks.add(task);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (FilterForFiles fork : forks) {
            result.addAll(fork.join());
        }
        return result;
    }
}
