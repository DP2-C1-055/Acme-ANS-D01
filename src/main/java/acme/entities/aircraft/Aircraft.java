
package acme.entities.aircraft;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
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
	@ValidString(max = 50)
	@Automapped
	protected String			model;

	@Mandatory
	@Column(unique = true)
	@ValidString(max = 50)
	protected String			registrationNumber;

	@Mandatory
	@ValidNumber(min = 0)
	@Automapped
	protected Integer			capacity; //Revisar limite en el foro

	@Mandatory
	@ValidNumber(min = 2, max = 50)
	@Automapped
	protected Integer			cargoWeight;

	@Mandatory
	@Valid
	@Automapped
	protected ServiceStatus		status;

	@Optional
	@ValidString
	@Automapped
	protected String			details;

}
