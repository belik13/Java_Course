package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task6 {

    private static final int FIRST_SCANNED_PORT = 0;
    private static final int LAST_SCANNED_PORT = 49151;
    private static final String LOG_FORMAT = "%-10s %-8s %s%n";
    private static final Map<Integer, String> PORT_MAP = Map.ofEntries(
        Map.entry(123, "NTP (Network Time Protocol)"),
        Map.entry(1042, "AFROG Subnet Roaming"),
        Map.entry(1900, "Microsoft SSDP")
    );
    private static final Logger LOGGER = LogManager.getLogger();

    private Task6() {
    }

//    public static void main(String[] args) {
//        scanPorts();
//    }
    public static void scanPorts() {
        LOGGER.info(LOG_FORMAT.formatted("Протокол", "Порт", "Сервис"));
        for (int i = FIRST_SCANNED_PORT; i < LAST_SCANNED_PORT; i++) {
            try (ServerSocket serverSocket = new ServerSocket(i)) {
                //
            } catch (IOException e) {
                LOGGER.info(LOG_FORMAT.formatted("TCP", i, (PORT_MAP.get(i) != null ? PORT_MAP.get(i) : "")));
            }
            try (DatagramSocket datagramSocket = new DatagramSocket(i)) {
                //
            } catch (IOException e) {
                LOGGER.info(LOG_FORMAT.formatted("UDP", i, (PORT_MAP.get(i) != null ? PORT_MAP.get(i) : "")));
            }
        }
    }
}
