package Human;

import Enums.membershipType;

import java.time.LocalDate;
import java.util.Objects;

public class memberRecord {
    private Long memberId;
    private membershipType type;
    private int noBookIssued;
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;

    public memberRecord(Long memberId, membershipType type, String name, String address, String phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.noBookIssued = 0;
        this.maxBookLimit = 5;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getMember(){
        System.out.println("Member ID: " + memberId);
        System.out.println("Member name: " + name);
        System.out.println("Issued Book: " + noBookIssued);
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
