package se.chalmers.johanbr.calc.core.state;

import se.chalmers.hajo.calc.core.Calculator;
import se.chalmers.hajo.calc.op.IBinOp;

/**
 * This state will not let another point enter the operand
 * 
 * @author hajo
 *
 */
public final class PointState extends AbstractState {

	public PointState(Calculator calc) {
		super(calc);
	}

	@Override
	public void enterDigit(String c) {
		calc.appendOperand(c);
	}

	@Override
	public void enterEqual() {
		calc.eval();	
		calc.setCurState(calc.START_STATE);
	}

	@Override
	public void enterOp(IBinOp op) {
		calc.eval();
		calc.setPendingOp(op);
		calc.setCurState(calc.OP_STATE);
	}

	@Override
	public String toString() {
		return "PointState";
	}
}
