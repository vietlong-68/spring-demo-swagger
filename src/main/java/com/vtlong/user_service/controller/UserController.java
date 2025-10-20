package com.vtlong.user_service.controller;

import com.vtlong.user_service.model.User;
import com.vtlong.user_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
/**
 * @Tag: Annotation Swagger để nhóm các API endpoint lại với nhau
 * - name: Tên nhóm hiển thị trong Swagger UI
 * - description: Mô tả chi tiết về nhóm API này
 * Kết quả: Tất cả endpoints trong controller này sẽ được nhóm dưới "User Management"
 */
@Tag(name = "User Management", description = "API quản lý người dùng")
public class UserController {
    
    private final UserService userService;
    
    /**
     * @Operation: Annotation Swagger để mô tả chi tiết một API endpoint
     * - summary: Tiêu đề ngắn gọn của endpoint (hiển thị trong danh sách)
     * - description: Mô tả chi tiết về chức năng, cách hoạt động của endpoint
     * Swagger sẽ hiển thị thông tin này trong UI để người dùng hiểu endpoint làm gì
     */
    @PostMapping
    @Operation(
        summary = "Tạo người dùng mới",
        description = "Tạo một người dùng mới trong hệ thống. UUID sẽ được tự động tạo."
    )
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    
    /**
     * @Operation: Mô tả endpoint lấy danh sách người dùng
     * Swagger tự động nhận diện:
     * - HTTP Method (GET)
     * - URL path (/api/users)
     * - Response type (List<User>)
     * và hiển thị trong UI để test trực tiếp
     */
    @GetMapping
    @Operation(
        summary = "Lấy danh sách người dùng",
        description = "Lấy toàn bộ danh sách người dùng trong hệ thống"
    )
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}

