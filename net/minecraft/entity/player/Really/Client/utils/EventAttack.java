package net.minecraft.entity.player.Really.Client.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.Really.Client.api.Event;

public class EventAttack extends Event {
   public Entity entity;
   private boolean preAttack;

   public EventAttack(Entity targetEntity, boolean preAttack) {
      this.entity = targetEntity;
      this.preAttack = preAttack;
   }

   public Entity getEntity() {
      return this.entity;
   }

   public boolean isPreAttack() {
      return this.preAttack;
   }

   public boolean isPostAttack() {
      return !this.preAttack;
   }
}
