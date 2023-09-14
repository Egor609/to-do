package com.example.android.architecture.blueprints.todoapp.taskdetail;

/**
 * Defines the navigation actions that can be called from the Details screen.
 */
public interface TaskDetailNavigator {

    void onTaskDeleted();

    void onStartEditTask();
}
