package edu.hw6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DiskMapTest {
    @TempDir(cleanup = CleanupMode.ALWAYS)
    private Path testDir;
    private Path storage;
    private DiskMap diskMap;

    @BeforeEach
    public void initStorage() {
        storage = testDir.resolve("data_storage.txt");
        diskMap = new DiskMap(storage);
        diskMap.put("test","testik");
    }

    @Test
    @DisplayName("Size test")
    void sizeTest() {
        int res = diskMap.size();

        assertThat(res).isEqualTo(1);
    }

    @Test
    @DisplayName("ContainsKey Test")
    void containsKeyTest() {
        assertThat(diskMap.containsKey("test")).isEqualTo(true);
    }

    @Test
    @DisplayName("Empty Test")
    void emptyTest() {
        assertThat(diskMap.isEmpty()).isFalse();
    }

    @Test
    @DisplayName("ContainsValue Test")
    void containsValueTest() {
        assertThat(diskMap.containsValue("testik")).isTrue();
    }

    @Test
    @DisplayName("Get Put Remove Test")
    void getPutRemoveTest() {
        assertThat(diskMap.get("test")).isEqualTo("testik");

        diskMap.put("testik","tesik");

        assertThat(diskMap.containsKey("testik")).isTrue();

        diskMap.remove("testik");

        assertThat(diskMap.containsKey("testik")).isFalse();
    }
}
