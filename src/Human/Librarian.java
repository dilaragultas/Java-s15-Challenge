package Human;

import Book.Book;
import Enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Librarian {
    private String name;
    private String password;
    private List<memberRecord> registeredMember;

    public Librarian(String name, String password) {
        this.name = name;
        this.password = password;
        this.registeredMember = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void searchBook(String bookName){
        System.out.println(bookName);
    }

    public void addNewMember(memberRecord member){
        if(!registeredMember.contains(member)){
            registeredMember.add(member);
        }
    }

    public memberRecord getMemberRecordById(long memberId){
        for(memberRecord item: registeredMember){
            if(item.getMemberId() == memberId){
                return item;
            }
        }
        return null;
    }

    public memberRecord getMemberRecordByName(String name){
        for(memberRecord item: registeredMember){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }

    public boolean verifyMember(memberRecord member){
       if (!registeredMember.contains(member)){
           System.out.println("Membership has not been found " + member.getName());
           return false;
       }
       if(member.getNoBookIssued() < member.getMaxBookLimit()){
           System.out.println(member.getName() + "is a member, she/he can borrow.");
           return true;
       } else {
           System.out.println(member.getName() + "Member has already 5 books.");
           return false;
       }
    }

    public boolean verifyMemberWithId(long memberId){
        for(memberRecord item: registeredMember){
            if(item.getMemberId() == memberId){
                System.out.println("Membership has been found.");
                return true;
            }
        }
        System.out.println("Membership has not been found.");
        System.out.println("Please request necessary info for registration.");
        return false;
    }

    public boolean canBarrowBook(memberRecord member){
        if(member.getNoBookIssued() < member.getMaxBookLimit()){
            return true;
        } else {
            System.out.println(member.getName() + "Member has already 5 books.");
            return false;
        }
    }

    public void issueBook(Book book, memberRecord member){
        if (book.getStatus().equals(Status.AVAILABLE)){
            member.incBookIssued();
            book.update_status();
        }
    }

    public int calculateFine(){
        int fine = 0;
        //localdatei ref alip aradaki gun sayisini hesaplayacak sonra bir ucret cikaracak
        return fine;
    }

    public int createBill(Book book, memberRecord member){
        int totalAmount = 0;
        //faturayi olusturacak
        return totalAmount;
    }

    public void returnBook(Book book, memberRecord member){
        member.decBookIssued();
        book.update_status();
        System.out.println("Successfully completed.");
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", registeredMember=" + registeredMember +
                '}';
    }
}
