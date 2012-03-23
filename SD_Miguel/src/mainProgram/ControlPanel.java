/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mainProgram;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ua.gboard.FilledGelem;
import pt.ua.gboard.GBoard;
import viewer.SimViewer;
import viewer.drawings.CanvasDrawing;

/**
 *
 * @author Miguel
 */
public class ControlPanel extends javax.swing.JFrame {

    private int totalThieves = Params.DEFAULT_TOTAL_THIEVES;
    private int groupSize = Params.DEFAULT_GROUP_SIZE;
    private int minSpeed = Params.DEFAULT_MIN_SPEED;
    private int maxSpeed = Params.DEFAULT_MAX_SPEED;
    private int maxGap = Params.DEFAULT_MAX_GAP;
    private int nRooms = Params.DEFAULT_N_ROOMS;
    private int minDistance = Params.DEFAULT_MIN_DISTANCE;
    private int maxDistance = Params.DEFAULT_MAX_DISTANCE;
    private int totalCanvases = Params.DEFAULT_TOTAL_CANVASES;
    
    private static HeistToTheMuseum heist = null;
    private static GBoard dummy, board = null;
    private static SimViewer viewer = null;
    
    /**
     * Creates new form ControlPanel
     */
    public ControlPanel() {
        initComponents();
        jDialogParams.pack();
        dummy = new GBoard("",1,1,1,1,1);
        dummy.frame().setVisible(false);
        buildViewer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogParams = new javax.swing.JDialog();
        jPanelMain = new javax.swing.JPanel();
        jPanelThieves = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerMaxSpeed = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jSpinnerDistance = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jSpinnerGroupSize = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jSpinnerMinSpeed = new javax.swing.JSpinner();
        jSpinnerThieves = new javax.swing.JSpinner();
        jLabelValid = new javax.swing.JLabel();
        jPanelMuseum = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSpinnerRooms = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jSpinnerCanvas = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerMinDistOut = new javax.swing.JSpinner();
        jSpinnerMaxDistOut = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jPanelButtons = new javax.swing.JPanel();
        jButtonDefaults = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonStart = new javax.swing.JButton();
        jButtonParams = new javax.swing.JButton();
        jSliderSpeed = new javax.swing.JSlider();
        jButtonCreate = new javax.swing.JButton();

        jDialogParams.setTitle("Edit Parameters");
        jDialogParams.setAlwaysOnTop(true);
        jDialogParams.setModal(true);
        jDialogParams.setResizable(false);
        jDialogParams.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jDialogParamsComponentShown(evt);
            }
        });

        jPanelMain.setLayout(new java.awt.GridLayout(2, 1));

        jPanelThieves.setBorder(javax.swing.BorderFactory.createTitledBorder("Thieves parameters"));

        jLabel1.setText("Total number");

        jLabel2.setText("Speed");

        jSpinnerMaxSpeed.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerMaxSpeed.setToolTipText("Maximum speed of thieves");
        jSpinnerMaxSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerMaxSpeedStateChanged(evt);
            }
        });

        jLabel3.setText("Maximum gap");

        jSpinnerDistance.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(4), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerDistance.setToolTipText("Maximum gap between two consecutive thieves");

        jLabel4.setText("Group Size");

        jSpinnerGroupSize.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(3), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerGroupSize.setToolTipText("Number of thieves per group");
        jSpinnerGroupSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerGroupSizeStateChanged(evt);
            }
        });

        jLabel5.setText("-");

        jSpinnerMinSpeed.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerMinSpeed.setToolTipText("Minimum speed of thieves");
        jSpinnerMinSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerMinSpeedStateChanged(evt);
            }
        });

        jSpinnerThieves.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(7), Integer.valueOf(2), null, Integer.valueOf(1)));
        jSpinnerThieves.setToolTipText("Number of thieves");
        jSpinnerThieves.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerThievesStateChanged(evt);
            }
        });

        jLabelValid.setForeground(new java.awt.Color(255, 0, 0));
        jLabelValid.setText("incompatible group size");

        javax.swing.GroupLayout jPanelThievesLayout = new javax.swing.GroupLayout(jPanelThieves);
        jPanelThieves.setLayout(jPanelThievesLayout);
        jPanelThievesLayout.setHorizontalGroup(
            jPanelThievesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThievesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelThievesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelThievesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelThievesLayout.createSequentialGroup()
                            .addGroup(jPanelThievesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelThievesLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                    .addComponent(jLabelValid)
                                    .addGap(1, 1, 1))
                                .addGroup(jPanelThievesLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSpinnerMinSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5)))
                            .addGap(3, 3, 3))
                        .addGroup(jPanelThievesLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(86, 86, 86)))
                    .addGroup(jPanelThievesLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(126, 126, 126)))
                .addGroup(jPanelThievesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinnerGroupSize, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jSpinnerDistance, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jSpinnerThieves)
                    .addComponent(jSpinnerMaxSpeed))
                .addContainerGap())
        );
        jPanelThievesLayout.setVerticalGroup(
            jPanelThievesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThievesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelThievesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinnerThieves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelValid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelThievesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinnerMaxSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerMinSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelThievesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinnerDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelThievesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnerGroupSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jPanelMain.add(jPanelThieves);

        jPanelMuseum.setBorder(javax.swing.BorderFactory.createTitledBorder("Museum parameters"));

        jLabel6.setText("Number of Rooms");

        jSpinnerRooms.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerRooms.setToolTipText("Number of rooms");

        jLabel7.setText("Total number of Canvases");

        jSpinnerCanvas.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(50), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerCanvas.setToolTipText("Total number of canvases at the museum");

        jLabel8.setText("Room distance");

        jSpinnerMinDistOut.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(5), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerMinDistOut.setToolTipText("Minimum distance to the Museum entrance");
        jSpinnerMinDistOut.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerMinDistOutStateChanged(evt);
            }
        });

        jSpinnerMaxDistOut.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(12), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerMaxDistOut.setToolTipText("Maximum distance to the Museum entrance");
        jSpinnerMaxDistOut.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerMaxDistOutStateChanged(evt);
            }
        });

        jLabel9.setText("-");

        javax.swing.GroupLayout jPanelMuseumLayout = new javax.swing.GroupLayout(jPanelMuseum);
        jPanelMuseum.setLayout(jPanelMuseumLayout);
        jPanelMuseumLayout.setHorizontalGroup(
            jPanelMuseumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMuseumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMuseumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMuseumLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(76, 76, 76))
                    .addGroup(jPanelMuseumLayout.createSequentialGroup()
                        .addGroup(jPanelMuseumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMuseumLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addComponent(jSpinnerMinDistOut, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))
                            .addGroup(jPanelMuseumLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanelMuseumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinnerRooms, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(jSpinnerMaxDistOut, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSpinnerCanvas, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelMuseumLayout.setVerticalGroup(
            jPanelMuseumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMuseumLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMuseumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jSpinnerRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMuseumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinnerCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMuseumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jSpinnerMaxDistOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jSpinnerMinDistOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanelMain.add(jPanelMuseum);

        jButtonDefaults.setText("Set Defaults");
        jButtonDefaults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDefaultsActionPerformed(evt);
            }
        });

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
        jPanelButtons.setLayout(jPanelButtonsLayout);
        jPanelButtonsLayout.setHorizontalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createSequentialGroup()
                .addComponent(jButtonDefaults)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancel))
        );
        jPanelButtonsLayout.setVerticalGroup(
            jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButtonDefaults)
                .addComponent(jButtonOk)
                .addComponent(jButtonCancel))
        );

        javax.swing.GroupLayout jDialogParamsLayout = new javax.swing.GroupLayout(jDialogParams.getContentPane());
        jDialogParams.getContentPane().setLayout(jDialogParamsLayout);
        jDialogParamsLayout.setHorizontalGroup(
            jDialogParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogParamsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialogParamsLayout.setVerticalGroup(
            jDialogParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogParamsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setTitle("Heist to the Museum");
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonParams.setText("Edit Parameters");
        jButtonParams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonParamsActionPerformed(evt);
            }
        });

        jSliderSpeed.setMinimum(1);
        jSliderSpeed.setToolTipText("Simulation Speed");
        jSliderSpeed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderSpeedStateChanged(evt);
            }
        });

        jButtonCreate.setText("Shuffle");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonParams)
                .addGap(18, 18, 18)
                .addComponent(jButtonCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSliderSpeed, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSliderSpeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonStart)
                        .addComponent(jButtonParams)
                        .addComponent(jButtonCreate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonParamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonParamsActionPerformed
        jDialogParams.setVisible(true);
    }//GEN-LAST:event_jButtonParamsActionPerformed

    private void jSpinnerMaxSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerMaxSpeedStateChanged
        if ((int) jSpinnerMaxSpeed.getValue() < (int) jSpinnerMinSpeed.getValue())
            jSpinnerMinSpeed.setValue(jSpinnerMaxSpeed.getValue());
    }//GEN-LAST:event_jSpinnerMaxSpeedStateChanged

    private void jSpinnerMinSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerMinSpeedStateChanged
        if ((int) jSpinnerMinSpeed.getValue() > (int) jSpinnerMaxSpeed.getValue())
            jSpinnerMaxSpeed.setValue(jSpinnerMinSpeed.getValue());
    }//GEN-LAST:event_jSpinnerMinSpeedStateChanged

    private void jSpinnerMinDistOutStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerMinDistOutStateChanged
        if ((int) jSpinnerMinDistOut.getValue() > (int) jSpinnerMaxDistOut.getValue())
                jSpinnerMaxDistOut.setValue(jSpinnerMinDistOut.getValue());
    }//GEN-LAST:event_jSpinnerMinDistOutStateChanged

    private void jSpinnerMaxDistOutStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerMaxDistOutStateChanged
        if ((int) jSpinnerMaxDistOut.getValue() < (int) jSpinnerMinDistOut.getValue())
                jSpinnerMinDistOut.setValue(jSpinnerMaxDistOut.getValue());
    }//GEN-LAST:event_jSpinnerMaxDistOutStateChanged

    private void jButtonDefaultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDefaultsActionPerformed
        jSpinnerCanvas.setValue(Params.DEFAULT_TOTAL_CANVASES);
        jSpinnerDistance.setValue(Params.DEFAULT_MAX_GAP);
        jSpinnerMaxDistOut.setValue(Params.DEFAULT_MAX_DISTANCE);
        jSpinnerMaxSpeed.setValue(Params.DEFAULT_MAX_SPEED);
        jSpinnerMinDistOut.setValue(Params.DEFAULT_MIN_DISTANCE);
        jSpinnerMinSpeed.setValue(Params.DEFAULT_MIN_SPEED);
        jSpinnerGroupSize.setValue(Params.DEFAULT_GROUP_SIZE);
        jSpinnerRooms.setValue(Params.DEFAULT_N_ROOMS);
        jSpinnerThieves.setValue(Params.DEFAULT_TOTAL_THIEVES);
    }//GEN-LAST:event_jButtonDefaultsActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        groupSize = (int) jSpinnerGroupSize.getValue();
        maxGap = (int) jSpinnerDistance.getValue();
        maxDistance = (int) jSpinnerMaxDistOut.getValue();
        maxSpeed = (int) jSpinnerMaxSpeed.getValue();
        minDistance = (int) jSpinnerMinDistOut.getValue();
        minSpeed = (int) jSpinnerMinSpeed.getValue();
        nRooms = (int) jSpinnerRooms.getValue();
        totalCanvases = (int) jSpinnerCanvas.getValue();
        totalThieves = (int) jSpinnerThieves.getValue();
        jDialogParams.setVisible(false);
        buildViewer();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        jDialogParams.setVisible(false);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jDialogParamsComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDialogParamsComponentShown
        jSpinnerCanvas.setValue(totalCanvases);
        jSpinnerDistance.setValue(maxGap);
        jSpinnerMaxDistOut.setValue(maxDistance);
        jSpinnerMaxSpeed.setValue(maxSpeed);
        jSpinnerMinDistOut.setValue(minDistance);
        jSpinnerMinSpeed.setValue(minSpeed);
        jSpinnerGroupSize.setValue(groupSize);
        jSpinnerRooms.setValue(nRooms);
        jSpinnerThieves.setValue(totalThieves);
        
        boolean valid = (totalThieves-1) % groupSize == 0;
        
        jButtonOk.setEnabled(valid);
        jLabelValid.setVisible(!valid);
    }//GEN-LAST:event_jDialogParamsComponentShown

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        
        heist.start();
        jButtonStart.setEnabled(false);
        jButtonCreate.setEnabled(false);
        jButtonParams.setEnabled(false);
        try {
            heist.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        jButtonStart.setEnabled(true);
        jButtonCreate.setEnabled(true);
        jButtonParams.setEnabled(true);
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jSliderSpeedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderSpeedStateChanged
        Params.SIM_SPEED = jSliderSpeed.getValue();
    }//GEN-LAST:event_jSliderSpeedStateChanged

    private void jSpinnerThievesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerThievesStateChanged
        boolean valid = ((int)jSpinnerThieves.getValue() - 1) % (int)jSpinnerGroupSize.getValue() == 0;
        
        jButtonOk.setEnabled(valid);
        jLabelValid.setVisible(!valid);
    }//GEN-LAST:event_jSpinnerThievesStateChanged

    private void jSpinnerGroupSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerGroupSizeStateChanged
        boolean valid = ((int)jSpinnerThieves.getValue() - 1) % (int)jSpinnerGroupSize.getValue() == 0;
        
        jButtonOk.setEnabled(valid);
        jLabelValid.setVisible(!valid);
    }//GEN-LAST:event_jSpinnerGroupSizeStateChanged

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        buildViewer();
    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dummy.terminate();
        if (board != null)
            board.terminate();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ControlPanel().setVisible(true);
            }
        });
    }
    
    private void buildViewer() {
        if (board != null)
            board.terminate();
        
        Params.setParams(totalThieves, groupSize, minSpeed, maxSpeed, maxGap, nRooms, minDistance, maxDistance, totalCanvases);
        
        int maxDist = 0;
        for (int r = 0; r < Params.nRooms(); r++)
            if (Params.distances()[r] > maxDist)
                maxDist = Params.distances()[r];
        
        board = new GBoard("Simulation Viewer",
                Params.nRooms()*2, maxDist + 1, 40, 40,  3);
        
        FilledGelem roomElem = new FilledGelem (Color.GREEN, 90, 2, 1);
        FilledGelem pathElem = new FilledGelem (Color.ORANGE, 60, 2, 1);
        FilledGelem outElem = new FilledGelem (Color.LIGHT_GRAY, 95, Params.nRooms()*2, 1);
        FilledGelem wallElem = new FilledGelem (Color.BLACK, 100, 2, 1);
        
        board.draw(outElem,0,0,1);
        for (int r = 0; r < Params.nRooms(); r++) {
            int c = 1;
            for (; c < Params.distances()[r]; c++)
                board.draw(pathElem, r*2, c, 1);
            board.draw(roomElem, r*2, c, 1);
            CanvasDrawing canvas = new CanvasDrawing(Params.nCanvases()[r]);
            board.draw(canvas, r*2, c++, 2);
            for(; c < maxDist + 1; c++)
                board.draw(wallElem, r*2, c, 1);
        }
        
        viewer = new SimViewer(board);
        heist = new HeistToTheMuseum(viewer);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonDefaults;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonParams;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JDialog jDialogParams;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelValid;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelMuseum;
    private javax.swing.JPanel jPanelThieves;
    private javax.swing.JSlider jSliderSpeed;
    private javax.swing.JSpinner jSpinnerCanvas;
    private javax.swing.JSpinner jSpinnerDistance;
    private javax.swing.JSpinner jSpinnerGroupSize;
    private javax.swing.JSpinner jSpinnerMaxDistOut;
    private javax.swing.JSpinner jSpinnerMaxSpeed;
    private javax.swing.JSpinner jSpinnerMinDistOut;
    private javax.swing.JSpinner jSpinnerMinSpeed;
    private javax.swing.JSpinner jSpinnerRooms;
    private javax.swing.JSpinner jSpinnerThieves;
    // End of variables declaration//GEN-END:variables
}