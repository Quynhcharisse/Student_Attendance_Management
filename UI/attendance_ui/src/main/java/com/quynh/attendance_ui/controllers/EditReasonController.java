package com.quynh.attendance_ui.controllers;

import com.quynh.attendance_be.models.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EditReasonController {
    @FXML
    public Button btn_take;
    @FXML
    public Button btn_edit;
    @FXML
    public Button btn_send;

    @FXML
    public TextField txt_id;
    @FXML
    public TextField txt_name;
    @FXML
    public TextField txt_code;
    @FXML
    public TextField txt_status;
    @FXML
    public TextField txt_search;

    @FXML
    public Button btn_search;
    @FXML
    public Button btn_save;

    @FXML
    public TextArea txt_reason;

    @FXML
    public ComboBox<String> combo_search;

    @FXML
    public TableColumn<Student, Integer> tblr_id;
    @FXML
    public TableColumn<Student, String> tblr_name;
    @FXML
    public TableColumn<Student, String> tblr_code;
    @FXML
    public TableColumn<Student, String> tblr_status;

    @FXML
    public TableView<Student> tbl_student;

    @FXML
    public void takeAttendance(MouseEvent event) {
        changePage("../fxml/Dashboard.fxml", event);
    }

    @FXML
    public void editReason(MouseEvent event) {
        changePage("../fxml/EditReason.fxml", event);
    }

    @FXML
    public void sendMail(MouseEvent event) {
    }

    @FXML
    private void changePage(String pageLink, MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(pageLink));
            AnchorPane page = loader.load();

            StackPane root = new StackPane();
            root.getChildren().add(page);

            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e)  {
            e.printStackTrace();
        }
    }

    @FXML
    public void search(MouseEvent event) {
    }

    @FXML
    public void save(MouseEvent event) {
    }

    @FXML
    public void catchSelectedRow(MouseEvent event) {
    }

}
