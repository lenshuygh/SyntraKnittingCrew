package be.lens.syntra.spring.knittingcrewhomepage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KnittingCrewRole {
    PRESIDENT("President"),
    VICE_PRESIDENT("Vice president"),
    SECRETARY("Secretary"),
    TREASURER("Treasurer"),
    MEMBER("Member");

    private String roleName;

    @Override
    public String toString() {
        return getRoleName();
    }
}
