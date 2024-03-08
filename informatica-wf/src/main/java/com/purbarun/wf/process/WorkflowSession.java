package com.purbarun.wf.process;

import com.purbarun.wf.model.WorkflowConfig;

public interface WorkflowSession {
	void preSql();

	void transform();

	void postSql();

	void process(WorkflowConfig workflowConfig);
}
