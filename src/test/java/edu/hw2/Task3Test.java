package edu.hw2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import java.util.Random;
import edu.hw2.Task3.Connection;
import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.ConnectionManager;
import edu.hw2.Task3.DefaultConnectionManager;
import edu.hw2.Task3.FaultyConnection;
import edu.hw2.Task3.FaultyConnectionManager;
import edu.hw2.Task3.PopularCommandExecutor;
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
    @Test
    @DisplayName("tryExecute test with Exception")
    public void wException() {
        PopularCommandExecutor executor = new PopularCommandExecutor(
            new DefaultConnectionManager(new Random(78)),
            1
        );
        assertThatThrownBy(executor::updatePackages).isInstanceOf(ConnectionException.class);
    }

    @Test
    @DisplayName("tryExecute test w/o Exception")
    public void noException() {
        PopularCommandExecutor executor = new PopularCommandExecutor(
            new DefaultConnectionManager(new Random(2)),
            2
        );
        assertThatCode(executor::updatePackages).doesNotThrowAnyException();
    }
}
