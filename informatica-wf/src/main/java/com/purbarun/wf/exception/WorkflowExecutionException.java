package com.purbarun.wf.exception;

public class WorkflowExecutionException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public WorkflowExecutionException(String message) {
		super(message);
	}
}
