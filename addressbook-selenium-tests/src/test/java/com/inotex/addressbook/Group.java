package com.inotex.addressbook;

public class Group {
    private String groupName;
    private String groupHeader;
    private String groupFooter;

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGroupHeader(String groupHeader) {
        this.groupHeader = groupHeader;
    }

    public void setGroupFooter(String groupFooter) {
        this.groupFooter = groupFooter;
    }

    public Group(String groupName, String groupHeader, String groupFooter) {
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupHeader() {
        return groupHeader;
    }

    public String getGroupFooter() {
        return groupFooter;
    }
}
