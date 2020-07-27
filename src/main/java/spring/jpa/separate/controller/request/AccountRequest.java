package spring.jpa.separate.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountRequest {

	private String name;
	private Character sex;
	private String phone;

}
