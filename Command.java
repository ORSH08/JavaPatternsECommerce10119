package orGalProject;

import java.util.List;

public interface Command {

	void execute();
}

class DisplayBuyersNamesCommand implements Command {

	private MarketManagmentFacade facade;

	public DisplayBuyersNamesCommand(MarketManagmentFacade facade) {
		this.facade = facade;
	}

	@Override
	public void execute() {
		facade.displayBuyersNames();

	}

}

class PrintNamesCountCommand implements Command {
	private MarketManagmentFacade facade;

	public PrintNamesCountCommand(MarketManagmentFacade facade) {
		this.facade = facade;
	}

	@Override
	public void execute() {
		facade.printNamesCount();
	}
}

class PrintSpecificNameCountCommand implements Command {
	private MarketManagmentFacade facade;

	public PrintSpecificNameCountCommand(MarketManagmentFacade facade) {
		this.facade = facade;
	}

	@Override
	public void execute() {
		facade.printSpesificNameCount();
	}
}

class PrintDoubleNamesCommand implements Command {
	private MarketManagmentFacade facade;

	public PrintDoubleNamesCommand(MarketManagmentFacade facade) {
		this.facade = facade;
	}

	@Override
	public void execute() {
		facade.printDoubleNames();
	}
}

class PrintSortedSetCommand implements Command {
	private MarketManagmentFacade facade;

	public PrintSortedSetCommand(MarketManagmentFacade facade) {
		this.facade = facade;
	}

	@Override
	public void execute() {
		facade.printSortedSet();
	}
}

 

