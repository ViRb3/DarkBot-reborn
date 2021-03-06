package org.darkstorm.minecraft.darkbot.ai;

import org.darkstorm.minecraft.darkbot.MinecraftBot;
import org.darkstorm.minecraft.darkbot.world.entity.MainPlayerEntity;

public class TwerkTask extends AbstractTask {
	private boolean active;
	private int timer;

	public TwerkTask(MinecraftBot bot) {
		super(bot);
	}

	@Override
	public boolean isPreconditionMet() {
		return active;
	}

	@Override
	public boolean start(String... options) {
		active = true;
		return true;
	}

	@Override
	public void stop() {
		active = false;
	}

	@Override
	public void run() {
		if(timer > 0) {
			timer--;
			return;
		}
		timer += 1;
		MainPlayerEntity player = bot.getPlayer();
		player.setCrouching(!player.isCrouching());
	}

	@Override
	public synchronized boolean isActive() {
		return active;
	}

	@Override
	public TaskPriority getPriority() {
		return TaskPriority.NORMAL;
	}

	@Override
	public boolean isExclusive() {
		return false;
	}

	@Override
	public boolean ignoresExclusive() {
		return false;
	}

	@Override
	public String getName() {
		return "Twerk";
	}

	@Override
	public String getOptionDescription() {
		return "";
	}
}
