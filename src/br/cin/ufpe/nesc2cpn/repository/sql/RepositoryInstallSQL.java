package br.cin.ufpe.nesc2cpn.repository.sql;

/**
 *
 * @author avld
 */
public class RepositoryInstallSQL
{
    public static final String SCHEMA = "nesc2cpn";
    public static final String TABLE_NAME = "energy";

    private RepositoryInstallSQL()
    {
        // do nothing
    }

    public static String createSchema()
    {
        return "CREATE DATABASE IF NOT EXISTS " + SCHEMA;
    }

    public static String createTable()
    {
        StringBuilder builder = new StringBuilder();
        builder.append( "CREATE TABLE IF NOT EXISTS `nesc2cpn`.`energy` (\n" );
        builder.append( " `id` BIGINT NOT NULL AUTO_INCREMENT ,\n" );
        builder.append( " `module` VARCHAR(200) NULL ,\n" );
        builder.append( " `interface` VARCHAR(200) NULL ,\n" );
        builder.append( " `method` VARCHAR(200) NULL ,\n" );
        builder.append( " `energy_mean` DOUBLE NULL ,\n" );
        builder.append( " `energy_variance` DOUBLE NULL ,\n" );
        builder.append( " `power_mean` DOUBLE NULL ,\n" );
        builder.append( " `power_variance` DOUBLE NULL ,\n" );
        builder.append( " `time_mean` DOUBLE NULL ,\n" );
        builder.append( " `time_variance` DOUBLE NULL ,\n" );
        builder.append( " `petri_net` BLOB NULL ,\n" );
        builder.append( " PRIMARY KEY (`id`) ,\n" );
        builder.append( " UNIQUE INDEX `id_UNIQUE` (`id` ASC) )\n" );
        builder.append( " ENGINE = MyISAM\n" );

        return builder.toString();
    }
}
