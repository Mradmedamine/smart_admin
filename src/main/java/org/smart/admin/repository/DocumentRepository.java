package org.smart.admin.repository;

import java.util.List;

import org.smart.admin.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {

	List<Document> findByUser_Username(String username);

}
