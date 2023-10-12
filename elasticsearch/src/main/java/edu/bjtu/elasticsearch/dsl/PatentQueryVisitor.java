// Generated from G:/workspace_exercise/tstack/elasticsearch/src/main/resources/g4\PatentQuery.g4 by ANTLR 4.9.2
package edu.bjtu.elasticsearch.dsl;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PatentQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PatentQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PatentQueryParser#parseQuery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParseQuery(PatentQueryParser.ParseQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatentQueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PatentQueryParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PatentQueryParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(PatentQueryParser.AtomContext ctx);
}