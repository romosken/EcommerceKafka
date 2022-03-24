package br.com.romosken.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class ServicoEmail {

        public static void main(String[] args) throws InterruptedException {

            var servicoEmail = new ServicoEmail();

           try(var service = new KafkaService<>(
                   ServicoEmail.class.getSimpleName(),
                   "ecommerce_novo_pedido",
                   servicoEmail::parse,
                   Email.class)
           ) {
               service.run();
           }
        }


    private void parse(ConsumerRecord<String,Email> record) throws InterruptedException {
        System.out.println("------------------------------");
        System.out.println("Processando mensagem!");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        Thread.sleep(5000);
        System.out.println("Mensagem processada!");

    }


}
