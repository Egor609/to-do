package com.example.android.architecture.blueprints.todoapp.tasks;


import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.data.Task;
import com.example.android.architecture.blueprints.todoapp.databinding.TaskItemBinding;

import java.util.List;


public class TasksAdapter extends BaseAdapter {

    private MediaPlayer sound;

    private final TasksViewModel mTasksViewModel;

    private List<Task> mTasks;


    public TasksAdapter(List<Task> tasks,
                        TasksViewModel tasksViewModel) {
        mTasksViewModel = tasksViewModel;
        setList(tasks);
    }

    public void replaceData(List<Task> tasks) {
        setList(tasks);
    }

    @Override
    public int getCount() {
        return mTasks != null ? mTasks.size() : 0;
    }

    @Override
    public Task getItem(int position) {
        return mTasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View view, final ViewGroup viewGroup) {
        TaskItemBinding binding;
        if (view == null) {
            // Inflate
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

            // Create the binding
            binding = TaskItemBinding.inflate(inflater, viewGroup, false);
        } else {
            // Recycling view
            binding = DataBindingUtil.getBinding(view);
        }

        TaskItemUserActionsListener userActionsListener = new TaskItemUserActionsListener() {
            @Override
            public void onCompleteChanged(Task task, View v) {
                boolean checked = ((CheckBox)v).isChecked();
                mTasksViewModel.completeTask(task, checked);

                mTasksViewModel.loadTasks(true);

                assert view != null;
                final MediaPlayer mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.sound);
                mediaPlayer.start();
            }

            @Override
            public void onTaskClicked(Task task) {
                mTasksViewModel.getOpenTaskEvent().setValue(task.getId());
            }
        };

        binding.setTask(mTasks.get(position));

        binding.setListener(userActionsListener);

        binding.executePendingBindings();
        return binding.getRoot();
    }


    private void setList(List<Task> tasks) {
        mTasks = tasks;
        notifyDataSetChanged();
    }
}
