package steps.implementation;

import cucumber.api.Scenario;
import cucumber.api.Result.Type;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import wdMethods.Annotations;
import wdMethods.SeMethods;

public class Hoooks  {
	
	@Before
	public void before(Scenario sc)
	{
		
		String name = sc.getName();
		System.out.println(name);
		String uri = sc.getUri();
		System.out.println("uri : "+uri);
		String id = sc.getId();
		System.out.println(id);		
	}
	
	@After
	public void after(Scenario sc)
	{
		Type status = sc.getStatus();
		System.out.println(status);		
	}
		
	

}
