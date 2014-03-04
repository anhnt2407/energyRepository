package br.cin.ufpe.nesc2cpn.repository.sql;

/**
 *
 * @author avld
 */
public class RepositorySQL
{
    public final static String ADD = "INSERT INTO `nesc2cpn`.`energy`"
                             + "( module , interface , method , energy_mean , energy_variance , power_mean , power_variance , time_mean , time_variance , petri_net )"
                             + " VALUES "
                             + "( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";

    public final static String UPDATE = "UPDATE `nesc2cpn`.`energy` SET"
                             + " module = ?"
                             + " , interface = ?"
                             + " , method = ?"
                             + " , energy_mean = ?"
                             + " , energy_variance = ?"
                             + " , power_mean = ?"
                             + " , power_variance = ?"
                             + " , time_mean = ?"
                             + " , time_variance = ?"
                             + " , petri_net = ?"
                             + " WHERE id = ?";

    public final static String DELETE = "DELETE FROM `nesc2cpn`.`energy` WHERE id = ?";

    public final static String SELECT = "SELECT * FROM `nesc2cpn`.`energy`";

    public final static String GET_ID = RepositorySQL.SELECT + " WHERE id = ?";
    
    public final static String GET_NAME = RepositorySQL.SELECT + " WHERE module = ?"
                                                               + " AND interface = ?"
                                                               + " AND method = ?";
}
