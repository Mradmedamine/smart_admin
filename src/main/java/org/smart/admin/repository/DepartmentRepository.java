package org.smart.admin.repository;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.model.json.JsonCommune;
import org.smart.admin.model.json.JsonDepartment;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DepartmentRepository {

	private static Logger logger = LoggerFactory.getLogger(DepartmentRepository.class);

	private static Map<String, JsonDepartment> departments = new HashMap<>();
	private static ObjectMapper mapper = new ObjectMapper();

	static {
		for (Integer i = 1; i <= 95; i++) {
			parseDepartment(String.format("%02d", i));
		}
	}

	public static JsonDepartment getDepartment(String key) {
		return departments.get(key);
	}

	private static void parseDepartment(String key) {
		try {
			JsonDepartment department = new JsonDepartment();
			department.setCode(key);
			department.setCommunes(parseCommunes(key));
			departments.put(key, department);
		} catch (Exception ex) {
			logger.debug("Error while parsing Department " + ex);
		}
	}

	private static List<JsonCommune> parseCommunes(String key) {
		URL res = DepartmentRepository.class.getClassLoader().getResource("data/department/" + key + ".json");
		File file = new File(res.getFile());
		JsonCommune[] communes = null;
		try {
			communes = mapper.readValue(file, JsonCommune[].class);
		} catch (Exception ex) {
			logger.debug("Error while parsing Communes " + ex);
		}
		return Arrays.asList(communes);
	}

}
