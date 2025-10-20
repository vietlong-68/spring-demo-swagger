package com.vtlong.user_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfig: Class cấu hình Swagger/OpenAPI cho dự án
 * 
 * Swagger tự động quét các @RestController và tạo API documentation
 * Nhưng để tùy chỉnh metadata (title, version, contact...), ta cần config này
 */
@Configuration
public class SwaggerConfig {

    /**
     * @Bean customOpenAPI(): Tạo bean OpenAPI để cấu hình thông tin tổng quan
     * 
     * OpenAPI: Là đối tượng chính chứa toàn bộ cấu hình API documentation
     * Spring Boot sẽ tự động sử dụng bean này khi khởi động Swagger UI
     * 
     * Truy cập Swagger UI tại: http://localhost:8080/swagger-ui.html
     * Truy cập JSON docs tại: http://localhost:8080/v3/api-docs
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            // Info: Chứa metadata (thông tin mô tả) hiển thị đầu trang Swagger UI
            .info(new Info()
                // Title: Tiêu đề chính của API documentation
                .title("User Service API")
                
                // Version: Phiên bản API (quan trọng khi có nhiều version: v1, v2...)
                .version("1.0")
                
                // Description: Mô tả chi tiết về API này làm gì
                .description("API quản lý người dùng - User Management API")
                
                // Contact: Thông tin liên hệ khi có vấn đề với API
                .contact(new Contact()
                    .name("VietLong")
                    .email("vtlong@example.com")));
    }
    
    /*
     * Lưu ý: Các cấu hình khác trong application.yml
     * 
     * springdoc.api-docs.path: Đường dẫn JSON API docs
     * springdoc.swagger-ui.path: Đường dẫn Swagger UI
     * springdoc.swagger-ui.enabled: Bật/tắt Swagger UI
     * 
     * Có thể thêm nhiều cấu hình khác như:
     * - Security (JWT Authentication)
     * - Grouped APIs (nhóm theo module)
     * - Custom servers
     */
}

