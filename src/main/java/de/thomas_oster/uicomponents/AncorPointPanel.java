/**
 * This file is part of VisiCut.
 * Copyright (C) 2011 - 2013 Thomas Oster <thomas.oster@rwth-aachen.de>
 * RWTH Aachen University - 52062 Aachen, Germany
 *
 *     VisiCut is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     VisiCut is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with VisiCut.  If not, see <http://www.gnu.org/licenses/>.
 **/
package de.thomas_oster.uicomponents;

import de.thomas_oster.liblasercut.platform.Util;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JRadioButton;

/**
 *
 * @author Thomas Oster <thomas.oster@rwth-aachen.de>
 */
public class AncorPointPanel extends javax.swing.JPanel implements ActionListener
{
  
  public void actionPerformed(ActionEvent ae)
  {
    for (Entry<Position, JRadioButton> e : buttons.entrySet())
    {
      if (e.getValue().equals(ae.getSource()) && e.getValue().isSelected())
      {
        this.setPosition(e.getKey());
      }
    }
  }

  public enum Position
  {
    TOP_LEFT,
    TOP_CENTER,
    TOP_RIGHT,
    CENTER_LEFT,
    CENTER_CENTER,
    CENTER_RIGHT,
    BOTTOM_LEFT,
    BOTTOM_CENTER,
    BOTTOM_RIGHT,
  }

  public static final String PROP_POSITION = "position";
  private Position position = Position.TOP_LEFT;
  private Map<Position,JRadioButton> buttons;

  /**
   * Get the value of position
   *
   * @return the value of position
   */
  public Position getPosition()
  {
    return position;
  }

  /**
   * Set the value of position
   *
   * @param position new value of position
   */
  public void setPosition(Position position)
  {
    if (Util.differ(this.position, position))
    {
      Position oldPosition = this.position;
      this.position = position;
      buttons.get(this.position).setSelected(true);
      firePropertyChange(PROP_POSITION, oldPosition, position);
    }
  }

  /**
   * Creates new form AncorPointPanel
   */
  public AncorPointPanel()
  {
    initComponents();
    buttons = new EnumMap<Position,JRadioButton>(Position.class);
    buttons.put(Position.TOP_LEFT, rTopLeft);
    buttons.put(Position.TOP_CENTER, rTopCenter);
    buttons.put(Position.TOP_RIGHT, rTopRight);
    buttons.put(Position.CENTER_LEFT, rCenterLeft);
    buttons.put(Position.CENTER_CENTER, rCenterCenter);
    buttons.put(Position.CENTER_RIGHT, rCenterRight);
    buttons.put(Position.BOTTOM_LEFT, rBottomLeft);
    buttons.put(Position.BOTTOM_CENTER, rBottomCenter);
    buttons.put(Position.BOTTOM_RIGHT, rBottomRight);
    for (JRadioButton b: buttons.values())
    {
      b.addActionListener(this);
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    radioButtonGroup = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    rTopLeft = new javax.swing.JRadioButton();
    rTopCenter = new javax.swing.JRadioButton();
    rTopRight = new javax.swing.JRadioButton();
    rCenterLeft = new javax.swing.JRadioButton();
    rCenterCenter = new javax.swing.JRadioButton();
    rCenterRight = new javax.swing.JRadioButton();
    rBottomCenter = new javax.swing.JRadioButton();
    rBottomLeft = new javax.swing.JRadioButton();
    rBottomRight = new javax.swing.JRadioButton();

    jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

    rTopLeft.setBackground(new Color(0,0,0,0));
    radioButtonGroup.add(rTopLeft);
    rTopLeft.setSelected(true);
    rTopLeft.setMargin(new java.awt.Insets(0, 0, 0, 0));
    rTopLeft.setOpaque(false);

    rTopCenter.setBackground(new Color(0,0,0,0));
    radioButtonGroup.add(rTopCenter);
    rTopCenter.setMargin(new java.awt.Insets(0, 0, 0, 0));
    rTopCenter.setOpaque(false);

    rTopRight.setBackground(new Color(0,0,0,0));
    radioButtonGroup.add(rTopRight);
    rTopRight.setMargin(new java.awt.Insets(0, 0, 0, 0));
    rTopRight.setOpaque(false);

    rCenterLeft.setBackground(new Color(0,0,0,0));
    radioButtonGroup.add(rCenterLeft);
    rCenterLeft.setMargin(new java.awt.Insets(0, 0, 0, 0));
    rCenterLeft.setOpaque(false);

    rCenterCenter.setBackground(new Color(0,0,0,0));
    radioButtonGroup.add(rCenterCenter);
    rCenterCenter.setMargin(new java.awt.Insets(0, 0, 0, 0));
    rCenterCenter.setOpaque(false);

    rCenterRight.setBackground(new Color(0,0,0,0));
    radioButtonGroup.add(rCenterRight);
    rCenterRight.setMargin(new java.awt.Insets(0, 0, 0, 0));
    rCenterRight.setOpaque(false);

    rBottomCenter.setBackground(new Color(0,0,0,0));
    radioButtonGroup.add(rBottomCenter);
    rBottomCenter.setMargin(new java.awt.Insets(0, 0, 0, 0));
    rBottomCenter.setOpaque(false);

    rBottomLeft.setBackground(new Color(0,0,0,0));
    radioButtonGroup.add(rBottomLeft);
    rBottomLeft.setMargin(new java.awt.Insets(0, 0, 0, 0));
    rBottomLeft.setOpaque(false);

    rBottomRight.setBackground(new Color(0,0,0,0));
    radioButtonGroup.add(rBottomRight);
    rBottomRight.setMargin(new java.awt.Insets(0, 0, 0, 0));
    rBottomRight.setOpaque(false);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(rTopLeft)
            .addGap(18, 18, 18)
            .addComponent(rTopCenter)
            .addGap(18, 18, 18)
            .addComponent(rTopRight))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(rCenterLeft)
            .addGap(18, 18, 18)
            .addComponent(rCenterCenter)
            .addGap(18, 18, 18)
            .addComponent(rCenterRight))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(rBottomLeft)
            .addGap(18, 18, 18)
            .addComponent(rBottomCenter)
            .addGap(18, 18, 18)
            .addComponent(rBottomRight)))
        .addGap(0, 0, 0))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(0, 0, 0)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(rTopRight)
          .addComponent(rTopCenter)
          .addComponent(rTopLeft))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(rCenterLeft)
          .addComponent(rCenterCenter)
          .addComponent(rCenterRight))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(rBottomRight)
          .addComponent(rBottomCenter)
          .addComponent(rBottomLeft))
        .addGap(0, 0, 0))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel jPanel1;
  private javax.swing.JRadioButton rBottomCenter;
  private javax.swing.JRadioButton rBottomLeft;
  private javax.swing.JRadioButton rBottomRight;
  private javax.swing.JRadioButton rCenterCenter;
  private javax.swing.JRadioButton rCenterLeft;
  private javax.swing.JRadioButton rCenterRight;
  private javax.swing.JRadioButton rTopCenter;
  private javax.swing.JRadioButton rTopLeft;
  private javax.swing.JRadioButton rTopRight;
  private javax.swing.ButtonGroup radioButtonGroup;
  // End of variables declaration//GEN-END:variables
}
