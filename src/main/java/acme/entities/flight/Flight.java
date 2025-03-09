
package acme.entities.flight;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoney;
import acme.client.components.validation.ValidString;
import acme.realms.AirlineManager;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Flight extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(min = 1, max = 50)
	@Automapped
	private String				tag;

	@Mandatory
	@Valid
	@Automapped
	private Indication			indication;

	@Mandatory
	@ValidMoney(min = 0, max = 1000000)
	@Automapped
	private Money				cost;

	@Optional
	@ValidString(min = 0, max = 255)
	@Automapped
	private String				description;

	// Derived attributes -----------------------------------------------------


	@Transient
	public Date getScheduledDeparture() {
		//TO DO IN D03
		return null;
	}

	//Validación custom
	@Transient
	public Date getScheduledArrival() {
		//TO DO IN D03
		return null;
	}

	@Transient
	public String getOriginCity() {
		//TO DO IN D03
		return null;
	}

	@Transient
	public String getDestinationCity() {
		//TO DO IN D03
		return null;
	}

	@Transient
	public int getNumberOfLayovers() {
		//TO DO IN D03
		return 0;
	}

	// Relationships ----------------------------------------------------------


	@Mandatory
	@Valid
	@OneToOne(optional = false)
	private AirlineManager airlineManager;

}
