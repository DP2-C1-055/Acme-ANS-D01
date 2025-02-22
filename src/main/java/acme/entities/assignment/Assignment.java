
package acme.entities.assignment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
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
public class Assignment extends AbstractEntity {

	// Serialisation identifier ----------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------

	@NotNull
	protected DutyCrew			duty;

	@Temporal(TemporalType.TIMESTAMP)
	@PastOrPresent
	@NotNull
	protected Date				lastUpdate;

	@NotNull
	protected CurrentStatus		currentStatus;

	@Length(max = 255)
	protected String			remarks;

	// Relationships ----------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Crew				crew;

	//	@NotNull
	//	@Valid
	//	@ManyToOne(optional = false)
	//	protected Leg				leg;

}
