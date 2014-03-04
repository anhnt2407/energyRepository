package br.cin.ufpe.nesc2cpn.repository.sql;

import br.cin.ufpe.nesc2cpn.repository.sql.RepositorySQL;
import br.cin.ufpe.nesc2cpn.exception.UnknownException;
import br.cin.ufpe.nesc2cpn.repository.Line;
import br.cin.ufpe.nesc2cpn.repository.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avld
 */
public class RepositoryDB implements Repository
{
    

    public RepositoryDB()
    {

    }

    public void add(Line line) throws Exception {
        try
        {
            Connection con = Database.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement( RepositorySQL.ADD );
            ps.setString( 1 , line.getModuleName() );
            ps.setString( 2 , line.getInterfaceName() );
            ps.setString( 3 , line.getMethodName() );
            
            ps.setDouble( 4 , line.getEnergyMean() );
            ps.setDouble( 5 , line.getEnergyVariance() );

            ps.setDouble( 6 , line.getPowerMean() );
            ps.setDouble( 7 , line.getPowerVariance() );

            ps.setDouble( 8 , line.getTimeMean() );
            ps.setDouble( 9 , line.getTimeVariance() );

            ps.setString( 10 , line.getPetriNet() );

            ps.execute();

            ps.close();
        }
        catch(Exception err)
        {
            throw new UnknownException( err );
        }
    }

    public void update(Line line) throws Exception {
        try
        {
            Connection con = Database.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement( RepositorySQL.UPDATE );
            ps.setString( 1 , line.getModuleName() );
            ps.setString( 2 , line.getInterfaceName() );
            ps.setString( 3 , line.getMethodName() );

            ps.setDouble( 4 , line.getEnergyMean() );
            ps.setDouble( 5 , line.getEnergyVariance() );

            ps.setDouble( 6 , line.getPowerMean() );
            ps.setDouble( 7 , line.getPowerVariance() );

            ps.setDouble( 8 , line.getTimeMean() );
            ps.setDouble( 9 , line.getTimeVariance() );

            ps.setString( 10 , line.getPetriNet() );
            ps.setLong( 11 , line.getId() );

            ps.execute();

            ps.close();
        }
        catch(Exception err)
        {
            throw new UnknownException( err );
        }
    }

    public Line get(long id) throws Exception {
        try
        {
            Connection con = Database.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement( RepositorySQL.GET_ID );
            ps.setLong( 1 , id );

            ResultSet rs = ps.executeQuery();

            Line line = null;
            if( rs.next() )
            {
                line = convertTo( rs );
            }

            rs.close();
            ps.close();

            return line;
        }
        catch(Exception err)
        {
            throw new UnknownException( err );
        }
    }

    public Line get(String moName, String itName, String meName) throws Exception {
        try
        {
            Connection con = Database.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement( RepositorySQL.GET_NAME );
            ps.setString( 1 , moName );
            ps.setString( 2 , itName );
            ps.setString( 3 , meName );

            ResultSet rs = ps.executeQuery();

            Line line = null;
            if( rs.next() )
            {
                line = convertTo( rs );
            }

            rs.close();
            ps.close();

            return line;
        }
        catch(Exception err)
        {
            throw new UnknownException( err );
        }
    }

    public void delete(Line line) throws Exception {
        try
        {
            Connection con = Database.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement( RepositorySQL.DELETE );
            ps.setLong( 1 , line.getId() );

            ps.execute();

            ps.close();
        }
        catch(Exception err)
        {
            throw new UnknownException( err );
        }
    }

    public List<Line> list() throws Exception {
        try
        {
            Connection con = Database.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement( RepositorySQL.SELECT );
            
            ResultSet rs = ps.executeQuery();

            List<Line> lineList = new ArrayList<Line>();
            while( rs.next() )
            {
                lineList.add( convertTo( rs ) );
            }

            rs.close();
            ps.close();

            return lineList;
        }
        catch(Exception err)
        {
            throw new UnknownException( err );
        }
    }

    public List<Line> list(String moName, String itName, String meName) throws Exception {
        try
        {
            String sql = "";
            
            if( moName == null ? false : !moName.isEmpty() )
                sql += "module like ('"+ moName +"%')";

            if( itName == null ? false : !itName.isEmpty() )
            {
                if( !sql.isEmpty() ) sql += " AND ";
                sql += "interface like ('"+ itName +"%')";
            }

            if( meName == null ? false : !meName.isEmpty() )
            {
                if( !sql.isEmpty() ) sql += " AND ";
                sql += "method like ('"+ meName +"%')";
            }

            sql = RepositorySQL.SELECT + " WHERE " + sql;

            Connection con = Database.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement( sql );
            
            ResultSet rs = ps.executeQuery();

            List<Line> lineList = new ArrayList<Line>();
            while( rs.next() )
            {
                lineList.add( convertTo( rs ) );
            }

            rs.close();
            ps.close();

            return lineList;
        }
        catch(Exception err)
        {
            throw new UnknownException( err );
        }
    }

    // -------------------------------------- //
    // -------------------------------------- //
    // -------------------------------------- //

    private Line convertTo(ResultSet rs) throws Exception
    {
        Line line = new Line();
        
        line.setId( rs.getLong("id") );

        line.setModuleName( rs.getString("module") );
        line.setInterfaceName( rs.getString("interface") );
        line.setMethodName( rs.getString("method") );

        line.setEnergyMean( rs.getDouble("energy_mean") );
        line.setEnergyVariance( rs.getDouble("energy_variance") );

        line.setPowerMean( rs.getDouble("power_mean") );
        line.setPowerVariance( rs.getDouble("power_variance") );

        line.setTimeMean( rs.getDouble("time_mean") );
        line.setTimeVariance( rs.getDouble("time_variance") );

        line.setPetriNet( rs.getString("petri_net") );

        return line;
    }
}
