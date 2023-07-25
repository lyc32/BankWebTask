package com.example.bankwebtask.model;

public class UserRequest
{
    private int requestId;
    private int userId;
    private String columnName;
    private String oldData;
    private String newData;
    private String state;

    public UserRequest(int userId, String columnName, String oldData, String newData, String state)
    {
        this.userId = userId;
        this.columnName = columnName;
        this.oldData = oldData;
        this.newData = newData;
        this.state = state;
    }
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOldData() {
        return oldData;
    }

    public void setOldData(String oldData) {
        this.oldData = oldData;
    }

    public String getNewData() {
        return newData;
    }

    public void setNewData(String newData) {
        this.newData = newData;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
