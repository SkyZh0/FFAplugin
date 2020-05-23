package io.github.thatkawaiisam.assemble.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import io.github.thatkawaiisam.assemble.AssembleBoard;

public class AssembleBoardCreatedEvent extends Event {

    public static HandlerList handlerList = new HandlerList();

    private boolean cancelled = false;
    private final AssembleBoard board;

    public AssembleBoardCreatedEvent(AssembleBoard board) {
        this.board = board;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
