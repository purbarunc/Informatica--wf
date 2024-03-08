package com.purbarun.wf.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.purbarun.wf.model.WorkflowConfig;

@Service
public class JsonUtils {
	@Autowired
	private ObjectMapper objectMapper;

	public WorkflowConfig readJsonFile(String fileName) throws IOException {
		String wfConfigText;
		InputStream resource = new ClassPathResource(fileName).getInputStream();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))) {
			wfConfigText = reader.lines().collect(Collectors.joining("\n"));
		}
		WorkflowConfig wfConfig = objectMapper.readValue(wfConfigText, new TypeReference<>() {
		});
		return wfConfig;
	}
}
