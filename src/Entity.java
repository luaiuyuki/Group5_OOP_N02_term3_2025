// Tạo interface Entity
public interface Entity {
    String getId();         // Trả về ID (StudentId, CourseID,...)
    void input();           // Nhập dữ liệu từ bàn phím
    void display();         // Hiển thị thông tin đối tượng
}