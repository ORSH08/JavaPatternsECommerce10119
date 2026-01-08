package orGalProject;

import java.util.HashMap;
import java.util.Map;

public class MenuFacade {
	    private Map<String, Command> commands = new HashMap<>();

	    public MenuFacade(MarketManagmentFacade facade) {
	        commands.put("99", new DisplayBuyersNamesCommand(facade));
	        commands.put("100", new PrintNamesCountCommand(facade));
	        commands.put("101", new PrintSpecificNameCountCommand(facade));
	        commands.put("102" , new PrintDoubleNamesCommand(facade));
	        commands.put("103" , new PrintSortedSetCommand(facade));
	        
	    }

	    public void executeCommand(String option) {
	        Command command = commands.get(option);
	        if (command != null) {
	            command.execute();
	        } else {
	            System.out.println("Invalid selection. Please try again.");
	        }
	    }
	}



