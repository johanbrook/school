package se.chalmers.hajo.debug.proc;

import java.util.List;

/**
 * Interface for a subsystem
 * @author hajo
 *
 */
public interface IProcessor {

	// Permutations of a string
	public abstract List<String> permutate(String s);

}