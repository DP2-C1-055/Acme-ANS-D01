
package acme.entities.assignment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import acme.realms.crew.Crew;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Assignment extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@Valid
	@Automapped
	private DutyCrew			duty;

	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment(past = true)
	@Mandatory
	private Date				lastUpdate;

	@Mandatory
	@Valid
	@Automapped
	private CurrentStatus		currentStatus;

	@Optional
	@ValidString
	private String				remarks;

	// Relationships ----------------------------------------------------

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	protected Crew				crew;

	//	@Mandatory
	//	@Valid
	//	@ManyToOne(optional = false)
	//	protected Leg				leg;
}
