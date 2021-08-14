/*
 * Created by JFormDesigner on Fri Aug 13 16:41:53 PDT 2021
 */

package com.company;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

/**
 * @author unknown
 */


public class Compound_Interest extends JFrame {

    Connection1 con = new Connection1();
    Connection conObj = con.connect();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Compound_Interest myform = new Compound_Interest();
        myform.getTableData();
        myform.setVisible(true);
    }

    public void getTableData() throws SQLException {
        String quer = "Select * from savingstable";
        PreparedStatement query = conObj.prepareStatement(quer);
        ResultSet resultSet = query.executeQuery();
        DefaultTableModel dfMode = (DefaultTableModel) DataTable.getModel();
        resultSet.last();
        int row = resultSet.getRow();
        resultSet.beforeFirst();

        String[][] array = new String[0][];
        if (row > 0) {
            array = new String[row][5];
        }
        int j = 0;
        while (resultSet.next()) {
            array[j][0] = resultSet.getString("custno");
            array[j][1] = resultSet.getString("custname");
            array[j][2] = resultSet.getString("cdep");
            array[j][3] = resultSet.getString("nyears");
            array[j][4] = resultSet.getString("savetype");
            ++j;
        }
        String[] cols = {"Number", "Name", "Deposit", "Year", "Types of Saving"};
        DefaultTableModel model = new DefaultTableModel(array, cols);
        DataTable.setModel(model);

    }

    public Compound_Interest() throws SQLException, ClassNotFoundException {
        initComponents();
    }

    private void btnAddActionPerformed(ActionEvent e) throws SQLException {
        String custno, custname, cdep, nyears, savetype;

        custno = txtCustomerNumber.getText();
        custname = textCustomerName.getText();
        cdep = textInitialDeposite.getText();
        nyears = textNumberOfYears.getText();
        savetype = (String) comboBoxSavingType.getSelectedItem();

        String query1 = "Select * from savingstable where custno =?";
        PreparedStatement query = conObj.prepareStatement(query1);

        query.setString(1, custno);

        ResultSet rs = query.executeQuery();

        if (rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, "The record is existing");
            //set the textboxes to space
            return;
        }


        String query2 = "Insert into savingstable values (?,?,?,?,?)";
        query = conObj.prepareStatement(query2);

        query.setString(1, custno);
        query.setString(2, custname);
        query.setString(3, cdep);
        query.setString(4, nyears);
        query.setString(5, savetype);

        query.executeUpdate();


        JOptionPane.showMessageDialog(null, "One record added ");
        getTableData();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        labelCustNumber = new JLabel();
        txtCustomerNumber = new JTextField();
        labelCustomerName = new JLabel();
        textCustomerName = new JTextField();
        labelInitialDeposite = new JLabel();
        textInitialDeposite = new JTextField();
        labelNumberOfYear = new JLabel();
        textNumberOfYears = new JTextField();
        labelTypeOfSaving = new JLabel();
        comboBoxSavingType = new JComboBox(new Object[]{"Saving-Regular", "Savings-Deluxe"});
        scrollPane1 = new JScrollPane();
        DataTable = new JTable();
        scrollPane2 = new JScrollPane();
        InterestTable = new JTable();
        btnAdd = new JButton();
        btnEdit = new JButton();
        btnDelete = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));

        //---- labelCustNumber ----
        labelCustNumber.setText("Enter the Customer Number");
        contentPane.add(labelCustNumber, "cell 0 0");

        //---- txtCustomerNumber ----
        txtCustomerNumber.setColumns(25);
        contentPane.add(txtCustomerNumber, "cell 1 0");

        //---- labelCustomerName ----
        labelCustomerName.setText("Enter the Customer Name");
        contentPane.add(labelCustomerName, "cell 0 1");
        contentPane.add(textCustomerName, "cell 1 1");

        //---- labelInitialDeposite ----
        labelInitialDeposite.setText("Enter Intial Deposite");
        contentPane.add(labelInitialDeposite, "cell 0 2");
        contentPane.add(textInitialDeposite, "cell 1 2");

        //---- labelNumberOfYear ----
        labelNumberOfYear.setText("Enter the number of years");
        contentPane.add(labelNumberOfYear, "cell 0 3");
        contentPane.add(textNumberOfYears, "cell 1 3");

        //---- labelTypeOfSaving ----
        labelTypeOfSaving.setText("Enter the types of saving");
        contentPane.add(labelTypeOfSaving, "cell 0 4");
        contentPane.add(comboBoxSavingType, "cell 1 4");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(DataTable);
        }
        contentPane.add(scrollPane1, "cell 0 5");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(InterestTable);
        }
        contentPane.add(scrollPane2, "cell 1 5");

        //---- btnAdd ----
        btnAdd.setText("Add");
        btnAdd.addActionListener(e -> {
            try {
                btnAddActionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
        contentPane.add(btnAdd, "cell 0 6");

        //---- btnEdit ----
        btnEdit.setText("Edit");
        contentPane.add(btnEdit, "cell 0 6");

        //---- btnDelete ----
        btnDelete.setText("Delete");
        contentPane.add(btnDelete, "cell 0 6");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel labelCustNumber;
    private JTextField txtCustomerNumber;
    private JLabel labelCustomerName;
    private JTextField textCustomerName;
    private JLabel labelInitialDeposite;
    private JTextField textInitialDeposite;
    private JLabel labelNumberOfYear;
    private JTextField textNumberOfYears;
    private JLabel labelTypeOfSaving;
    private JComboBox comboBoxSavingType;
    private JScrollPane scrollPane1;
    private JTable DataTable;
    private JScrollPane scrollPane2;
    private JTable InterestTable;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
