package br.cin.ufpe.nesc2cpn.repository.gui;

import br.cin.ufpe.nesc2cpn.repository.Line;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author avld
 */
public class EnergyTableModel extends AbstractTableModel {
    private String[] columns = new String[]{"Module",
                                            "Interface",
                                            "Function",
                                            "energy",
                                            "power",
                                            "time" };
    private List<Line> lineList;

    public EnergyTableModel()
    {
        lineList = new ArrayList<Line>();
    }

    public int getRowCount()
    {
        return lineList.size();
    }

    public int getColumnCount()
    {
        return columns.length;
    }

    @Override
    public String getColumnName(int col)
    {
        return columns[col];
    }

    public Object getValueAt( int row , int col )
    {
        Line line = get( row );

        switch( col )
        {
            case 0: return line.getModuleName();
            case 1: return line.getInterfaceName();
            case 2: return line.getMethodName();
            case 3: return line.getEnergyMean();
            case 4: return line.getPowerMean();
            case 5: return line.getTimeMean();
        }

        return null;
    }

    // ------------------------------------ //
    // ------------------------------------ //
    // ------------------------------------ //

    public Line get( int row )
    {
        return lineList.get( row );
    }

    public Line delete( int row )
    {
        Line line = lineList.remove( row );

        fireTableRowsDeleted( row , 0 );

        return line;
    }

    public List<Line> getList()
    {
        return lineList;
    }

    public void setList(List<Line> list)
    {
        lineList.clear();

        if( list != null )
        {
            lineList = list;
        }

        fireTableDataChanged();
    }

}
