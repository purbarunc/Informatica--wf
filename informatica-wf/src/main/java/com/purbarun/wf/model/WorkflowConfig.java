package com.purbarun.wf.model;

import java.util.ArrayList;

public class WorkflowConfig {
	private String workflowName;
	private String packageName;
	private ArrayList<SavePointConfig> savepoint;
	private ArrayList<SessionConfig> session;

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public ArrayList<SavePointConfig> getSavepoint() {
		return savepoint;
	}

	public void setSavepoint(ArrayList<SavePointConfig> savepoint) {
		this.savepoint = savepoint;
	}

	public ArrayList<SessionConfig> getSession() {
		return session;
	}

	public void setSession(ArrayList<SessionConfig> session) {
		this.session = session;
	}

	@Override
	public String toString() {
		return "WorkflowConfig [workflowName=" + workflowName + ", packageName=" + packageName + ", savepoint="
				+ savepoint + ", session=" + session + "]";
	}
}
