package org.smart.admin.repository;

import java.io.File;
import java.net.URL;
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
		initDepartments();
	}

	public static JsonDepartment getDepartment(String key) {
		logger.debug("getting department with code {}", key);
		return departments.get(key);
	}

	private static void initDepartments() {
		URL res = DepartmentRepository.class.getClassLoader().getResource("data/departments.json");
		File file = new File(res.getFile());
		List<JsonDepartment> departmentsList = null;
		try {
			departmentsList = mapper.readValue(file,
					mapper.getTypeFactory().constructCollectionType(List.class, JsonDepartment.class));
			departmentsList.forEach((dep) -> {
				logger.debug("added department with code {}", dep.getCode());
				departments.put(dep.getCode(), dep);
			});
		} catch (Exception ex) {
			logger.debug("Error while parsing Communes " + ex);
		}
	}

}
