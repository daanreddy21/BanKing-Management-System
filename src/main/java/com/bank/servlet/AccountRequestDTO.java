package com.bank.servlet;

public class AccountRequestDTO {

    private int id;
    private String name;
    private String aadhaar;
    private String phone;
    private String address;
    private double deposit;
    private String status;
    private String rejectionReason;

    public AccountRequestDTO() {}

    public AccountRequestDTO(String name, String aadhaar, String phone,
                             String address, double deposit) {
        this.name = name;
        this.aadhaar = aadhaar;
        this.phone = phone;
        this.address = address;
        this.deposit = deposit;
        this.status = "PENDING";
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAadhaar() {
        return aadhaar;
    }
    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public double getDeposit() {
        return deposit;
    }
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRejectionReason() {
        return rejectionReason;
    }
    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }
}
