package se.chalmers.hajo.debug.proc;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the interface
 * 
 * @author hajo
 * 
 */
/*
 * *** You DON'T need to understand this! ***
 * 
 * It's also very strange to debug, but try ...!
 */
public class Processor implements IProcessor {

	List<String> permStrs = new ArrayList<String>();

	// Factory method
	public static IProcessor getProcessor() {
		return new Processor();
	}

	// Can't use contructor
	private Processor() {
	}

	public List<String> permutate(String s) {
		perm("", s);
		return permStrs;
	}

	private void perm(String prefix, String s) {
		int n = s.length();
		if (n == 0)
			permStrs.add(prefix);
		else {
			for (int i = 0; i < n; i++) {
				char ch =  s.charAt(i);
				String preCh = s.substring(0, i);
				String postCh = s.substring(i + 1, n);
				String pre = prefix + ch;
				String post = preCh + postCh;
				// Hmm, call myself...?
				perm( pre , post );
			
			}

		}

	}
}
