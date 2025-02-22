
package acme.entities.airline;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.components.basis.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airline extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(max = 50)
	protected String			name;

	@Pattern(regexp = "^[A-Z]{2}X$")
	@NotBlank
	protected String			IATACode;

	@NotBlank
	//@Link ????
	protected String			website;

	@NotBlank
	protected AirLineType		airlineType;

	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent
	@NotBlank
	protected Date				foundationMoment;

	@Email
	protected String			email;

	@Pattern(regexp = "^\\+?\\d{6,15}$")
	protected String			phoneNumber;

}
