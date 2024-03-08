package com.purbarun.wf.process;

import com.purbarun.wf.model.WorkflowConfig;

public abstract class WorkflowSessionImpl implements WorkflowSession {
	@Override
	public void process(WorkflowConfig workflowConfig) {
		preSql();
		transform();
		postSql();
	}
}
