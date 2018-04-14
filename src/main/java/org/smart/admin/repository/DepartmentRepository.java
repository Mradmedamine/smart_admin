package org.smart.admin.repository;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.model.json.JsonDepartment;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DepartmentRepository {

	private static Logger logger = LoggerFactory.getLogger(DepartmentRepository.class);

	private static Map<String, JsonDepartment> departments = new HashMap<>();
	private static ObjectMapper mapper = new ObjectMapper();

	static {
		List<JsonDepartment> departmentsList = parseDepartments();
		departmentsList.forEach((dep) -> {
			departments.put(dep.getCode(), dep);
		});
	}

	public static JsonDepartment getDepartment(String key) {
		return departments.get(key);
	}

	private static List<JsonDepartment> parseDepartments() {
		URL res = DepartmentRepository.class.getClassLoader().getResource("data/departments.json");
		File file = new File(res.getFile());
		JsonDepartment[] departments = null;
		try {
			departments = mapper.readValue(file, JsonDepartment[].class);
		} catch (Exception ex) {
			logger.debug("Error while parsing Communes " + ex);
		}
		return Arrays.asList(departments);
	}

}
