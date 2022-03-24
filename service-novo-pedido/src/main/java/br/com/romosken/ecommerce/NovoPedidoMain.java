
package br.com.romosken.ecommerce;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NovoPedidoMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (var orderDispatcher = new KafkaDispatcher<Order>()) {
            try (var emailDispatcher = new KafkaDispatcher<Email>()) {


                for (int i = 0; i < 10; i++) {

                    var userId = UUID.randomUUID().toString();
                    var orderId = UUID.randomUUID().toString();
                    var value = new BigDecimal(Math.random() * 5000 + 1);
                    var order = new Order(userId, orderId, value);
                    orderDispatcher.send("ecommerce_novo_pedido", userId, order);


                    var email = new Email("rodrigo.mosken@outlook.com", orderId);
                    emailDispatcher.send("ecommerce_envio_email", userId, email);


                }


            }
        }
    }
}
