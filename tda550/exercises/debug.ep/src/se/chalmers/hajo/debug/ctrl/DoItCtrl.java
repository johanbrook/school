package se.chalmers.hajo.debug.ctrl;

import java.util.List;

import se.chalmers.hajo.debug.proc.IProcessor;
import se.chalmers.hajo.debug.proc.Processor;

public final class DoItCtrl {
	
	private final IProcessor p = Processor.getProcessor();
	private final String in;
	private final StringBuilder out;
	
	public DoItCtrl(String in, StringBuilder out){
		this.in = in;
		this.out = out;
	}

	public void execute(){
		List<String> result = p.permutate(in);
		StringBuilder b = new StringBuilder();
		for( String s : result ){
			b.append(s + "\n");
		}
		out.append(b);
	}
}
