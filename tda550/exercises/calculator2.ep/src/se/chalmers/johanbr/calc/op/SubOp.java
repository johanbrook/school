package se.chalmers.johanbr.calc.op;


class SubOp implements IBinOp {

	@Override
	public double eval(double op1, double op2) {
		// TODO bug here op1 - op2
		return op2-op1;
	}
	@Override
	public String toString() {
		return "SubOp";
	}
}
