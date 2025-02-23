
package acme.entities.activityLog;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.realms.crew.Crew;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ActivityLog extends AbstractEntity {

	// Serialisation identifier ----------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ------------------------------------------------------

	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment(past = true)
	@Mandatory
	private Date				registrationMoment;

	@Mandatory
	@ValidString(max = 50)
	private String				typeIncident;

	@Mandatory
	@ValidString
	private String				description;

	@Mandatory
	@ValidNumber(min = 0, max = 10, fraction = 0)
	private Integer				range;

	// Relationships ----------------------------------------------------

	//	@Mandatory
	//	@Valid
	//	@ManyToOne(optional = false)
	//	private Leg				leg;

	@Mandatory
	@Valid
	@ManyToOne(optional = false)
	private Crew				crew;
}
