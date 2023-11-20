/*	Filename: 'Starlight High School' record system
	Programmers : Faris, Aina, Cut, Adam, Aedam   
	Program Description: To develop a comprehensive C++ program for the tasks given
	Date: 17/11/23
*/ 

#include <iostream>
#include <string>
using namespace std;

// Maximum number of students allowed
const int MAX_STUDENTS = 51;

// Arrays to store student information
string studentID[MAX_STUDENTS];
string studentName[MAX_STUDENTS];
double scores[MAX_STUDENTS];
int attendance[MAX_STUDENTS];

// Function to input data for each student
void inputStudentData(int numStudents) {
    for (int i = 0; i < numStudents; i++) {
        // Ask for the user input for details of each student
        cout << "\nEnter the details of student " << i + 1<< ":\n";
        cout << "-------------------------------\n";
        cout << "Student ID: ";
        cin >> studentID[i];
        cin.ignore();  // Clear the newline character from the buffer
        cout << "Student Name: ";
        getline(cin, studentName[i]);
        cout << "Scores(%): ";
        cin >> scores[i];
        cout << "Attendance(%): ";
        cin >> attendance[i];
    }
}

// Functions to calculate and return the average of all student scores
double calculateAverageScores(int numStudents) {
    double totalScores = 0;
    double totalAttendance = 0;

    for (int i = 0; i < numStudents; i++) {
        totalScores += scores[i];
        totalAttendance += attendance[i];
    }

    double averageScore;
    double averageAttendance;

    if (numStudents == 0) {
        // If there are no students, set averages to 0
        averageScore = 0;
        averageAttendance = 0;
    } else {
        // Calculate averages based on total scores and attendance
        averageScore = totalScores / numStudents;
        averageAttendance = totalAttendance / numStudents;
    }

    cout << "Average Attendance is: " << averageAttendance << "\n";

    return averageScore;
}

// Function to display student records
void displayStudentRecords(int numStudents, double averageScore) {
    cout << "\nStudent Records:\n";
    cout << "--------------------------------------------------\n";
    cout << "|ID|\t|Name|\t\t|Attendance|\t|Scores|\n";
    cout << "--------------------------------------------------\n";

    for (int i = 0; i < numStudents; ++i) {
        // Display information for each student
        cout << studentID[i] << "\t" << studentName[i] << "\t\t" << attendance[i]
                  << "\t\t" << scores[i] << "\n\n";
    }

    cout << "--------------------------------------------------\n";
    cout << "Average Scores is : " << averageScore << "\t"
              << "\n";
}

// Functions to check and display pass/fail status for each student
void displayPassFailStatus(int numStudents) {
    if (numStudents == 0) {
        cout << "\nNo student records available.\n";
        return;
    }

    // Passing score defined early on
    const double passingScore = 30.0;

    cout << "\nPassing grade : 30 \n";
    cout << "-------------------------------\n";
    cout << "ID\tName\t\tStatus\n";
    cout << "-------------------------------\n";

    for (int i = 0; i < numStudents; ++i) {
        string status = (scores[i] >= passingScore) ? "Pass" : "Fail";
        cout << studentID[i] << "\t" << studentName[i] << "\t\t" << status << "\n";
    }

    cout << "-------------------------------\n";
}

int main() {
    int numStudents;

    do {
        // Get the number of students from the user
        cout << "Enter the number of students: ";
        cin >> numStudents;

        // Checking if the input is valid
        if (numStudents > MAX_STUDENTS) {
            // Display an error if the number of students is over the maximum limit
            cout << "Error! Number of students exceeds the maximum limit.\nPlease enter again.\n";
        } else if (numStudents <= 0) {
            // Display an error if the number of students is lesser than 0
            cout << "Error! Number of students must be greater than 0.\nPlease enter again.\n";
        } else {
            break;
            // Break out of the loop if the input is valid
        }

    } while (true);

	inputStudentData(numStudents);

    double averageScore = calculateAverageScores(numStudents);

    displayStudentRecords(numStudents, averageScore);

    //Function to display pass/fail status
    displayPassFailStatus(numStudents);

    return 0;
}