package org.darion.jopt;

import joptsimple.OptionParser;

public class Examples {
	public static void main(String[] args) {
		//Arguments of Options
		
		
		// OptionParser parser = new OptionParser("aB?.fc:q::");
		// OptionSet options = parser.parse("-a", "-B", "-?", "-f", "-c", "foo",
		// "-q");
		//
		// if (options.has("a")) {
		//
		// }
		//
		// if (options.has("B")) {
		//
		// }
		//
		// if (options.has("?")) {
		//
		// }
		//
		// if (options.has(".")) {
		//
		// }

		// Clustering Short Options
		// OptionParser parser = new OptionParser("aBcd");
		// OptionSet options = parser.parse("-cdBa");
		// if (options.has("a")) {
		// System.out.println("has a");
		// }
		// if (options.has("B")) {
		// System.out.println("has B");
		// }
		// if (options.has("c")) {
		// System.out.println("has c");
		// }
		// if (options.has("d")) {
		// System.out.println("has d");
		// }

		// OptionParser parser = new OptionParser();
		// parser.accepts("a");
		// parser.accepts("B");
		// parser.accepts("c").withRequiredArg();
		// OptionSet options = parser.parse("-aBcfoo");
		// if (options.has("a")) {
		// System.out.println("has a");
		// }
		// if (options.has("B")) {
		// System.out.println("has B");
		// }
		// if (options.has("c")) {
		// System.out.println("c == " + options.valueOf("c"));
		// }

		// Long Options/Fluent Interface
		// OptionParser parser = new OptionParser();
		// parser.accepts("flag");
		// parser.accepts("verbose");
		// OptionSet options = parser.parse("--flag");
		// if (options.has("flag")) {
		// System.out.println("has flag");
		// }
		// if (options.has("verbose")) {
		// System.out.println("has verbose");
		// }

		// "Required" Options
		OptionParser parser = new OptionParser() {
			{
				accepts("userid").withRequiredArg().required();
				accepts("password").withRequiredArg().required();
			}
		};

		parser.parse("--userid", "bob");
	}
}
