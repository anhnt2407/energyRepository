package br.cin.ufpe.nesc2cpn.util;

/**
 *
 * @author avld
 */
public class Configuration {
    private String dbDriver;
    
    private String dbUser;
    private String dbPassword;
    private String dbHost;

    private boolean bootstrapEnabled;
    private int bootstrapSize;

    public Configuration()
    {
        
    }

    public boolean isBootstrapEnabled() {
        return bootstrapEnabled;
    }

    public void setBootstrapEnabled(boolean bootstrapEnabled) {
        this.bootstrapEnabled = bootstrapEnabled;
    }

    public int getBootstrapSize() {
        return bootstrapSize;
    }

    public void setBootstrapSize(int bootstrapSize) {
        this.bootstrapSize = bootstrapSize;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbHost() {
        return dbHost;
    }

    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser;
    }

}
