package se.chalmers.johanbr.calc.op;

class MulOp implements IBinOp {

	@Override
	public double eval(double op1, double op2) {
		return op1 * op2;
	}
	
	@Override
	public String toString() {
		return "MulOp";
	}
}
