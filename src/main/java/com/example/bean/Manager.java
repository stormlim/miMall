package com.example.bean;

public class Manager {
	private Long managerId;

    private String managerName;

    private String managerPassword;

    private String managerPhone;

    private String managerAddress;

    public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(Long managerId, String managerName, String managerPassword, String managerPhone,
			String managerAddress) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.managerPassword = managerPassword;
		this.managerPhone = managerPhone;
		this.managerAddress = managerAddress;
	}

	public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword == null ? null : managerPassword.trim();
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone == null ? null : managerPhone.trim();
    }

    public String getManagerAddress() {
        return managerAddress;
    }

    public void setManagerAddress(String managerAddress) {
        this.managerAddress = managerAddress == null ? null : managerAddress.trim();
    }
}
