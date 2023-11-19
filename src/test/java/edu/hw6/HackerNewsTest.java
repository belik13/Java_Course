package edu.hw6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HackerNewsTest {
    @Test
    @DisplayName("Get test")
    public void getTest() {
        long[] actual = new HackerNews().getHackerNewsTopStories();
        assertThat(actual).isNotEmpty();
    }

    @Test
    @DisplayName("GetTitle test")
    public void getTitleTest() {
        String actual = new HackerNews().getNewsTitle(1);
        assertThat(actual).isNotEmpty();
    }
}
