package org.springframework.aot.smoketest.support.junit;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <code>int</code> parameters of JUnit test methods annotated with this annotation will
 * be resolved to the docker-compose port for a given service.
 *
 * @author Moritz Halbritter
 */
@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
public @interface DockerComposePort {

	/**
	 * Name of the docker-compose service.
	 * @return name of the docker-compose service.
	 */
	String service();

	/**
	 * Port number of the docker-compose service.
	 * @return port number of the docker-compose service.
	 */
	int port();

}
