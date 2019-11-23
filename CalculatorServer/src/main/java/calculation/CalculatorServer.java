/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package calculation;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import com.fathzer.soft.javaluator.DoubleEvaluator;

@Path("calculation")
public class CalculatorServer {
	@POST
	@Path("calculate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String calculate(String expression) {
		DoubleEvaluator evaluator = new DoubleEvaluator();
		double result;
		try
		{
			result = evaluator.evaluate(expression);
		}
		catch(RuntimeException e)
		{
			return "Illegal expression";
		}
		return String.valueOf(result);
	}

	@POST
	@Path("factorial")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String factorial(String expression) {
		DoubleEvaluator evaluator = new DoubleEvaluator();
		double result;
		try
		{
			result = factorial(evaluator.evaluate(expression));
		}
		catch(RuntimeException e)
		{
			return "Illegal expression";
		}
		return String.valueOf(result);
	}

	@POST
	@Path("squareRoot")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String squareRoot(String expression) {
		DoubleEvaluator evaluator = new DoubleEvaluator();
		double result;
		try
		{
			result = Math.sqrt(evaluator.evaluate(expression));
		}
		catch(RuntimeException e)
		{
			return "Illegal expression";
		}
		return String.valueOf(result);
	}

	private long factorial(double n) {
		long fact = 1;
		if (n < 0)
			throw new IllegalArgumentException();
		for (int i = 2; i <= n; i++) {
			fact = Math.multiplyExact(fact, i);
		}
		return fact;
	}
}
