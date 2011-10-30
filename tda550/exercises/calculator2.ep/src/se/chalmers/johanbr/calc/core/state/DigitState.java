package se.chalmers.johanbr.calc.core.state;

import se.chalmers.johanbr.calc.core.Calculator;
import se.chalmers.johanbr.calc.op.IBinOp;

/**
 * As long as we read digits we stay here
 * @author hajo
 *
 */
public final class DigitState extends AbstractState {

	public DigitState(Calculator calc) {
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
	public void enterPoint() {
		calc.appendOperand(".");
		calc.setCurState(calc.POINT_STATE);
	}

	@Override
	public String toString() {
		return "DigitState";
	}
}
