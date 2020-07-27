package spring.jpa.separate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.jpa.model.dao.AccountDao;
import spring.jpa.model.dto.AccountDto;
import spring.jpa.separate.controller.request.AccountRequest;
import spring.jpa.separate.controller.response.BaseResponse;
import spring.jpa.separate.controller.response.ErrCode;

@RestController
@RequestMapping("/account")
public class AccountController {

	private final AccountDao accountDao;

	@Autowired
	public AccountController(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BaseResponse get()
	{
		try {
			List<AccountDto> accountList = accountDao.findAll(Sort.by(Direction.DESC, "id"));
			return new BaseResponse(accountList);

		} catch (Exception e) {
			System.out.println("[API-GetAccounts] " + e.getMessage());
			return new BaseResponse(ErrCode.UNKNOWN_ERROR, e.getMessage());
		}
	}

	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BaseResponse create(@RequestBody AccountRequest request)
	{
		try {
			AccountDto accountDto = AccountDto.builder().name(request.getName()).sex(request.getSex())
					.phone(request.getPhone()).build();
			accountDto = accountDao.save(accountDto);
			return new BaseResponse(accountDto.getId());

		} catch (Exception e) {
			System.out.println("[API-CreateAccount] " + e.getMessage());
			return new BaseResponse(ErrCode.UNKNOWN_ERROR, e.getMessage());
		}
	}

	@PutMapping(value = "/update/{accountId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BaseResponse update(@PathVariable("accountId") Long id, @RequestBody AccountRequest request)
	{
		try {
			Optional<AccountDto> accountOpt = accountDao.findById(id);
			AccountDto accountDto = accountOpt
					.orElseThrow(() -> new IllegalArgumentException(ErrCode.INVALID_ARG_ACCOUNT_ID.getMessage()));
			if (!StringUtils.isEmpty(request.getName())) {
				accountDto.setName(request.getName());
			}
			if (null != request.getSex()) {
				accountDto.setSex(request.getSex());
			}
			if (!StringUtils.isEmpty(request.getPhone())) {
				accountDto.setPhone(request.getPhone());
			}
			accountDao.save(accountDto);

			return new BaseResponse(ErrCode.SUCCESS);

		} catch (Exception e) {
			System.out.println("[API-UpdateAccount] " + e.getMessage());
			return new BaseResponse(ErrCode.UNKNOWN_ERROR, e.getMessage());
		}
	}

	@DeleteMapping(value = "/delete/{accountId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public BaseResponse delete(@PathVariable("accountId") Long id)
	{
		try {
			if (accountDao.existsById(id)) {
				accountDao.deleteById(id);
			} else {
				throw new IllegalArgumentException(ErrCode.INVALID_ARG_ACCOUNT_ID.getMessage());
			}

			return new BaseResponse(ErrCode.SUCCESS);

		} catch (Exception e) {
			System.out.println("[API-DeleteAccount] " + e.getMessage());
			return new BaseResponse(ErrCode.UNKNOWN_ERROR, e.getMessage());
		}
	}

}
