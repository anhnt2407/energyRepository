package br.cin.ufpe.nesc2cpn.repository.file;

import br.cin.ufpe.nesc2cpn.repository.Line;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author avld
 */
public class Schema
{
    private File file;
    private Properties p;

    public Schema()
    {
        p = new Properties();
        p.setProperty( "size" , "0" );
    }

    public List<Line> list() throws Exception
    {
        return convertTo( p );
    }

    public void open(String filename) throws Exception
    {
        file = new File( filename );
        p = new Properties();
        
        if( !file.exists() )
        {
            throw new Exception("This file ( "+ filename +" ) does not exist.");
        }

        FileInputStream fip = new FileInputStream( file );
        p.loadFromXML( fip );
        fip.close();
    }

    public void save() throws Exception
    {
        FileOutputStream fos = new FileOutputStream( file );
        p.storeToXML( fos , null );
        fos.close();
    }

    // ----------------------------------- //
    // ----------------------------------- //
    // ----------------------------------- //

    private List<Line> convertTo(Properties p)
    {
        int size = Integer.parseInt( p.getProperty( "size" , "0" ) );

        List<Line> lineList = new ArrayList<Line>();
        for(int i = 0; i < size; i++)
        {
            Line l = convertTo( i , p );
            
            if( l != null)
            {
                lineList.add( l );
            }
        }

        return lineList;
    }

    private Line convertTo(int i, Properties p)
    {
        String preName = getPreName( i );

        if( !p.containsKey( preName + ".moduleName" ) )
        {
            return null;
        }

        Line line = new Line();
        line.setId( i );

        line.setModuleName( p.getProperty( preName + ".moduleName" ) );
        line.setInterfaceName( p.getProperty( preName + ".interfaceName" ) );
        line.setMethodName( p.getProperty( preName + ".functionName" ) );

        line.setPetriNet( p.getProperty( preName + ".petriNet" ) );

        Double energyMean = Double.parseDouble( p.getProperty( preName + ".energyMean" , "0.0" ) );
        line.setEnergyMean( energyMean );

        Double energyVar = Double.parseDouble( p.getProperty( preName + ".energyVariance" , "0.0" ) );
        line.setEnergyVariance( energyVar );

        Double energyError = Double.parseDouble( p.getProperty( preName + ".energyError" , "0.0" ) );
        line.setEnergyError( energyError );

        Double powerMean = Double.parseDouble( p.getProperty( preName + ".powerMean" , "0.0" ) );
        line.setPowerMean( powerMean );

        Double powerVar = Double.parseDouble( p.getProperty( preName + ".powerVariance" , "0.0" ) );
        line.setPowerVariance( powerVar );

        Double powerError = Double.parseDouble( p.getProperty( preName + ".powerError" , "0.0" ) );
        line.setPowerError( powerError );

        Double timeMean = Double.parseDouble( p.getProperty( preName + ".timeMean" , "0.0" ) );
        line.setTimeMean( timeMean );

        Double timeVar = Double.parseDouble( p.getProperty( preName + ".timeVariance" , "0.0" ) );
        line.setTimeVariance( timeVar );

        Double timeError = Double.parseDouble( p.getProperty( preName + ".timeError" , "0.0" ) );
        line.setTimeError( timeError );

        // -------------------------------------- //

        boolean radio = Boolean.parseBoolean( p.getProperty( preName + ".radioOn" , "true" ) );
        line.setRadioOn( radio );

        boolean led0 = Boolean.parseBoolean( p.getProperty( preName + ".led0On" , "true" ) );
        line.setLed0On( led0 );

        boolean led1 = Boolean.parseBoolean( p.getProperty( preName + ".led1On" , "true" ) );
        line.setLed1On( led1 );

        boolean led2 = Boolean.parseBoolean( p.getProperty( preName + ".led2On" , "true" ) );
        line.setLed2On( led2 );

        // ------------------------------------ //

        boolean radioStart = Boolean.parseBoolean( p.getProperty( preName + ".radioStart" , "false" ) );
        line.setRadioStart( radioStart );

        boolean radioStop = Boolean.parseBoolean( p.getProperty( preName + ".radioStop" , "false" ) );
        line.setRadioStop( radioStop );

        Set<Long> eventRelatedSet = convertTo( p.getProperty( preName + ".eventRelated" , "[]") );
        line.setEventSet( eventRelatedSet );

        return line;
    }

    private int getSize()
    {
        return Integer.parseInt( p.getProperty( "size" , "0" ) );
    }

    private String getPreName(long i)
    {
        return "line[" + i + "]";
    }

    private static Set<Long> convertTo(String longStr)
    {
        Set<Long> longSet = new HashSet<Long>();

        if( longStr == null
                ? true
                : longStr.isEmpty() )
        {
            return longSet;
        }
        else if( longStr.equals("[]") )
        {
            return longSet;
        }

        String txt = longStr.substring( 1 , longStr.length() - 1 );
        for( String idStr : txt.split(", ") )
        {
            long id = Long.parseLong( idStr );
            longSet.add( id );
        }

        return longSet;
    }

    // ----------------------------------- //
    // ----------------------------------- //
    // ----------------------------------- //

    public void add(Line line)
    {
        long size = getSize();
        set( size , line );

        p.setProperty( "size" , ( size + 1 ) + "" );
    }

    public void update(Line line)
    {
        set( line.getId() , line );
    }

    public void delete(Line line)
    {
        String pre = getPreName( line.getId() );

        p.remove( pre + ".moduleName" );
        p.remove( pre + ".interfaceName" );
        p.remove( pre + ".functionName" );

        p.remove( pre + ".petriNet" );

        p.remove( pre + ".energyMean" );
        p.remove( pre + ".energyVariance" );
        p.remove( pre + ".energyError" );
        
        p.remove( pre + ".powerMean" );
        p.remove( pre + ".powerVariance" );
        p.remove( pre + ".powerError" );
        
        p.remove( pre + ".timeMean" );
        p.remove( pre + ".timeVariance" );
        p.remove( pre + ".timeError" );

        p.remove( pre + ".radioOn" );
        p.remove( pre + ".led0On" );
        p.remove( pre + ".led1On" );
        p.remove( pre + ".led2On" );

        p.remove( pre + ".radioStart" );
        p.remove( pre + ".radioStop" );

        p.remove( pre + ".eventRelated" );
    }

    private void set(long i, Line line)
    {
        String pre = getPreName( i );

        if( p == null )
        {
            p = new Properties();
        }

        p.setProperty(pre + ".moduleName", line.getModuleName() );
        p.setProperty( pre + ".interfaceName" , line.getInterfaceName() );
        p.setProperty( pre + ".functionName" , line.getMethodName() );

        p.setProperty( pre + ".petriNet" , line.getPetriNet() );

        p.setProperty( pre + ".energyMean" , line.getEnergyMean() + "" );
        p.setProperty( pre + ".energyVariance" , line.getEnergyVariance() + "" );
        p.setProperty( pre + ".energyError" , line.getEnergyError() + "" );

        p.setProperty( pre + ".powerMean" , line.getPowerMean() + "" );
        p.setProperty( pre + ".powerVariance" , line.getPowerVariance() + "" );
        p.setProperty( pre + ".powerError" , line.getPowerError() + "" );

        p.setProperty( pre + ".timeMean" , line.getTimeMean() + "" );
        p.setProperty( pre + ".timeVariance" , line.getTimeVariance() + "" );
        p.setProperty( pre + ".timeError" , line.getTimeError() + "" );

        p.setProperty( pre + ".radioOn" , line.isRadioOn() + "" );
        p.setProperty( pre + ".led0On" , line.isLed0On() + "" );
        p.setProperty( pre + ".led1On" , line.isLed1On() + "" );
        p.setProperty( pre + ".led2On" , line.isLed2On() + "" );

        p.setProperty( pre + ".radioStart" , line.isRadioStart() + "" );
        p.setProperty( pre + ".radioStop" , line.isRadioStop() + "" );

        p.setProperty( pre + ".eventRelated" , line.getEventSet() + "" );
    }
}
