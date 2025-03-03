
package acme.entities.claim;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.ValidEmail;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidString;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Claim extends AbstractEntity {
	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				registrationMoment; // Momento de registro (en el pasado)

	@Mandatory
	@ValidEmail
	@Automapped
	private String				passengerEmail; // Correo electrónico del pasajero

	@Mandatory
	@ValidString(max = 255)
	@Automapped
	private String				description; // Descripción de la reclamación (máximo 255 caracteres)

	@Mandatory
	@Valid
	@Automapped
	private ClaimType			type; // Tipo de reclamación (enum con los valores especificados)

	@Mandatory
	//?¿
	@Automapped
	private Boolean				isAccepted; // Indicador de si la reclamación fue aceptada (true/false)

}
