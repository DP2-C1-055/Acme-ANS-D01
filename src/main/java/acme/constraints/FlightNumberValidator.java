
package acme.constraints;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import acme.client.components.validation.AbstractValidator;
import acme.features.administrator.airline.AdministratorAirlineRepository;
import acme.features.manager.leg.ManagerLegRepository;

public class FlightNumberValidator extends AbstractValidator<ValidFlightNumber, String> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private ManagerLegRepository			legRepository;

	@Autowired
	private AdministratorAirlineRepository	airlineRepository;

	private static final Pattern			FLIGHT_PATTERN	= Pattern.compile("^[A-Z]{2}\\d{4}$");

	// ConstraintValidator interface ------------------------------------------


	@Override
	protected void initialise(final ValidFlightNumber annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final String flightNumber, final ConstraintValidatorContext context) {
		assert context != null;

		boolean result;

		if (flightNumber == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");
		else {
			{
				boolean matchesPattern = flightNumber != null && FlightNumberValidator.FLIGHT_PATTERN.matcher(flightNumber).matches();
				super.state(context, matchesPattern, "flightNumber", "acme.validation.leg.invalid-flight-number.message");
			}
			{
				boolean airlineExists = flightNumber != null && this.airlineRepository.existsByIataCode(flightNumber.substring(0, 2));
				super.state(context, airlineExists, "flightNumber", "acme.validation.leg.nonexistent-airline.message");
			}
			{
				boolean uniqueFlightNumber = this.legRepository.findLegByFlightNumber(flightNumber) == null;
				super.state(context, uniqueFlightNumber, "flightNumber", "acme.validation.leg.duplicated-flight-number.message");
			}
		}

		result = !super.hasErrors(context);
		return result;
	}
}
