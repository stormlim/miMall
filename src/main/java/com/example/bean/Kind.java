package com.example.bean;

public class Kind {
    private Long kindId;

    private String kindName;

    public Kind() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kind(Long kindId, String kindName) {
		super();
		this.kindId = kindId;
		this.kindName = kindName;
	}

	public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName == null ? null : kindName.trim();
    }
}