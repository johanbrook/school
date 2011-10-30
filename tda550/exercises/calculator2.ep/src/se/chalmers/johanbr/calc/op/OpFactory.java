package se.chalmers.johanbr.calc.op;

import java.util.HashMap;
import java.util.Map;


/**
 * A static factory for bin ops
 * @author hajo
 *
 */
public final class OpFactory {

	private static final Map<String, IBinOp> binOps = new HashMap<String, IBinOp>();
	static {
		binOps.put("+", new AddOp());
		binOps.put("-", new SubOp());
		binOps.put("*", new MulOp());
		// TODO Bug here : remove following row
		binOps.put("/", new DivOp());
	}

	public static IBinOp getBinOp(String op) {
		return binOps.get(op);
	}
}
