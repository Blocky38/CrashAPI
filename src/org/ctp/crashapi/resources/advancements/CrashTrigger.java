package org.ctp.crashapi.resources.advancements;

import org.ctp.crashapi.resources.trigger.ImpossibleTrigger;
import org.ctp.crashapi.resources.trigger.Trigger;

public class CrashTrigger {

	private String criteria;
	private Trigger trigger;
	private int maxAmount = 0;
	private int[] versionMinimum, versionMaximum;

	public CrashTrigger(String criteria) {
		this(criteria, 0, new int[3], new int[3], new ImpossibleTrigger());
	}

	public CrashTrigger(String criteria, int maxAmount) {
		this(criteria, maxAmount, new int[3], new int[3], new ImpossibleTrigger());
	}

	public CrashTrigger(String criteria, int maxAmount, int[] versionMinimum, int[] versionMaximum) {
		this(criteria, maxAmount, versionMinimum, versionMaximum, new ImpossibleTrigger());
	}

	public CrashTrigger(String criteria, int maxAmount, int[] versionMinimum, int[] versionMaximum, Trigger trigger) {
		this.criteria = criteria;
		this.maxAmount = maxAmount;
		this.versionMinimum = versionMinimum;
		this.versionMaximum = versionMaximum;
		this.trigger = trigger;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public Trigger getTrigger() {
		return trigger;
	}

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}

	public int getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}

	public int[] getVersionMinimum() {
		return versionMinimum;
	}

	public int[] getVersionMaximum() {
		return versionMaximum;
	}
}
