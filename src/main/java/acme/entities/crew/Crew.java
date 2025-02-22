
package acme.entities.crew;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Crew extends AbstractEntity {

	// Serialisation identifier ----------------------------------------

	protected static final long		serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------

	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z]{2,3}\\d{6}$", message = "{validation.code}")
	protected String				code;

	@NotBlank
	@Pattern(regexp = "^\\+?\\d{6,15}$", message = "{validation.phoneNumber}")
	protected String				phoneNumber;

	@NotBlank
	@Length(max = 255)
	protected String				skills;

	@NotNull
	protected AvailabilityStatus	availability;

	@NotNull
	protected Money					salary;

	protected int					yearsExperience;

	// Relationships ----------------------------------------------------

	//	@NotNull
	//	@Valid
	//	@ManyToOne(optional = false)
	//	protected Airline				airline;

}
