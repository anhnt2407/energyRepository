package br.cin.ufpe.nesc2cpn.exception;

/**
 *
 * @author avld
 */
public class Nesc2CpnException extends Exception
{

    public Nesc2CpnException(String text)
    {
        super( text );
    }

    public Nesc2CpnException(Throwable thr)
    {
        super( thr );
    }

}
