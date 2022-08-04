package com.jasonzhao.addon.skgrind.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.skript.log.ErrorQuality;
import ch.njol.skript.registrations.Classes;
import ch.njol.util.Kleenean;
import net.splodgebox.eliteenchantments.enchants.events.EnchantActivationEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class ExprEnchantTarget extends SimpleExpression<LivingEntity> {

    static{
        Skript.registerExpression(ExprEnchantTarget.class, LivingEntity.class, ExpressionType.SIMPLE, "[the] elite (attacker|target)");
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends LivingEntity> getReturnType() {
        return LivingEntity.class;
    }

    @Override
    public String toString(Event e, boolean debug) {
        if (e == null)
            return "the elite attacker";
        return Classes.getDebugMessage(getSingle(e));
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        if(!getParser().isCurrentEvent(EnchantActivationEvent.class)){
            Skript.error("Cannot use 'elite attacker' outside of a elite enchant event", ErrorQuality.SEMANTIC_ERROR);
            return false;
        }
        return true;
    }


    @Override
    protected LivingEntity[] get(Event e) {
        return new LivingEntity[] {getEliteAttacker(e)};
    }

    @Nullable
    private static LivingEntity getEliteAttacker(@Nullable Event e){
        if (e instanceof EnchantActivationEvent){
            return ((EnchantActivationEvent) e).getTarget();
        }
        return null;
    }
}

