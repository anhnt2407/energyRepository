package br.cin.ufpe.nesc2cpn.repository;

import br.cin.ufpe.nesc2cpn.repository.file.RepositoryFile;
import java.util.List;

/**
 *
 * @author avld
 */
public class RepositoryControl
{
    private static RepositoryControl instance;
    
    private RepositoryValidate validate;
    private Repository repository;

    private RepositoryControl()
    {
        validate = new RepositoryValidate();
        repository = new RepositoryFile();
        //repository = new RepositoryDB();
    }

    public static RepositoryControl getInstance()
    {
        if( instance == null )
        {
            instance = new RepositoryControl();
        }

        return instance;
    }

    // -------------------------------------- //
    // -------------------------------------- //
    // -------------------------------------- //

    public void add(Line line) throws Exception
    {
        validate.object( line );

        try
        {
            repository.get( line.getModuleName() , line.getInterfaceName() , line.getMethodName() );
            validate.object( line );
            update( line );
        }
        catch(Exception err)
        {
            repository.add( line );
        }
    }

    public void update(Line line) throws Exception
    {
        validate.object( line );
        validate.id( line.getId() );
        repository.update( line );
    }

    public Line get(String moName, String itName, String meName) throws Exception
    {
        if( moName == null ) moName = "";
        if( itName == null ) itName = "";
        if( meName == null ) meName = "";

        Line line = new Line();
        line.setModuleName( moName );
        line.setInterfaceName( itName );
        line.setMethodName( meName );

        validate.object( line );
        line = repository.get( moName , itName , meName );
        
        try
        {
            validate.object( line );
        }
        catch(Exception err)
        {
            line = new Line();
            line.setModuleName( moName );
            line.setInterfaceName( itName );
            line.setMethodName( meName );
        }

//        System.out.print( "invoke: " + moName  );
//        System.out.print( "." + itName  );
//        System.out.println( "." + meName  );
//
//        System.out.println( "energy mean: " + line.getEnergyMean() );

        return line;
    }

    public boolean exist(String moName, String itName, String meName) throws Exception
    {
        Line line = get( moName , itName , meName );

        if( line.getEnergyMean() == 0.0
                || line.getPowerMean() == 0.0
                || line.getTimeMean() == 0.0 )
        {
            return false;
        }

        return true;
    }

    public void delete(Line line) throws Exception
    {
        //validate.id( line.getId() );
        validate.object( line );
        repository.delete( line );
    }

    public List<Line> list() throws Exception
    {
        List<Line> lineList = repository.list();

        for( Line line : lineList )
        {
            line.setEnergyError( 1.96 * line.getEnergyVariance() / Math.sqrt( 30 ) );
            line.setTimeError( 1.96 * line.getTimeVariance() / Math.sqrt( 30 ) );
            line.setPowerError( 1.96 * line.getPowerVariance() / Math.sqrt( 30 ) );
        }

        return lineList;
    }
    
    public List<Line> list(String moName, String itName, String meName) throws Exception
    {
        if( moName == null ) moName = "";
        if( itName == null ) itName = "";
        if( meName == null ) meName = "";

        validate.list( moName , itName , meName );
        return repository.list( moName , itName , meName );
    }
}
