package com.apssouza.events;

import com.apssouza.commands.UserUpdateCreateCommand;
import com.apssouza.entities.Account;
import java.time.Instant;
import java.util.UUID;

/**
 *
 * @author apssouza
 */
public class UserCreatedEvent implements DomainEvent {
    
    private final UUID uuid;
    private final String type = "Created";
    private final Instant when = Instant.now();
    
    private final Account account;

    public UserCreatedEvent(UUID uuid, Account account) {
        this.uuid = uuid;
        this.account = account;
    }
    
    
    @Override
    public UUID uuid() {
        return uuid;
    }
    
    public Account getAccount(){
        return account;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public Instant when() {
        return when;
    }
}
