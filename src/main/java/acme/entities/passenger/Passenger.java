
package acme.entities.passenger;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.components.basis.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Passenger extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(max = 255)
	protected String			fullName;

	@NotBlank
	@Email
	protected String			email;

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z0-9]{6,9}$", message = "{validation.passportNumber}")
	protected String			passportNumber;

	@Temporal(TemporalType.DATE)
	@PastOrPresent
	@NotNull
	protected Date				dateOfBirth;

	@Length(max = 50)
	protected String			specialNeeds;

}
