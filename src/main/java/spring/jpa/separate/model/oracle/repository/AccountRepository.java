package spring.jpa.separate.model.oracle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.jpa.separate.model.oracle.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
