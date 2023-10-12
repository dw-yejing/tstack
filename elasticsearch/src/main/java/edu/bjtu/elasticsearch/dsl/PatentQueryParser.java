// Generated from G:/workspace_exercise/tstack/elasticsearch/src/main/resources/g4\PatentQuery.g4 by ANTLR 4.9.2
package edu.bjtu.elasticsearch.dsl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PatentQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STRING=6, INT=7;
	public static final int
		RULE_parseQuery = 0, RULE_expression = 1, RULE_atom = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"parseQuery", "expression", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'and'", "'or'", "'Ti'", "'='", "'ad'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "STRING", "INT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PatentQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PatentQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseQueryContext extends ParserRuleContext {
		public QueryBuilder queryBuilder;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PatentQueryParser.EOF, 0); }
		public ParseQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parseQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatentQueryListener ) ((PatentQueryListener)listener).enterParseQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatentQueryListener ) ((PatentQueryListener)listener).exitParseQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatentQueryVisitor ) return ((PatentQueryVisitor<? extends T>)visitor).visitParseQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseQueryContext parseQuery() throws RecognitionException {
		ParseQueryContext _localctx = new ParseQueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parseQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6);
			((ParseQueryContext)_localctx).expression = expression();
			setState(7);
			match(EOF);
			((ParseQueryContext)_localctx).queryBuilder =  ((ParseQueryContext)_localctx).expression.queryBuilder;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public QueryBuilder queryBuilder;
		public AtomContext atom;
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatentQueryListener ) ((PatentQueryListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatentQueryListener ) ((PatentQueryListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatentQueryVisitor ) return ((PatentQueryVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			((ExpressionContext)_localctx).atom = atom();
			((ExpressionContext)_localctx).queryBuilder =  ((ExpressionContext)_localctx).atom.queryBuilder;
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__1) {
				{
				setState(20);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(12);
					match(T__0);
					setState(13);
					((ExpressionContext)_localctx).atom = atom();
					((ExpressionContext)_localctx).queryBuilder =  QueryBuilders.boolQuery().must(_localctx.queryBuilder).must(((ExpressionContext)_localctx).atom.queryBuilder);
					}
					break;
				case T__1:
					{
					setState(16);
					match(T__1);
					setState(17);
					((ExpressionContext)_localctx).atom = atom();
					((ExpressionContext)_localctx).queryBuilder =  QueryBuilders.boolQuery().should(_localctx.queryBuilder).should(((ExpressionContext)_localctx).atom.queryBuilder);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public QueryBuilder queryBuilder;
		public Token text;
		public Token year;
		public TerminalNode STRING() { return getToken(PatentQueryParser.STRING, 0); }
		public TerminalNode INT() { return getToken(PatentQueryParser.INT, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PatentQueryListener ) ((PatentQueryListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PatentQueryListener ) ((PatentQueryListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PatentQueryVisitor ) return ((PatentQueryVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_atom);
		int _la;
		try {
			setState(37);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				match(T__2);
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(26);
					match(T__3);
					}
				}

				setState(29);
				((AtomContext)_localctx).text = match(STRING);
				((AtomContext)_localctx).queryBuilder =  QueryBuilders.matchQuery("title", _input.getText(_localctx.start, _input.LT(-1)));
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(T__4);
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(32);
					match(T__3);
					}
				}

				setState(35);
				((AtomContext)_localctx).year = match(INT);
				((AtomContext)_localctx).queryBuilder =  QueryBuilders.termQuery("year", ((AtomContext)_localctx).year.getText());
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t*\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3"+
		"\27\n\3\f\3\16\3\32\13\3\3\4\3\4\5\4\36\n\4\3\4\3\4\3\4\3\4\5\4$\n\4\3"+
		"\4\3\4\5\4(\n\4\3\4\2\2\5\2\4\6\2\2\2+\2\b\3\2\2\2\4\f\3\2\2\2\6\'\3\2"+
		"\2\2\b\t\5\4\3\2\t\n\7\2\2\3\n\13\b\2\1\2\13\3\3\2\2\2\f\r\5\6\4\2\r\30"+
		"\b\3\1\2\16\17\7\3\2\2\17\20\5\6\4\2\20\21\b\3\1\2\21\27\3\2\2\2\22\23"+
		"\7\4\2\2\23\24\5\6\4\2\24\25\b\3\1\2\25\27\3\2\2\2\26\16\3\2\2\2\26\22"+
		"\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\5\3\2\2\2\32\30"+
		"\3\2\2\2\33\35\7\5\2\2\34\36\7\6\2\2\35\34\3\2\2\2\35\36\3\2\2\2\36\37"+
		"\3\2\2\2\37 \7\b\2\2 (\b\4\1\2!#\7\7\2\2\"$\7\6\2\2#\"\3\2\2\2#$\3\2\2"+
		"\2$%\3\2\2\2%&\7\t\2\2&(\b\4\1\2\'\33\3\2\2\2\'!\3\2\2\2(\7\3\2\2\2\7"+
		"\26\30\35#\'";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}