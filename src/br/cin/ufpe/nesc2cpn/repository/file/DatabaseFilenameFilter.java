package br.cin.ufpe.nesc2cpn.repository.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author avld
 */
public class DatabaseFilenameFilter implements FilenameFilter
{
    private String module;

    public DatabaseFilenameFilter()
    {
        // do nothing
    }

    public DatabaseFilenameFilter(String module)
    {
        this.module = module;
    }

    public boolean accept(File file, String string)
    {
        if( string.endsWith( DatabaseUtil.EXT ) )
        {
            if( module == null ? false : module.isEmpty() )
            {
                return string.indexOf( module ) >= 0;
            }
            else
            {
                return true;
            }
        }

        return false;
    }

}
