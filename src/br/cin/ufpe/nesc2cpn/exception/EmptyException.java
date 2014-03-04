package br.cin.ufpe.nesc2cpn.exception;

/**
 *
 * @author avld
 */
public class EmptyException extends Nesc2CpnException
{
    public EmptyException()
    {
        super( "The all variable is empty or invalid." );
    }

    public EmptyException( String variable )
    {
        super( "The variable '" + variable + "' is empty or invalid." );
    }

    public EmptyException( Class c )
    {
        super( "The object '" + c.getSimpleName() + "' is empty or invalid." );
    }
}
