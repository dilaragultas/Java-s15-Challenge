package Human;

import Enums.membershipType;

import java.time.LocalDate;

public class Student extends memberRecord{
    public Student(Long memberId, membershipType type, String name, String address, String phoneNo) {
        super(memberId, type, name, address, phoneNo);
    }
}
