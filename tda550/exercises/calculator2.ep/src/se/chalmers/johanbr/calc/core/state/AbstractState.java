package se.chalmers.johanbr.calc.core.state;

import se.chalmers.johanbr.calc.core.Calculator;
import se.chalmers.johanbr.calc.op.IBinOp;

/**
 * Default implementations of contract for state
 * States only overrides methods that are valid in the state
 * (if invalid nothing happens)
 * 
 * @author hajo
 */
public abstract class AbstractState implements ICalcState {

	protected final Calculator calc;
	
	public AbstractState(Calculator calc) {
		//TODO Bug here calc = calc  (remove final above)
		this.calc = calc;
	}

	public void enterDigit(String c) {
	} 

	public void enterEqual() {
	}

	public void enterOp(IBinOp op) {
	}

	public void enterPoint() {
	}

}
