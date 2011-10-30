package se.chalmers.hajo.calc.core.state;

import se.chalmers.hajo.calc.op.IBinOp;

/**
 * The common type for the states (so we can have
 * a single variable (in Calculator) and swap between objects).
 * 
 * NOTE: enterClear() is not state dependent so not 
 *       represented here
 *       
 * @author hajo
 */
public interface ICalcState {
	public void enterDigit(String c);

	public void enterOp(IBinOp op);

	public void enterEqual();

	public void enterPoint();

}
