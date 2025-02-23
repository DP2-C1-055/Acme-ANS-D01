
package acme.entities.crew;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
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
public class Crew extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	protected static final long		serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@Column(unique = true)
	@ValidString(pattern = "^[A-Z]{2,3}\\d{6}$", message = "{validation.code}")
	protected String				code;

	@Mandatory
	@ValidString(pattern = "^\\+?\\d{6,15}$", message = "{validation.phoneNumber}")
	protected String				phoneNumber;

	@Mandatory
	@ValidString
	protected String				skills;

	@Mandatory
	@Valid
	@Automapped
	protected AvailabilityStatus	availability;

	@Mandatory
	@ValidMoney
	protected Money					salary;

	@Optional
	@ValidNumber(min = 0, integer = 2, fraction = 0)
	protected Integer				yearsExperience;

}
