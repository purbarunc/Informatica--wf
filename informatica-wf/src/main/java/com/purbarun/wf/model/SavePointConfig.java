package com.purbarun.wf.model;

import java.util.ArrayList;

public class SavePointConfig {
	private ArrayList<String> tableNames;
	private String schemaNames;

	public ArrayList<String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(ArrayList<String> tableNames) {
		this.tableNames = tableNames;
	}

	public String getSchemaNames() {
		return schemaNames;
	}

	public void setSchemaNames(String schemaNames) {
		this.schemaNames = schemaNames;
	}

	@Override
	public String toString() {
		return "SavePointConfig [tableNames=" + tableNames + ", schemaNames=" + schemaNames + "]";
	}
}
