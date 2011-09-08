/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditVectorProfileDialog.java
 *
 * Created on 06.09.2011, 10:34:59
 */
package com.t_oster.visicut.gui;

import com.t_oster.liblasercut.LaserProperty;
import com.t_oster.visicut.gui.beans.EditableTableProvider;
import com.t_oster.visicut.model.LaserPropertyBean;
import com.t_oster.visicut.model.VectorProfile;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thommy
 */
public class EditVectorProfileDialog extends javax.swing.JDialog implements EditableTableProvider
{

  public Object getNewInstance()
  {
    return new LaserProperty();
  }

  public Object editObject(Object o)
  {
    if (o instanceof LaserProperty)
    {
      EditLaserPropertyPanel d = new EditLaserPropertyPanel();
      d.setLaserProperty(new LaserPropertyBean(((LaserProperty) o).clone()));
      if (JOptionPane.showConfirmDialog(this, d, "Edit Laser Property", JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION)
      {
        return d.getLaserProperty().getLaserProperty();
      }
      else
      {
        return null;
      }
    }
    return o;
  }

  private class LaserPropertiesTableModel extends DefaultTableModel
  {

    public void setVectorProfile(VectorProfile vp)
    {
      this.vp = vp;
    }
    private VectorProfile vp = null;
    private String[] columnNames = new String[]
    {
      "Power", "Speed", "Frequency", "Focus"
    };

    @Override
    public int getColumnCount()
    {
      return columnNames.length;
    }

    @Override
    public String getColumnName(int i)
    {
      return columnNames[i];
    }

    @Override
    public Object getValueAt(int y, int x)
    {
      switch (x)
      {
        case 0:
          return vp.getLaserProperties().get(y).getPower();
        case 1:
          return vp.getLaserProperties().get(y).getSpeed();
        case 2:
          return vp.getLaserProperties().get(y).getFrequency();
        case 3:
          return vp.getLaserProperties().get(y).getFocus();
      }
      return null;
    }

    @Override
    public boolean isCellEditable(int i, int i1)
    {
      return true;
    }

    @Override
    public void setValueAt(Object o, int y, int x)
    {
      switch (x)
      {
        case 0:
          vp.getLaserProperties().get(y).setPower(Integer.parseInt(o.toString()));
          return;
        case 1:
          vp.getLaserProperties().get(y).setSpeed(Integer.parseInt(o.toString()));
          return;
        case 2:
          vp.getLaserProperties().get(y).setFrequency(Integer.parseInt(o.toString()));
          return;
        case 3:
          vp.getLaserProperties().get(y).setFocus(Float.parseFloat(o.toString()));
          return;
      }
    }

    @Override
    public int getRowCount()
    {
      return vp == null ? 0 : vp.getLaserProperties().size();
    }
  }
  protected VectorProfile vectorProfile = null;
  public static final String PROP_VECTORPROFILE = "vectorProfile";

  /**
   * Get the value of vectorProfile
   *
   * @return the value of vectorProfile
   */
  public VectorProfile getVectorProfile()
  {
    return vectorProfile;
  }

  /**
   * Set the value of vectorProfile
   *
   * @param vectorProfile new value of vectorProfile
   */
  public void setVectorProfile(VectorProfile vectorProfile)
  {
    VectorProfile oldVectorProfile = this.vectorProfile;
    this.vectorProfile = vectorProfile;
    firePropertyChange(PROP_VECTORPROFILE, oldVectorProfile, vectorProfile);
    if (vectorProfile == null)
    {
      this.setCurrentVectorProfile(new VectorProfile());
    }
    else
    {
      this.setCurrentVectorProfile((VectorProfile) vectorProfile.clone());
    }
  }
  protected VectorProfile currentVectorProfile = null;
  public static final String PROP_CURRENTVECTORPROFILE = "currentVectorProfile";

  /**
   * Get the value of currentVectorProfile
   *
   * @return the value of currentVectorProfile
   */
  public VectorProfile getCurrentVectorProfile()
  {
    return currentVectorProfile;
  }

  /**
   * Set the value of currentVectorProfile
   *
   * @param currentVectorProfile new value of currentVectorProfile
   */
  public void setCurrentVectorProfile(VectorProfile currentVectorProfile)
  {
    VectorProfile oldCurrentVectorProfile = this.currentVectorProfile;
    this.currentVectorProfile = currentVectorProfile;
    firePropertyChange(PROP_CURRENTVECTORPROFILE, oldCurrentVectorProfile, currentVectorProfile);
    this.listModel.setVectorProfile(currentVectorProfile);
  }
  private LaserPropertiesTableModel listModel = new LaserPropertiesTableModel();

  /** Creates new form EditVectorProfileDialog */
  public EditVectorProfileDialog(java.awt.Frame parent, boolean modal)
  {
    super(parent, modal);
    initComponents();
    this.editableTablePanel1.setTableModel(listModel);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

    jLabel3 = new javax.swing.JLabel();
    jButton4 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();
    jTextField4 = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jTextField2 = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jCheckBox1 = new javax.swing.JCheckBox();
    selectThumbnailButton1 = new com.t_oster.visicut.gui.beans.SelectThumbnailButton();
    chooseColorButton1 = new com.t_oster.visicut.gui.beans.ChooseColorButton();
    editableTablePanel1 = new com.t_oster.visicut.gui.beans.EditableTablePanel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setName("Form"); // NOI18N

    org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.t_oster.visicut.gui.VisicutApp.class).getContext().getResourceMap(EditVectorProfileDialog.class);
    jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
    jLabel3.setName("jLabel3"); // NOI18N

    jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
    jButton4.setName("jButton4"); // NOI18N
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
    jButton3.setName("jButton3"); // NOI18N
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
    jLabel5.setName("jLabel5"); // NOI18N

    jTextField4.setName("jTextField4"); // NOI18N

    org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentVectorProfile.width}"), jTextField4, org.jdesktop.beansbinding.BeanProperty.create("text"));
    bindingGroup.addBinding(binding);

    jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
    jLabel4.setName("jLabel4"); // NOI18N

    jTextField2.setName("jTextField2"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentVectorProfile.description}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"), "desc");
    bindingGroup.addBinding(binding);

    jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
    jLabel2.setName("jLabel2"); // NOI18N

    jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
    jLabel1.setName("jLabel1"); // NOI18N

    jTextField1.setName("jTextField1"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentVectorProfile.name}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"), "Name");
    bindingGroup.addBinding(binding);

    jCheckBox1.setText(resourceMap.getString("jCheckBox1.text")); // NOI18N
    jCheckBox1.setName("jCheckBox1"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentVectorProfile.isCut}"), jCheckBox1, org.jdesktop.beansbinding.BeanProperty.create("selected"));
    bindingGroup.addBinding(binding);

    selectThumbnailButton1.setName("selectThumbnailButton1"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentVectorProfile.thumbnailPath}"), selectThumbnailButton1, org.jdesktop.beansbinding.BeanProperty.create("thumbnailPath"), "thumbnailbt");
    bindingGroup.addBinding(binding);

    chooseColorButton1.setName("chooseColorButton1"); // NOI18N

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentVectorProfile.color}"), chooseColorButton1, org.jdesktop.beansbinding.BeanProperty.create("selectedColor"), "colorbt");
    bindingGroup.addBinding(binding);

    editableTablePanel1.setName("editableTablePanel1"); // NOI18N
    editableTablePanel1.setProvider(this);

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentVectorProfile.laserProperties}"), editableTablePanel1, org.jdesktop.beansbinding.BeanProperty.create("objects"), "laserprops");
    bindingGroup.addBinding(binding);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(editableTablePanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
          .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addComponent(jLabel4)
              .addComponent(selectThumbnailButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chooseColorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jLabel1)
              .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
              .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jButton4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton3)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(selectThumbnailButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(chooseColorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5)
          .addComponent(jCheckBox1))
        .addGap(18, 18, 18)
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(editableTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton3)
          .addComponent(jButton4))
        .addContainerGap())
    );

    bindingGroup.bind();

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
  {//GEN-HEADEREND:event_jButton4ActionPerformed

    this.setVectorProfile(null);     this.setVisible(false);   }//GEN-LAST:event_jButton4ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
  {//GEN-HEADEREND:event_jButton3ActionPerformed

    this.setVectorProfile(this.getCurrentVectorProfile());     this.setVisible(false);   }//GEN-LAST:event_jButton3ActionPerformed
  /**
   * @param args the command line arguments
   */
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private com.t_oster.visicut.gui.beans.ChooseColorButton chooseColorButton1;
  private com.t_oster.visicut.gui.beans.EditableTablePanel editableTablePanel1;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JCheckBox jCheckBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JTextField jTextField2;
  private javax.swing.JTextField jTextField4;
  private com.t_oster.visicut.gui.beans.SelectThumbnailButton selectThumbnailButton1;
  private org.jdesktop.beansbinding.BindingGroup bindingGroup;
  // End of variables declaration//GEN-END:variables
}
