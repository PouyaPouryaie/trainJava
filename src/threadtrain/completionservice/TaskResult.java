package threadtrain.completionservice;

public class TaskResult {

    private int taskId;
    private int result;

    public TaskResult(int taskId, int result) {
        this.taskId = taskId;
        this.result = result;
    }
    public int getTaskId() {
        return taskId;
    }
    public int getResult() {
        return result;
    }
    public String toString() {
        return "Task Name: Task #" + taskId + ", Task Result:" + result + " seconds";
    }
}
