package org.smart.admin.repository;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.model.json.JsonCommune;
import org.smart.admin.model.json.JsonDepartment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

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

	public static JsonCommune getCommune(String dep, String insee) {
		JsonDepartment department = getDepartment(dep);
		List<JsonCommune> communes = department.getCommunes();
		return communes.stream().filter(e -> e.getInseeCommune().equals(insee)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	private static void initDepartments() {
		InputStream is = DepartmentRepository.class.getResourceAsStream("/static/data/departments.json");
		List<JsonDepartment> departmentsList = null;
		try {
			CollectionType ParamType = mapper.getTypeFactory().constructCollectionType(List.class,
					JsonDepartment.class);
			departmentsList = mapper.readValue(is, ParamType);
			departmentsList.forEach((dep) -> {
				String code = extractCode(dep.getDepartment());
				dep.setCode(code);
				logger.debug("added department with code {}", code);
				departments.put(code, dep);
			});
		} catch (Exception ex) {
			logger.debug("Error while parsing Communes " + ex);
		}
	}

	private static String extractCode(String department) {
		return department.substring(department.indexOf('(') + 1 , department.indexOf(')'));
	}

}
