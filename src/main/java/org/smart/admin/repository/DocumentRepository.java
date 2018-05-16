package org.smart.admin.repository;

import org.smart.admin.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {

	Document findByUser_Username(String username);

}
