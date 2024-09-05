package com.goriant.nova.ucm.dto;

import java.time.LocalDateTime;

public class ConfigurationDTO {

 /*   private String name;
    private String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }*/
 private Long Id;  // ID người dùng, khóa chính
    private String name;  // Tên đăng nhập, yêu cầu duy nhất
    private String passwordHash;  // Mật khẩu đã được mã hóa
    private String email;  // Địa chỉ email, yêu cầu duy nhất
    private String profilePicture;  // Đường dẫn đến hình ảnh đại diện của người dùng
    private LocalDateTime createdAt;  // Thời điểm tạo tài khoản
    private String createdBy;  // Người tạo
    private LocalDateTime updatedAt;  // Thời điểm cập nhật thông tin
    private String updatedBy;  // Người sửa

    public ConfigurationDTO(Long id, String name, String passwordHash, String email, String profilePicture, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy) {
        Id = id;
        this.name = name;
        this.passwordHash = passwordHash;
        this.email = email;
        this.profilePicture = profilePicture;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public ConfigurationDTO(){}

    public Long getId() {
        return Id;
    }

    public void setUserId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getName(String name) {

        this.name = name;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


}
