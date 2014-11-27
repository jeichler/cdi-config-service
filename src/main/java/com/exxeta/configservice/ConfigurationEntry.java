package com.exxeta.configservice;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

final class ConfigurationEntry {

	final class Entry {

		Object value;

		Date validFrom;

		Date validTo;

		private Entry(Object value) {
			this.value = value;
		}

		private Entry(Object value, Date validFrom, Date validTo) {
			this.value = value;
			this.validFrom = validFrom;
			this.validTo = validTo;
		}
	}

	private final List<Entry> entries;

	/**
	 * Konstruktor fuer Serialisierung.
	 */
	protected ConfigurationEntry() {
		this(null);
	}

	public ConfigurationEntry(Object value) {
		this.entries = new LinkedList<Entry>();
		if (value != null) {
			addEntry(value);
		}
	}

	List<Entry> getEntries() {
		return entries;
	}

	void addEntry(Object value) {
		entries.add(new Entry(value));
	}

	void addEntry(Object value, Date validFrom, Date validTo) {
		entries.add(new Entry(value, validFrom, validTo));
	}
}