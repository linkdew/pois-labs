package org.linkdew.daopattern.entities;

public class Timerange {
    private Long timerangeId;
    private Long taskId;
    private Long timetaken;
    private String note;

    public Timerange(Long timerangeId, Long taskId, Long timetaken, String note) {
        this.timerangeId = timerangeId;
        this.taskId = taskId;
        this.timetaken = timetaken;
        this.note = note;
    }

    @Override
    public String toString(){
        return "Timerange id: " + timerangeId.toString() +
                "\tTask id: " + taskId.toString() +
                "\tHours taken: " + (timetaken / 60) + "h" +
                "\tNote: " + note;
    }

    public Long getTimerangeId() {
        return timerangeId;
    }

    public void setTimerangeId(Long timerangeId) {
        this.timerangeId = timerangeId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTimetaken() {
        return timetaken;
    }

    public void setTimetaken(Long timetaken) {
        this.timetaken = timetaken;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
