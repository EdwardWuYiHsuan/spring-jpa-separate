package spring.jpa.separate.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import spring.jpa.separate.dto.AccountDto;

public interface AccountDao {

	boolean existsById(Long id);

	List<AccountDto> findAll(Sort sort);

	Optional<AccountDto> findById(Long id);

	AccountDto save(AccountDto accountDto);

	void deleteById(Long id);

}
