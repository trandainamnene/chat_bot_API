# Chatbot Login API

Đây là một RESTful API đơn giản được xây dựng bằng **Spring Boot**, dùng để xử lý chức năng **đăng nhập** và **xác thực người dùng** cho ứng dụng **chatbot**.

## 🔐 Mục tiêu

- Cung cấp endpoint `/auth/login` cho người dùng nhập tài khoản & mật khẩu.
- Sau khi xác thực thành công, trả về **JWT Token** cho client.
- Bảo vệ các endpoint còn lại bằng cơ chế **JWT Authentication**.

## ⚙️ Công nghệ sử dụng

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Maven

## 🧩 Cấu trúc chính

- `JwtAuthenticationController`: Controller chính xử lý đăng nhập.
- `JwtRequestFilter`: Filter kiểm tra và xác thực JWT từ mỗi request.
- `JwtTokenUtil`: Tạo và kiểm tra token JWT.
- `WebSecurityConfig`: Cấu hình bảo mật (CORS, JWT, v.v...)

## 📦 API

### `POST /auth/login`

#### Request:
```json
{
  "username": "your_username",
  "password": "your_password"
}
```

## 👥 Thành viên dự án
- Trần Đại Nam 
- Huỳnh Thành Tựu