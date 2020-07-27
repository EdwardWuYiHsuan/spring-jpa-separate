package spring.jpa.separate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

	private Long id;
	private String name;
	private Character sex;
	private String phone;

	public static AccountDto valueOf(spring.jpa.separate.model.oracle.entity.Account account)
	{
		return new AccountDto(account.getId(), account.getName(), account.getSex(), account.getPhone());
	}
	
	public static AccountDto valueOf(spring.jpa.separate.model.sql_server.entity.Account account)
	{
		return new AccountDto(account.getId(), account.getName(), account.getSex(), account.getPhone());
	}
}
