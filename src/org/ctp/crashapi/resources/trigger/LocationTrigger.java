package org.ctp.crashapi.resources.trigger;

import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import org.ctp.crashapi.resources.shared.LocationObject;

import com.google.gson.JsonObject;

/**
 * Fires every 20 ticks (every second). Useful for pre-finished/always completed
 * advancements.
 * 
 * @see TickTrigger
 */

public class LocationTrigger extends Trigger {
	private @Nullable LocationObject location = null;

	public LocationTrigger() {
		super(Type.LOCATION);
	}

	/**
	 * @return information about the location or null, if none was specified
	 */
	public @Nullable LocationObject getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            information about the location or null, if it should be cleared
	 * @return the current trigger for chaining
	 */
	public LocationTrigger setLocation(@Nullable LocationObject location) {
		this.location = location;
		return this;
	}

	@Override
	protected JsonObject getConditions() {
		return location == null ? null : location.toJson();
	}
}
