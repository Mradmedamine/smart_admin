package org.smart.admin.repository;

import java.util.List;

import org.smart.admin.model.entity.UserCommuneComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommuneCommentRepository extends JpaRepository<UserCommuneComment, Long> {

	List<UserCommuneComment> findByUser_Username(String username);

	List<UserCommuneComment> findByInseeCommune(String inseeCommune);
	
}
