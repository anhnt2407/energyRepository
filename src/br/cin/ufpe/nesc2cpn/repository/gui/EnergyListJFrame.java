package br.cin.ufpe.nesc2cpn.repository.gui;

import br.cin.ufpe.nesc2cpn.repository.gui.listener.ShowAllActionListener;
import br.cin.ufpe.nesc2cpn.repository.gui.listener.SearchActionListener;
import br.cin.ufpe.nesc2cpn.repository.Line;
import br.cin.ufpe.nesc2cpn.repository.gui.listener.DeleteActionListener;
import br.cin.ufpe.nesc2cpn.repository.gui.listener.EnergyJDialogActionListener;
import br.cin.ufpe.nesc2cpn.repository.gui.listener.NextComponentKeyListener;
import br.cin.ufpe.nesc2cpn.repository.gui.listener.SelectActionListener;
import java.util.List;

/**
 *
 * @author avld
 */
public class EnergyListJFrame extends javax.swing.JFrame {
    private EnergyTableModel tableModel;
    
    public EnergyListJFrame()
    {
        initComponents();
        init();

        setLocationRelativeTo( null );
    }

    private void init()
    {
        tableModel = new EnergyTableModel();
        energyJTable.setModel( tableModel );

        // ----------------------------------

        NextComponentKeyListener next = new NextComponentKeyListener( this );

        moduleJTextField.addKeyListener( next );
        interfaceJTextField.addKeyListener( next );
        methodJTextField.addKeyListener( next );
        
        // ----------------------------------

        searchJButton.addActionListener( new SearchActionListener( this ) );
        showAllJButton.addActionListener( new ShowAllActionListener( this ) );

        addJButton.addActionListener( new EnergyJDialogActionListener( this , false ) );
        editJButton.addActionListener( new EnergyJDialogActionListener( this , true ) );
        deleteJButton.addActionListener( new DeleteActionListener(this) );

        selectJButton.addActionListener( new SelectActionListener( this ) );
        selectJButton.setVisible( false );
    }

    public void setOnlySelect()
    {
        addJButton.setVisible( false );
        editJButton.setVisible( false );
        deleteJButton.setVisible( false );

        selectJButton.setVisible( true );
    }

    public void setEnergyList(List<Line> list)
    {
        tableModel.setList( list );
    }

    public Line getEnergySelect()
    {
        int row = energyJTable.getSelectedRow();

        if( row < 0 )
        {
            return null;
        }

        return tableModel.get( row );
    }

    public Line deleteEnergySelect()
    {
        int row = energyJTable.getSelectedRow();

        if( row < 0 )
        {
            return null;
        }

        return tableModel.delete( row );
    }

    // ------------------------------------ //
    // ------------------------------------ //
    // ------------------------------------ //

    public String getModuleName()
    {
        return moduleJTextField.getText();
    }

    public String getInterfaceName()
    {
        return interfaceJTextField.getText();
    }

    public String getMethodName()
    {
        return methodJTextField.getText();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        energyJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        showAllJButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        moduleJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        interfaceJTextField = new javax.swing.JTextField();
        methodJTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        searchJButton = new javax.swing.JButton();
        selectJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Repository Manager");

        energyJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(energyJTable);

        addJButton.setText("Add");

        editJButton.setText("Edit");

        deleteJButton.setText("Delete");

        showAllJButton.setText("Show All");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Module Name");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Interface Name");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Method Name");

        searchJButton.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(interfaceJTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(methodJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(moduleJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moduleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(interfaceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(methodJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(searchJButton)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        selectJButton.setText("Select");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showAllJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                        .addComponent(selectJButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addJButton)
                    .addComponent(editJButton)
                    .addComponent(deleteJButton)
                    .addComponent(showAllJButton)
                    .addComponent(selectJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void showFrame()
    {
        java.awt.EventQueue.invokeLater(
                new Runnable()
                {
                    public void run() {
                        new EnergyListJFrame().setVisible(true);
                    }
                });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JButton editJButton;
    private javax.swing.JTable energyJTable;
    private javax.swing.JTextField interfaceJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField methodJTextField;
    private javax.swing.JTextField moduleJTextField;
    private javax.swing.JButton searchJButton;
    private javax.swing.JButton selectJButton;
    private javax.swing.JButton showAllJButton;
    // End of variables declaration//GEN-END:variables

}
