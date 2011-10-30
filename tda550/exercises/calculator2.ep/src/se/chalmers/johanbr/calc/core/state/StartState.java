package se.chalmers.johanbr.calc.core.state;

import se.chalmers.hajo.calc.core.Calculator;
import se.chalmers.hajo.calc.op.IBinOp;

/**
 * Program starts here. As long as we enter 0's we stay here
 * 
 * @author hajo
 */
public final class StartState extends AbstractState {

	public StartState(Calculator calc) {
		super(calc);
	}

	@Override
	public void enterDigit(String c) {
		// If 0 stay here!
		if (c.charAt(0) != '0') {
			calc.setOperand(c); // Remove leading 0
			calc.setCurState(calc.DIGIT_STATE);
		}
	}

	@Override
	public void enterPoint() {
		// TODO bug = addOperand(c) possible to get two '.'s
		calc.setOperand("0.");
		calc.setCurState(calc.POINT_STATE);
	}

	@Override
	public void enterOp(IBinOp op) {
		// Operand value is the default i.e. 0
		calc.setPendingOp(op);
		calc.setCurState(calc.OP_STATE);
	}

	@Override
	public String toString() {
		return "StartState";
	}

}
