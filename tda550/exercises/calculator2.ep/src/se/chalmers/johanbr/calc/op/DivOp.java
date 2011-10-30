package se.chalmers.johanbr.calc.op;

class DivOp implements IBinOp {

	@Override
	public double eval(double op1, double op2) {
		// Div with 0 no problem will yield "Infinity"
		return op2/op1;
	}
	@Override
	public String toString() {
		return "DivOp";
	}
}
