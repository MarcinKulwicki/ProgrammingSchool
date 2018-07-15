package pl.coderslab.model;

public class Task {

    private int id;
    private int userId;
    private int taskId;
    private String taskName;
    private String taskAnswer;
    private String taskData;


    public Task(int id, int userId, int taskId, String taskName, String taskAnswer) {
        setId(id);
        setUserId(userId);
        setTaskId(taskId);
        setTaskName(taskName);
        setTaskAnswer(taskAnswer);
    }

    public Task(int id, int userId, int taskId, String taskName, String taskAnswer, String taskData) {
        setId(id);
        setUserId(userId);
        setTaskId(taskId);
        setTaskName(taskName);
        setTaskAnswer(taskAnswer);
        setTaskData(taskData);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskAnswer() {
        return taskAnswer;
    }

    public void setTaskAnswer(String taskAnswer) {
        this.taskAnswer = taskAnswer;
    }

    public String getTaskData() {
        return taskData;
    }

    public void setTaskData(String taskData) {
        this.taskData = taskData;
    }
}
