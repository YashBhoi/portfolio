import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentFeedbackFormSwing extends JFrame implements ActionListener {
    JTextField nameField, rollField;
    JRadioButton male, female, other;
    JComboBox<String> courseBox;
    JList<String> semList;
    JCheckBox lib, lab, wifi, canteen, hostel;
    JSlider rating;
    JButton submit, reset;
    ButtonGroup genderGroup;
    JTextArea output;

    StudentFeedbackFormSwing() {
        setTitle("Student Feedback Form");
        setSize(400, 600);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        nameField = new JTextField(20);
        add(nameField);

        add(new JLabel("Roll No:"));
        rollField = new JTextField(10);
        add(rollField);

        add(new JLabel("Gender:"));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        add(male); add(female); add(other);

        add(new JLabel("Course:"));
        courseBox = new JComboBox<>(new String[]{"BCA", "BSc IT", "MCA", "MSc IT"});
        add(courseBox);

        add(new JLabel("Semester:"));
        semList = new JList<>(new String[]{"Sem 1", "Sem 2", "Sem 3", "Sem 4", "Sem 5", "Sem 6", "Sem 7", "Sem 8"});
        semList.setVisibleRowCount(4);
        add(new JScrollPane(semList));

        add(new JLabel("Facilities:"));
        lib = new JCheckBox("Library");
        lab = new JCheckBox("Lab");
        wifi = new JCheckBox("Wi-Fi");
        canteen = new JCheckBox("Canteen");
        hostel = new JCheckBox("Hostel");
        add(lib); add(lab); add(wifi); add(canteen); add(hostel);

        add(new JLabel("Rating (1–10):"));
        rating = new JSlider(1, 10, 5);
        rating.setMajorTickSpacing(1);
        rating.setPaintTicks(true);
        rating.setPaintLabels(true);
        add(rating);

        submit = new JButton("Submit");
        reset = new JButton("Reset");
        add(submit);
        add(reset);
        submit.addActionListener(this);
        reset.addActionListener(this);

        output = new JTextArea(5, 30);
        add(new JScrollPane(output));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "Other";
            String msg = "Name: " + nameField.getText() +
                         "\nRoll No: " + rollField.getText() +
                         "\nGender: " + gender +
                         "\nCourse: " + courseBox.getSelectedItem() +
                         "\nSemester: " + semList.getSelectedValue() +
                         "\nFacilities: ";
            if (lib.isSelected()) msg += "Library ";
            if (lab.isSelected()) msg += "Lab ";
            if (wifi.isSelected()) msg += "Wi-Fi ";
            if (canteen.isSelected()) msg += "Canteen ";
            if (hostel.isSelected()) msg += "Hostel ";
            msg += "\nRating: " + rating.getValue();
            output.setText(msg);
        } else {
            nameField.setText("");
            rollField.setText("");
            genderGroup.clearSelection();
            semList.clearSelection();
            lib.setSelected(false); lab.setSelected(false); wifi.setSelected(false);
            canteen.setSelected(false); hostel.setSelected(false);
            rating.setValue(5);
            output.setText("Form Reset!");
        }
    }

    public static void main(String[] args) {
        new StudentFeedbackFormSwing();
    }
}
