package com.jasonzhao.addon.skgrind.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleEvent;
import org.bukkit.UndefinedNullability;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerRiptideEvent;

public class EvtTest extends SkriptEvent {

    static {
        Skript.registerEvent("Player riptide", SimpleEvent.class, PlayerRiptideEvent.class, "[player] [trident] riptid(e|ing)");
    }
    @Override
    public boolean init(Literal<?>[] args, int matchedPattern, SkriptParser.ParseResult parseResult) {
        return false;
    }

    @Override
    public boolean check(Event e) {
        return false;
    }

    @Override
    public String toString(Event e, boolean debug) {
        return null;
    }
}
