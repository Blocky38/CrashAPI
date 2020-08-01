package org.ctp.crashapi.resources.trigger;

import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import org.ctp.crashapi.resources.shared.ItemObject;
import org.ctp.crashapi.resources.shared.RangeObject;
import org.ctp.crashapi.resources.util.JsonBuilder;

import com.google.gson.JsonObject;

public class EnchantedItemTrigger extends Trigger {
	private @Nullable ItemObject item = null;
	private @Nullable RangeObject levels = null;

	public EnchantedItemTrigger() {
		super(Type.ENCHANTED_ITEM);
	}

	public @Nullable ItemObject getItem() {
		return item;
	}

	public @Nullable RangeObject getLevels() {
		return levels;
	}

	public EnchantedItemTrigger setItem(@Nullable ItemObject item) {
		this.item = item;
		return this;
	}

	public EnchantedItemTrigger setLevels(@Nullable RangeObject levels) {
		this.levels = levels;
		return this;
	}

	@Override
	protected JsonObject getConditions() {
		return item == null && levels == null ? null : new JsonBuilder().add("item", item).add("levels", levels).build();
	}
}
