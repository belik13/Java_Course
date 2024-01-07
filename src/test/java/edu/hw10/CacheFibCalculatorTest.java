package edu.hw10;

import edu.hw10.Task2.CacheProxy;
import edu.hw10.Task2.Calculators.CacheCalculator;
import edu.hw10.Task2.Calculators.CacheFibCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheFibCalculatorTest {
    @Test
    @DisplayName("Cache FibCalculator Test")
    void cacheFibCalculatorTest(@TempDir Path path) {
        CacheCalculator cacheCalculator = (CacheCalculator) CacheProxy.create(new CacheFibCalculator(), path);
        assertEquals(89, cacheCalculator.calculate(11));
        assertEquals(144, cacheCalculator.calculate(12));
        assertEquals(233, cacheCalculator.calculate(13));
        assertEquals(377, cacheCalculator.calculate(14));

        List<File> fileList = new ArrayList<>(List.of(
            Path.of(path + File.separator + "calculate" + "_1" + ".cache").toFile(),
            Path.of(path + File.separator + "calculate" + "_2" + ".cache").toFile(),
            Path.of(path + File.separator + "calculate" + "_3" + ".cache").toFile(),
            Path.of(path + File.separator + "calculate" + "_4" + ".cache").toFile()
        ));

        Set<File> fileSet = new HashSet<>(Set.of(Objects.requireNonNull(path.toFile().listFiles())));
        assertTrue(fileSet.containsAll(fileList));
    }
}
