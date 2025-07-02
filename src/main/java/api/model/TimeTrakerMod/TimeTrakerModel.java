package api.model.TimeTrakerMod;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class TimeTrakerModel {
    @JsonProperty("id") 
    public String getId() { 
		 return this.id; } 
    public void setId(String id) { 
		 this.id = id; } 
    String id;
    @JsonProperty("description") 
    public String getDescription() { 
		 return this.description; } 
    public void setDescription(String description) { 
		 this.description = description; } 
    String description;
    @JsonProperty("tagIds") 
    public Object getTagIds() { 
		 return this.tagIds; } 
    public void setTagIds(Object tagIds) { 
		 this.tagIds = tagIds; } 
    Object tagIds;
    @JsonProperty("userId") 
    public String getUserId() { 
		 return this.userId; } 
    public void setUserId(String userId) { 
		 this.userId = userId; } 
    String userId;
    @JsonProperty("billable") 
    public boolean getBillable() { 
		 return this.billable; } 
    public void setBillable(boolean billable) { 
		 this.billable = billable; } 
    boolean billable;
    @JsonProperty("taskId") 
    public Object getTaskId() { 
		 return this.taskId; } 
    public void setTaskId(Object taskId) { 
		 this.taskId = taskId; } 
    Object taskId;
    @JsonProperty("projectId") 
    public Object getProjectId() { 
		 return this.projectId; } 
    public void setProjectId(Object projectId) { 
		 this.projectId = projectId; } 
    Object projectId;
    @JsonProperty("workspaceId") 
    public String getWorkspaceId() { 
		 return this.workspaceId; } 
    public void setWorkspaceId(String workspaceId) { 
		 this.workspaceId = workspaceId; } 
    String workspaceId;
    @JsonProperty("timeInterval") 
    public TimeInterval getTimeInterval() { 
		 return this.timeInterval; } 
    public void setTimeInterval(TimeInterval timeInterval) { 
		 this.timeInterval = timeInterval; } 
    TimeInterval timeInterval;
    @JsonProperty("customFieldValues") 
    public ArrayList<Object> getCustomFieldValues() {
		 return this.customFieldValues; } 
    public void setCustomFieldValues(ArrayList<Object> customFieldValues) { 
		 this.customFieldValues = customFieldValues; } 
    ArrayList<Object> customFieldValues;
    @JsonProperty("type") 
    public String getType() { 
		 return this.type; } 
    public void setType(String type) { 
		 this.type = type; } 
    String type;
    @JsonProperty("kioskId") 
    public Object getKioskId() { 
		 return this.kioskId; } 
    public void setKioskId(Object kioskId) { 
		 this.kioskId = kioskId; } 
    Object kioskId;
    @JsonProperty("hourlyRate") 
    public HourlyRate getHourlyRate() { 
		 return this.hourlyRate; } 
    public void setHourlyRate(HourlyRate hourlyRate) { 
		 this.hourlyRate = hourlyRate; } 
    HourlyRate hourlyRate;
    @JsonProperty("costRate") 
    public CostRate getCostRate() { 
		 return this.costRate; } 
    public void setCostRate(CostRate costRate) { 
		 this.costRate = costRate; } 
    CostRate costRate;
    @JsonProperty("isLocked") 
    public boolean getIsLocked() { 
		 return this.isLocked; } 
    public void setIsLocked(boolean isLocked) { 
		 this.isLocked = isLocked; } 
    boolean isLocked;
}
