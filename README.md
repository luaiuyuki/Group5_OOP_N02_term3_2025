## 📘 Project Nhóm 5: Quản Lý Sinh Viên
*Dự án cuối kỳ môn Lập trình Hướng Đối Tượng (OOP)*

*Giảng viên: Nguyễn Lệ Thu*

----------------------------------------------------
## 👥 Thành viên nhóm:

1. Nguyễn Thị Lụa

   ID:23010369

   Github: https://github.com/luaiuyuki

2. Đặng Thị Thu Hoài
   
   ID:23010316

   Github: https://github.com/hoai2310

----------------------------------------------------

## 📌 Giới Thiệu:

Ứng dụng quản lý sinh viên là một ứng dụng console được phát triển bằng ngôn ngữ **Java**, nhằm mô phỏng hệ thống quản lý sinh viên tại các trường đại học. Giao diện được xây dựng trên nền **console** đơn giản, trực quan. Dự án áp dụng mô hình **Lập trình Hướng Đối Tượng (OOP)**, sử dụng các cấu trúc dữ liệu như **ArrayList** để quản lý dữ liệu, và lưu trữ thông tin bằng **file nhị phân**.

## 🚀 Mục tiêu dự án:

- Giao diện <b>Java Spring Boot</b>.
- Có chức năng quản lý sinh viên, môn học và bảng điểm.
- Và các chức năng khác(tìm kiếm, CRUD).
- Lưu trữ và truy xuất dữ liệu thông qua hệ quản trị cơ sở dữ liệu **MySQL**.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

# 📌 Cụ thể:

### 1. Người dùng:(`User`)

#### • **Gồm các thuộc tính:** `username`, `password`, `role`

#### • **Chức năng**:

   🔑 **ADMIN**: có quyền truy cập đầy đủ vào hệ thống
   
                ○ Thêm, sửa, xóa dữ liệu: sinh viên, môn học, bảng điểm.
                ○ Xem toàn bộ danh sách sinh viên, môn học, bảng điểm.
                ○ Tìm kiếm bảng điểm, sinh viên, môn học để CRUD và theo dõi, quản lí.

   🎓 **STUDENT(Đang phát triển)**: có quyền truy cập hạn chế

                ○ Chỉ xem và theo dõi được thông tin về sinh viên,môn học, bảng điểm của mình.

### 2. Sinh viên:(`Student`)

#### • **Gồm các thuộc tính:** `student_id`, `fullname`, `gender`, `date_of_birth`, `major`


#### • **Chức năng**:

       ○ Thêm mới sinh viên, Sửa, Xóa thông tin sinh viên, Lưu dữ liệu, Hệ thống phản hồi và hiển thị lại danh sách sinh viên. 

### 3. Môn học:(`Course`)

#### • **Gồm các thuộc tính:** `course_id`, `course_name`, `credits`, `status`

#### • **Chức năng**:

       ○ Thêm mới môn học, Sửa,Xóa thông tin môn học, Lưu dữ liệu, Hệ thống phản hồi và hiển thị lại danh sách môn học.

### 4. Bảng điểm(`Transcript`)

#### • **Gồm các thuộc tính:** `id`, `student_id`, `course_id`, `grade10`, `semester`

#### • **Chức năng**: 

       ○ Tự động quy đổi điểm hệ 10 sang hệ 4, điểm chữ, và đánh giá đạt / không đạt.
       ○ Thêm mới bảng điểm, Sửa,Xóa thông tin bảng điểm, Lưu dữ liệu, Hệ thống phản hồi và hiển thị lại danh sách bảng điểm.

### ⚙️ Phương thức hoạt động chính:

#### Student Manager:

     • Hiển thị toàn bộ danh sách sinh viên, danh sách môn học, danh sách bảng điểm và theo dõi thông tin.
     • Tìm kiếm bảng điểm bằng mã sinh viên, mã môn học, tên học kì, tích hợp CRUD bảng điểm sau khi tìm kiếm.
     • Có chức năng đăng ký sinh viên vào các khóa học tương ứng.
     
- Dữ liệu được lưu trữ xuống file nhị phân.
- Cần tạo các lớp liên quan đến “Sinh viên”, “Môn học”, “Bảng điểm” để đọc, ghi dữ liệu vào một hoặc nhiều file.
- Khi làm việc với dữ liệu trong bộ nhớ, dữ liệu cần được lưu trữ dưới dạng các Collection tùy chọn như ArrayList, LinkedList, Map, ....

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 📊 Sơ đồ khối yêu cầu

**1.1 UML Class Diagram**

![class diagram](https://github.com/user-attachments/assets/7baeb75d-6f0e-4c00-bcb3-a1a0411f8756)


**1.2 UML Activity Diagram**

### Role = 'ADMIN'

#### 1.2.1. Đăng nhập: (Login)

![image](https://github.com/user-attachments/assets/fe371e66-a730-437f-a39e-c44efc90fa37)

#### 1.2.2. Trang chủ: (Home)

![image](https://github.com/user-attachments/assets/ef7a015e-63f8-480a-96c5-57a91669bd12)

#### 1.2.3. Mục sinh viên trong trang chủ: (Student Section on the Home Page)

![Untitled (3)](https://github.com/user-attachments/assets/427da5f2-d289-40cc-bdcf-64ee545750b5)

#### 1.2.4. Mục môn học trong trang chủ: (Course Section on the Home Page)

![Untitled (4)](https://github.com/user-attachments/assets/c36198fc-882d-40ec-8ef2-609d28f299f4)

#### 1.2.5. Mục môn học trong trang chủ: (Transcript Section on the Home Page)

![Untitled (6)](https://github.com/user-attachments/assets/a762ffe6-0958-44a7-860e-1b87ea9253af)

#### 1.2.6. Mục Student Manager trong trang chủ: (Student Manager Section on the Home Page)

![Untitled (8)](https://github.com/user-attachments/assets/20572093-c4ef-4d70-846a-188338ff0fb4)

#### 1.2.7. Hiển thị toàn bộ danh sách sinh viên trong danh mục của quản lí sinh viên: (View All Students in the Student Manager Menu)

![Untitled (9)](https://github.com/user-attachments/assets/a6d17b6f-ecbe-4a4a-ace1-6ff950028919)

#### 1.2.8. Hiển thị toàn bộ danh sách môn học trong danh mục của quản lí sinh viên: (View All Courses in the Student Manager Menu)

![Untitled (10)](https://github.com/user-attachments/assets/a70cfd1d-53d3-457d-b82b-9f9dd76f31e5)

#### 1.2.9. Hiển thị toàn bộ danh sách môn học trong danh mục của quản lí sinh viên: (View All Transcripts in the Student Manager Menu)

![Untitled (11)](https://github.com/user-attachments/assets/fe5e4522-5ebc-4d55-a224-6681a551af5d)

#### 1.2.10. Tìm kiếm sinh viên trong danh mục của quản lí sinh viên: (Search Student in the Student Manager Menu)

![Untitled (12)](https://github.com/user-attachments/assets/c971c5cb-b750-4f0d-afae-121ff22c9889)

#### 1.2.11. Hiển thị và thêm sửa xóa bảng điểm sau khi tìm kiếm sinh viên:

![Untitled (13)](https://github.com/user-attachments/assets/b3d18982-d21f-4523-bff5-7466270ee0e7)

#### 1.2.12. Tìm kiếm môn học trong danh mục của quản lí sinh viên: (Search Course in the Student Manager Menu)

![Untitled (14)](https://github.com/user-attachments/assets/10146d41-04a2-44ff-b568-37341d7274c3)

#### 1.2.13. Hiển thị và thêm sửa xóa bảng điểm sau khi tìm kiếm môn học:

![Untitled (15)](https://github.com/user-attachments/assets/2a99b2ee-4be9-4897-9980-0fb1f34c3e95)

#### 1.2.14. Tìm kiếm bảng điểm trong danh mục của quản lí sinh viên: (Search Transcript in the Student Manager Menu)

![Untitled (16)](https://github.com/user-attachments/assets/c5d9e936-1b47-4beb-a9c1-321ab4c9f350)

#### 1.2.15. Hiển thị và thêm sửa xóa bảng điểm sau khi tìm kiếm bảng điểm:

![Untitled (17)](https://github.com/user-attachments/assets/2c8c4aff-8cc4-4da2-9de7-6b8f00112781)

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### ⚠️Khối bắt lỗi: (Error Handling Block)

• **complete\src\main\java\com\example\servingwebcontent\MyException.java:**


package com.example.servingwebcontent;

public class MyException {

    public static void g() {
    
        throw new RuntimeException("From g()");
        
    }
    
    public static void f() {
    
        g();
        
    }
    public static void main(String[] args) {
    
        f();
        
    }  
}

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### 🖥️ Giao diện UI của Admin:(Admin User Interface)

![giao diện](https://github.com/user-attachments/assets/2f913fa1-bf41-4b61-b3a3-58c0bd53a76d)

### 📁 Cấu trúc thư mục:

[Group5_OOP_N02_term3_2025-main.zip](https://github.com/user-attachments/files/21039134/Group5_OOP_N02_term3_2025-main.zip)

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 🧰 Công nghệ sử dụng:

- Ngôn ngữ lập trình: **Java**.
- Framework: <b>Java Spring Boot</b>.
- Cơ sở dữ liệu: **MySQL** (kết nối bằng Spring Data JPA)
- Tương tác động: **AJAX (jQuery)**.
- Xử lý nghiệp vụ: **Java OOP** (Object-Oriented Programming)

## 📚 Tài liệu tham khảo:

- Java Tutorials (Oracle)
- Tài liệu học của cô Thu tải trên canvas.
- W3Schools Online Web Tutorials.
- Spring Boot Documentation.

## 🌐 Application Deployment Link:

**Deployment URL:** 

group5oopn02term32025-production-5b7b.up.railway.app






