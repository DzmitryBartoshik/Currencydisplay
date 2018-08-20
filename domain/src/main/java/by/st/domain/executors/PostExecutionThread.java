package by.st.domain.executors;


import io.reactivex.Scheduler;

public interface PostExecutionThread  {
    Scheduler getScheduler();
}
