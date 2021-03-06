package org.smart.admin.repository;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart.admin.model.Commune;
import org.smart.admin.model.Department;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class DepartmentRepository {

	private static Logger logger = LoggerFactory.getLogger(DepartmentRepository.class);

	private static Map<String, Department> departments = new HashMap<>();
	private static ObjectMapper mapper = new ObjectMapper();
	static {
		initDepartments();
	}

	public static Department getDepartment(String key) {
		logger.debug("getting department with code {}", key);
		return departments.get(key);
	}

	public static Commune getTownship(String department, String insee) {
		List<Commune> townships = getDepartment(department).getCommunes();
		return townships.stream().filter(township -> township.getInseeCommune().equals(insee)).findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	private static void initDepartments() {
		InputStream is = DepartmentRepository.class.getResourceAsStream("/static/data/departments.json");
		List<Department> departmentsList = null;
		try {
			CollectionType ParamType = mapper.getTypeFactory().constructCollectionType(List.class, Department.class);
			departmentsList = mapper.readValue(is, ParamType);
			departmentsList.forEach((department) -> {
				logger.debug("added department with code {}", department.getCode());
				departments.put(department.getCode(), department);
			});
		} catch (Exception ex) {
			logger.debug("Error while parsing Communes " + ex);
		}
	}

}
