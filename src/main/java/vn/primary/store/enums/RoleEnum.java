package vn.primary.store.enums;

import vn.primary.common.enums.IEnum;

public enum RoleEnum implements IEnum {
    ADMIN((short) 1),
    MANAGER((short) 2),
    LIBRARIAN((short) 3),
    USER((short) 4);

    private short role;

    RoleEnum(short role) {
        this.role = role;
    }

    @Override
    public Short getValue() {
        return this.role;
    }

    @Override
    public String getName() {
        switch (role){
            case 1: return "ADMIN";
            case 2: return "MANAGER";
            case 3: return "LIBRARIAN";
            case 4: return "USER";
        }
        return null;
    }
}
