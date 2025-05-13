
## Thành Viên 
Đặng Thị Thu Hoài 23010316

Nguyễn Thị Lụa    23010369
## TIÊU ĐỀ : QUẢN LÍ SINH VIÊN
## ĐỐI TƯỢNG :
---- Student
Class Student {
studentID;
fullName;
dateOfBirth;
className ;
}

----- Course
Class Course {
courseID;
courseName;
credits;
}

------ Transcript
Class Transcript{
student;
course;
grade;
}

