package com.afkghouri.JPAVaadinAssignment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

}
