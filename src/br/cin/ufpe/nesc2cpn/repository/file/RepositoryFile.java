package br.cin.ufpe.nesc2cpn.repository.file;

import br.cin.ufpe.nesc2cpn.repository.Line;
import br.cin.ufpe.nesc2cpn.repository.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avld
 */
public class RepositoryFile extends DatabaseUtil implements Repository
{
    
    public RepositoryFile()
    {
        
    }

    public void add(Line line) throws Exception
    {
        Schema schema = open( line , true );
        schema.add( line );
        schema.save();
    }

    public void update(Line line) throws Exception
    {
        Schema schema = open( line , false );
        schema.update( line );
        schema.save();
    }

    public void delete(Line line) throws Exception
    {
        Schema schema = open( line , false );
        schema.delete( line );
        schema.save();
    }

    public Line get(String moName, String itName, String meName) throws Exception
    {
        Schema schema = open( moName , false );

        for( Line line : schema.list() )
        {
            if( match( line , itName, meName, true ) )
            {
                return line;
            }
        }

        return null;
    }

    public List<Line> list() throws Exception
    {
        List<Line> lineList = new ArrayList<Line>();

        for( Schema schema : list( "" ).values() )
        {
            lineList.addAll( schema.list() );
        }

        return lineList;
    }

    public List<Line> list(String moName, String itName, String meName) throws Exception
    {
        List<Line> lineList = new ArrayList<Line>();

        for( Schema schema : list( moName ).values() )
        {
            for( Line line : schema.list() )
            {
                if( match( line , itName, meName, false ) )
                {
                    lineList.add( line );
                }
            }
        }

        return lineList;
    }

    private boolean match(Line line, String itName, String opName, boolean all)
    {
        if( itName != null ? true : !itName.isEmpty() )
        {
            if( all && !itName.toUpperCase().equals( line.getInterfaceName().toUpperCase() ) )
            {
                return false;
            }
            if( itName.toUpperCase().indexOf( line.getInterfaceName().toUpperCase() ) < 0 )
            {
                return false;
            }
        }

        if( opName != null ? true : !opName.isEmpty() )
        {
            if( all && !opName.toUpperCase().equals( line.getMethodName().toUpperCase() ) )
            {
                return false;
            }
            if( opName.toUpperCase().indexOf( line.getMethodName().toUpperCase() ) < 0 )
            {
                return false;
            }
        }

        return true;
    }
}