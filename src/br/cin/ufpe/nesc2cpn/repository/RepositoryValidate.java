package br.cin.ufpe.nesc2cpn.repository;

import br.cin.ufpe.nesc2cpn.exception.EmptyException;

/**
 *
 * @author avld
 */
public class RepositoryValidate
{
    public RepositoryValidate()
    {
        // do nothing
    }

    public void id(long id) throws Exception
    {
        if( id <= 0 )
        {
            throw new EmptyException( "id" );
        }
    }

    public void object(Line line) throws Exception
    {
        if( line == null )
        {
            throw new EmptyException( Line.class );
        }
/*
        else if( line.getModuleName() == null ? true : line.getModuleName().isEmpty() )
        {
            throw new EmptyException( "module name" );
        }
*/
//        else if( line.getMethodName() == null ? true : line.getMethodName().isEmpty() )
//        {
//            throw new EmptyException( "method name" );
//        }
    }

    public void list(String moName, String itName, String meName) throws Exception
    {
        boolean haveModuleName    = ( moName == null ? false : !moName.isEmpty() );
        boolean haveInterfaceName = ( itName == null ? false : !itName.isEmpty() );
        boolean haveMethodName    = ( meName == null ? false : !meName.isEmpty() );

        if( !haveModuleName && !haveInterfaceName && !haveMethodName )
        {
            throw new EmptyException();
        }
    }
}
