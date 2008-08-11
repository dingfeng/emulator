package org.rifidi.emulator.reader.thingmagic.database.impl;

import java.util.AbstractList;

import org.rifidi.emulator.reader.thingmagic.database.IDBRow;
import org.rifidi.emulator.reader.thingmagic.database.IDBTable;

public class DBSettings extends AbstractList<IDBRow> implements IDBTable {

	private DBSettingsRow settings = new DBSettingsRow();
	
	@Override
	public IDBRow get(int arg0) {
		// TODO Auto-generated method stub
		if (arg0 != 0)
			throw new IndexOutOfBoundsException();
		return settings;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 1;
	}


}
