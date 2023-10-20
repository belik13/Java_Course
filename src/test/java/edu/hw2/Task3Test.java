package edu.hw2;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Random;
import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnection;
import edu.hw2.Task3.FaultyConnectionManager;
import edu.hw2.Task3.StableConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task3Test {

    @Test
    @DisplayName("FaultyConnection")
    public void faultyConnection() {
        ConnectionManager faultyConnectionManager = new FaultyConnectionManager();
        Connection actual = faultyConnectionManager.getConnection();
        assertThat(actual).isInstanceOf(FaultyConnection.class);
    }

    @Test
    @DisplayName("StableConnection")
    public void stableConnection() {
        Random random = new Random(2);
        ConnectionManager connectionManager = new DefaultConnectionManager(random);
        Connection actual = connectionManager.getConnection();
        assertThat(actual).isInstanceOf(StableConnection.class);
    }

    @Test
    @DisplayName("FaultyConnectionAfterAttempts")
    public void faultyConnectionAfterAttempts() {
        Random random = new Random(1);
        ConnectionManager connectionManager = new DefaultConnectionManager(random);
        Connection actual = connectionManager.getConnection();
        assertThat(actual).isInstanceOf(FaultyConnection.class);
    }
}
