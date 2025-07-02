package api.model.TimeTrakerMod;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TimeInterval{
    @JsonProperty("start") 
    public Date getStart() {
		 return this.start; } 
    public void setStart(Date start) { 
		 this.start = start; } 
    Date start;
    @JsonProperty("end") 
    public Date getEnd() { 
		 return this.end; } 
    public void setEnd(Date end) { 
		 this.end = end; } 
    Date end;
    @JsonProperty("duration") 
    public String getDuration() { 
		 return this.duration; } 
    public void setDuration(String duration) { 
		 this.duration = duration; } 
    String duration;
}
