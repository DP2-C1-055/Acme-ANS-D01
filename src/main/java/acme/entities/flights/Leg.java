
package acme.entities.flights;

import java.util.Date;

import javax.persistence.Column;
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
import acme.entities.airport.Airport;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Leg extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	// Preguntar sobre este atributo. Debería ser derivado para poder obtener el IATA de la aerolínea?
	@Column(unique = true)
	@Mandatory
	@ValidString(pattern = "^[A-Z]{3}\\d{4}$")
	private String				flightNumber;

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				scheduledDeparture;

	@Mandatory
	@ValidMoment(past = true)
	private Date				scheduledArrival;

	@Mandatory
	@ValidNumber(min = 0, integer = 2, fraction = 0)
	private Double				durationInHours;

	@Mandatory
	@Valid
	private LegStatus			status;

	// Relationships ----------------------------------------------------------

	@Mandatory
	@ManyToOne(optional = false)
	@Valid
	private Airport				departureAirport;

	@Mandatory
	@ManyToOne(optional = false)
	@Valid
	private Airport				arrivalAirport;

	// El Aircraft asignado, que pertenece a una Airline, de la cual se extrae el código IATA.
	//@Mandatory
	//@ManyToOne(optional = false)
	//@Valid
	//private Aircraft			aircraft;

	@Mandatory
	@ManyToOne(optional = false)
	@Valid
	private Flight				flight;

}
