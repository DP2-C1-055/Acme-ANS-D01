
package acme.entities.airline;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import acme.client.components.validation.ValidUrl;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Airline extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@ValidString(max = 50)
	private String				name;

	@ValidString(pattern = "^[A-Z]{2}X$")
	@Mandatory
	private String				IATACode;

	@Mandatory
	@ValidUrl
	private String				website;

	@Mandatory
	private AirLineType			airlineType;

	@Temporal(TemporalType.TIMESTAMP)
	@ValidMoment(past = true)
	@Mandatory
	private Date				foundationMoment;

	@ValidEmail
	@Optional
	private String				email;

	@ValidString(pattern = "^\\+?\\d{6,15}$")
	@Optional
	private String				phoneNumber;

}
