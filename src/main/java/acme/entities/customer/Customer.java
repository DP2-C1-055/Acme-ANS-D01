
package acme.entities.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.ValidNumber;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$", message = "{validation.identifierCode}")
	protected String			identifier;

	@NotBlank
	@Pattern(regexp = "^\\+?\\d{6,15}$", message = "{validation.phoneNumber}")
	protected String			phoneNumber;

	@NotBlank
	@Length(max = 255)
	protected String			address;

	@NotBlank
	@Length(max = 50)
	protected String			city;

	@NotBlank
	@Length(max = 50)
	protected String			country;

	@ValidNumber(max = 500)
	protected Integer			earnedPoints;

	protected boolean			draftmode;

}
