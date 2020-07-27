package spring.jpa.separate.model.oracle.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import spring.jpa.separate.dto.AccountDto;
import spring.jpa.separate.model.dao.AccountDao;
import spring.jpa.separate.model.oracle.entity.Account;
import spring.jpa.separate.model.oracle.repository.AccountRepository;

@Repository
public class AccountDaoImpl implements AccountDao {

	private final AccountRepository accountRepo;

	@Autowired
	public AccountDaoImpl(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public boolean existsById(Long id)
	{
		return accountRepo.existsById(id);
	}

	@Override
	public List<AccountDto> findAll(Sort sort)
	{
		List<Account> list = accountRepo.findAll(sort);
		return list.stream().map(e -> AccountDto.valueOf(e)).collect(Collectors.toList());
	}

	@Override
	public Optional<AccountDto> findById(Long id)
	{
		Optional<Account> accountOpt = accountRepo.findById(id);
		if (accountOpt.isPresent()) {
			return Optional.of(AccountDto.valueOf(accountOpt.get()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public AccountDto save(AccountDto accountDto)
	{
		Account account = Account.builder().id(accountDto.getId()).name(accountDto.getName())
				.sex(accountDto.getSex()).phone(accountDto.getPhone()).build();
		return AccountDto.valueOf(accountRepo.save(account));
	}

	@Override
	public void deleteById(Long id)
	{
		accountRepo.deleteById(id);
	}

}
