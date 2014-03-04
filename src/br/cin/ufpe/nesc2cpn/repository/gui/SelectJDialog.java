package br.cin.ufpe.nesc2cpn.repository.gui;

import br.cin.ufpe.nesc2cpn.repository.Line;
import br.cin.ufpe.nesc2cpn.repository.RepositoryControl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avld
 */
public class SelectJDialog extends javax.swing.JDialog
{
    private EnergyTableModel tableModel;
    private boolean select;

    public SelectJDialog(java.awt.Window parent, boolean modal)
    {
        super( parent );
        setModal( modal );

        initComponents();
        init();

        setLocationRelativeTo( parent );
    }

    private void init()
    {
        tableModel = new EnergyTableModel();
        jTable.setModel( tableModel );

        select = false;
    }

    public void setModel(String moduleName) throws Exception
    {
        if( moduleName == null
                ? true
                : moduleName.isEmpty() )
        {
            throw new Exception("Please, you should set the module name.");
        }

        tableModel.setList( getModuleList( moduleName ) );
        select = false;
    }

    private List<Line> getModuleList(String moduleName) throws Exception
    {
        List<Line> energyList = RepositoryControl.getInstance().list();

        List<Line> energyModuleList = new ArrayList<Line>();
        for( Line line : energyList )
        {
            if( line.getModuleName() == null
                    ? false
                    : line.getModuleName().equals( moduleName ) )
            {
                energyModuleList.add( line );
            }
        }

        return energyModuleList;
    }

    public Line getLineSelect()
    {
        int row = jTable.getSelectedRow();
        if( row == -1 ) return null;
        else if( !select ) return null;

        return tableModel.get( row );
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        selectJButton = new javax.swing.JButton();
        cancelJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select Event");

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable);

        jLabel1.setText("Choose one event:");

        selectJButton.setText("Select");
        selectJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectJButtonActionPerformed(evt);
            }
        });

        cancelJButton.setText("Cancel");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectJButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectJButton)
                    .addComponent(cancelJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectJButtonActionPerformed
        select = true;
        setVisible( false );
    }//GEN-LAST:event_selectJButtonActionPerformed

    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        select = false;
        setVisible( false );
    }//GEN-LAST:event_cancelJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton selectJButton;
    // End of variables declaration//GEN-END:variables

}
