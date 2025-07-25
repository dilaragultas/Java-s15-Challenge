package Human;

import Enums.membershipType;

import java.time.LocalDate;

public class Student extends memberRecord{
    public Student(Long memberId, membershipType type, LocalDate dateOfMembership, int noBookIssued, int maxBookLimit, String name, String address, String phoneNo) {
        super(memberId, type, dateOfMembership, noBookIssued, maxBookLimit, name, address, phoneNo);
    }
}
