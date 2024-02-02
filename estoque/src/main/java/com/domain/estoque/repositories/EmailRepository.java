package com.domain.estoque.repositories;

import com.domain.estoque.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email,Long> {


}
