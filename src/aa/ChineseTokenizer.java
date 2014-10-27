package aa;

import org.ibm.nlp.chinese.tokenizaer.core.Token;
import org.ibm.nlp.chinese.tokenizaer.core.Tokenizer;
import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class ChineseTokenizer {

	private static ChineseTokenizer instance;

	private ChineseTokenizer() throws Exception {

	}

	public static ChineseTokenizer getInstance() throws Exception {
		if (instance == null) {
			instance = new ChineseTokenizer();
		}
		return instance;
	}

	public void tokenizeAndLowerCase(String line, ArrayList<String> tokens)
			throws IOException {
		StringReader sr = new StringReader(line);
		IKSegmentation iks = new IKSegmentation(sr, true);
		Lexeme lex = null;
		while ((lex = iks.next()) != null) {
			tokens.add(lex.getLexemeText());
		}
		sr.close();
	}

	Tokenizer tokenizer = new Tokenizer(true);

	public void getTokenList(String strText, ArrayList<String> tokens)
			throws IOException {

		Token token = null;
		tokens.clear();
		Tokenizer t = new Tokenizer(true);

		t.setInputStream(strText);
		token = t.getNextToken();
		while (token != null) {
			tokens.add(token.getString());
			token = t.getNextToken();
		}
		// System.out.println(tokens.toString());
		tokens.remove(0);
		System.out.println(tokens.toString());

	}
}