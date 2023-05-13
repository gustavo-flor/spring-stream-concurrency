package com.github.gustavoflor.ssc.message.consumer;

import com.github.gustavoflor.ssc.message.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class EventConsumer implements Consumer<Message<Event>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventConsumer.class);
    private static final String START_MESSAGE = "Started Event: {}, Partition: {}";
    private static final String END_MESSAGE = "Ended Event: {}, Partition: {}";

    @Override
    public void accept(final Message<Event> message) {
        final var event = message.getPayload();
        final var partition = message.getHeaders().get(KafkaHeaders.RECEIVED_PARTITION, Integer.class);
        LOGGER.info(START_MESSAGE, event, partition);
        sleep(event.delay());
        LOGGER.info(END_MESSAGE, event, partition);
    }

    private static void sleep(final Long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

}
