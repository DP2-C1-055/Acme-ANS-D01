
package acme.entities.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.entities.passenger.Passenger;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@Mandatory
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$", message = "{validation.identifierCode}")
	protected String			identifier;

	@Mandatory
	@Pattern(regexp = "^\\+?\\d{6,15}$", message = "{validation.phoneNumber}")
	protected String			phoneNumber;

	@Mandatory
	@ValidString
	protected String			address;

	@Mandatory
	@Length(max = 50)
	protected String			city;

	@Mandatory
	@Length(max = 50)
	protected String			country;

	@ValidNumber(max = 500)
	@Optional
	protected Integer			earnedPoints;

	protected boolean			draftMode;

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Passenger			passenger;

}
