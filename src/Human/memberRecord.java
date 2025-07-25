package Human;

import Enums.membershipType;

import java.time.LocalDate;
import java.util.Objects;

public class memberRecord {
    protected Long memberId;
    protected membershipType type;
    protected LocalDate dateOfMembership;
    protected int noBookIssued;
    protected int maxBookLimit;
    protected String name;
    protected String address;
    protected String phoneNo;

    public memberRecord(Long memberId, membershipType type, LocalDate dateOfMembership, int noBookIssued, int maxBookLimit, String name, String address, String phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBookIssued = 0;
        this.maxBookLimit = 5;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public void getMember(){
        System.out.println("Member ID: " + memberId);
        System.out.println("Member name: " + name);
        System.out.println("Issued Book: " + noBookIssued);
        System.out.println("Date of Membership: " + dateOfMembership);
        System.out.println("Phone no: " + phoneNo);
        System.out.println("Address: " + address);
    }

    public String getName(){
        return name;
    }

    public int getNoBookIssued(){
        return noBookIssued;
    }

    public int getMaxBookLimit(){
        return maxBookLimit;
    }

    public void incBookIssued(){
        if(noBookIssued < maxBookLimit){
            noBookIssued++;
            System.out.println("Total issued book: " + noBookIssued);
        } else {
            System.out.println("You have reached your limit: " + maxBookLimit);
        }
    }

    public void decBookIssued(){
        if(noBookIssued> 0){
            noBookIssued--;
        }
    }

    public void payBill(double amount){
        System.out.println(name + "paid " + amount);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){return true;}
        if (o == null || getClass() != o.getClass()) return false;
        memberRecord mmbr = (memberRecord) o;
        return memberId != null && memberId.equals(mmbr.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(memberId);
    }
}
