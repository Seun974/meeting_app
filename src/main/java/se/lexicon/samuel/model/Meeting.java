package se.lexicon.samuel.model;

import se.lexicon.samuel.App;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

//this will have details of the participants and meeting features
public class Meeting implements Comparable<Meeting> {
    private String meetingId;
    private LocalDateTime start;
    private LocalDateTime end;
    private String topic;
    private String agenda;
    private AppUser organizer;
    private List<AppUser> participants;

    public Meeting(String meetingId, LocalDateTime start, LocalDateTime end, String topic, String agenda, AppUser organizer, List<AppUser> participants) {
        this.meetingId = meetingId;
        this.start = start;
        this.end = end;
        this.topic = topic;
        this.agenda = agenda;
        this.organizer = organizer;
        this.participants = participants;
    }
    //chain the constructor again to call the above constructor
    public Meeting(LocalDateTime start, LocalDateTime end, String topic, String agenda, AppUser organizer) {
        this(UUID.randomUUID().toString(), start, end, topic, agenda, organizer, new ArrayList<>());
    }

    public String getMeetingId() {
        return meetingId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    public AppUser getOrganizer() {
        return organizer;
    }

    public void setOrganizer(AppUser organizer) {
        this.organizer = organizer;
    }

    public List<AppUser> getParticipants() {
        return participants;
    }

    public void setParticipants(List<AppUser> participants) {
        this.participants = participants;
    }
    //method to add participants
    public void addParticipants(AppUser appUser){
        if(!participants.contains(appUser)){ //if participants does not contain
            participants.add(appUser);
            appUser.getMeetings().add(this);
        }
    }

    public void removeParticipants(AppUser appUser){
        if(participants.contains(appUser)){
            appUser.getMeetings().remove(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meeting)) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(meetingId, meeting.meetingId) &&
                Objects.equals(start, meeting.start) &&
                Objects.equals(end, meeting.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meetingId, start, end);
    }

    @Override
    public String  toString() {
        return "Meeting{" +
                "meetingId='" + meetingId + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", topic='" + topic + '\'' +
                ", agenda='" + agenda + '\'' +
                '}';
    }

    @Override
    public int compareTo(Meeting o) {
        return getStart().compareTo(o.getStart());
    }
}
