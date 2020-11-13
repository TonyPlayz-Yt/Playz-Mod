package net.mcreator.playzmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.playzmod.PlayzModModElements;

import java.util.Map;
import java.util.HashMap;

@PlayzModModElements.ModElement.Tag
public class FlyCommandCommandExecutedTrueProcedure extends PlayzModModElements.ModElement {
	public FlyCommandCommandExecutedTrueProcedure(PlayzModModElements instance) {
		super(instance, 8);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FlyCommandCommandExecutedTrue!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.allowFlying = (true);
			((PlayerEntity) entity).sendPlayerAbilities();
		}
	}

	@SubscribeEvent
	public void onCommand(CommandEvent event) {
		Entity entity = event.getParseResults().getContext().getSource().getEntity();
		if (entity != null) {
			int i = (int) entity.getPosition().getX();
			int j = (int) entity.getPosition().getY();
			int k = (int) entity.getPosition().getZ();
			String command = event.getParseResults().getReader().getString();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("command", command);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
