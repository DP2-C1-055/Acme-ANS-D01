
package acme.entities.assistanceAgents;

import java.util.Date;

import javax.persistence.Column;
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
import acme.client.components.validation.ValidUrl;
import acme.entities.airline.Airline;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AssistanceAgents extends AbstractEntity {

	// Serialisation version --------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------

	@Mandatory
	@ValidString(pattern = "^[A-Z]{2,3}[0-9]{6}$")
	@Column(unique = true)
	private String				employeeCode; // Código único de empleado (ej. "ABC123456")

	@Mandatory
	@ValidString(max = 255)
	@Automapped
	private String				spokenLanguages; // Lista de idiomas hablados (máximo 255 caracteres)

	@Mandatory
	@Valid
	@Automapped
	private Airline				airline; // Relación con la entidad Airline (la aerolínea para la que trabajan)

	@Mandatory
	@ValidMoment(past = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date				startWorkMoment; // Momento en que comenzaron a trabajar (en el pasado)

	@Optional
	@ValidString(max = 255)
	@Automapped
	private String				bio; // Biografía breve (opcional, máximo 255 caracteres)

	@Optional
	@ValidNumber(min = 0)
	@Automapped
	private Double				salary; // Salario (opcional, número positivo o cero)

	@Optional
	@ValidUrl
	@Automapped
	private String				photoLink; // Link a una foto almacenada en otro lugar (opcional)

}
