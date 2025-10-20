package com.vtlong.user_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    
    /**
     * @JsonProperty(access = READ_ONLY): 
     * - Từ Jackson library, xử lý JSON serialization/deserialization
     * - READ_ONLY: Trường này CHỈ xuất hiện khi trả về response (serialize)
     * - Khi nhận request, Jackson sẽ BỎ QUA trường này (không deserialize)
     * - Bảo vệ backend: Ngăn client gửi ID giả mạo
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    
    /**
     * @Schema: Annotation Swagger để mô tả field trong API documentation
     * - accessMode = READ_ONLY: Báo cho Swagger UI biết trường này chỉ đọc
     *   → Swagger sẽ ẨN field này trong Request Body schema
     *   → Nhưng vẫn HIỂN THỊ trong Response schema
     * - description: Mô tả ý nghĩa của trường
     * Kết quả: Khi POST /api/users, user không thấy field "id" để nhập
     */
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "ID tự động tạo, không cần nhập")
    private String id;
    
    /**
     * @Schema với description và example:
     * - description: Giải thích ý nghĩa của trường trong Swagger UI
     * - example: Giá trị mẫu hiển thị trong Swagger UI
     * Giúp người dùng hiểu cần nhập gì và có ví dụ để tham khảo
     */
    @Schema(description = "Tên người dùng", example = "Nguyễn Văn A")
    private String name;
    
    /**
     * @Schema cho email:
     * Swagger UI sẽ hiển thị placeholder với example này
     * giúp người test API dễ dàng hơn
     */
    @Schema(description = "Email người dùng", example = "nguyenvana@example.com")
    private String email;
}
