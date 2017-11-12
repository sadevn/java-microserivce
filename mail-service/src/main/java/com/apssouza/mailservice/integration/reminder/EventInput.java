package com.apssouza.mailservice.integration.reminder;

import com.apssouza.eventsourcing.aggregates.EmailState;
import com.apssouza.eventsourcing.commands.EmailCreateCommand;
import com.apssouza.eventsourcing.entities.Email;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;

/**
 *
 * The Stream Kafka event input
 *
 * @author apssouza
 */
@EnableBinding(Sink.class)
public class EventInput {

    Logger LOG = Logger.getLogger(EventInput.class);

    @StreamListener(
            target = Sink.INPUT,
            condition = "headers['type']=='TodoCreatedEvent'"
    )
    public void todoCreated(@Payload TodoCreatedEvent event) {
        LOG.info("Todo created");
        LOG.info("when = " + event.when());
        LOG.info("todo = " + event.getTodo().toString());

        String uuid = UUID.randomUUID().toString();
        Email email = new Email("Alexsandro", "apssouza22@gmail.com", EmailState.CREATED);
        EmailCreateCommand command = new EmailCreateCommand(uuid, email);
    }

}
