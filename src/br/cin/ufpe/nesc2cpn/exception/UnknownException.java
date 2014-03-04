package br.cin.ufpe.nesc2cpn.exception;

/**
 *
 * @author avld
 */
public class UnknownException extends Nesc2CpnException
{
    public UnknownException(String text)
    {
        super( text );
    }

    public UnknownException(Throwable thr)
    {
        super( thr );
    }
}
