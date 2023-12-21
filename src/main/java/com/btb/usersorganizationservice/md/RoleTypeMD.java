package com.btb.usersorganizationservice.md;

public enum RoleTypeMD {
    BROKER(1L, "Broker", "B"),
    ADMIN(2L, "Admin", "A"),
    USER(3L, "Organization", "O"),
    ;

    private Long id;

    private String roleName;

    private String internalCode;

    RoleTypeMD(Long id, String roleName, String internalCode) {
        this.id = id;
        this.roleName = roleName;
        this.internalCode = internalCode;
    }

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getInternalCode() {
        return internalCode;
    }
}
