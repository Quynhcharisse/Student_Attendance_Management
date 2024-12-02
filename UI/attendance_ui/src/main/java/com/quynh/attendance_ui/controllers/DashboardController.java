package com.quynh.attendance_ui.controllers;

import com.quynh.attendance_be.models.Student;
import com.quynh.attendance_be.services.AttendanceService;
import com.quynh.attendance_be.services.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@RequiredArgsConstructor
public class DashboardController implements Initializable {
    @FXML
    public Button btn_take;
    @FXML
    public Button btn_edit;
    @FXML
    public Button btn_send;

    @FXML
    public TableColumn<Student, Integer> tblr_id;
    @FXML
    public TableColumn<Student, String> tblr_name;
    @FXML
    public TableColumn<Student, String> tblr_code;
    @FXML
    public TableColumn<Student, String> tblr_status;

    @FXML
    public TextField txt_id;
    @FXML
    public TextField txt_name;
    @FXML
    public TextField txt_code;
    @FXML
    public TextField txt_status;

    @FXML
    public Button btn_present;
    @FXML
    public Button btn_save;
    @FXML
    public Button btn_search;

    @FXML
    public TextField txt_search;

    @FXML
    public ComboBox <String> combo_search;
    @FXML
    public TableView<Student> tbl_student;

    private final StudentService studentService;

    private final AttendanceService attendanceService;

    private ObservableList<Student> students;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        initAttendance();
//        initComboBox();
//        load();
    }

    private void initAttendance() {
        attendanceService.initAttendance();
    }

    private void initComboBox() {
        combo_search.setValue("name");
    }

    @FXML
    public void takeAttendance(MouseEvent event) {
        changePage("../fxml/Dashboard.fxml", event);
    }

    @FXML
    public void editReason(MouseEvent event) {
        changePage("../fxml/EditReason.fxml", event);
    }

    @FXML
    public void sendEmail(MouseEvent event) {
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
    public void present(MouseEvent event) {
    }


    @FXML
    public void save(MouseEvent event) {
    }

    @FXML
    public void search(MouseEvent event) {
    }

    @FXML
    public void catchSelectedRow(MouseEvent event) {
    }

    private void load() {
        List<Student> studentList = studentService.getAllStudents();
        students = FXCollections.observableList(studentList);
        tblr_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblr_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblr_code.setCellValueFactory(new PropertyValueFactory<>("code"));
        tblr_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        tbl_student.setItems(students);
    }

}
