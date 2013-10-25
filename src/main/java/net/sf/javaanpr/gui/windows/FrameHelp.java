/*
------------------------------------------------------------------------
JavaANPR - Automatic Number Plate Recognition System for Java
------------------------------------------------------------------------

This file is a part of the JavaANPR, licensed under the terms of the
Educational Community License

Copyright (c) 2006-2007 Ondrej Martinsky. All rights reserved

This Original Work, including software, source code, documents, or
other related items, is being provided by the copyright holder(s)
subject to the terms of the Educational Community License. By
obtaining, using and/or copying this Original Work, you agree that you
have read, understand, and will comply with the following terms and
conditions of the Educational Community License:

Permission to use, copy, modify, merge, publish, distribute, and
sublicense this Original Work and its documentation, with or without
modification, for any purpose, and without fee or royalty to the
copyright holder(s) is hereby granted, provided that you include the
following on ALL copies of the Original Work or portions thereof,
including modifications or derivatives, that you make:

# The full text of the Educational Community License in a location
viewable to users of the redistributed or derivative work.

# Any pre-existing intellectual property disclaimers, notices, or terms
and conditions.

# Notice of any changes or modifications to the Original Work,
including the date the changes were made.

# Any modifications of the Original Work must be distributed in such a
manner as to avoid any confusion with the Original Work of the
copyright holders.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

The name and trademarks of copyright holder(s) may NOT be used in
advertising or publicity pertaining to the Original or Derivative Works
without specific, written prior permission. Title to copyright in the
Original Work and any associated documentation will at all times remain
with the copyright holders. 

If you want to alter upon this work, you MUST attribute it in 
a) all source files
b) on every place, where is the copyright of derivated work
exactly by the following label :

---- label begin ----
This work is a derivate of the JavaANPR. JavaANPR is a intellectual 
property of Ondrej Martinsky. Please visit http://net.sf.javaanpr.sourceforge.net 
for more info about JavaANPR. 
----  label end  ----

------------------------------------------------------------------------
                                         http://net.sf.javaanpr.sourceforge.net
------------------------------------------------------------------------
 */

package net.sf.javaanpr.gui.windows;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.sf.javaanpr.configurator.Configurator;

public class FrameHelp extends javax.swing.JFrame {
    static final long serialVersionUID = 0;

    public static int SHOW_HELP = 0;
    public static int SHOW_ABOUT = 1;
    public int mode;

    /** Creates new form FrameHelp */
    public FrameHelp(int mode) {
        this.initComponents();
        this.mode = mode;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = this.getWidth();
        int height = this.getHeight();
        this.setLocation((screenSize.width - width) / 2, (screenSize.height - height) / 2);
        try {
            if (mode == FrameHelp.SHOW_ABOUT) { //TODO 1 Fix to actually load the html file
                Path p = Paths.get(Configurator.getConfigurator().getPathProperty("help_file_about"));
                File aboutFile = p.toFile();               
                this.editorPane.setPage(aboutFile.toURI().toURL());
            } else {
                Path p = Paths.get(Configurator.getConfigurator().getPathProperty("help_file_help"));
                File helpFile = p.toFile();               
                this.editorPane.setPage(helpFile.toURI().toURL());
            }
        } catch (Exception e) {
            this.dispose();
        }
        this.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed"
    // desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        this.jScrollPane1 = new javax.swing.JScrollPane();
        this.editorPane = new javax.swing.JEditorPane();
        this.helpWindowClose = new javax.swing.JButton();

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("JavaANPR");
        this.setResizable(false);
        this.jScrollPane1.setViewportView(this.editorPane);

        this.helpWindowClose.setFont(new java.awt.Font("Arial", 0, 11));
        this.helpWindowClose.setText("Close");
        this.helpWindowClose.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrameHelp.this.helpWindowCloseActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
                layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout
                                .createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, this.helpWindowClose)
                                .add(this.jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 514,
                                        Short.MAX_VALUE)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
                org.jdesktop.layout.GroupLayout.TRAILING,
                layout.createSequentialGroup().addContainerGap()
                        .add(this.jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(this.helpWindowClose)
                        .addContainerGap()));
        this.pack();
    }// </editor-fold>//GEN-END:initComponents

    private void helpWindowCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_helpWindowCloseActionPerformed
        this.dispose();
    }// GEN-LAST:event_helpWindowCloseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane editorPane;
    private javax.swing.JButton helpWindowClose;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
