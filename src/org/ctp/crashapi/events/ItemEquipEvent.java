package org.ctp.crashapi.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.ctp.crashapi.item.ItemSlotType;

public final class ItemEquipEvent extends PlayerEvent implements Cancellable {

	private static final HandlerList handlers = new HandlerList();

	@Override
	public final HandlerList getHandlers() {
		return handlers;
	}

	public final static HandlerList getHandlerList() {
		return handlers;
	}

	private boolean cancel = false;
	private final HandMethod equipType;
	private final ItemStack oldItem, newItem;
	private final ItemSlotType slot;

	/**
	 * Constructor for the ItemEquipEvent.
	 *
	 * @param player
	 *            The player who put on / removed the armor.
	 * @param oldItem
	 *            The ItemStack of the item removed.
	 * @param newItem
	 *            The ItemStack of the item added.
	 */
	public ItemEquipEvent(final Player player, final HandMethod equipType, final ItemSlotType slot,
	final ItemStack oldItem, final ItemStack newItem) {
		super(player);
		this.equipType = equipType;
		this.slot = slot;
		this.newItem = newItem;
		this.oldItem = oldItem;
	}

	@Override
	public final void setCancelled(final boolean cancel) {
		this.cancel = cancel;
	}

	@Override
	public final boolean isCancelled() {
		return cancel;
	}

	public final ItemStack getOldItem() {
		return oldItem;
	}

	public final ItemStack getNewItem() {
		return newItem;
	}

	public HandMethod getMethod() {
		return equipType;
	}

	public ItemSlotType getSlot() {
		return slot;
	}

	public enum HandMethod {
		HELD_SWITCH, CRAFTED, PICK_UP, DROP, HOT_BAR, HELD_SWAP,
		/**
		 * When an item piece breaks to unequip
		 */
		BROKE,
		/**
		 * When you die causing all items to unequip
		 */
		DEATH,
		JOIN,
		/**
		 * When getting an item changed from a command
		 */
		COMMAND;
	}
}