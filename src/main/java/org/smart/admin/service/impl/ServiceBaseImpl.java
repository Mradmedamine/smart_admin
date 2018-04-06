package org.smart.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.StringUtils;

public abstract class ServiceBaseImpl {

	protected String buildQueryTextParam(String text) {
		if (StringUtils.isEmpty(text)) {
			text = "%";
		} else {
			text = "%" + text.toUpperCase() + "%";
		}
		return text;
	}

	protected Logger getLogger() {
		return LoggerFactory.getLogger(this.getClass());
	}
}
