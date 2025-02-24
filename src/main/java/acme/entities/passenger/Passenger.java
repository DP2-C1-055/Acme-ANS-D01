
package acme.entities.passenger;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Passenger extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@Mandatory
	@ValidString
	protected String			fullName;

	@Mandatory
	@ValidEmail
	protected String			email;

	@Mandatory
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z0-9]{6,9}$", message = "{validation.passportNumber}")
	protected String			passportNumber;

	@Temporal(TemporalType.DATE)
	@ValidMoment(past = true)
	@Mandatory
	protected Date				dateOfBirth;

	@Length(max = 50)
	@Optional
	protected String			specialNeeds;

}
