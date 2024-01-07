package edu.hw7;

import edu.hw7.Task3.Person;
import edu.hw7.Task3.ReadWriteLockSolution;
import edu.hw7.Task3.SynchronizedSolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.security.SecureRandom;
import java.util.concurrent.Executors;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("readWriteLockSolution test")
    void readWriteLockSolutionTest() {
        var db = new ReadWriteLockSolution();

        var executors = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; ++i) {
            var id = i;
            var name = "Person" + i;
            var address = "Ekb" + i;
            var phoneNumber = "Tel" + i;
            executors.submit(() -> {
                db.add(new Person(id, name, address, phoneNumber));
            });
        }

        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < 1000; ++i) {
            int id = secureRandom.nextInt(1000);
            boolean flag = secureRandom.nextBoolean();

            String name = "Person" + secureRandom.nextInt(1000);
            String address = "Ekb" + secureRandom.nextInt(1000);
            String phoneNumber = "Tel" + secureRandom.nextInt(1000);

            executors.submit(() -> {
                if (flag) {
                    db.delete(id);
                }

                var listFindByName = db.findByName(name);
                var listFindByAddress = db.findByAddress(address);
                var listFindByPhone = db.findByPhone(phoneNumber);

                for (var people : listFindByName) {
                    assertThat(
                        people.address() != null && people.name() != null && people.phoneNumber() != null)
                        .isTrue();
                }

                for (var people : listFindByAddress) {
                    assertThat(
                        people.address() != null && people.name() != null && people.phoneNumber() != null)
                        .isTrue();
                }

                for (var people : listFindByPhone) {
                    assertThat(
                        people.address() != null && people.name() != null && people.phoneNumber() != null)
                        .isTrue();
                }

            });
        }
    executors.shutdown();
    }

    @Test
    @DisplayName("Synchronized Solution test")
    void synchronizedSolutionTest() {
        var db = new SynchronizedSolution();

        var executors = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; ++i) {
            var id = i;
            var name = "Person" + i;
            var address = "Ekb" + i;
            var phoneNumber = "Tel" + i;
            executors.submit(() -> {
                db.add(new Person(id, name, address, phoneNumber));
            });
        }

        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < 1000; ++i) {
            int id = secureRandom.nextInt(1000);
            boolean flag = secureRandom.nextBoolean();

            String name = "Person" + secureRandom.nextInt(1000);
            String address = "Ekb" + secureRandom.nextInt(1000);
            String phoneNumber = "Tel" + secureRandom.nextInt(1000);

            executors.submit(() -> {
                if (flag) {
                    db.delete(id);
                }

                var listFindByName = db.findByName(name);
                var listFindByAddress = db.findByAddress(address);
                var listFindByPhone = db.findByPhone(phoneNumber);

                for (var people : listFindByName) {
                    assertThat(
                        people.address() != null && people.name() != null && people.phoneNumber() != null)
                        .isTrue();
                }

                for (var people : listFindByAddress) {
                    assertThat(
                        people.address() != null && people.name() != null && people.phoneNumber() != null)
                        .isTrue();
                }

                for (var people : listFindByPhone) {
                    assertThat(
                        people.address() != null && people.name() != null && people.phoneNumber() != null)
                        .isTrue();
                }

            });
        }
        executors.shutdown();
    }
}
