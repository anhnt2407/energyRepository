package br.cin.ufpe.nesc2cpn.repository.sql;

import br.cin.ufpe.nesc2cpn.exception.Nesc2CpnException;
import br.cin.ufpe.nesc2cpn.util.Configuration;
import br.cin.ufpe.nesc2cpn.util.ConfigurationUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author avld
 */
public class Database
{
    private static Database instance;
    private Connection connection;
    private Configuration configuration;
    
    private Database()
    {
        ConfigurationUtil util = new ConfigurationUtil();
        configuration = util.get();

        util = null;
    }

    public static Database getInstance()
    {
        if( instance == null )
        {
            instance = new Database();
        }

        return instance;
    }

    private Connection connectToSGBD() throws ClassNotFoundException, SQLException
    {
        if(connection != null){             //Ja foi criada
            if( !connection.isClosed() ){   //Ainda esta ativa
                return connection;          //Retorna ao cliente conexao existe
            }
        }

        Class.forName( configuration.getDbDriver() );
        connection = DriverManager.getConnection( configuration.getDbHost() ,
                                                  configuration.getDbUser() ,
                                                  configuration.getDbPassword() );

        return connection;
    }

    public Connection getConnection() throws Nesc2CpnException
    {
        try
        {
            return connectToSGBD();
        }
        catch(ClassNotFoundException err)
        {
            throw new Nesc2CpnException("A seguinte class está ausente: "
                                        + configuration.getDbDriver() );
        }
        catch(SQLException err)
        {
            throw new Nesc2CpnException("Não foi possível conectar com o banco de dados. " +
                    "["+err.getErrorCode()+": "+ err.getMessage() +"].");
        }
    }

    public void desconnect() throws Nesc2CpnException
    {
        try
        {
            getConnection().close();
        }
        catch(SQLException err)
        {
            throw new Nesc2CpnException("Error ao fechar a conexão do banco de dados. " +
                    "["+err.getErrorCode()+": "+ err.getMessage() +"].");
        }
    }
}
