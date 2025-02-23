
package acme.realms.crew;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;

import acme.client.components.basis.AbstractRole;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Crew extends AbstractRole {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{2,3}\\d{6}$", message = "{validation.code}")
	private String				code;

	@Mandatory
	@ValidString(pattern = "^\\+?\\d{6,15}$", message = "{validation.phoneNumber}")
	private String				phoneNumber;

	@Mandatory
	@ValidString
	private String				skills;

	@Mandatory
	@Valid
	@Automapped
	private AvailabilityStatus	availability;

	@Mandatory
	@ValidMoney
	private Money				salary;

	@Optional
	@ValidNumber(min = 0, integer = 2, fraction = 0)
	private Integer				yearsExperience;

	// Relationships ----------------------------------------------------

	//	@NotNull
	//	@Valid
	//	@ManyToOne(optional = false)
	//	protected Airline

}
