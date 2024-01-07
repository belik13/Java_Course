package edu.hw8;

import edu.hw8.Task1.Client;
import edu.hw8.Task1.Server;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    private static Server server;
    @BeforeAll
    static void startServer() {
        server = new Server();
        CountDownLatch serverStartLatch = new CountDownLatch(1);

        Thread thread = new Thread(() -> {
            server.runWithLatch(serverStartLatch);
        });

        thread.start();
        try {
            serverStartLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterAll
    static void stopServer() {
        server.stop();
    }

    @Test
    @DisplayName("clientConnection Test")
    void clientConnectionTest() throws InterruptedException {

        Client client = new Client();
        client.connect();
        String response = client.sendAndGet("личности");

        assertThat("Не переходи на личности там, где их нет.").isEqualTo(response);

        client.disconnect();
    }
}
