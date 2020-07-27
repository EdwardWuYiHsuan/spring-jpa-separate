package spring.jpa.separate.model.sql_server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.jpa.separate.model.sql_server.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
