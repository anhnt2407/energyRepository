package br.cin.ufpe.nesc2cpn.repository;

import br.cin.ufpe.nesc2cpn.repository.file.RepositoryFile;
import br.cin.ufpe.nesc2cpn.repository.sql.RepositoryDB;
import java.net.URL;
import java.util.List;

/**
 *
 * @author avld
 */
public class ImportRepository
{

    public static void main(String arg[]) throws Exception
    {
        Repository repositoryFrom = new RepositoryDB();
        Repository repositoryTo   = new RepositoryFile();

        List<Line> lineList = repositoryFrom.list();
        for( Line line : lineList )
        {
            if( "*basic*".equals( line.getModuleName() ) )
            {
                line.setModuleName( "$basic" );
            }

            repositoryTo.add( line );
        }
    }
}
