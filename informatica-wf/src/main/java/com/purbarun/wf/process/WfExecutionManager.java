package com.purbarun.wf.process;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purbarun.wf.exception.WorkflowExecutionException;
import com.purbarun.wf.model.WorkflowConfig;
import com.purbarun.wf.utils.Constants;
import com.purbarun.wf.utils.JsonUtils;

@Service
public class WfExecutionManager {
	@Autowired
	private JsonUtils jsonUtils;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public void executeWorkflow(ClassLoader classLoader) {
		WorkflowConfig wfConfig;
		try {
			wfConfig = jsonUtils.readJsonFile(Constants.CFG_FILE_NAME);
			executeWfSessions(wfConfig, classLoader);
		} catch (IOException e) {
			logger.error(Constants.JSON_ERROR_MSG, e);
			throw new WorkflowExecutionException(Constants.JSON_ERROR_MSG);
		}
	}

	public void executeWfSessions(WorkflowConfig workflowConfig, ClassLoader classLoader) {
		
		workflowConfig.getSession().forEach(sessionConfig -> {

			sessionConfig.getSessionClass().forEach(sessionClassNames -> {
				String sessionClassName = workflowConfig.getPackageName() + "." + sessionClassNames;
				Class<?> sessionClass;
				try {
					sessionClass = classLoader.loadClass(sessionClassName);
					WorkflowSessionImpl newInstance;
					newInstance = (WorkflowSessionImpl) sessionClass.getConstructor().newInstance();
					newInstance.process(workflowConfig);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException | NoSuchMethodException
						| SecurityException e) {
					logger.error(Constants.NOT_FOUND_ERROR_MSG, e);
					throw new WorkflowExecutionException(Constants.NOT_FOUND_ERROR_MSG);
				}
			});
		});
		
	}
}
