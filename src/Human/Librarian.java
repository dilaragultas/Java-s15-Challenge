package Human;

import java.util.List;

public class Librarian {
    private String name;
    private String password;
    private List<memberRecord> registeredMember;

    public Librarian(String name, String password, List<memberRecord> registeredMember) {
        this.name = name;
        this.password = password;
        this.registeredMember = registeredMember;
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

    public boolean verifyMember(memberRecord member){
       if (!registeredMember.contains(member)){
           System.out.println("Membership has not been found " + member.getName());
           return false;
       }
       if(member.getNoBookIssued() < member.getMaxBookLimit()){
           System.out.println(member.getName() + "is a member, she/he can borrow.");
           return true;
       } else {
           System.out.println(member.getName() + "is not a member, she/he cannot borrow.");
           return false;
       }
    }

    public void issueBook(){
        //kitap owneri atayabilmeli?
    }

    public int calculateFine(){
        int fine = 0;
        //localdatei ref alip aradaki gun sayisini hesaplayacak sonra bir ucret cikaracak
        return fine;
    }

    public int createBill(){
        int totalAmount = 0;
        //faturayi olusturacak
        return totalAmount;
    }

    public void returnBook(){

    }


}
