
package acme.entities.trackingLogs;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import acme.client.components.basis.AbstractEntity;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidMoment;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.entities.claim.Claim;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrackingLogs extends AbstractEntity {
	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidMoment
	@Temporal(TemporalType.TIMESTAMP)
	private Date				lastUpdateMoment; // Último momento de actualización

	@Mandatory
	@ValidString(max = 50)
	@Automapped
	private String				currentStep; // Paso en curso (máximo 50 caracteres)

	@Mandatory
	@ValidNumber(min = 0, max = 100)
	@Automapped
	private Integer				resolutionPercentage; // Porcentaje de resolución (0-100)

	@Mandatory
	//?¿
	@Automapped
	private Boolean				isFinallyAccepted; // Indicador de si la reclamación fue finalmente aceptada o no

	@Mandatory
	@Valid
	@Automapped
	private Claim				claim; // Relación con la entidad Claim (la reclamación que se está rastreando)

	// Campos adicionales cuando la reclamación es aceptada o rechazada
	@Optional
	@ValidString(max = 255)
	@Automapped
	private String				resolutionReason; // Razón por la que fue rechazada o compensación a ofrecer (máximo 255 caracteres)
}
