
package acme.entities.aircraft;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.Length;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Aircraft extends AbstractEntity {

	private static final long	serialVersionUID	= 1L;

	@Mandatory
	@Length(max = 50)
	protected String			model;

	@Mandatory
	@Column(unique = true)
	@Length(max = 50)
	protected String			registrationNumber;

	@Mandatory
	@ValidNumber(min = 0)
	protected Integer			capacity;

	@Mandatory
	@ValidNumber(min = 2, max = 50)
	protected Integer			cargoWeight;

	@Mandatory
	protected ServiceStatus		status;

	@Optional
	@ValidString
	protected String			details;

}
