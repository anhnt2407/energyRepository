package br.cin.ufpe.nesc2cpn.repository.gui;

import br.cin.ufpe.nesc2cpn.repository.gui.listener.CloseWindowActionListener;
import br.cin.ufpe.nesc2cpn.repository.gui.listener.SaveActionListener;
import br.cin.ufpe.nesc2cpn.repository.gui.listener.NextComponentKeyListener;
import br.cin.ufpe.nesc2cpn.repository.Line;
import br.cin.ufpe.nesc2cpn.repository.gui.listener.EventAddActionListener;
import br.cin.ufpe.nesc2cpn.repository.gui.listener.EventDelActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author avld
 */
public class EnergyJDialog extends javax.swing.JDialog
{
    private DefaultListModel listModel;
    private Line line;

    public EnergyJDialog(java.awt.Window parent, boolean modal)
    {
        super( parent );
        setModal( modal );

        initComponents();
        init();
        
        setLocationRelativeTo( parent );
    }

    private void init()
    {
        line = new Line();

        listModel = new DefaultListModel();
        jList.setModel( listModel );

        // ----------------------------

        NextComponentKeyListener next = new NextComponentKeyListener( this );
        
        moduleJTextField.addKeyListener( next );
        interfaceJTextField.addKeyListener( next );
        methodJTextField.addKeyListener( next );

        energyMeanJTextField.addKeyListener( next );
        energyVarianceJTextField.addKeyListener( next );

        powerMeanJTextField.addKeyListener( next );
        powerVarianceJTextField.addKeyListener( next );

        timeMeanJTextField.addKeyListener( next );
        timeVarianceJTextField.addKeyListener( next );

        // ----------------------------

        cancelJButton.addActionListener( new CloseWindowActionListener( this ) );
        saveJButton.addActionListener( new SaveActionListener( this ) );

        // ----------------------------

        eventAddJButton.addActionListener( new EventAddActionListener( this ) );
        eventDelJButton.addActionListener( new EventDelActionListener( this ) );
    }

    public Line getLine()
    {
        line.setModuleName( moduleJTextField.getText() );
        line.setInterfaceName( interfaceJTextField.getText() );
        line.setMethodName( methodJTextField.getText() );

        line.setEnergyMean( getDouble( energyMeanJTextField ) );
        line.setEnergyVariance( getDouble( energyVarianceJTextField ) );
        line.setEnergyError( getDouble( energyErrorJTextField ) );

        line.setPowerMean( getDouble( powerMeanJTextField ) );
        line.setPowerVariance( getDouble( powerVarianceJTextField ) );
        line.setPowerError( getDouble( powerErrorJTextField ) );

        line.setTimeMean( getDouble( timeMeanJTextField ) );
        line.setTimeVariance( getDouble( timeVarianceJTextField ) );
        line.setTimeError( getDouble( timeErrorJTextField ) );

        line.setPetriNet( petriNetJTextArea.getText() );

        line.setRadioOn( radioJCheckBox.isSelected() );
        line.setLed0On( led0JCheckBox.isSelected() );
        line.setLed1On( led1JCheckBox.isSelected() );
        line.setLed2On( led2JCheckBox.isSelected() );

        line.setRadioStart( radioStartJCheckBox.isSelected() );
        line.setRadioStop( radioStopJCheckBox.isSelected() );

        line.getEventSet().clear();
        for( int i = 0; i < listModel.size(); i++ )
        {
            long id = (Long) listModel.getElementAt( i );
            line.getEventSet().add( id );
        }

        return line;
    }

    private Double getDouble( JTextField field )
    {
        String text = field.getText();
        text = text.replace( ',' , '.' );
        
        return Double.parseDouble( text );
    }

    public void setLine(Line line)
    {
        if( line == null )
        {
            line = new Line();
        }

        if( line.getModuleName() == null ? false : !line.getModuleName().isEmpty() )
        {
            moduleJTextField.setEditable( false );
        }
        else
        {
            moduleJTextField.setEditable( true );
        }

        moduleJTextField.setText( line.getModuleName() );
        interfaceJTextField.setText( line.getInterfaceName() );
        methodJTextField.setText( line.getMethodName() );

        energyMeanJTextField.setText( line.getEnergyMean() + "" );
        energyVarianceJTextField.setText( line.getEnergyVariance() + "" );
        energyErrorJTextField.setText( line.getEnergyError() + "" );

        powerMeanJTextField.setText( line.getPowerMean() + "" );
        powerVarianceJTextField.setText( line.getPowerVariance() + "" );
        powerErrorJTextField.setText( line.getPowerError() + "" );

        timeMeanJTextField.setText( line.getTimeMean() + "" );
        timeVarianceJTextField.setText( line.getTimeVariance() + "" );
        timeErrorJTextField.setText( line.getTimeError() + "" );

        petriNetJTextArea.setText( line.getPetriNet() );

        radioJCheckBox.setSelected( line.isRadioOn() );
        led0JCheckBox.setSelected( line.isLed0On() );
        led1JCheckBox.setSelected( line.isLed1On() );
        led2JCheckBox.setSelected( line.isLed2On() );

        radioStartJCheckBox.setSelected( line.isRadioStart() );
        radioStopJCheckBox.setSelected( line.isRadioStop() );
        
        moduleJTextField.requestFocus();

        listModel.clear();
        for( long id : line.getEventSet() )
        {
            listModel.addElement( id );
        }

        this.line = line;
    }

    public JList getJList()
    {
        return jList;
    }

    public DefaultListModel getListModel()
    {
        return listModel;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        titleJLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        moduleJTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        energyMeanJTextField = new javax.swing.JTextField();
        energyVarianceJTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        energyErrorJTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        powerMeanJTextField = new javax.swing.JTextField();
        powerVarianceJTextField = new javax.swing.JTextField();
        powerErrorJTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        timeMeanJTextField = new javax.swing.JTextField();
        timeVarianceJTextField = new javax.swing.JTextField();
        timeErrorJTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        radioJCheckBox = new javax.swing.JCheckBox();
        led0JCheckBox = new javax.swing.JCheckBox();
        led1JCheckBox = new javax.swing.JCheckBox();
        led2JCheckBox = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        petriNetJTextArea = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        radioStartJCheckBox = new javax.swing.JCheckBox();
        led0OnJCheckBox = new javax.swing.JCheckBox();
        led1OnJCheckBox = new javax.swing.JCheckBox();
        led2OnJCheckBox = new javax.swing.JCheckBox();
        radioStopJCheckBox = new javax.swing.JCheckBox();
        led0OffJCheckBox = new javax.swing.JCheckBox();
        led0ToggleJCheckBox = new javax.swing.JCheckBox();
        led1OffJCheckBox = new javax.swing.JCheckBox();
        led1ToggleJCheckBox = new javax.swing.JCheckBox();
        led2OffJCheckBox = new javax.swing.JCheckBox();
        led2ToggleJCheckBox = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        eventOpenJButton = new javax.swing.JButton();
        eventAddJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList();
        eventDelJButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        interfaceJTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        methodJTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        cancelJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        keyJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Energy");

        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleJLabel.setText("Energy");

        jLabel2.setText("Module ...:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Energy (Joules)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel3.setText("Mean");

        jLabel4.setText("Variance");

        jLabel11.setText("Standard Error");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(energyMeanJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(energyVarianceJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addComponent(energyErrorJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(energyMeanJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(energyVarianceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(energyErrorJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Power (Watts)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel5.setText("Mean");

        jLabel6.setText("Variance");

        jLabel12.setText("Standard Error");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(powerMeanJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(powerVarianceJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addComponent(powerErrorJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(powerMeanJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(powerVarianceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(powerErrorJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Time (Seconds)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel7.setText("Mean");

        jLabel8.setText("Variance");

        jLabel13.setText("Standard Error");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeMeanJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(timeVarianceJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addComponent(timeErrorJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeMeanJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeVarianceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeErrorJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Accepted Energy from:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        radioJCheckBox.setText("Radio");

        led0JCheckBox.setText("Red Led");

        led1JCheckBox.setText("Green Led");

        led2JCheckBox.setText("Yellow Led");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioJCheckBox)
                    .addComponent(led0JCheckBox)
                    .addComponent(led1JCheckBox)
                    .addComponent(led2JCheckBox))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(radioJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(led0JCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(led1JCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(led2JCheckBox))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Petri Net", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        petriNetJTextArea.setColumns(20);
        petriNetJTextArea.setRows(5);
        jScrollPane1.setViewportView(petriNetJTextArea);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "This instruction Enable this device:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        radioStartJCheckBox.setText("Radio Start");

        led0OnJCheckBox.setText("Red Led On");

        led1OnJCheckBox.setText("Green Led On");

        led2OnJCheckBox.setText("Yellow Led On");

        radioStopJCheckBox.setText("Radio Stop");

        led0OffJCheckBox.setText("Red Led Off");

        led0ToggleJCheckBox.setText("Red Led Toggle");

        led1OffJCheckBox.setText("Green Led Off");

        led1ToggleJCheckBox.setText("Green Led Toggle");

        led2OffJCheckBox.setText("Yellow Led Off");

        led2ToggleJCheckBox.setText("Yellow Led Toggle");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioStartJCheckBox)
                            .addComponent(led0OnJCheckBox)
                            .addComponent(led1OnJCheckBox))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(led2OnJCheckBox)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioStopJCheckBox)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(led0OffJCheckBox)
                            .addComponent(led1OffJCheckBox)
                            .addComponent(led2OffJCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(led2ToggleJCheckBox)
                            .addComponent(led1ToggleJCheckBox)
                            .addComponent(led0ToggleJCheckBox))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(radioStartJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(led0OnJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(led1OnJCheckBox))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(radioStopJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(led0ToggleJCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(led1ToggleJCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(led2ToggleJCheckBox))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(led0OffJCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(led1OffJCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(led2OffJCheckBox)
                            .addComponent(led2OnJCheckBox)))))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Event Related", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        eventOpenJButton.setText("O");

        eventAddJButton.setText("+");

        jList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList);

        eventDelJButton.setText("x");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(eventOpenJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eventAddJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(eventDelJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(eventAddJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventOpenJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eventDelJButton)
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Interface .:");

        jLabel10.setText("Function .:");

        cancelJButton.setText("Cancel");

        saveJButton.setText("Save");

        keyJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        keyJLabel.setText("key:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(keyJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(moduleJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                            .addComponent(interfaceJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                            .addComponent(methodJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelJButton))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(moduleJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(interfaceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(methodJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keyJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelJButton)
                    .addComponent(saveJButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JTextField energyErrorJTextField;
    private javax.swing.JTextField energyMeanJTextField;
    private javax.swing.JTextField energyVarianceJTextField;
    private javax.swing.JButton eventAddJButton;
    private javax.swing.JButton eventDelJButton;
    private javax.swing.JButton eventOpenJButton;
    private javax.swing.JTextField interfaceJTextField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel keyJLabel;
    private javax.swing.JCheckBox led0JCheckBox;
    private javax.swing.JCheckBox led0OffJCheckBox;
    private javax.swing.JCheckBox led0OnJCheckBox;
    private javax.swing.JCheckBox led0ToggleJCheckBox;
    private javax.swing.JCheckBox led1JCheckBox;
    private javax.swing.JCheckBox led1OffJCheckBox;
    private javax.swing.JCheckBox led1OnJCheckBox;
    private javax.swing.JCheckBox led1ToggleJCheckBox;
    private javax.swing.JCheckBox led2JCheckBox;
    private javax.swing.JCheckBox led2OffJCheckBox;
    private javax.swing.JCheckBox led2OnJCheckBox;
    private javax.swing.JCheckBox led2ToggleJCheckBox;
    private javax.swing.JTextField methodJTextField;
    private javax.swing.JTextField moduleJTextField;
    private javax.swing.JTextArea petriNetJTextArea;
    private javax.swing.JTextField powerErrorJTextField;
    private javax.swing.JTextField powerMeanJTextField;
    private javax.swing.JTextField powerVarianceJTextField;
    private javax.swing.JCheckBox radioJCheckBox;
    private javax.swing.JCheckBox radioStartJCheckBox;
    private javax.swing.JCheckBox radioStopJCheckBox;
    private javax.swing.JButton saveJButton;
    private javax.swing.JTextField timeErrorJTextField;
    private javax.swing.JTextField timeMeanJTextField;
    private javax.swing.JTextField timeVarianceJTextField;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables

}
