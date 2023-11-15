package edu.hw3;

import edu.hw3.Task6.Market;
import edu.hw3.Task6.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Task6Test {
    @Test
    @DisplayName("Проверка самой дорогой акции")
    void mostValuableStockTest() {
        Market market = new Market();
        market.add(new Stock("SBER",280));
        market.add(new Stock("YANDEX",2400));
        market.add(new Stock("VTB",2));
        Stock stock = new Stock("YANDEX",2400);
        assertThat(market.mostValuableStock()).isEqualTo(stock);
    }
}
