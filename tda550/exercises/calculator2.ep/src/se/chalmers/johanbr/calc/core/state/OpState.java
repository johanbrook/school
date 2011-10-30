package se.chalmers.johanbr.calc.core.state;

import se.chalmers.hajo.calc.core.Calculator;
import se.chalmers.hajo.calc.op.IBinOp;

/**
 * As long as we read operators we stay here
 * Reading more operators will trigger evaluation after
 * every one.
 * 
 * @author hajo
 *
 */
public final class OpState extends AbstractState {

	public OpState(Calculator calc) {
		super(calc);
	}

	@Override
	public void enterDigit(String c) {
		calc.storeOperand();
		calc.setOperand(c); // Remove previous operand
		calc.setCurState(calc.DIGIT_STATE);
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
	}
	
	@Override
	public String toString() {
		return "OpState";
	}
}
