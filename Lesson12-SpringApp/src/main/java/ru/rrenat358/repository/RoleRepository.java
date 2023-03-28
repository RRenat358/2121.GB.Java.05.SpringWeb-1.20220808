package ru.rrenat358.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rrenat358.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
