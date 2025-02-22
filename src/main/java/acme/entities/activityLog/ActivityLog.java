
package acme.entities.activityLog;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import acme.client.components.basis.AbstractEntity;
import acme.entities.crew.Crew;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ActivityLog extends AbstractEntity {

	// Serialisation identifier ----------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------

	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent
	@NotNull
	protected Date				registrationMoment;

	@NotBlank
	@Length(max = 50)
	protected String			typeIncident;

	@NotBlank
	@Length(max = 255)
	protected String			description;

	@NotBlank
	@Length(min = 0, max = 10)
	protected Integer			range;

	// Relationships ----------------------------------------------------

	//	@NotNull
	//	@Valid
	//	@ManyToOne(optional = false)
	//	protected Leg				leg;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Crew				crew;
}
