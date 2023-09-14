package com.example.android.architecture.blueprints.todoapp.tasks;


import android.view.View;

import com.example.android.architecture.blueprints.todoapp.data.Task;

/**
 * Listener used with data binding to process user actions.
 */
public interface TaskItemUserActionsListener {
    void onCompleteChanged(Task task, View v);

    void onTaskClicked(Task task);
}
