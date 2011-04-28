package specula.runtime;

import asmlib.Type;

public class ContinuationFilter {

	private final String[] prefixes = { "java.", "sun.", "jvstm.", "transactifier.",
			"specula.runtime.", "specula.core.",
			"org.eclipse.tptp.", "com.yourkit.runtime.", "org.apache.", "com.google.", };

		protected String[] prefixes() {
			return prefixes;
		}

		// Overload que recebe tipo numa String em formato ASM
		public boolean filter(String type) {
			return filter(Type.fromAsm(type));
		}

		public boolean filter(Type type) {			
			for (String s : prefixes()) if (type.commonName().startsWith(s)) return true;
			return false;
		}
		
}
