
package com.cydeo.repository;

import com.cydeo.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    Optional<Parent> findByUsername(String username);

}
