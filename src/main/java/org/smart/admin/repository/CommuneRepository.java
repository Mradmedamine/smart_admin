package org.smart.admin.repository;

import java.util.List;

import org.smart.admin.model.entity.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommuneRepository extends JpaRepository<Commune, Long> {

	List<Commune> findByInsee(String insee);

}
