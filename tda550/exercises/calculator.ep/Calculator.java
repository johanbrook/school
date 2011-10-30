package se.chalmers.hajo.calc.core;

import se.chalmers.hajo.calc.con.Constants;
import se.chalmers.hajo.calc.core.state.DigitState;
import se.chalmers.hajo.calc.core.state.ICalcState;
import se.chalmers.hajo.calc.core.state.OpState;
import se.chalmers.hajo.calc.core.state.PointState;
import se.chalmers.hajo.calc.core.state.StartState;
import se.chalmers.hajo.calc.ctrl.ICalculator;
import se.chalmers.hajo.calc.op.IBinOp;

/**
 * This is the core calculator class. Delegating much of the work to the states
 * 
 * NOTE: There are circular dependencies between this package and the
 * state-package. That's no problem they really are one package. The sub package
 * state is just for comfort.
 * 
 * @author hajo
 * 
 */
public class Calculator implements ICalculator {

	// The possible states
	public final ICalcState DIGIT_STATE = new DigitState(this);
	public final ICalcState OP_STATE = new OpState(this);
	public final ICalcState POINT_STATE = new PointState(this);
	public final ICalcState START_STATE = new StartState(this);

	// The current state
	private ICalcState curState = START_STATE;
	// Accumulator to store the previous operand
	private double acc = 0;
	// The current operand (and result)
	private final StringBuffer operand = new StringBuffer();

	// The identity operation. Never used from outside
	private final IBinOp ID_OP = new IBinOp() {
		public double eval(double n1, double n2) {
			return n1;
		}

		@Override
		public String toString() {
			return "NoOp";
		}
	};
	// The last entered operation
	private IBinOp pendingOp = ID_OP;

	// ----- Called from the states --------------------------------

	// This is the end of a calculation
	// Reset
	public void eval() {

		double result = pendingOp.eval(Double.parseDouble(operand.toString()),
				acc);
		acc = 0;
		pendingOp = ID_OP;
		operand.setLength(0);
		operand.append(result);
	}

	public void appendOperand(String string) {
		// TODO bug here string.length()
		if (operand.length() < Constants.N_DIGITS - 4) {
			operand.append(string);
		}
	}

	// Overwrite current operand
	public void setOperand(String c) {
		operand.setLength(0);
		operand.append(c);
	}

	public final void setPendingOp(IBinOp op) {
		pendingOp = op;
	}

	public final void setCurState(ICalcState state) {
		this.curState = state;
	}

	public void storeOperand() {
		acc = Double.parseDouble(operand.toString());
	}

	// ICalculator (used by GUI) ----------------------------

	public final String enterDigit(String digit) {
		curState.enterDigit(digit);
		return operand.toString();
	}

	public final String enterPoint() {
		curState.enterPoint();
		return operand.toString();
	}

	public final String enterOp(IBinOp op) {
		curState.enterOp(op);
		return operand.toString();
	}

	public final String enterEqual() {
		curState.enterEqual();
		return operand.toString();
	}

	// Not state dependent
	public String enterClear() {
		acc = 0;
		pendingOp = ID_OP;
		operand.setLength(0);
		operand.append("0");
		curState = START_STATE;
		return operand.toString();
	}

	// Debug --------------------------------------------------------

	@Override
	public String toString() {
		String s = "STATE:" + curState + " PENDING:" + pendingOp + " OPER:"
				+ operand.toString() + " ACC:" + acc;
		return s;
	}
}
