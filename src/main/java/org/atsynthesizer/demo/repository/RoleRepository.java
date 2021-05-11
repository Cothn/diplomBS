package org.atsynthesizer.demo.repository;

import org.atsynthesizer.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
