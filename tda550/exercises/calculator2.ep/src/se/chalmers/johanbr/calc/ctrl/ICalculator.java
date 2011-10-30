package se.chalmers.johanbr.calc.ctrl;

import se.chalmers.hajo.calc.op.IBinOp;

/**
 * Interface used by GUI. This is to isolate (and limit the
 * visibility of) the Calculator class i.e. hiding 
 * the implementation
 * 
 * @author hajo
 *
 */

public interface ICalculator {

	public abstract String enterDigit(String digit);

	public abstract String enterPoint();

	public abstract String enterOp(IBinOp op);

	public abstract String enterEqual();

	public abstract String enterClear();

}