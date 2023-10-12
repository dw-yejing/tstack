// Generated from G:/workspace_exercise/tstack/elasticsearch/src/main/resources/g4\PatentQuery.g4 by ANTLR 4.9.2
package edu.bjtu.elasticsearch.dsl;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link PatentQueryVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class PatentQueryBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements PatentQueryVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitParseQuery(PatentQueryParser.ParseQueryContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitExpression(PatentQueryParser.ExpressionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAtom(PatentQueryParser.AtomContext ctx) { return visitChildren(ctx); }
}