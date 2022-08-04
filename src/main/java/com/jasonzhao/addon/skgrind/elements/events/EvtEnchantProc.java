package com.jasonzhao.addon.skgrind.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import ch.njol.skript.util.Getter;
import net.splodgebox.eliteenchantments.enchants.events.EnchantActivationEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class EvtEnchantProc extends SkriptEvent {
    static {
        //Skript.registerEvent("Player riptide", SimpleEvent.class, PlayerRiptideEvent.class, "[player] riptide");
        Skript.registerEvent("Player enchant proc", SimpleEvent.class, EnchantActivationEvent.class, "[player] eliteenchant proc");
        EventValues.registerEventValue(EnchantActivationEvent.class, LivingEntity.class, new Getter<LivingEntity, EnchantActivationEvent>() {
            @Override
            public LivingEntity get(EnchantActivationEvent e) {
                return e.getPlayer();
            }
        }, 0);
    }
    @Override
    public boolean init(Literal<?>[] args, int matchedPattern, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public boolean check(Event e) {
        return true;
    }

    @Override
    public String toString(Event e, boolean debug) {
        return null;
    }
}
