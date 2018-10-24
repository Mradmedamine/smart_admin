package org.smart.admin.repository;

import org.smart.admin.model.entity.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommuneRepository extends JpaRepository<Commune, Long> {

	Commune findByInsee(String insee);

}
