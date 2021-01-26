package se.lexicon.samuel.model;

import java.util.Collections;
import java.util.Objects;
import java.util.TreeSet;
import java.util.UUID;

//this class will handle details of the meetings that the users can access
public class AppUser {
    private String userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private TreeSet<Meeting> meetings; //this will act as a stub

    //creating a constructor for the fields
    public AppUser(String userId, String userName, String password, String firstName, String lastName, TreeSet<Meeting> meetings) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.meetings = meetings;
    }
    //creating another constructor again: chaining constructors. these would be the needed parameters to be entered
    //top constructor will be called from here
    public AppUser(String userName, String password, String firstName, String lastName) {
        this(UUID.randomUUID().toString(), userName, password, firstName, lastName, new TreeSet<>());
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TreeSet<Meeting> getMeetings() {
        if(meetings == null) meetings = new TreeSet<>(); //so this makes meeting return an empty set instead of a null value
        return meetings;
    }
    //THIS SETTER WILL WORK BUT NOT BE accessed publicly
    void setMeetings(TreeSet<Meeting> meetings){
        this.meetings = meetings;
    }

    //this method adds a meeting to the collection of meetings but still checks for duplicates before adding
    //this add returns a boolean
    //this method makes a participant able to add himself to the meeting
    public void addMeeting(Meeting meeting){
        if(meetings.add(meeting)){
            if(! meeting.getParticipants().contains(this)) //getting participants directly adds specific participants to the meeting schedule
            meeting.getParticipants().add(this);
        }
    }
    //when you have a add method, you also put a remove method
    //this method makes a participant able to remove himself to the meeting
    public void removeMeeting(Meeting meeting){
        if(meetings.remove(meeting)){
            meeting.getParticipants().remove(this);//this removes the meeting and does not remove the participants too
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(userId, appUser.userId) &&
                Objects.equals(userName, appUser.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}


//===================================================================================================================
//this could involve maybe a case where meeting is cancelled or no meeting scheduled and we want to set a meeting
//this is not going to be used since the add and remove is being applied just for demonstration
//for bi-directional the add and remove methods are also ok.
//    public void setMeetings(TreeSet<Meeting> meetings) {
//        if(meetings == null || meetings.isEmpty()){ //note null comes before the .isEmpty
//            meetings = new TreeSet<>();
//            for(this.meetings){
//                for(Meeting m : this.meetings){
//                    removeMeeting(m);
//                }
//            }
//        }
//        this.meetings = meetings;
//    }