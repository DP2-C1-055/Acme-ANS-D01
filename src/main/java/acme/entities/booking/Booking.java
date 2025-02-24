
package acme.entities.booking;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.datatypes.Money;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidMoney;
import acme.entities.customer.Customer;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Booking extends AbstractEntity {

	protected static final long	serialVersionUID	= 1L;

	@Mandatory
	@Column(unique = true)
	@Pattern(regexp = "^[A-Z0-9]{6,8}$", message = "{validation.locatorCode}")
	protected String			locatorCode;

	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment
	@Mandatory
	protected Date				purchaseMoment;

	@Mandatory
	protected TravelClass		travelClass;

	@Mandatory
	@ValidMoney
	protected Money				price;

	@Optional
	protected String			lastNibble;

	protected boolean			draftMode;

	// Relationships ----------------------------------------------------------

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Customer			customer;

	//	@NotNull
	//	@Valid
	//	@ManyToOne(optional = false)
	//	private Flight fligth;

}
