package cz.karan.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.karan.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
