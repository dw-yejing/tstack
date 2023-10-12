// Generated from G:/workspace_exercise/tstack/elasticsearch/src/main/resources/g4\PatentQuery.g4 by ANTLR 4.9.2
package edu.bjtu.elasticsearch.dsl;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PatentQueryParser}.
 */
public interface PatentQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PatentQueryParser#parseQuery}.
	 * @param ctx the parse tree
	 */
	void enterParseQuery(PatentQueryParser.ParseQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatentQueryParser#parseQuery}.
	 * @param ctx the parse tree
	 */
	void exitParseQuery(PatentQueryParser.ParseQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatentQueryParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PatentQueryParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatentQueryParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PatentQueryParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PatentQueryParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(PatentQueryParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PatentQueryParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(PatentQueryParser.AtomContext ctx);
}