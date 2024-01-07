package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CountFiles extends RecursiveTask<List<String>> {

    private final Path directory;
    private final int minFiles;

    public CountFiles(Path directory, int minFiles) {
        this.directory = directory;
        this.minFiles = minFiles;
    }

    @Override
    protected List<String> compute() {
        List<String> result = new ArrayList<>();
        List<CountFiles> forks = new ArrayList<>();
        int filesCounter = 0;
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(directory)) {
            for (Path path : paths) {
                if (Files.isRegularFile(path)) {
                    filesCounter++;
                } else if (Files.isDirectory(path)) {
                    CountFiles nextTask = new CountFiles(path, minFiles);
                    nextTask.fork();
                    forks.add(nextTask);
                }
            }
            if (filesCounter > minFiles) {
                result.add(directory.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (CountFiles task : forks) {
            result.addAll(task.join());
        }
        return result;
    }
}
