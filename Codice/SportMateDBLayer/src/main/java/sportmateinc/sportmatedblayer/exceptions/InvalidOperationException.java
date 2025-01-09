/**
 * InvalidOperationException
 * 
 * Versione 1.0
 */

package sportmateinc.sportmatedblayer.exceptions;

/**
 * {@code InvalidOperationException} è lanciata quando il fallimento durante 
 * l'invocazione di un metodo è causato da ragioni diverse dal passaggio di 
 * argomenti non validi. 
 * Normalmente, viene lanciata quando lo stato attuale dell'oggetto non 
 * supporta l'invocazione del metodo.
 * @since 1.0
 * @version 1.0
 * */

public class InvalidOperationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidOperationException() {}
	
	public InvalidOperationException(String message) {
		super(message);
	}
}
