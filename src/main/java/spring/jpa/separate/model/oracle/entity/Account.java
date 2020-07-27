package spring.jpa.separate.model.oracle.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_generator")
	@SequenceGenerator(sequenceName = "seq_account", allocationSize = 1, name = "account_generator")
	private Long id;
	
	@Setter
	@NotNull
	@Column(name = "name")
	private String name;
	
	@Setter
	@NotNull
	private Character sex;
	
	@Setter
	@Column(name = "phone")
	private String phone;

}
