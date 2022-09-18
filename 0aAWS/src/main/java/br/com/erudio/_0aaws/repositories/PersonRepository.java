package br.com.erudio._0aaws.repositories;

import br.com.erudio._0aaws.model.PersonVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonVO, Long> {
}
