package Human;

import Enums.membershipType;

import java.time.LocalDate;

public class Faculty extends memberRecord {
    public Faculty(Long memberId, membershipType type, String name, String address, String phoneNo) {
        super(memberId, type, name, address, phoneNo);
    }
}
