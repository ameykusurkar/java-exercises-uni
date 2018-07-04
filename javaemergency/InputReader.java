

import java.io.*;

public class InputReader {

    //static
	 PushbackReader pbr;
    //static 
	InputStreamReader isr;
    //static 
	StreamTokenizer tokenizer;

    //static {
	public InputReader() {
	isr = new InputStreamReader( System.in );
	pbr = new PushbackReader( isr );
	tokenizer = new StreamTokenizer( pbr );
	tokenizer.resetSyntax();
	tokenizer.whitespaceChars( 0, ' ' );
	tokenizer.wordChars( 33 , 255 );
    //}
	}

		
 //   public static boolean isEOF() {
   public  boolean isEOF() {

	try {
	    int c = pbr.read();
	    
	    if ( c == -1 ) {
		return true;
	    } else {
		pbr.unread(c);
		return false;
	    }
	    
	} catch (java.io.IOException e){ System.out.println(e); }
	
	return true;
    }
    
//    public static int readInt() {
    public  int readInt() {
	
	try {
	    
	    tokenizer.resetSyntax();
	    tokenizer.whitespaceChars( 0 , ' ' );
	    tokenizer.wordChars(33,255);
	    
	    if ( tokenizer.nextToken() == StreamTokenizer.TT_EOF ) {
		System.out.println("End Of File found.");
	    } else {
		return (int)Double.parseDouble(tokenizer.sval);
	    }
	}
	catch (NumberFormatException nfe){ System.out.println("Could not read integer, incorrectly formatted number (" + tokenizer.sval + ")" ); System.exit(1);}
	catch (java.io.IOException e){ System.out.println(e); }
	
	return 0;
    } 
    
//    public static double readDouble() {
    public double readDouble() {

	tokenizer.resetSyntax();
	tokenizer.whitespaceChars( 0 , ' ' );
	tokenizer.wordChars(33,255);

	
	try {
	    if ( tokenizer.nextToken() == StreamTokenizer.TT_EOF ) {
		System.out.println("End Of File found.");
	    } else {
		return Double.parseDouble(tokenizer.sval);
	    }
	}
	catch (NumberFormatException nfe){ System.out.println("Could not read double, incorrectly formatted number (" + tokenizer.sval + ")" ); }
	catch (java.io.IOException e){System.out.println(e);}
	
	return 0.0;
    }
    
//    public static String readString() {
    public String readString() {

	tokenizer.resetSyntax();
	tokenizer.whitespaceChars( 0 , ' ' );
	tokenizer.wordChars( 33 , 255 );

	try {

	    if ( tokenizer.nextToken() == StreamTokenizer.TT_EOF ) {
		System.out.println("End Of File found."); 
	    } else {
		return tokenizer.sval;
	    }
	}
	catch (java.io.IOException e){System.out.println(e);}
 
	return "";
    }

//    public static char readChar() {
    public char readChar() {

	char c = ' ';

	while( c == ' ' /*|| c == '\n' */ ) { c = read(); }

	return c;
    }

//    public static char read() {
    public char read() {

	char c = ' ';
	try {
	    c = (char)pbr.read(); }
	catch ( IOException e ) { System.out.println(e); }
		
	return c;
    }

}
