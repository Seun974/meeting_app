package se.lexicon.samuel.data;

import se.lexicon.samuel.model.Meeting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MeetingCollection implements MeetingDAO {
    //implementing a singleton
   private static final MeetingCollection INSTANCE;

   static {
       INSTANCE = new MeetingCollection();
   }

    private MeetingCollection(){
        meetings = new ArrayList<>();
    }

    static MeetingCollection getInstance(){
       return INSTANCE;
    }


    private List<Meeting> meetings;

   public Optional<Meeting> findByID(String meetingId){
       return meetings.stream()
               .filter(meeting -> meeting.getMeetingId().equals(meetingId))
               .findFirst();
   }

   public List<Meeting> findAll(){
       return new ArrayList<>(meetings);
   }

   public List<Meeting> findByTimeBetween(LocalDateTime begin, LocalDateTime end){
       return meetings.stream()
               .filter(meeting -> (meeting.getStart().isBefore(begin) || meeting.equals(begin)) && (meeting.getEnd().equals(end)))
               .collect(Collectors.toList());
   }


}
