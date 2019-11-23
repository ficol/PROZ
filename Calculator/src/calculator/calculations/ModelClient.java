package calculator.calculations;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.json.bind.Jsonb;

public class ModelClient {
	private final String URI = "http://docker-proz.apps.us-west-1.online-starter.openshift.com/CalculatorServer/rest/calculation";
	private Client client = ClientBuilder.newClient();

	public String calculate(String expression) {
		return client
				.target(URI)
				.path("calculate")
				.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(expression), String.class);
	}
	public String factorial(String expression) {
		return client
				.target(URI)
				.path("factorial")
				.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(expression), String.class);
	}
	public String squareRoot(String expression) {
		return client
				.target(URI)
				.path("squareRoot")
				.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(expression), String.class);
	}
}
