
package acme.constraints;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import acme.client.components.principals.DefaultUserIdentity;
import acme.client.components.validation.AbstractValidator;
import acme.features.authenticated.manager.AuthenticatedManagerRepository;
import acme.realms.Manager;

public class IdentifierValidator extends AbstractValidator<ValidIdentifier, String> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedManagerRepository repository;


	@Override
	protected void initialise(final ValidIdentifier annotation) {
		assert annotation != null;
	}

	@Override
	public boolean isValid(final String identifier, final ConstraintValidatorContext context) {
		assert context != null;

		boolean result;

		if (identifier == null)
			super.state(context, false, "*", "javax.validation.constraints.NotNull.message");
		else {
			// 1. Validar el formato del identifier
			boolean matchesPattern = identifier.matches("^[A-Z]{2,3}\\d{6}$");
			super.state(context, matchesPattern, "identifier", "acme.validation.manager.invalid-identifier.message");

			// 2. Validar la unicidad del identifier
			Manager existingManager = this.repository.findManagerByIdentifier(identifier);
			boolean uniqueIdentifier = existingManager == null;
			super.state(context, uniqueIdentifier, "identifier", "acme.validation.manager.duplicated-identifier.message");

			// 3. Validar que las dos primeras letras del identifier coinciden con las iniciales de la identidad del manager actual
			if (identifier.length() >= 2) {
				// Obtener el username del usuario autenticado
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				String username = authentication.getName();

				// Buscar el Manager por username
				Manager currentManager = this.repository.findManagerByUsername(username);
				if (currentManager != null) {
					DefaultUserIdentity identity = currentManager.getIdentity();
					if (identity != null) {
						String name = identity.getName();
						String surname = identity.getSurname();
						boolean initialsValid = false;
						if (name != null && surname != null && !name.isEmpty() && !surname.isEmpty())
							initialsValid = identifier.charAt(0) == name.charAt(0) && identifier.charAt(1) == surname.charAt(0);
						super.state(context, initialsValid, "identifier", "acme.validation.manager.incorrect-initials.message");
					}
				}
			}
		}

		result = !super.hasErrors(context);
		return result;
	}
}
