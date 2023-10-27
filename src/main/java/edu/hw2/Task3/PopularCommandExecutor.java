package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {

    private static final Logger LOGGER = LogManager.getLogger();
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        int currentNumberOfAttempts = 0;
        while (currentNumberOfAttempts < maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                LOGGER.info("Command was executed successfully");
                return;
            } catch (ConnectionException e) {
                throw new ConnectionException("The maximum number of attempts has been exceeded", e);
            }
        }
    }
}
